package com.solum.aims.msp.persistence.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.solum.aims.msp.comstant.Constants;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity(name="end_device")
public class EndDevice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "station_code")
	private String stationCode;
	
	@Id
	@Column(name = "label_code")
	private String labelCode;

	public EndDevice(String stationCode, String labelCode) {
		this.stationCode = stationCode;
		this.labelCode = labelCode;
	}
	
	public EndDevice(String labelCode) {
		this.stationCode = Constants.DEFAULT_STATION_CODE;
		this.labelCode=labelCode;
	}
	
	public EndDevice() {}
	
	@ManyToMany(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(joinColumns=@JoinColumn(name="labelCode"),
			inverseJoinColumns = {@JoinColumn(name= "articleId"), @JoinColumn(name= "station_code")})
	@OrderColumn(name="seq")
	private List<Article> articles = new ArrayList<>();
	/*
	@ManyToMany(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(joinColumns=@JoinColumn(name="labelCode"),
			inverseJoinColumns = {@JoinColumn(name = "name"), @JoinColumn(name = "station_code")})
	@OrderColumn(name="page")
	private List<Template> templates = new ArrayList<>();
	*/
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified")
	private Date lastModified;
	@Column(name = "template_manual")
	private boolean templateManual;

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
