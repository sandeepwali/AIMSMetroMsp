package com.solum.aims.msp.infrastructure.batch.task;

import com.solum.aims.core.entity.Content.ContentType;
import com.solum.aims.msp.infrastructure.batch.MessageEndPointChain;
import com.solum.aims.msp.message.AimsApiResponse;
import com.solum.aims.msp.message.AimsPortalUpdateImage;
import com.solum.aims.msp.message.AimsPortalUpdateImageLabel;
import com.solum.aims.msp.message.AimsPortalUpdateImageLabelContent;
import com.solum.aims.msp.persistence.entity.MetroArticle;
import com.solum.aims.msp.persistence.entity.MetroContent;
import com.solum.aims.msp.persistence.entity.MetroEnddevice;
import com.solum.aims.msp.service.MetroContentService;
import com.solum.aims.msp.service.MetroEnddeviceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.client.RestTemplate;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class SendingImageToAimsTasklet implements Tasklet, InitializingBean {

	@Autowired
	private String aimsUrl;
	
	@Autowired
	private MetroEnddeviceService metroEnddeviceService;
	
	@Autowired
	private MetroContentService contentService;
	
	@Autowired
	private RestTemplate restTemplate;

	@Value("${aims.portal.api.key}")
	private String apiKey;
	
	@Override
	public void afterPropertiesSet() throws Exception {}

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
		String enddeviceId = (String) chunkContext.getStepContext().getJobParameters().get(MessageEndPointChain.MESSAGE_KEY);
		
		log.info("Enddevice id({})", enddeviceId);
		
		String[] enddeviceCode = enddeviceId.split("-");
		MetroEnddevice metroEnddevice = metroEnddeviceService.getByLabelCode(enddeviceCode[0]);
		List<MetroContent> contents = contentService.getByEnddeviceAndPage(metroEnddevice, Integer.parseInt(enddeviceCode[1]));

		AimsPortalUpdateImage updateImage = new AimsPortalUpdateImage();
		updateImage.setLabels(new ArrayList<>());
		
		AimsPortalUpdateImageLabel label = new AimsPortalUpdateImageLabel();
		label.setLabelCode(metroEnddevice.getCode());
		//Setting up NFC url while sending ImagePush new requirement ticket #21495 F560 field is for NFC.
		String nfcUrl = Optional.ofNullable(metroEnddevice.getArticle())
				.map(MetroArticle::getData)
				.map(data -> data.get("F560"))
				.orElse("");
		label.setNfcUrl(nfcUrl);
		label.setFrontPage(1);
		label.setContents(new ArrayList<>());
		if(contents.size() > 0) {
			contents.stream().forEach(c->{
				AimsPortalUpdateImageLabelContent content = new AimsPortalUpdateImageLabelContent();
				content.setContentType(ContentType.IMAGE);
				content.setPageIndex(c.getPage());
				content.setSkipChecksumValidation(false);
				
				try {
					InputStream svgByteArrayStream = new ByteArrayInputStream(c.getContent().getBytes("UTF-8"));
					TranscoderInput svgTranscoderInput = new TranscoderInput(svgByteArrayStream);
					PNGTranscoder pngTranscoder = new PNGTranscoder();
					pngTranscoder.addTranscodingHint(PNGTranscoder.KEY_MAX_WIDTH, c.getWidth() * 1.0F);
					pngTranscoder.addTranscodingHint(PNGTranscoder.KEY_MAX_HEIGHT, c.getHeight() * 1.0F);
					
					FastByteArrayOutputStream os = new FastByteArrayOutputStream();
					TranscoderOutput pngImage = new TranscoderOutput(os);
					pngTranscoder.transcode(svgTranscoderInput, pngImage);
					os.close();
					
					content.setImgBase64(os.toByteArray());
					label.getContents().add(content);
				} catch (UnsupportedEncodingException | TranscoderException e) {
					log.warn("", e);
				}
			});
		} else {
			log.info("Creating default image.");
			
			AimsPortalUpdateImageLabelContent content = new AimsPortalUpdateImageLabelContent();
			content.setContentType(ContentType.IMAGE);
			content.setPageIndex(1);
			content.setSkipChecksumValidation(false);
			
			BufferedImage bufferdImage = contentService.createDefaultImage(metroEnddevice.getCode(), metroEnddevice.getArticle().getArticleId());
			FastByteArrayOutputStream os = new FastByteArrayOutputStream(); 
			ImageIO.write(bufferdImage, "PNG", os);
			os.close();
			
			content.setImgBase64(os.toByteArray());
			label.getContents().add(content);
		}
		
		if(label.getContents().size() > 0) {
			updateImage.getLabels().add(label);
			
			HttpHeaders httpHeader = new HttpHeaders();
			httpHeader.setContentType(MediaType.APPLICATION_JSON);
			httpHeader.set("api-key", apiKey);

			HttpEntity<AimsPortalUpdateImage> httpEntity = new HttpEntity<AimsPortalUpdateImage>(
					updateImage, httpHeader);
			ResponseEntity<AimsApiResponse> sendRsp = restTemplate.exchange(
					new StringBuilder(aimsUrl)
					.append("/labels/contents/image?stationCode=")
					.append(metroEnddevice.getArticle().getAimsStationCode())
					.toString(),
					HttpMethod.POST,
					httpEntity, 
					new ParameterizedTypeReference<AimsApiResponse>(){}
					);
			
			log.info("Response from AIMS : {}, {}",sendRsp.getStatusCode(), sendRsp.getBody());
		}

		return RepeatStatus.FINISHED;
	}
}
