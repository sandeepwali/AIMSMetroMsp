package com.solum.aims.msp.controller.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class MetroTemplateGroupResponse {

	private String name;

	@JsonIgnore
	private String description;

	private String created;

	@JsonIgnore
	private String lastModified;

	@JsonIgnore
	private Integer model;

}
