package com.solum.aims.msp.message;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter @ToString
public class AimsPortalUpdateImageLabel {

	private String labelCode;
	
	private int frontPage;
	
	private String nfcUrl;
/*	
	private Map<Integer, String> buttons = new HashMap<>();

	private Integer scanPeriod;
	
	private Integer activationRetryPeriod;
	
	private Integer scanRetryCount;
	
	private Integer connectThreshMode;
	
	private Boolean isHibernate;
	
	private Boolean isScanDirect;
*/
	private List<AimsPortalUpdateImageLabelContent> contents;
}
