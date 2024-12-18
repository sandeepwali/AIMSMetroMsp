package com.solum.aims.msp.controller.parameter.report;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class DepartmentParam implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<String> deptList;

	private String responseCode;

	private String responseMessage;
}