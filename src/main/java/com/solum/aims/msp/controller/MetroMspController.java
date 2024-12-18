package com.solum.aims.msp.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solum.aims.core.entity.EndDevice.EndDeviceType;
import com.solum.aims.core.entity.util.EndDeviceUtils;
import com.solum.aims.msp.Scheduler;
import com.solum.aims.msp.controller.request.UpdateImageRequestBody;
import com.solum.aims.msp.controller.response.MetroResponse;
import com.solum.aims.msp.controller.response.MetroStatus;
import com.solum.aims.msp.controller.response.OneResult;
import com.solum.aims.msp.persistence.entity.MetroArticle;
import com.solum.aims.msp.persistence.entity.MetroContent;
import com.solum.aims.msp.persistence.entity.MetroEnddevice;
import com.solum.aims.msp.property.ApplicationProperties;
import com.solum.aims.msp.property.BatchProperties;
import com.solum.aims.msp.service.MetroArticleService;
import com.solum.aims.msp.service.MetroContentService;
import com.solum.aims.msp.service.MetroEnddeviceService;
import com.solum.aims.msp.util.SolumJsonParser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/")

public class MetroMspController {

	@Autowired
	private MetroArticleService articleService;

	@Autowired
	private MetroContentService contentService;

	@Autowired
	private MetroEnddeviceService enddeviceService;

	@Autowired
	private MessageChannel sendingProductImageChannel;

	@Autowired
	private ApplicationProperties properties;

	@Autowired
	private BatchProperties batchProperties;
	private Scheduler scheduler;

	MetroMspController(Scheduler scheduler) {
		this.scheduler = scheduler;
	}

	@Value("${aims.msp.msp-use}")
	private Boolean isMspEnabled;

	private static final String[] msg = { "Success.", "The requested data is empty or is not enough.",
			"The imageData is not valid.", "There is no label linked the article id.", "The page is not supported.",
			"Unknown Exception." };

