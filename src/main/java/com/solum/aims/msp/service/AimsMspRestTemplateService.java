package com.solum.aims.msp.service;

import com.solum.aims.msp.message.AimsPortalUpdateArticleParam;

public interface AimsMspRestTemplateService {

	void updateArticle(AimsPortalUpdateArticleParam updateArticleParam);
	void sendPostRequestAssign(String stationCode, String labelCode, String articleId, String templateName);
	void sendRequestDeleteArticle(String stationCode, String articleId);
	Integer getPortalStatus();
}
