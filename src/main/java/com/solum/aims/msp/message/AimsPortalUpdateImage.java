package com.solum.aims.msp.message;

import com.solum.aims.msp.util.KeyGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter @ToString
public class AimsPortalUpdateImage {
	private String customBatchId = KeyGenerator.getKeyByDateFormat();
	
	private List<AimsPortalUpdateImageLabel> labels;
}
