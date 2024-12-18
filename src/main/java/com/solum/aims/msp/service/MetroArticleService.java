package com.solum.aims.msp.service;

import java.util.List;

import com.solum.aims.msp.persistence.entity.MetroArticle;

public interface MetroArticleService {

	public MetroArticle getByStationAndArticleId(String countryCode, String storeNumber, String salesLine, String articleId);
	
	public MetroArticle update(MetroArticle metorArticle);
	
	public void remove(Long id);
	
	public List<MetroArticle> findByStationCode(String stationCode);
	
}
