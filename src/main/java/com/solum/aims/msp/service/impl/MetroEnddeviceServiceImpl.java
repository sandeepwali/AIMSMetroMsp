package com.solum.aims.msp.service.impl;

import com.solum.aims.msp.persistence.entity.MetroEnddevice;
import com.solum.aims.msp.persistence.repository.MetroEnddeviceRepository;
import com.solum.aims.msp.service.MetroEnddeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("metroEnddeviceService")
public class MetroEnddeviceServiceImpl implements MetroEnddeviceService {

	@Autowired
	private MetroEnddeviceRepository repository;

	@Override
	public MetroEnddevice get(Long id) {
		return repository.findById(id).get();
	}
	
	@Transactional(
			transactionManager="transactionManager", 
			propagation=Propagation.REQUIRES_NEW
			)
	@Override
	public MetroEnddevice getByLabelCode(String labelCode) {
		return repository.findByCode(labelCode).orElse(new MetroEnddevice());
	}

	@Transactional(
			transactionManager="transactionManager", 
			propagation=Propagation.REQUIRES_NEW
			)
	@Override
	public MetroEnddevice updateLinkInfo(MetroEnddevice metroEnddevice) {
		return repository.save(metroEnddevice);
	}

	@Transactional(
			transactionManager="transactionManager", 
			propagation=Propagation.REQUIRES_NEW
			)
	@Override
	public void removeLinkInfo(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<MetroEnddevice> getByArticleId(long articleId) {
		return repository.findByArticleId(articleId).orElse(new ArrayList<MetroEnddevice>());
	}
	
	@Override
	@Transactional(
			transactionManager="transactionManager", 
			propagation=Propagation.REQUIRES_NEW
			)
	public List<MetroEnddevice> getByArticleIdAndType(long articleId, String type){
		return repository.findByArticleIdAndType(articleId, type).orElse(new ArrayList<MetroEnddevice>());		
	}
	
	@Override
	public List<MetroEnddevice> getByType(String type){
		return repository.findByType(type).orElse(new ArrayList<MetroEnddevice>());
	}

	@Override
	public int getCountByArticleIdAndType(long articleId, String type) {
		return repository.countByArticleIdAndType(articleId,type);
	}

}
