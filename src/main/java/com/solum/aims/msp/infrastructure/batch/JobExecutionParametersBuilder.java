package com.solum.aims.msp.infrastructure.batch;

import java.util.LinkedHashMap;
import java.util.Map;

public final class JobExecutionParametersBuilder {

	private final Map<String, Object> parameterMap;

	public JobExecutionParametersBuilder() {
		this.parameterMap = new LinkedHashMap<>();
	}

	public JobExecutionParametersBuilder add(String key, Object value) {
		this.parameterMap.put(key, value);
		return this;
	}

	public JobExecutionParameters toJobExecutionParameters() {
		return new JobExecutionParameters(this.parameterMap);
	}
}
