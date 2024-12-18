package com.solum.aims.msp.controller.parameter.report;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.solum.aims.msp.controller.response.AimsApiResponse;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
public class ErrorParam extends AimsApiResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private String lastUpdatedTime;

	private List<ErrorListParam> errorList;
}