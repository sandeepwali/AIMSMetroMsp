package com.solum.aims.msp.infrastructure.batch;

import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
public final class JobExecutionParameters {

	private final Map<String, Object> parameterMap;

	public JobExecutionParameters(Map<String, Object> parameterMap) {
		this.parameterMap = new LinkedHashMap<>(parameterMap);
	}
}
