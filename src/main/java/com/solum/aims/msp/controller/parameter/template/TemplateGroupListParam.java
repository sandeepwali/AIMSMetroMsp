package com.solum.aims.msp.controller.parameter.template;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class TemplateGroupListParam implements Serializable {

	private static final long serialVersionUID = 1L;

	private String groupName;
	private Date lastModifiedDate;
	private Integer model;
}