package com.solum.aims.msp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.solum.aims.msp.persistence.core.repository.CoreEndDeviceRepository;
import com.solum.aims.msp.service.CoreEndDeviceService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("coreEndDeviceService")
public class CoreEndDeviceServiceImpl implements CoreEndDeviceService {

	@Autowired
	private CoreEndDeviceRepository repository;

	@Override
	public int getErrorLabelListInfoForCount(long id) {
		return repository.getErrorLabelListInfoForCount(id);
	}

	@Override
	public int getErrorLabelListForCount(long id) {
		return repository.getErrorLabelListForCount(id);
	}

	@Override
	public List<String> getErrorLabelList(long stationId) {
		return repository.findErrorLabelByStationId(stationId);
	}

	@Override
	public List<String> getErrorLabelListInfo(long stationId) {
		return repository.findErrorLabeInfolByStationId(stationId);
	}

	@Override
	public Page<Object[]> getProductInfoList(long stationId, Pageable pageable) {
		 return repository.getProductInfoList(stationId, pageable);
	}

}
