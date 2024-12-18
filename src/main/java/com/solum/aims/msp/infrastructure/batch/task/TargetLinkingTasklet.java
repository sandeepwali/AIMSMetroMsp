package com.solum.aims.msp.infrastructure.batch.task;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.solum.aims.core.entity.EndDevice.EndDeviceType;
import com.solum.aims.core.entity.util.EndDeviceUtils;
import com.solum.aims.msp.comstant.Constants;
import com.solum.aims.msp.controller.request.MetroGroupResponse;
import com.solum.aims.msp.message.MetroMessage;
import com.solum.aims.msp.message.MetroRequestChannelMessage;
import com.solum.aims.msp.persistence.entity.*;
import com.solum.aims.msp.persistence.entity.embeddable.AddArticleListParam;
import com.solum.aims.msp.persistence.entity.embeddable.ArticleCompositePK;
import com.solum.aims.msp.persistence.entity.embeddable.TemplateCompositePK;
import com.solum.aims.msp.persistence.repository.TemplateRepository;
import com.solum.aims.msp.property.ApplicationProperties;
import com.solum.aims.msp.service.*;
import com.solum.aims.msp.util.AimsObjectMapper;
import com.solum.aims.msp.util.CommonUtils;
import com.solum.aims.msp.util.TagType;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Slf4j
@Component
public class TargetLinkingTasklet implements Tasklet, InitializingBean {

	@Autowired
	private MessageChannel sendingProductImageChannel;

	@Autowired
	private MessageChannel sendingUnlinkChannel;

	

	@Autowired
	private MessageChannel requestReleaseImageChannel;

	@Autowired
	private MetroArticleService metroArticleService;

	@Autowired
	private MetroEnddeviceService metroEnddeviceService;

	@Autowired
	private ArticleService<Article> articleService;

	@Autowired
	private EndDeviceService<EndDevice> endDeviceService;

	@Autowired
	private FileResultService<FileResult> fileResultService;

	@Autowired
	private MetroContentService contentService;

	@Autowired
	private ApplicationProperties properties;

	@Autowired
	private CSVParser csvParserI1;

	@Autowired
	private AimsObjectMapper objectMapper;

	@Autowired
	private AimsMspRestTemplateService restTemplateService;

	@Autowired
	private MetroTemplateGroupService templateGroupService;

	@Autowired
	private TemplateTypeService templateTypeService;

	@Autowired
	private TemplateStationService templateStationService;

	@Autowired
	private TemplateRepository templateRepository;

	@Value("${msp.force.update.image}")
	private Boolean isForceUpdate;

	@Autowired
	private CommonUtils commonUtils;

	@Override
	public void afterPropertiesSet() throws Exception {
	}

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

		Date created = new Date();
		List<Integer> failList = new ArrayList<Integer>();
		String messageFilePath = (String) chunkContext.getStepContext().getJobParameters().get("m1FilePath");
		String[] tmp = messageFilePath.split("\\\\");
		String messageFileName = "Link_" + tmp[tmp.length - 1];
		String stationCode = properties.getCountryCodeDefault() + "_" + properties.getStoreNumberDefault();

		MetroMessage metroMessage = (MetroMessage) chunkContext.getStepContext().getStepExecution().getJobExecution()
				.getExecutionContext().get("MetroMessage");
		BufferedReader infoFileBufferedReader = new BufferedReader(
				new InputStreamReader(new FileInputStream(metroMessage.getStartPath()), "UTF8"));

		CSVReader infoFileCsvReader = new CSVReaderBuilder(infoFileBufferedReader)
				.withSkipLines(CSVReader.DEFAULT_SKIP_LINES).withCSVParser(csvParserI1)
				.withKeepCarriageReturn(CSVReader.DEFAULT_KEEP_CR).withVerifyReader(CSVReader.DEFAULT_VERIFY_READER)
				.withMultilineLimit(CSVReader.DEFAULT_MULTILINE_LIMIT).withErrorLocale(Locale.getDefault()).build();

