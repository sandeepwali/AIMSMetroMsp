package com.solum.aims.msp.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity(name="template_type")
@Getter
@Setter
public class TemplateType implements Serializable {

	private static final long serialVersionUID = 4553003762746022921L;

	@Id
	@Column(name="type_name")
	private String typeName;

	@Column(name="template_size")
	private String templateSize;

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
