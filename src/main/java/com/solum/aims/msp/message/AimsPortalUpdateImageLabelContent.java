package com.solum.aims.msp.message;

import com.solum.aims.core.entity.Content.ContentType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class AimsPortalUpdateImageLabelContent {

	private ContentType contentType;
	
	private byte [] imgBase64;
	
	private int pageIndex;
	
	private boolean skipChecksumValidation = false;
}
