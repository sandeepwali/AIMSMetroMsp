package com.solum.aims.msp.service;

import java.awt.image.BufferedImage;
import java.util.List;

import com.solum.aims.msp.persistence.entity.MetroArticle;
import com.solum.aims.msp.persistence.entity.MetroContent;
import com.solum.aims.msp.persistence.entity.MetroEnddevice;

public interface MetroContentService {

	public MetroContent getByUpdateImageParam(MetroArticle article, 
			int width,
			int height,
			int color,
			int page,
			int model);
	
	public void updateContent(MetroContent content);
	public void updateContents(List<MetroContent> contents);
	
	public List<MetroContent> getByEnddevice(MetroEnddevice metroEnddevice);
	public List<MetroContent> getByEnddeviceAndPage(MetroEnddevice metroEnddevice, int page);

	public void removeByArticle(MetroArticle article);

	public void removeByArticleAndType(MetroArticle article,String type);

	public BufferedImage createDefaultImage(String labelCode, String articleId);
}
