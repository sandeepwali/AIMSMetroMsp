package com.solum.aims.msp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solum.aims.msp.persistence.core.repository.AccesspointRepository;
import com.solum.aims.msp.service.AccesspointService;

@Service("accesspointService")
public class AccesspointServiceImpl implements AccesspointService {

	@Autowired
	private AccesspointRepository accesspointRepository;

	@Override
	public Object[] getErrorLabelByGw(String gw) {
		if ("".equals(gw)) gw = null;
	    return Optional.ofNullable(gw).isPresent() ? accesspointRepository.getErrorLabelByGw(Long.valueOf(gw)) : accesspointRepository.getErrorLabelByGw();
	}


	@Override
	public List<Object[]> getGwList(String stationCode) {
	    return accesspointRepository.getGwList(stationCode);
	}


	@Override
	public String findNameById(String gw) {
		return accesspointRepository.findNameById(Long.valueOf(gw));
	}


	

}