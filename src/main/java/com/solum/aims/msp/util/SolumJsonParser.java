package com.solum.aims.msp.util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class SolumJsonParser {

	@SuppressWarnings("deprecation")
	public JsonNode parseJson(String jsonString) throws JsonParseException {
			ObjectMapper mapper = new ObjectMapper();
			JsonFactory factory = mapper.getJsonFactory();
			JsonParser jp;
			
			try {
				jp = factory.createJsonParser(jsonString);
				return mapper.readTree(jp);
			} catch (JsonParseException e) {
				throw new JsonParseException("JSON Parsing Error.\n" + jsonString + "\n", e.getLocation());
			} catch (JsonProcessingException e) {
				throw new JsonParseException("JSON  Processing Error.\n" + jsonString + "\n", e.getLocation());
			} catch (IOException e) {
				JsonParseException jpe = new JsonParseException("JSON Parsing Error.\n" + jsonString + "\n", null, e);
				jpe.setStackTrace(e.getStackTrace());
				throw jpe;
			}
	}
	

	
	public String createJson(Object data) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			return mapper.writeValueAsString(data);
		} catch (Exception e) {
			log.error("Json create error!", e);
			throw new Exception("Json create error.");
		}
	}
}
