package com.solum.aims.msp.persistence.entity.embeddable;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode
@Embeddable
public class TemplateCompositePK implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="station_code")
	private String stationCode;
	
	private String name;
	
	public TemplateCompositePK() {}
	
	public TemplateCompositePK(String stationCode, String templateName) {
		this.stationCode = stationCode;
		this.name = templateName;
	}
	
}
