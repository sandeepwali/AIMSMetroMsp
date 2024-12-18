package com.solum.aims.msp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.solum.aims.msp.persistence.core.entity.Station;
import com.solum.aims.msp.persistence.core.repository.StationRepository;
import com.solum.aims.msp.service.StationService;

@Transactional
@Service
public class StationServiceImpl implements StationService {

	@Autowired
	private StationRepository stationRepository;

	@Override
	public Station getStation(String stationCode) {
		return stationRepository.findByCode(stationCode);
	}

}