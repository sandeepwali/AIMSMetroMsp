package com.solum.aims.msp.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.solum.aims.msp.persistence.entity.embeddable.TemplateStationCompositePK;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity(name="template_station")
@Getter @Setter
public class TemplateStation implements Serializable {

	private static final long serialVersionUID = 4553003762746022921L;

	@EmbeddedId
	private TemplateStationCompositePK id;
	@Column(name="template_name")
	private String templateName;
		
	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	
	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_modified")
	private Date lastModified;
	
	@PrePersist
	private void onCreate() {
		Date date = new Date();
		setCreated(date);
		setLastModified(date);
	}

	@PreUpdate
	private void onUpdate() {
		setLastModified(new Date());
	}
}
