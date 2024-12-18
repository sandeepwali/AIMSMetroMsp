package com.solum.aims.msp.message;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Setter @Getter
public class AimsPortalArticleMessage implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String stationCode;
	private String id;
	private String name;
	private String nfc;
	
	private String originPrice;
	private String salePrice;
	private String discountPercent;
	
	private String reservedOne;
	private String reservedTwo;
	private String reservedThree;
	String reserved;

	private Map<String, String> data = new HashMap<>();
}
