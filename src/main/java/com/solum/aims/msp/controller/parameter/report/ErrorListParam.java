package com.solum.aims.msp.controller.parameter.report;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
public class ErrorListParam implements Serializable {
	private static final long serialVersionUID = 1L;

	private String itemGroup;

	private String itemId;

	private String description;

	private String labelId;

	private String price;

	private String amountLabel;
}