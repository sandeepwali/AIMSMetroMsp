package com.solum.aims.msp.infrastructure.batch.task;

import com.fasterxml.jackson.core.type.TypeReference;
import com.solum.aims.msp.infrastructure.batch.MessageEndPointChain;
import com.solum.aims.msp.message.AimsApiResponse;
import com.solum.aims.msp.message.MetroRequestChannelMessage;
import com.solum.aims.msp.message.MetroRequestMspBody;
import com.solum.aims.msp.util.AimsObjectMapper;
import com.solum.aims.msp.util.KeyGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class RequestingReleaseImageToMspTasklet implements Tasklet, InitializingBean {

	// /providerTransactionId/:providerTransactionId/requestType/unlink/countryCode/:countryCode/salesLine/:salesLine/storeNumber/:storeNumber 
	
	@Autowired
	private AimsObjectMapper objectMapper;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private String mspUrl;
	
	@Override
	public void afterPropertiesSet() throws Exception {}

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
		String messageString = (String) chunkContext.getStepContext().getJobParameters().get(MessageEndPointChain.MESSAGE_KEY);
		
		MetroRequestChannelMessage message = objectMapper.readValue(
				messageString, new TypeReference<MetroRequestChannelMessage>() {});
		
		log.info("MetroRequestChannelMessage = {}", message.toString());
		
		MetroRequestMspBody requestBody = new MetroRequestMspBody();
		requestBody.setProviderTransactionId(KeyGenerator.getKeyByDateFormat());
		requestBody.setCountryCode(message.getCountryCode());
		requestBody.setStoreNumber(message.getStoreNumber());
		requestBody.setSalesLine(message.getSalesLine());
		requestBody.setArticleId(message.getArticleId());
		message.getContents().forEach(content->{
			requestBody.setWidth(content.getWidth());
			requestBody.setHeight(content.getHeight());
			requestBody.setColor(content.getColor());
			requestBody.setModel(content.getModel());
			requestBody.setType(content.getType());
			
			log.info("MetroRequestMspBody = {}", requestBody.toString());
			
			HttpHeaders httpHeader = new HttpHeaders();
			httpHeader.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<MetroRequestMspBody> httpEntity = new HttpEntity<MetroRequestMspBody>(requestBody, httpHeader);
			
			ResponseEntity<AimsApiResponse> sendRsp = restTemplate.exchange(
					new StringBuilder(mspUrl)
					.append("/providerTransactionId/").append(requestBody.getProviderTransactionId())
					.append("/requestType/unlink")
					.append("/countryCode/").append(requestBody.getCountryCode())
					.append("/salesLine/").append(requestBody.getSalesLine())
					.append("/storeNumber/").append(requestBody.getStoreNumber())
					.toString(),
					HttpMethod.POST,
					httpEntity, 
					new ParameterizedTypeReference<AimsApiResponse>(){}
					);
			
			log.info("{}", sendRsp.getStatusCode());
		});
		
		return RepeatStatus.FINISHED;
	}
}
