package com.solum.aims.msp.persistence.entity.embeddable.converter;

import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.solum.aims.msp.util.AimsObjectMapper;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply=true)
public class StringStringMapConverter implements AttributeConverter<Map<String, String>, String>{

	protected static AimsObjectMapper objectMapper = new AimsObjectMapper();
	
	@Override
	public String convertToDatabaseColumn(Map<String, String> attribute) {
		return objectMapper.writeValueAsString(attribute);
	}

	@Override
	public Map<String, String> convertToEntityAttribute(String dbData) {
		return objectMapper.readValue(dbData, new TypeReference<Map<String, String>>() {});
	}
}
