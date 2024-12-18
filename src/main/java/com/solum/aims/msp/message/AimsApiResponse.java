package com.solum.aims.msp.message;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class AimsApiResponse {

	private String	returnMsg;
	
	private String	returnCode;
	
	private String	customBatchId;
}
