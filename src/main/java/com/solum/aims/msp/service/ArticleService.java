package com.solum.aims.msp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.solum.aims.msp.persistence.entity.Article;

public interface ArticleService<T extends Article> {

	T saveArticle(T entity);		
	T findArticle(String stationCode, String articleId);
	boolean isExistArticle(String stationCode, String articleId);
	void deleteArticle(String stationCode, String articleId);
	List<String> getArticleGroupByStationCode();
	public List<String> getReservedList(String stationCode, String key);
	Page<Object[]> getErrorList(String dept, List<String> labels, String resOne, String resTwo, String resThree,
				Integer count, String type, Pageable pageable);
	List<Object[]> getGwErrorList(List<String> labels, String resOne, String resTwo, String resThree,
			Pageable pageable);
}