		String[] value = null;
		Integer linenum = 0;
		List<String[]> csvData = new ArrayList<>();
		while (true) {
			linenum++;
			try {
				value = infoFileCsvReader.readNext();
			} catch (Exception e) {
				log.error("The line cannot be parsed. [{}] {}", linenum, e);
				failList.add(linenum);
				continue;
			}
			if (value == null) {
				log.info("The file is ended.");
				break;
			}
			if (value.length <= 1) {
				log.info("The line is empty. Skipped. [{}]", linenum);
				continue;
			}
			csvData.add(value);

		}
		infoFileBufferedReader.close();
		infoFileCsvReader.close();

		CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
			String m1 = messageFileName;
			Integer i = 0;
			for (String[] values : csvData) {
				try {
					i++;
					log.info("Processing  the line number:  {} ", i);
					// [0][1]
					String[] linkCmdHeader = values[0].trim().split("\\s+", -1);
					String articleId = linkCmdHeader[1].trim();
					MetroLinkCommand linkCmd = "N".equals(values[1].trim()) ? MetroLinkCommand.LINK
							: MetroLinkCommand.UNLINK;

					String labelCode = values[3].trim().toUpperCase(); // TODO : Verified label code.

					switch (linkCmd) {
					case LINK:
						m1 = "Link_" + tmp[tmp.length - 1];
						String eslModel = values[5].trim();

						// 1. Save link info
						// TODO : Dummy countryCode, storeNumber, salesLine info.
						MetroArticle metroArticle = metroArticleService.getByStationAndArticleId(
								properties.getCountryCodeDefault(), properties.getStoreNumberDefault(),
								properties.getSalesLineDefault(), articleId);
						if (null == metroArticle.getId()) {
							metroArticle.setCountryCode(properties.getCountryCodeDefault());
							metroArticle.setStoreNumber(properties.getStoreNumberDefault());
							metroArticle.setSalesLine(properties.getSalesLineDefault());
							metroArticle.setArticleId(articleId);
							metroArticle = metroArticleService.update(metroArticle);
							if (properties.isMspUse()) {
								Article article = new Article();
								article.setId(new ArticleCompositePK(stationCode, articleId));
								article.setName("No infomation");

								AddArticleListParam addArticle = new AddArticleListParam();
								addArticle.setId(articleId);
								addArticle.setName("No infomation");
								addArticle.setStationCode(stationCode);
								addArticle.setData(metroArticle.getData());
								article.setData(new ObjectMapper().writeValueAsString(addArticle));
								articleService.saveArticle(article);
							}
						}
						MetroEnddevice metroEnddevice = metroEnddeviceService.getByLabelCode(labelCode);
						EndDeviceType enddeviceType = EndDeviceUtils.getEndDeviceType(labelCode);
						metroEnddevice.setArticle(metroArticle);
						metroEnddevice.setCode(labelCode);
						switch (enddeviceType.getColorType()) {
						case BINARY:
						default:
							metroEnddevice.setColor(1);
							break;
						case TERNARY_RED:
							metroEnddevice.setColor(2);
							break;
						case TERNARY_YELLOW:
							metroEnddevice.setColor(3);
							break;
						}
						metroEnddevice.setWidth(enddeviceType.getDisplayWidth());
						metroEnddevice.setHeight(enddeviceType.getDisplayHeight());
						metroEnddevice.setType(enddeviceType.getTypeCode()[0]);
						try {
							metroEnddevice.setModel(Integer.parseInt(eslModel));
						} catch (NumberFormatException e) {
							metroEnddevice.setModel(1);
						}
						metroEnddevice = metroEnddeviceService.updateLinkInfo(metroEnddevice);
						if (!properties.isMspUse()) {
							// Logic to retrieve template from model value
							String templateName = getTemplateByModelValue(stationCode, enddeviceType,
									metroEnddevice.getModel());
							restTemplateService.sendPostRequestAssign(stationCode, labelCode, articleId, templateName);
						} else {
							endDeviceService.updateLinkInfo(stationCode, labelCode, articleId);
							log.info("Link the metroEnddevice ({})", metroEnddevice.toString());
							// 2. Checking the contents of metroEnddevice are or not
							List<MetroContent> contents = contentService.getByEnddevice(metroEnddevice);

							if (Boolean.TRUE.equals(isForceUpdate) || contents.size() == 0) {
								commonUtils.requestToMetroMSP(metroArticle, metroEnddevice);
							} else {
								log.info("Sending the product image that are existed.");
								sendingProductImageChannel
										.send(MessageBuilder.withPayload(metroEnddevice.getCode() + "-1").build());
							}
						}
						break;

					case UNLINK:
						m1 = "Unlink_" + tmp[tmp.length - 1];
						MetroEnddevice unlinkEnddevice = metroEnddeviceService.getByLabelCode(labelCode);
						if (null != unlinkEnddevice.getId()) {

							log.info("Un-Link the metroEnddevice ({})", unlinkEnddevice.toString());
							int assignedCount = metroEnddeviceService.getCountByArticleIdAndType(
									unlinkEnddevice.getArticle().getId(), unlinkEnddevice.getType());

							List<MetroContent> unlinkContents = contentService.getByEnddevice(unlinkEnddevice);
							if (unlinkContents.stream().filter(uc -> uc.getPage() == 1).collect(Collectors.toList())
									.size() == 1) {
								if (assignedCount <= 1) {

									contentService.removeByArticleAndType(unlinkEnddevice.getArticle(),
											unlinkEnddevice.getType());

									MetroRequestChannelMessage message = new MetroRequestChannelMessage();
									message.setCountryCode(unlinkEnddevice.getArticle().getCountryCode());
									message.setStoreNumber(unlinkEnddevice.getArticle().getStoreNumber());
									message.setArticleId(unlinkEnddevice.getArticle().getArticleId());
									message.setSalesLine(unlinkEnddevice.getArticle().getSalesLine());

									MetroContent content = new MetroContent();
									content.setWidth(unlinkEnddevice.getWidth());
									content.setHeight(unlinkEnddevice.getHeight());
									content.setColor(unlinkEnddevice.getColor());
									content.setModel(unlinkEnddevice.getModel());
									content.setType(unlinkEnddevice.getType());

									message.getContents().add(content);

									log.info("Sending the request to release the product image to MSP.({})",
											message.toString());

									if (properties.isMspUse()) {
										requestReleaseImageChannel.send(MessageBuilder
												.withPayload(objectMapper.writeValueAsString(message)).build());
									}
								} else {
									log.info("Skipping removing content. Total Assigned Label({})", assignedCount);
								}
							}

							metroEnddeviceService.removeLinkInfo(unlinkEnddevice.getId());
							sendingUnlinkChannel.send(MessageBuilder.withPayload(labelCode).build());
						} else {
							log.info("({}) is not linked.", labelCode);
						}
						break;
					}
				} catch (Exception e) {
					log.error("The line cannot be processed. [{}] {}", i, e);
					failList.add(i);
				}

			}
			if (csvData.size() == i) {
				log.info("Total Records processed successfully ");
			}
		});

		fileResultService.postProcess(messageFileName, (int) infoFileCsvReader.getLinesRead(), failList, created,
				new Date());

		infoFileCsvReader.close();

		return RepeatStatus.FINISHED;
	}

	private String getTemplateByModelValue(String stationCode, EndDeviceType labelType, int model) {
		String strTemplateType = "";
		String template = "";
		String templateSize = TagType.TemplateSize.getType(labelType.getDisplayWidth(), labelType.getDisplayHeight())
				.getName();
		MetroGroupResponse metroGroupData = templateGroupService.getByModel(model);
		for (String templateName : metroGroupData.getTemplateNameList()) {
			TemplateType templateType = templateTypeService.findByTypeNameAndTemplateSize(templateName, templateSize);
			if (Optional.ofNullable(templateType).isEmpty())
				continue;
			else
				strTemplateType = templateType.getTypeName();

			if ((strTemplateType != null) && (!strTemplateType.isEmpty())) {
				// Get template by station code and type name and size
				Template fitTemplate = getTemplateByTemplateGroup(stationCode, strTemplateType, templateSize);

				if (fitTemplate != null) {
					template = strTemplateType;
//					template = fitTemplate.getId().getName();
					break;
				}
			}
		}
		return template;
	}

	private Template getTemplateByTemplateGroup(String stationCode, String typeName, String templateSize) {
		TemplateStation templateStation = templateStationService
				.findByStationCodeAndTypeNameAndTemplateSize(stationCode, typeName, templateSize);
		return templateRepository
				.findById(new TemplateCompositePK(Constants.DEFAULT_STATION_CODE, templateStation.getTemplateName()))
				.orElse(null);
	}

	@Getter
	public enum MetroLinkCommand {
		LINK, UNLINK;
	}
}
