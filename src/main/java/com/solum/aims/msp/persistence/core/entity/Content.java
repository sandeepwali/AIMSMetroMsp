package com.solum.aims.msp.persistence.core.entity;
import java.util.Date;

import org.hibernate.annotations.LazyGroup;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.solum.aims.msp.persistence.core.entity.CoreEndDevice.MessageType;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter

public class Content extends CoreEntity {
	protected static final long serialVersionUID = 1L;

	//@Column(name="content_type")
	@Enumerated(EnumType.STRING)
	private ContentType type;

	@Enumerated(EnumType.STRING)
	private ContentState state;

	@Enumerated(EnumType.STRING)
	private MessageType messageType;

	private long transmissionSequence;

	@Column(name="jobnumber")
	private long jobNumber;

	@Column(columnDefinition="clob")
	@Basic(fetch=FetchType.LAZY)
	@LazyGroup("content")
	private String content;

	@Transient
	@JsonIgnore
	private String ledConfig;

	@Transient
	@JsonIgnore
	private String contentBase64;

	private int checksum;

	@Enumerated(EnumType.STRING)
	private CompressionType compressionType = CompressionType.NONE;

	@Column(columnDefinition="clob")
	@Basic(fetch=FetchType.LAZY)
	@LazyGroup("contract")
	private String contract;
	
	@Transient
	private int contractSize;
	private long messageSequence;
	private String messageGroupId;
	private long dataLength;
	private boolean sendNew;

	@Column(name="\"index\"")
	private int index;

	private Date processUpdateTime;
	private Date statusUpdateTime;
	private Date sendTime;
	
	@ManyToOne//(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="enddevice_id")
	//@LazyToOne(LazyToOneOption.NO_PROXY)
	//@LazyGroup("Content.endDevice")
	private CoreEndDevice endDevice;
	
	
	@ManyToOne//(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="station_id")
	//@LazyToOne(LazyToOneOption.NO_PROXY)
	//@LazyGroup("Content.station")
	private Station station;	
	
	public enum ContentType {
		DEFAULT(0),
		IMAGE(1),
		SEGMENT(2),
		MULTI_SEGMENT(3),
		SCHEDULE(4),
		NFC(5),
		RFID(6),
		LED(7);

		@Getter
		private int value;

		ContentType(int value) {
			this.value = value;
		}
	}

	public enum ContentState {
		SUCCESS,
		PROCESSING,
		TIMEOUT,
		STALE
	}
	
	public enum CompressionType {
		NONE(0),
		LZSS(1),
		DEFLATE(2);

		@Getter
		private int value;

		CompressionType(int value) {
			this.value = value;
		}
	}
}