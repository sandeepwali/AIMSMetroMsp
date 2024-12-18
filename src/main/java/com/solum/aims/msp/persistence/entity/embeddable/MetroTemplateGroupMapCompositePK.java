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
public class MetroTemplateGroupMapCompositePK implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	
	@Column(name="station_code")
	private String stationCode;

	@Column(name="group_name")
	private String groupName;
	
	public MetroTemplateGroupMapCompositePK() {}
	
	public MetroTemplateGroupMapCompositePK(String typeName, String stationCode, String groupName) {
		this.name = typeName;
		this.stationCode = stationCode;
		this.groupName = groupName;
	}
	
}
