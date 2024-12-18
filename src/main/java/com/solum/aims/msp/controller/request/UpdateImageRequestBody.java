package com.solum.aims.msp.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class UpdateImageRequestBody {

	private String recordId;
	
	private String countryCode;
	
	private String salesLine;
	
	private String storeNumber;
	
	private String articleId;
	
	private int width;
	
	private int height;
	
	private int color;
	
	private int model;
	
	private String type;
	
	private String imageData;
	
	private int page;
	
	public void setImageData(String imageSvgData) {
		this.imageData = imageSvgData.replace("\\\"", "\"");
	}
}
