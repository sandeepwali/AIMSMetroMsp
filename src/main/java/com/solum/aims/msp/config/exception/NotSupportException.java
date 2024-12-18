package com.solum.aims.msp.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class NotSupportException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotSupportException() {
		super(new StringBuilder("This is not supported function.").toString());
	}
}
