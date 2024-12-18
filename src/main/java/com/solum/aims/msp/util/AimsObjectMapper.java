package com.solum.aims.msp.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.text.SimpleDateFormat;

@Slf4j
public class AimsObjectMapper extends ObjectMapper {
	private static final long serialVersionUID = 1L;
	
	public AimsObjectMapper() {
		super
		.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZ"))
		.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
		.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
	}

	@Override
	public <T> T readValue(String content, TypeReference<T> valueTypeRef) {
		if (content != null) {
			try {
				return super.readValue(content, valueTypeRef);
			} catch (IOException e) {
				log.error(e.getMessage());
			}
		}

		return null;
	}

	@Override
	public String writeValueAsString(Object value) {
		if (value != null) {
			try {
				return super.writeValueAsString(value);
			} catch (JsonProcessingException e) {
				log.error(e.getMessage());
			}
		}

		return null;
	}

	@Override
	public ObjectMapper copy() {
		return new AimsObjectMapper();
	}
}
