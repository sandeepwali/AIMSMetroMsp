package com.solum.aims.msp.persistence.core.entity;
import java.io.Serializable;

import com.solum.aims.core.entity.EndDevice.EndDeviceState;
import com.solum.aims.core.entity.EndDevice.UpdateStatus;
import com.solum.aims.core.entity.messaging.AimsCoreMessage.MessageType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class WhiteList implements Serializable {
	protected static final long serialVersionUID = 1L;

	@Column(unique=true, name="mac_address")
	private String macAddress;

	private Long id;
	
	@Id
	private String code;

	@Column(nullable=true)
	private long stationId;
	
	@Column(nullable=true)
	private Integer accesspointId;
	
	@Column(nullable=true)
	private String statusUpdateTime;
	
	@Column(nullable=true)
	private String nfcData;
	
	@Column(nullable=true)
	@Enumerated(EnumType.STRING)
	private MessageType messageType;
	
	@Column(nullable=true)
	private String slabelType;
	
	@Column(nullable=true)
	private String batteryLevel;
	
	@Column(nullable=true)
	private Integer dataChannelRssi;
	
	@Column(nullable=true)
	private Integer firmwareVersion;
	
	@Column(nullable=true)
	@Enumerated(EnumType.STRING)
	private UpdateStatus updateStatus;
	
	@Column(nullable=true)
	private Integer currentPage;

	@Column(nullable=true)
	@Enumerated(EnumType.STRING)
	private EndDeviceState state;
	
	private String messageGroupId;
}