package com.solum.aims.msp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.solum.aims.msp.message.AimsApiResponse;
import com.solum.aims.msp.message.AimsPortalRequestAssignParam;
import com.solum.aims.msp.message.AimsPortalUpdateArticleParam;
import com.solum.aims.msp.service.AimsMspRestTemplateService;

import lombok.extern.slf4j.Slf4j;

@Service("aimsMspRestTemplateService")
@Slf4j
public class AimsMspRestTemplateServiceImpl implements AimsMspRestTemplateService {

    @Autowired
    private String aimsUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${aims.portal.api.key}")
    private String apiKey;


    @Override
    public void updateArticle(AimsPortalUpdateArticleParam updateArticleParam) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AimsPortalUpdateArticleParam> httpEntity = new HttpEntity<>(updateArticleParam, headers);

        restTemplate.exchange(new StringBuilder(aimsUrl).append("" +
                "/articles").toString(), HttpMethod.POST, httpEntity, new ParameterizedTypeReference<AimsApiResponse>() {
        });
    }

    @Override
    public void sendPostRequestAssign(String stationCode, String labelCode, String articleId, String templateName) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        AimsPortalRequestAssignParam requestAssignParam = new AimsPortalRequestAssignParam();
        requestAssignParam.setLabelCode(labelCode);
        requestAssignParam.getArticleIdList().add(articleId);
        if(!templateName.isEmpty()){
            requestAssignParam.setTemplateName(templateName);
        }
        HttpEntity<AimsPortalRequestAssignParam> httpEntity = new HttpEntity<>(requestAssignParam, headers);
        restTemplate.exchange(new StringBuilder(aimsUrl).append("/labels/link/").append(stationCode).toString(), HttpMethod.POST, httpEntity, new ParameterizedTypeReference<AimsApiResponse>() {
        });

    }

    @Override
    public void sendRequestDeleteArticle(String stationCode, String articleId) {
        String requestUrl = new StringBuilder(aimsUrl).append("/articles/").append(articleId).append("?stationCode=").append(stationCode).toString();

        restTemplate.delete(requestUrl);
    }

	@Override
	public Integer getPortalStatus() {
		try {
			log.info("Checking for Portal Status");
            HttpHeaders headers = new HttpHeaders();
            headers.set("api-key", apiKey); // Replace "your-api-key" with your actual API key

            ResponseEntity<Object> exchange = restTemplate.exchange(
                    aimsUrl + "/system",
                    HttpMethod.GET,
                    new HttpEntity<>(headers),
                    new ParameterizedTypeReference<Object>() {}
            );

            if (exchange.getStatusCode() == HttpStatus.OK) {
                return Integer.valueOf(HttpStatus.OK.value());
            } else {
                return Integer.valueOf(HttpStatus.BAD_GATEWAY.value());
            }
		} catch (Exception e) {
			e.printStackTrace();
            return Integer.valueOf(HttpStatus.BAD_GATEWAY.value());
		}
	}

}
