package com.solum.aims.msp.controller.parameter.report;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
public class ProductInfoListParam implements Serializable {
	private static final long serialVersionUID = 1L;

	private String system;

	private String type;

	private int total;

	private int year8more;

	private int year7;

	private int year6;

	private int year5;

	private int year5less;

	private int unknown;
}