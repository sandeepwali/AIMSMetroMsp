package com.solum.aims.msp.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.solum.aims.msp.persistence.entity.MetroContent;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(Include.NON_NULL)
@Setter @Getter @ToString
public class MetroRequestChannelMessage {

	private String countryCode;
	
	private String storeNumber;
	
	private String salesLine;
	
	private String articleId;
	
	private List<MetroContent> contents = new ArrayList<>();
	
	private MetroContent content = new MetroContent();
}
