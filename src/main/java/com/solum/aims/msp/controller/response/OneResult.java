package com.solum.aims.msp.controller.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class OneResult {
	private String resultCode = "00";	
	private String resultMessage = "";	
	private String recordId;
}