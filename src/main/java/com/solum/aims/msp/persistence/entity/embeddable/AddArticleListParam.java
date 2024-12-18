package com.solum.aims.msp.persistence.entity.embeddable;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class AddArticleListParam implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String nfc;
	private String stationCode;
	
	@NotNull @Size(min=1)
	private Map<String, String> data = new HashMap<>();
}
