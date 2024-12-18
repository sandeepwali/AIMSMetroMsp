package com.solum.aims.msp.controller.parameter.report;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
public class ErrorGwParam implements Serializable {
	private static final long serialVersionUID = 1L;

	private String lastUpdatedTime;

	private List<ErrorListParam> errorListGw;

	private String responseCode;

	private String responseMessage;
}