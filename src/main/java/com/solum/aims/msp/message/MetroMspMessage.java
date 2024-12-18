package com.solum.aims.msp.message;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class MetroMspMessage {

	private String countryCode;
	
	private String salesLine;
	
	private String storeNumber;
	
	private String articleId;
	
	private Integer width;
	
	private Integer height;
	
	private Integer color;
	
	private Integer model;
	
	private String type;
	
	private String imageData;
	
	private Integer page;
}