	@PostMapping("/updateImage")
	public ResponseEntity<MetroResponse> updateImageOne(@RequestBody String reqData) {

		MetroResponse metroResp = new MetroResponse();
		List<OneResult> resultData = new ArrayList<OneResult>();

		// The API is Only for MSP
		if (!properties.isMspUse()) {
			log.warn("[METRO MSP] It does not support MSP flow because of the 'aims.msp.msp-use' is false.");
			OneResult tmpResult = new OneResult();
			metroResp.setResult(false);
			tmpResult.setResultCode("05");
			tmpResult.setResultMessage("It does not support MSP flow because of the 'aims.msp.msp-use' is false.");
			tmpResult.setRecordId("");
			resultData.add(tmpResult);
			metroResp.setResultData(resultData);
			return ResponseEntity.ok(metroResp);
		}

		log.info("[METRO MSP] updateImage : {}", reqData);

		try {

			if (reqData.equals("")) {
				OneResult oneResult = new OneResult();
				oneResult.setResultCode("01");
				oneResult.setResultMessage(msg[1]);
				resultData.add(oneResult);
				metroResp.setResult(false);
				metroResp.setResultData(resultData);
				log.error("[METRO MSP] The requested data is empty");
				ResponseEntity.ok(metroResp);
			}

			SolumJsonParser jsonParse = new SolumJsonParser();
			JsonNode rootNode = jsonParse.parseJson(reqData);
			if (rootNode.isArray()) {

				Set<String> listLabelId = new HashSet<>();
				// List<MetroContent> contents = new ArrayList<>();
				List<UpdateImageRequestBody> updateImages = new ObjectMapper().readValue(reqData,
						new TypeReference<List<UpdateImageRequestBody>>() {
						});
				updateImages.stream().forEach(updateImage -> {

					OneResult oneResult = new OneResult();
					String recordId = updateImage.getRecordId();

					try {
						String type = updateImage.getType();
						int page = updateImage.getPage();
						List<OneResult> one = validateAndUpdateImage(updateImage, recordId);

						if (!ObjectUtils.isEmpty(one)) {
							resultData.addAll(one);
							return;
						}
						MetroArticle article;
						if (batchProperties.getProcessorJob().isUseStationParam()) {
							article = articleService.getByStationAndArticleId(updateImage.getCountryCode(),
									updateImage.getStoreNumber(), updateImage.getSalesLine(),
									updateImage.getArticleId());
							if (null == article.getId()) {
								log.info("[METRO MSP] NO ARTICLE Info : {}", article);
								oneResult.setResultCode("03");
								oneResult.setResultMessage(msg[3]);
								oneResult.setRecordId(recordId);
								resultData.add(oneResult);
								return;
							}
						} else {
							article = articleService.getByStationAndArticleId(properties.getCountryCodeDefault(),
									properties.getStoreNumberDefault(), properties.getSalesLineDefault(),
									updateImage.getArticleId());
							if (null == article.getId()) {
								log.info("[METRO MSP] NO ARTICLE Info : {}", article);
								oneResult.setResultCode("03");
								oneResult.setResultMessage(msg[3]);
								oneResult.setRecordId(recordId);
								resultData.add(oneResult);
								return;
							}
						}

						List<MetroEnddevice> metroEnddevices = enddeviceService.getByArticleIdAndType(article.getId(),
								type);

						if (metroEnddevices == null || metroEnddevices.size() == 0) {
							log.info("[METRO MSP] Invalid Type Info : {}", type);
							oneResult.setResultCode("01");
							oneResult.setResultMessage("This Article is not mapped with this label type {} " + type);
							oneResult.setRecordId(recordId);
							resultData.add(oneResult);
							return;
						}

						EndDeviceType labelType = EndDeviceUtils.getEndDeviceType(metroEnddevices.get(0).getCode());
						int tmpMaxPage = labelType.getTotalPage();
						if ((page <= 0) || (tmpMaxPage < page)) {
							log.info("[METRO MSP] Invalid Page Info : {}", page);
							oneResult.setResultCode("04");
							oneResult.setResultMessage(msg[4]);
							oneResult.setRecordId(recordId);
							resultData.add(oneResult);
							return;
						}

						MetroContent content = contentService.getByUpdateImageParam(article, updateImage.getWidth(),
								updateImage.getHeight(), updateImage.getColor(), updateImage.getPage(),
								updateImage.getModel());

						content.setArticle(article);
						content.setWidth(updateImage.getWidth());
						content.setHeight(updateImage.getHeight());
						content.setColor(updateImage.getColor());
						content.setModel(updateImage.getModel());
						content.setType(updateImage.getType());
						content.setContent(updateImage.getImageData());
						content.setPage(updateImage.getPage());

						contentService.updateContent(content);
						// contents.add(content);

						// TODO : Send to content ID
						article.getEnddevices().stream()
								.filter(enddevice -> (enddevice.getWidth() == updateImage.getWidth()))
								.filter(enddevice -> (enddevice.getHeight() == updateImage.getHeight()))
								.filter(enddevice -> (enddevice.getColor() == updateImage.getColor()))
								.filter(enddevice -> (enddevice.getModel() == updateImage.getModel()))
								.forEach(enddevice -> {
									// sendingProductImageChannel.send(MessageBuilder.withPayload(enddevice.getId()).build());
									listLabelId.add(enddevice.getCode() + "-" + updateImage.getPage());
								});

						oneResult.setResultCode("00");
						oneResult.setResultMessage(msg[0]);
						oneResult.setRecordId(recordId);
						resultData.add(oneResult);

					} catch (Throwable e) {
						log.error("[METRO MSP] {}", e);
						oneResult.setResultCode("05");
						oneResult.setResultMessage(msg[5]);
						oneResult.setRecordId(recordId);
						resultData.add(oneResult);
						return;
					}
				});

				// List<String> labelIds =
				// listLabelId.stream().distinct().collect(Collectors.toList());
				listLabelId.parallelStream().forEach(labelId -> {
					sendingProductImageChannel.send(MessageBuilder.withPayload(labelId).build());
				});

				metroResp.setResult(true);
			} else {
				try {
					OneResult oneResult = new OneResult();
					UpdateImageRequestBody updateImage = new ObjectMapper().readValue(reqData,
							new TypeReference<UpdateImageRequestBody>() {
							});
					String recordId = updateImage.getRecordId();
					String type = updateImage.getType();
					int page = updateImage.getPage();

					List<OneResult> one = validateAndUpdateImage(updateImage, recordId);

					if (!ObjectUtils.isEmpty(one)) {
						resultData.addAll(one);
						metroResp.setResultData(resultData);
						return ResponseEntity.ok(metroResp);
					}
					MetroArticle article = articleService.getByStationAndArticleId(updateImage.getCountryCode(),
							updateImage.getStoreNumber(), updateImage.getSalesLine(), updateImage.getArticleId());

					if (null == article.getId()) {
						article = articleService.getByStationAndArticleId(properties.getCountryCodeDefault(),
								properties.getStoreNumberDefault(), properties.getSalesLineDefault(),
								updateImage.getArticleId());

						if (null == article.getId()) {
							log.info("[METRO MSP] Invalid Article Info : {}", article);
							metroResp.setResult(false);
							oneResult.setResultCode("03");
							oneResult.setResultMessage(msg[3]);
							oneResult.setRecordId(recordId);
							resultData.add(oneResult);
							metroResp.setResultData(resultData);
							return ResponseEntity.ok(metroResp);
						}
					}

					List<MetroEnddevice> metroEnddevices = enddeviceService.getByArticleIdAndType(article.getId(),
							type);

					if (metroEnddevices == null || metroEnddevices.size() == 0) {
						log.info("[METRO MSP] Invalid Type Info : {}", type);
						metroResp.setResult(false);
						oneResult.setResultCode("01");
//						oneResult.setResultMessage(msg[1] + "May be Invalid Type " + type);
						oneResult.setResultMessage("This Article is not mapped with this label type {} " + type);
						oneResult.setRecordId(recordId);
						resultData.add(oneResult);
						metroResp.setResultData(resultData);
						return ResponseEntity.ok(metroResp);
					}

					EndDeviceType labelType = EndDeviceUtils.getEndDeviceType(metroEnddevices.get(0).getCode());
					int tmpMaxPage = labelType.getTotalPage();
					if ((page <= 0) || (tmpMaxPage < page)) {
						log.info("[METRO MSP] Invalid Page Info : {}", page);
						oneResult.setResultCode("04");
						oneResult.setResultMessage(msg[4]);
						oneResult.setRecordId(recordId);
						resultData.add(oneResult);
						metroResp.setResultData(resultData);
						return ResponseEntity.ok(metroResp);
					}

					MetroContent content = contentService.getByUpdateImageParam(article, updateImage.getWidth(),
							updateImage.getHeight(), updateImage.getColor(), updateImage.getPage(),
							updateImage.getModel());

					content.setArticle(article);
					content.setWidth(updateImage.getWidth());
					content.setHeight(updateImage.getHeight());
					content.setColor(updateImage.getColor());
					content.setModel(updateImage.getModel());
					content.setType(updateImage.getType());
					content.setContent(updateImage.getImageData());
					content.setPage(updateImage.getPage());

					contentService.updateContent(content);

					// TODO : Send to content ID
					article.getEnddevices().stream()
							.filter(enddevice -> (enddevice.getWidth() == updateImage.getWidth()))
							.filter(enddevice -> (enddevice.getHeight() == updateImage.getHeight()))
							.filter(enddevice -> (enddevice.getColor() == updateImage.getColor()))
							.filter(enddevice -> (enddevice.getModel() == updateImage.getModel()))
							.forEach(enddevice -> {
								sendingProductImageChannel.send(MessageBuilder
										.withPayload(enddevice.getCode() + "-" + updateImage.getPage()).build());
							});

					metroResp.setResult(true);
					oneResult.setResultCode("00");
					oneResult.setResultMessage(msg[0]);
					oneResult.setRecordId(recordId);
					resultData.add(oneResult);
				} catch (Throwable e) {
					log.info("[METRO MSP] Exception : {}", e);
					OneResult tmpResult = new OneResult();
					metroResp.setResult(false);
					tmpResult.setResultCode("05");
					tmpResult.setResultMessage(msg[5]);
					tmpResult.setRecordId("");
					resultData.add(tmpResult);
					metroResp.setResultData(resultData);
					return ResponseEntity.ok(metroResp);
				}
			}

		} catch (Throwable e) {
			log.info("[METRO MSP] Exception : {}", e);
			OneResult tmpResult = new OneResult();
			metroResp.setResult(false);
			tmpResult.setResultCode("05");
			tmpResult.setResultMessage(msg[5]);
			tmpResult.setRecordId("");
			resultData.add(tmpResult);
			metroResp.setResultData(resultData);
			return ResponseEntity.ok(metroResp);
		}

		metroResp.setResultData(resultData);
		log.info("[METRO MSP] updateImage : END");
		return ResponseEntity.ok(metroResp);
	}

