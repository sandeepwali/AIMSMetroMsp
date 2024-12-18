package com.solum.aims.msp.service;

import java.util.List;

import com.solum.aims.msp.persistence.entity.MetroEnddevice;

public interface MetroEnddeviceService {

	public MetroEnddevice get(Long id);
	public MetroEnddevice getByLabelCode(String labelCode);
	public MetroEnddevice updateLinkInfo(MetroEnddevice metroEnddevice);
	public void removeLinkInfo(Long id);
	public List<MetroEnddevice> getByArticleId(long articleId);
	public List<MetroEnddevice> getByArticleIdAndType(long articleId, String type);
	public List<MetroEnddevice> getByType(String type);

	public int getCountByArticleIdAndType(long articleId, String type);

}
