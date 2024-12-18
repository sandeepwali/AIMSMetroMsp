package com.solum.aims.msp.controller.parameter.template;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter @Getter
public class TemplateGroupNameListParam implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<String> templateNameList;
	private String responseCode;
	private String responseMessage;
}
