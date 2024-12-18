package com.solum.aims.msp.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.solum.aims.msp.persistence.entity.EndDevice;
import com.solum.aims.msp.persistence.repository.EndDeviceRepository;
import com.solum.aims.msp.persistence.repository.projection.ArticleEnddeviceProjection;
import com.solum.aims.msp.service.EndDeviceService;



@Service("endDeviceService")
public class EndDeviceServiceImpl<T extends EndDevice> implements EndDeviceService<T> {

	@Autowired
	private EndDeviceRepository<T> endDeviceRepository;
	
	@Override
	public T saveEndDevice(T entity) {
		return endDeviceRepository.save(entity);
	}
	
	@Override @Transactional(transactionManager = "transactionManager", propagation= Propagation.REQUIRES_NEW)
	public void deleteEndDevice(String labelCode) {
		endDeviceRepository.deleteByLabelCode(labelCode);
	}

	@Override
	public T findEndDevice(String labelCode) {
		return endDeviceRepository.findById(labelCode).orElse((T) new EndDevice());
	}

	@Override
	public boolean isExistEndDevice(String labelCode) {
		return endDeviceRepository.existsById(labelCode);
	}

	@Transactional(transactionManager="transactionManager", propagation=Propagation.REQUIRES_NEW)
	@Override
	public void updateLinkInfo(String stationCode, String labelCode, String articleId) {
		if(!endDeviceRepository.existsById(labelCode)) {
			endDeviceRepository.insertEnddevice(stationCode, labelCode, new Date(), new Date(), false);
		} else {
			endDeviceRepository.updateEnddevice(labelCode, new Date());
			endDeviceRepository.deleteEnddeviceArticles(labelCode);
		}
		endDeviceRepository.insertEnddeviceArticles(stationCode, labelCode, 1, articleId);
	}
	
	@Override
	public List<String> getEnddeviceGroupByStationCode() {
		return endDeviceRepository.getEnddeviceGroupByStationCode();
	}
	
	@Override
	public List<ArticleEnddeviceProjection> getArticleEnddevice(String stationCode) {
		return endDeviceRepository.getArticleEnddevice(stationCode);
	}
}
