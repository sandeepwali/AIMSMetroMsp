package com.solum.aims.msp.controller.request;

import lombok.Data;

import java.util.List;

@Data
public class TemplateGroupMapParam {

	private String groupName;
	private Integer model;

	private List<String> templateNameList;
}
