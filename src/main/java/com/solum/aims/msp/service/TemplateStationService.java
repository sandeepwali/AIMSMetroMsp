package com.solum.aims.msp.service;

import com.solum.aims.msp.persistence.entity.TemplateStation;

public interface TemplateStationService {

	TemplateStation findByStationCodeAndTypeNameAndTemplateSize(String stationCode, String typeName,
			String templateSize);

}
