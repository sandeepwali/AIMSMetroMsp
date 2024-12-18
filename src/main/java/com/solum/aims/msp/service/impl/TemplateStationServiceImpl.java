package com.solum.aims.msp.service.impl;

import com.solum.aims.msp.persistence.entity.TemplateStation;
import com.solum.aims.msp.persistence.repository.TemplateStationRepository;
import com.solum.aims.msp.service.TemplateStationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TemplateStationServiceImpl implements TemplateStationService {

	
	@Autowired
	TemplateStationRepository templateStationRepository;
	@Override
	public TemplateStation findByStationCodeAndTypeNameAndTemplateSize(String stationCode, String typeName,
			String templateSize) {
		log.info("Service Request to get Template Station By Station Code {} , Type Name {} and Template Size {} ",
				stationCode, typeName, templateSize);
		return templateStationRepository.findByStationCodeAndTypeNameAndTemplateSize(stationCode, typeName,
				templateSize);

	}

}
