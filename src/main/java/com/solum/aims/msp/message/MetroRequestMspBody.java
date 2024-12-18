package com.solum.aims.msp.message;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class MetroRequestMspBody {

	private String providerTransactionId;
	
	private String countryCode;
	
	private String storeNumber;
	
	private String salesLine;
	
	private String articleId;
	
	private int width;
	
	private int height;
	
	private int color;
	
	private int model;
	
	private String type;
}
