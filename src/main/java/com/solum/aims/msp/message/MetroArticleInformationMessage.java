package com.solum.aims.msp.message;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class MetroArticleInformationMessage {

	private String countryCode;
	
	private String storeNumber;
	
	private String articleId;
	
}
