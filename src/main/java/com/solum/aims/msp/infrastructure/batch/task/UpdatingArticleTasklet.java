package com.solum.aims.msp.infrastructure.batch.task;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.solum.aims.msp.message.AimsPortalArticleMessage;
import com.solum.aims.msp.message.AimsPortalUpdateArticleParam;
import com.solum.aims.msp.message.MetroMessage;
import com.solum.aims.msp.persistence.entity.Article;
import com.solum.aims.msp.persistence.entity.FileResult;
import com.solum.aims.msp.persistence.entity.MetroArticle;
import com.solum.aims.msp.persistence.entity.embeddable.AddArticleListParam;
import com.solum.aims.msp.persistence.entity.embeddable.ArticleCompositePK;
import com.solum.aims.msp.property.ApplicationProperties;
import com.solum.aims.msp.service.AimsMspRestTemplateService;
import com.solum.aims.msp.service.ArticleService;
import com.solum.aims.msp.service.FileResultService;
import com.solum.aims.msp.service.MetroArticleService;
import com.solum.aims.msp.util.KeyGenerator;
import lombok.extern.slf4j.Slf4j;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

@Slf4j
@Component
public class UpdatingArticleTasklet implements Tasklet, InitializingBean {

	@Autowired
	private MetroArticleService metroArticleService;

	@Autowired
	private ArticleService<Article> articleService;

	@Autowired
	private FileResultService<FileResult> fileResultService;

	@Autowired
	private CSVParser csvParserI1;

	@Autowired
	private ApplicationProperties properties;

	@Autowired
	private AimsMspRestTemplateService restTemplateService;

	@Override
	public void afterPropertiesSet() throws Exception {
	}

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

		Date created = new Date();
		List<Integer> failList = new ArrayList<Integer>();
		String messageFilePath = (String) chunkContext.getStepContext().getJobParameters().get("m1FilePath");
		String[] tmp = messageFilePath.split("\\\\");
		String messageFileName = "Update_" + tmp[tmp.length - 1];
		String customBatchId = "MSP" + KeyGenerator.getKeyByDateFormat();

		MetroMessage metroMessage = (MetroMessage) chunkContext.getStepContext().getStepExecution().getJobExecution()
				.getExecutionContext().get("MetroMessage");

		BufferedReader informationFileBufferedReader = new BufferedReader(
				new InputStreamReader(new FileInputStream(metroMessage.getStartPath()), "UTF8"));

		CSVReader informationFileCsvReader = new CSVReaderBuilder(informationFileBufferedReader)
				.withSkipLines(CSVReader.DEFAULT_SKIP_LINES).withCSVParser(csvParserI1)
				.withKeepCarriageReturn(CSVReader.DEFAULT_KEEP_CR).withVerifyReader(CSVReader.DEFAULT_VERIFY_READER)
				.withMultilineLimit(CSVReader.DEFAULT_MULTILINE_LIMIT).withErrorLocale(Locale.getDefault()).build();

		AimsPortalUpdateArticleParam updateArticleParam = new AimsPortalUpdateArticleParam();

		String[] values = null;
		int linenum = 0;

