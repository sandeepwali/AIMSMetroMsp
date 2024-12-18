package com.solum.aims.msp.persistence.core.entity;

import java.util.Arrays;
import java.util.Date;

import org.hibernate.annotations.LazyGroup;
import org.springframework.util.DigestUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.solum.aims.msp.persistence.core.entity.Station.WhiteListFetchType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
@Table(name="accesspoint")
public class Accesspoint extends CoreEntity {
	protected static final long serialVersionUID = 1L;

	public static final long INITIAL_TRANSMISSION_SEQUENCE = 0;
	public static final long EXCLUDED_TRANSMISSION_SEQUENCE = -1;
	public static final int API_VERSION = 1;

	@Column(unique=true, name="mac_address")
	private String macAddress;

	@Enumerated(EnumType.STRING)
	private AccessPointType type = AccessPointType.UNKNOWN;

	@Enumerated(EnumType.STRING)
	private AccessPointState state = AccessPointState.UNREGISTERED;

	private String ipAddress;
	private String name;
	private int apiVersion;

	@JsonIgnore
	private String adminKey;

	@Enumerated(EnumType.STRING)
	private UriScheme uriScheme = UriScheme.HTTPS;

	private int port = 443;
	private String firmwareVersion;
	private Date lastConnectionDate;
	private int maxLaunch = 1;

	@Enumerated(EnumType.STRING)
	private WhiteListFetchType whiteListFetchType;

	@JsonIgnore
	private boolean init;

	@JsonIgnore
	private int launched;

	@ManyToOne(fetch= FetchType.LAZY, optional=false)
	@JoinColumn(name="station_id")
	@LazyGroup("AccessPoint.station")
	private Station station;

	@Override
	public void setCode(String code) {
		if (code.length() != 16) {
			throw new IllegalArgumentException(code + " does not comply with EUI-64 format");
		}

		super.setCode(code);
		this.macAddress = code.substring(0, 6).concat(code.substring(10)).toUpperCase().replaceAll("(..)(?!$)", "$1-");
		this.adminKey = DigestUtils.md5DigestAsHex((code + "SoluM").getBytes());
	}
	
	public enum UriScheme {
		HTTP,
		HTTPS
	}

	public enum AccessPointState implements State {
		DISCONNECTED,
		CONNECTED,
		NOT_READY,
		UNREGISTERED
	}
	
	@Getter
	public enum AccessPointType {
		UNKNOWN(0, "0", "0.0.0", "0.0.0"),
		SIMPLEX(1, "2", "1.5.16", "1.5.*"),
		DUPLEX(2, "2", "1.6.10", "1.6.*"),
		DUPLEX_RT_2400(4, "2", "4.0.2.8", "4.*.*.*"),
		DUPLEX_INTEGRATED(6, "2", "6.0.13", "6.*.*"),
		DUPLEX_RT_900(8, "2", "5.0.1.6", "5.*.*.*"),
		N_SYSTEM(9, "4", "1.0.0", "3.*.*"),
		N_SYSTEM_USB(10, "4", "1.0.0", "3.*.*"),
		N_SYSTEM_PCIE(11, "4", "1.0.0", "3.*.*"),
		N_SYSTEM_CISCO_SERIAL(12, "4", "1.0.0", "3.*.*");

		private int value;
		private String uriVersion;
		private String[] versionRange;

		AccessPointType(int value, String uriVersion, String... versionRange) {
			this.value = value;
			this.uriVersion = uriVersion;
			this.versionRange = versionRange;
		}

		public static AccessPointType parseInt(int intValue) {
			return Arrays.stream(values())
							.filter(mode -> mode.value == intValue)
							.findAny()
							.orElse(AccessPointType.UNKNOWN);
		}
	}
}