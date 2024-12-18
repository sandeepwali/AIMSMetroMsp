package com.solum.aims.msp.controller.parameter.template;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TemplateGroupParam implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<TemplateGroupListParam> groupList;
	private String responseCode;
	private String responseMessage;
}