		while (true) {
			linenum++;

			try {
				values = informationFileCsvReader.readNext();
			} catch (Exception e) {
				log.error("The line cannot be parsed. [{}] {}", linenum, e);
				failList.add(linenum);
				continue;
			}
			if (values == null) {
				log.info("The file is ended.");
				break;
			}

			if (values.length <= 1) {
				log.info("The line is empty. Skipped. [{}]", linenum);
				continue;
			}

			try {
				String[] header = values[0].trim().split("\\s+", -1);
				// String sign = header[0].trim();
				String itemId = header[1].trim();
				// String header2 = header[2].trim();
				// String header3 = header[3].trim();

				values[0] = values[0].replaceFirst(header[0], "").trim();
				values[0] = values[0].replaceFirst(header[1], "").trim();

				// TODO : Dummy countryCode, storeNumber, salesLine info.
				MetroArticle metroArticle = new MetroArticle();
				metroArticle.setCountryCode(properties.getCountryCodeDefault());
				metroArticle.setStoreNumber(properties.getStoreNumberDefault());
				metroArticle.setSalesLine(properties.getSalesLineDefault());

				metroArticle.setArticleId(itemId);
				if (null == metroArticle.getData()) {
					metroArticle.setData(new HashMap<>());
				}

				String name = "";
				String nfcUrl = "";

				for (int index = 0; index < values.length - 1; index += 2) {
					String[] arrayOfField = values[index].trim().split("\\s+", -1);

					String numOfField = new StringBuilder("F").append(arrayOfField[0].trim()).toString();
					String infoOfField = values[index + 1].trim();

					metroArticle.getData().put(numOfField, infoOfField);

				}
//				Map<String, String> mapReservedData = new HashMap<>();
				metroArticle = metroArticleService.update(metroArticle);
				name = metroArticle.getData().get("F7");
				nfcUrl = metroArticle.getData().get("F560");

				JSONObject mapReservedData = new JSONObject();
				mapReservedData.put("F5", metroArticle.getData().get("F5"));
				mapReservedData.put("F6", metroArticle.getData().get("F6"));
				mapReservedData.put("F66", metroArticle.getData().get("F66"));
				mapReservedData.put("F37", metroArticle.getData().get("F37"));
				mapReservedData.put("F448", metroArticle.getData().get("F448"));
				mapReservedData.put("F67", metroArticle.getData().get("F67"));
//				for (String res : reservedData) {
//					if (map.containsKey(res)) {
//						String data = map.get(res);
//						try {
//							if (data != null) {
//								mapReservedData.put(res, data);
//							} else {
//								mapReservedData.put(res, "");
//							}
//						} catch (Exception e) {
//							log.error("Exception while getting reserved data : {}", e.getMessage());
//
//						}
//					}
//
//				}

				if (!properties.isMspUse()) {
					AimsPortalArticleMessage articleMessage = new AimsPortalArticleMessage();
					articleMessage.setStationCode(
							properties.getCountryCodeDefault() + "_" + properties.getStoreNumberDefault());
					articleMessage.setId(itemId);
					articleMessage.setName(name);
					articleMessage.setNfc(nfcUrl);
					articleMessage.setReservedOne(metroArticle.getData().get("F5"));
					articleMessage.setReservedTwo(metroArticle.getData().get("F6"));
					articleMessage.setReservedThree(metroArticle.getData().get("F66"));
					articleMessage.setData(metroArticle.getData());
					articleMessage.setReserved(mapReservedData.toString().replace("=", ":"));
					updateArticleParam.getDataList().add(articleMessage);

					if (updateArticleParam.getDataList().size() == 1000) {
						restTemplateService.updateArticle(updateArticleParam);
						updateArticleParam.getDataList().clear();
					}
				} else {
					// Only update the product info without creating the assign batch in the image
					// push system
					Article article = new Article();
					String stationCode = properties.getCountryCodeDefault() + "_" + properties.getStoreNumberDefault();
					article.setId(new ArticleCompositePK(stationCode, itemId));
					article.setName(name);
					article.setNfcUrl(nfcUrl);
					article.setCustomBatchId(customBatchId);
					article.setReservedOne(metroArticle.getData().get("F5"));
					article.setReservedTwo(metroArticle.getData().get("F6"));
					article.setReservedThree(metroArticle.getData().get("F66"));
					article.setReserved(mapReservedData.toString().replace("=", ":"));
					AddArticleListParam addArticle = new AddArticleListParam();
					addArticle.setId(itemId);
					addArticle.setName(name);
					addArticle.setNfc(nfcUrl);
					addArticle.setStationCode(stationCode);
					addArticle.setData(metroArticle.getData());
					article.setData(new ObjectMapper().writeValueAsString(addArticle));

					articleService.saveArticle(article);
				}

				log.info("L({}), {}", linenum, metroArticle.toString());
			} catch (Exception e) {
				log.error("The line cannot be processed. [{}] {}", linenum, e);
				failList.add(linenum);
			}
		}

		if (!properties.isMspUse()) {
			restTemplateService.updateArticle(updateArticleParam);
		}

		fileResultService.postProcess(messageFileName, (int) informationFileCsvReader.getLinesRead(), failList, created,
				new Date());

		informationFileCsvReader.close();

		return RepeatStatus.FINISHED;
	}
}
