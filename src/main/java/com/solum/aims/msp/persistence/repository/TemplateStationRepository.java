package com.solum.aims.msp.persistence.repository;

import com.solum.aims.msp.persistence.entity.TemplateStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TemplateStationRepository extends JpaRepository<TemplateStation, String> {

	@Query(nativeQuery = true, value = "select * from template_station where station_code=?1 and type_name=?2 and template_size=?3")
	TemplateStation findByStationCodeAndTypeNameAndTemplateSize(String stationCode, String typeName,
			String templateSize);

}
