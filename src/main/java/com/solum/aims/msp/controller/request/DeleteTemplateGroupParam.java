package com.solum.aims.msp.controller.request;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DeleteTemplateGroupParam implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<String> templateGroupDeleteList;
}
