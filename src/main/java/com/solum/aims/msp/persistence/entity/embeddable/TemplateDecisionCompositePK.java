package com.solum.aims.msp.persistence.entity.embeddable;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode
@Embeddable
public class TemplateDecisionCompositePK implements Serializable{

	private static final long serialVersionUID = 1L;

	public TemplateDecisionCompositePK() {}
	
	public TemplateDecisionCompositePK(String stationCode, int page) {
		this.stationCode = stationCode;
		this.page = page;
	}
	
	private String stationCode;
	
	private int page;
}
