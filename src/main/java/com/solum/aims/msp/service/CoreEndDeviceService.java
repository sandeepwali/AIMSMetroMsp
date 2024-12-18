package com.solum.aims.msp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CoreEndDeviceService {

	List<String> getErrorLabelList(long stationId);

	List<String> getErrorLabelListInfo(long stationId);

	int getErrorLabelListInfoForCount(long id);

	int getErrorLabelListForCount(long id);

	

	Page<Object[]> getProductInfoList(long id, Pageable pageable);
}
