package com.solum.aims.msp.persistence.repository;

import com.solum.aims.msp.persistence.entity.MetroArticle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("metroArticleRepository")
public interface MetroArticleRepository extends CrudRepository<MetroArticle, Long> {

	public Optional<MetroArticle> findByCountryCodeAndStoreNumberAndSalesLineAndArticleId(String countryCode, String storeNumber, String salesLine, String articleId);
	
	@Query(nativeQuery=true, value="select * from metro_article ma where ma.country_code||'_'||ma.store_number = ?1 ")
	public List<MetroArticle> findByStationCode(String stationCode);
}
