package com.solum.aims.msp.controller.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter @Getter
public class EditTemplateGroupParam implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<String> templateNameList;
}