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
public class TemplateStationCompositePK implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="station_code")
	private String stationCode;
	@Column(name="type_name")
	private String typeName;
	@Column(name="template_size")
	private String templateSize;
	
	public TemplateStationCompositePK() {}
	
	public TemplateStationCompositePK(String stationCode, String typeName, String templateSize) {
		this.stationCode = stationCode;
		this.typeName = typeName;
		this.templateSize = templateSize;	
	}	
}
