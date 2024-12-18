package com.solum.aims.msp.controller.parameter.report;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
public class GwParam {
	private String id;
	private String name;
}