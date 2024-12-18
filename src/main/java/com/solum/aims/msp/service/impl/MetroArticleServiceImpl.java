package com.solum.aims.msp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.solum.aims.msp.persistence.entity.MetroArticle;
import com.solum.aims.msp.persistence.repository.MetroArticleRepository;
import com.solum.aims.msp.service.MetroArticleService;

@Service("metroArticleService")
public class MetroArticleServiceImpl implements MetroArticleService {

	@Autowired(required = true)
	private MetroArticleRepository repository;

	@Transactional(transactionManager = "transactionManager", propagation = Propagation.REQUIRES_NEW)
	@Override
	public MetroArticle getByStationAndArticleId(String countryCode, String storeNumber, String salesLine,
			String articleId) {

		return repository
				.findByCountryCodeAndStoreNumberAndSalesLineAndArticleId(countryCode, storeNumber, salesLine, articleId)
				.orElse(new MetroArticle());
	}

	@Transactional(transactionManager = "transactionManager", propagation = Propagation.REQUIRES_NEW)
	@Override
	public MetroArticle update(MetroArticle metroArticle) {
		MetroArticle entity = repository
				.findByCountryCodeAndStoreNumberAndSalesLineAndArticleId(metroArticle.getCountryCode(),
						metroArticle.getStoreNumber(), metroArticle.getSalesLine(), metroArticle.getArticleId())
				.orElse(new MetroArticle());

		entity.setCountryCode(metroArticle.getCountryCode());
		entity.setStoreNumber(metroArticle.getStoreNumber());
		entity.setSalesLine(metroArticle.getSalesLine());
		entity.setArticleId(metroArticle.getArticleId());

		if (!ObjectUtils.isEmpty(entity.getData())) {
			entity.getData().putAll(metroArticle.getData());
		} else {
			entity.setData(metroArticle.getData());
		}
		return repository.save(entity);
	}

	@Override
	public void remove(Long id) {
		if (null != id) {
			repository.deleteById(id);
		}
	}

	@Override
	public List<MetroArticle> findByStationCode(String stationCode) {
		return repository.findByStationCode(stationCode);
	}

}
