package com.solum.aims.msp.persistence.repository;

import com.solum.aims.msp.persistence.entity.EndDevice;
import com.solum.aims.msp.persistence.repository.projection.ArticleEnddeviceProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Repository("endDeviceRepository")
public interface EndDeviceRepository<T extends EndDevice> extends JpaRepository<T, String> {
	
	@Transactional
	public void deleteByLabelCode(String labelCode);
	
	@Query(nativeQuery = true, value="SELECT DISTINCT label_code FROM end_device")
	public List<String> getAllEndDeviceCodes();
	
	@Transactional @Modifying
	@Query(nativeQuery = true,
			value="insert into end_device (station_code, label_code, created, last_modified, template_manual) values (?1, ?2, ?3, ?4, ?5)")
	public void insertEnddevice(String stationCode, String labelCode, Date created, Date modified, boolean templateManual);
	
	@Transactional @Modifying
	@Query(nativeQuery = true,
			value="update end_device set last_modified=?2 where label_code=?1")
	public void updateEnddevice(String labelCode, Date modified);
	
	@Transactional @Modifying
	@Query(nativeQuery = true,
			value="delete from end_device_templates where label_code=?1")
	public void deleteEnddeviceTemplates(String labelCode);
	
	@Transactional @Modifying
	@Query(nativeQuery = true,
			value="delete from end_device_articles where label_code=?1")
	public void deleteEnddeviceArticles(String labelCode);
	
	@Transactional @Modifying
	@Query(nativeQuery = true,
			value="insert into end_device_templates (station_code, label_code, page, name) values (?1, ?2, ?3, ?4)")
	public void insertEnddeviceTemplates(String stationCode, String labelCode, int page, String name);
	
	@Transactional @Modifying
	@Query(nativeQuery = true,
			value="insert into end_device_articles (station_code, label_code, seq, article_id) values (?1, ?2, ?3, ?4)")
	public void insertEnddeviceArticles(String stationCode, String labelCode, int seq, String articleId);
	
	@Query(nativeQuery=true, value="select station_code from end_device group by station_code")
	List<String> getEnddeviceGroupByStationCode();
	
	@Query(nativeQuery=true, value="select ma.article_id articleId, me.code code, me.model model from metro_article ma inner join metro_enddevice me on ma.id = me.article_id where ma.country_code||'_'||ma.store_number = ?1 ")
	List<ArticleEnddeviceProjection> getArticleEnddevice(String stationCode);
	
}
