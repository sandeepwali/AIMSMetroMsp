package com.solum.aims.msp.controller.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter @ToString
public class MetroResponse {

	private boolean result = true;
	
	private List<OneResult> resultData;
	/*
	private String resultCode = "00";	
	private String resultMessage = "";	
	private String recordId;
	*/
}
