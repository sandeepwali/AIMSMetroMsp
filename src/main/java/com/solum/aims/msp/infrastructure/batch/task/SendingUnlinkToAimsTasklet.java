package com.solum.aims.msp.infrastructure.batch.task;

import com.solum.aims.msp.infrastructure.batch.MessageEndPointChain;
import com.solum.aims.msp.message.AimsApiResponse;
import com.solum.aims.msp.message.AimsPortalUpdateImage;
import lombok.extern.slf4j.Slf4j;
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
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class SendingUnlinkToAimsTasklet implements Tasklet, InitializingBean {

	@Autowired
	private String aimsUrl;
	
	@Autowired
	private RestTemplate restTemplate;

	@Value("${aims.portal.api.key}")
	private String apiKey;
	
	@Override
	public void afterPropertiesSet() throws Exception {}

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
		String labelCode = (String) chunkContext.getStepContext().getJobParameters().get(MessageEndPointChain.MESSAGE_KEY);
		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.set("api-key", apiKey);
		HttpEntity<AimsPortalUpdateImage> httpEntity = new HttpEntity<AimsPortalUpdateImage>(
				httpHeader);
		try {
			ResponseEntity<AimsApiResponse> sendRsp = restTemplate.exchange(
					new StringBuilder(aimsUrl)
					.append("/labels/unlink?labelCode=")
					.append(labelCode)
					.toString(), 
					HttpMethod.POST,
					httpEntity,
					new ParameterizedTypeReference<AimsApiResponse>(){}
					);
			
			log.info("Response from AIMS : {}, {}",sendRsp.getStatusCode(), sendRsp.getBody());
		} catch (HttpClientErrorException.NotFound e) {
			log.warn("It does not exist label - {}", labelCode);
		}
		return RepeatStatus.FINISHED;
	}
}