	@GetMapping("msp-status")
	public ResponseEntity<MetroStatus> getMetroMspStatus() throws JSONException {
		log.info("REST request to get Metro MSP Status");
		MetroStatus response = new MetroStatus();
		if (Boolean.TRUE.equals(isMspEnabled)) {
			response.setMsp_enabled(true);
			return ResponseEntity.ok(response);
		} else {
			response.setMsp_enabled(false);
			return ResponseEntity.ok(response);
		}

	}

	@GetMapping("/backup")
	public ResponseEntity<String> getScheduler() {
		log.info("REST request to link back up API");
		try {
			scheduler.runBackupSchedule();
			return ResponseEntity.ok("Success");
		} catch (JsonProcessingException e) {
			log.error("Error while link back up schedule {} ", e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");

		}

	}

	private List<OneResult> addErrorResult(String resultCode, String resultMessage, String recordId) {
		List<OneResult> resultData = new ArrayList<OneResult>();
		OneResult oneResult = new OneResult();
		oneResult.setResultCode(resultCode);
		oneResult.setResultMessage(resultMessage);
		oneResult.setRecordId(recordId);
		resultData.add(oneResult);
		return resultData;

	}

	private List<OneResult> validateAndUpdateImage(UpdateImageRequestBody updateImage, String recordId) {
		if (ObjectUtils.isEmpty(updateImage.getRecordId())) {
			return addErrorResult("01", "Record ID is empty in the request body", "");
		} else if (ObjectUtils.isEmpty(updateImage.getArticleId())) {
			return addErrorResult("01", "Article ID is empty in the request body", recordId);
		} else if (ObjectUtils.isEmpty(updateImage.getWidth()) || updateImage.getWidth() == 0) {
			return addErrorResult("01", "Label Width is empty in the request body", recordId);
		} else if (ObjectUtils.isEmpty(updateImage.getHeight()) || updateImage.getHeight() == 0) {
			return addErrorResult("01", "Label Height is empty in the request body", recordId);
		} else if (ObjectUtils.isEmpty(updateImage.getColor()) || updateImage.getColor() == 0) {
			return addErrorResult("01", "Label Color is empty in the request body", recordId);
		} else if (ObjectUtils.isEmpty(updateImage.getModel()) || updateImage.getModel() == 0) {
			return addErrorResult("01", "Label Model is empty in the request body", recordId);
		} else if (ObjectUtils.isEmpty(updateImage.getType())) {
			return addErrorResult("01", "Label Type is empty in the request body", recordId);
		} else if (ObjectUtils.isEmpty(updateImage.getImageData())) {
			return addErrorResult("01", "Label Image is empty in the request body", recordId);
		} else if (ObjectUtils.isEmpty(updateImage.getPage()) || updateImage.getPage() == 0) {
			return addErrorResult("01", "Label Page is empty in the request body", recordId);
		} else {
			return new ArrayList<>();
		}
	}
}
