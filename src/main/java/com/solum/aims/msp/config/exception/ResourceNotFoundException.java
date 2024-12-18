package com.solum.aims.msp.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(String text) {
		super(new StringBuilder(text).toString());
	}

	public ResourceNotFoundException(String parameterName, String parameterValue) {
		super(new StringBuilder("It can't find ").append(parameterName).append(" with the value '")
				.append(parameterValue).append("'.").toString());
	}
}
