package com.solum.aims.msp.infrastructure.batch.task;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.solum.aims.msp.service.*;
import com.solum.aims.msp.message.MetroMessage;
import com.solum.aims.msp.message.MetroRequestChannelMessage;
import com.solum.aims.msp.persistence.entity.*;
import com.solum.aims.msp.property.ApplicationProperties;
import com.solum.aims.msp.util.AimsObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Slf4j
@Component
public class DeletingArticleTasklet implements Tasklet, InitializingBean {

	@Autowired
	private MessageChannel sendingUnlinkChannel;
	
	@Autowired
	private MessageChannel requestReleaseImageChannel;
	
	@Autowired
	private MetroArticleService metroArticleService;
	
	@Autowired
	private MetroContentService contentService;
	
	@Autowired
	private MetroEnddeviceService metroEnddeviceService;
	
	@Autowired
	private EndDeviceService<EndDevice> endDeviceService;
	
	@Autowired
	private ArticleService<Article> articleService;
	
	@Autowired
	private FileResultService<FileResult> fileResultService;
	
	@Autowired
	private ApplicationProperties properties;
	
	@Autowired
	private CSVParser csvParserI1;
	
	@Autowired
	private AimsObjectMapper objectMapper;
	
	@Autowired
	private AimsMspRestTemplateService restTemplateService;
	
	@Override
	public void afterPropertiesSet() throws Exception {}

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
		Date created = new Date();
		List<Integer>	failList = new ArrayList<Integer>();
		String messageFilePath = (String) chunkContext.getStepContext().getJobParameters().get("m1FilePath");
		String[] tmp = messageFilePath.split("\\\\");
		String messageFileName = "Delete_" + tmp[tmp.length-1];
		
		MetroMessage metroMessage = (MetroMessage) chunkContext
				.getStepContext()
				.getStepExecution()
				.getJobExecution()
				.getExecutionContext()
				.get("MetroMessage");

		BufferedReader informationFileBufferedReader = 
				new BufferedReader(new InputStreamReader(new FileInputStream(metroMessage.getStartPath()),"UTF8"));
		
		CSVReader infoFileCsvReader = new CSVReaderBuilder(informationFileBufferedReader)
				.withSkipLines(CSVReader.DEFAULT_SKIP_LINES)
				.withCSVParser(csvParserI1)
				.withKeepCarriageReturn(CSVReader.DEFAULT_KEEP_CR)
				.withVerifyReader(CSVReader.DEFAULT_VERIFY_READER)
				.withMultilineLimit(CSVReader.DEFAULT_MULTILINE_LIMIT)
				.withErrorLocale(Locale.getDefault())
				.build();
		
		List<MetroRequestChannelMessage> messages = new ArrayList<>();
		List<String> unlinkLabelCodes = new ArrayList<>();
		
		String [] values = null;
		int linenum = 0;
		while(true) {
			linenum++;
			
			try {
				values = infoFileCsvReader.readNext();
			}catch(Exception e) {
				log.error("The line cannot be parsed. [{}] {}", linenum, e);
				failList.add(linenum);
				continue;
			}			
			if(values == null) {
				log.info("The file is ended.");
				break;
			}
			
			if(values[0] == null || values[0].equals("") == true) { 
				log.info("The line is empty. Skipped. [{}]", linenum);
				continue;
			}
			
			try {
				String [] header = values[0].trim().split("\\s+", -1);
	//			String sign = header[0].trim();
				String itemId = header[1].trim();
	//			String header2 = header[2].trim();
				
				MetroArticle metroArticle = metroArticleService.getByStationAndArticleId(
						properties.getCountryCodeDefault(), 
						properties.getStoreNumberDefault(), 
						properties.getSalesLineDefault(), 
						itemId);
				
				if(null != metroArticle.getId()) {
					
					log.info("Removing the article. {}", metroArticle.toString());
					
					metroArticle.getEnddevices().stream().forEach(metroEnddevice->{
						unlinkLabelCodes.add(metroEnddevice.getCode());
						metroEnddeviceService.removeLinkInfo(metroEnddevice.getId());
						if(properties.isMspUse()) {
							endDeviceService.deleteEndDevice(metroEnddevice.getCode());
						}
					});

					if(properties.isMspUse()) {
						if(null != metroArticle.getContents() && metroArticle.getContents().size() > 0) {
							MetroRequestChannelMessage message = new MetroRequestChannelMessage();
							message.setCountryCode(metroArticle.getCountryCode());
							message.setStoreNumber(metroArticle.getStoreNumber());
							message.setSalesLine(metroArticle.getSalesLine());
							message.setArticleId(metroArticle.getArticleId());
							
							metroArticle.getContents().stream()
							.filter(f->f.getPage() == 1)
							.forEach(c->{
								MetroContent content = new MetroContent();
								content.setWidth(c.getWidth());
								content.setHeight(c.getHeight());
								content.setColor(c.getColor());
								content.setModel(c.getModel());
								content.setType(c.getType());
								
								message.getContents().add(content);
							});
							
							messages.add(message);
						}
						contentService.removeByArticle(metroArticle);
					}
					
					metroArticleService.remove(metroArticle.getId());
					
					String stationCode = properties.getCountryCodeDefault() +"_"+ properties.getStoreNumberDefault();
					if(!properties.isMspUse()) {
						// Request DELETE API
						restTemplateService.sendRequestDeleteArticle(stationCode, itemId);
					} else {
						articleService.deleteArticle(stationCode, itemId);
					}
				} else {
					log.info("The article does not exist. {}", metroArticle.toString());
					failList.add(linenum);
				}
			} catch(Exception e) {
				log.error("The line cannot be processed. [{}] {}", linenum, e);
				failList.add(linenum);
			}
		}
		
		Date completed = new Date();
		fileResultService.postProcess(messageFileName, (int)infoFileCsvReader.getLinesRead(), failList, created, completed);
		
		infoFileCsvReader.close();
		
		if(properties.isMspUse()) {
			log.info("Sending unlink. ({})", unlinkLabelCodes.size());		
			for(String unlinkLabelCode : unlinkLabelCodes) {
				try {
					sendingUnlinkChannel.send(MessageBuilder.withPayload(unlinkLabelCode).build());
				}catch(Exception e) {
					
				}
			}
			
			log.info("Sending the request to release image. ({})", messages.size());		
			if(properties.isMspUse()) {
				for (MetroRequestChannelMessage message : messages) {
					try {
						requestReleaseImageChannel.send(
								MessageBuilder
								.withPayload(objectMapper.writeValueAsString(message))
								.build()
								);
					}catch (Exception e) {
						log.info("Fail to release the image to MSP. : {}",e);
					}
				}
			}
		}
		
		return RepeatStatus.FINISHED;
	}
}
