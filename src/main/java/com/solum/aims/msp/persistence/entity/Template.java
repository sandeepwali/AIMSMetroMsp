package com.solum.aims.msp.persistence.entity;


import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.solum.aims.msp.persistence.entity.embeddable.TemplateCompositePK;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity(name="template")
@Getter @Setter
public class Template implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TemplateCompositePK id;
	
	private int width;
	
	private int height;
	
	@Enumerated(EnumType.STRING)
	private TemplateFormat type;
	
	@Column(length=1024*1024*1024)
	private String data;
	
//	@JsonIgnore
//	@ManyToMany(mappedBy="templates", fetch=FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE})
//	private Set<EndDevice> endDevices = new HashSet<>();
	@Column(name="custom_batch_id")
	private String customBatchId;
	
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
	
	public enum TemplateFormat {
		JSON,
		XSL
	}
}