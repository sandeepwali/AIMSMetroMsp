package com.solum.aims.msp.service;

import java.util.List;

public interface AccesspointService {
	Object[] getErrorLabelByGw(String gw);
	List<Object[]> getGwList(String stationCode);
	String findNameById(String gw);

}
