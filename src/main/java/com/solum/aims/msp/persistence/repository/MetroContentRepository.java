package com.solum.aims.msp.persistence.repository;

import com.solum.aims.msp.persistence.entity.MetroArticle;
import com.solum.aims.msp.persistence.entity.MetroContent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("metroContentRepository")
public interface MetroContentRepository extends CrudRepository<MetroContent, Long> {

	public Optional<MetroContent> findByArticleAndWidthAndHeightAndColorAndModelAndPage(
			MetroArticle article, 
			int width,
			int height,
			int color,
			int model,
			int page);
	
	public List<MetroContent> findByArticleAndWidthAndHeightAndColorAndModelOrderByPage(
			MetroArticle article, 
			int width,
			int height,
			int color,
			int model);
	
	public List<MetroContent> findByArticleAndWidthAndHeightAndColorAndModelAndPageOrderByPage(
			MetroArticle article, 
			int width,
			int height,
			int color,
			int model,
			int page);
	
	public void deleteByArticle(MetroArticle article);
	public void deleteByArticleAndType(MetroArticle article,String type);
}
