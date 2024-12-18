package com.solum.aims.msp.service;

import java.util.List;

import com.solum.aims.msp.persistence.entity.EndDevice;
import com.solum.aims.msp.persistence.repository.projection.ArticleEnddeviceProjection;


public interface EndDeviceService<T extends EndDevice> {
	
	T saveEndDevice(T entity);
	
	void deleteEndDevice(String labelCode);
	
	T findEndDevice(String labelCode);
	
	boolean isExistEndDevice(String labelCode);
	
	void updateLinkInfo(String stationCode, String labelCode, String articleId);
	
	List<String> getEnddeviceGroupByStationCode();

	List<ArticleEnddeviceProjection> getArticleEnddevice(String stationCode);
}
