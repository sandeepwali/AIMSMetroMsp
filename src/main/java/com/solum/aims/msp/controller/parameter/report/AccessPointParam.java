package com.solum.aims.msp.controller.parameter.report;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;
import com.solum.aims.msp.persistence.core.entity.Accesspoint.AccessPointState;
import com.solum.aims.msp.persistence.core.entity.Accesspoint.UriScheme;
import com.solum.aims.msp.persistence.core.entity.Station;
import com.solum.aims.msp.util.JsonViewFilter;

import lombok.Getter;
import lombok.Setter;

@JsonPropertyOrder(value={"lastModifiedDate", "id", "code", "macAddress", "ipAddress", "name", "version", "status", "endDevicesCount", "lastConnectionDate", "station", "sGatewayStatus", "sGatewayConfig"})
@JsonInclude(Include.NON_NULL)
@Setter @Getter
public class AccessPointParam {
	@JsonView({JsonViewFilter.EndDeviceView.class,JsonViewFilter.StationView.class})
	private Date lastModifiedDate;
	
	@JsonView({JsonViewFilter.WhistListView.class,JsonViewFilter.EndDeviceView.class,JsonViewFilter.StationView.class,JsonViewFilter.NewEndDeviceView.class})	
	private long id;

	@JsonView({JsonViewFilter.EndDeviceView.class,JsonViewFilter.StationView.class,JsonViewFilter.NewEndDeviceView.class})
	private String macAddress;

	@JsonView({JsonViewFilter.EndDeviceView.class,JsonViewFilter.StationView.class,JsonViewFilter.NewEndDeviceView.class})
	private String version;
	
	@JsonView({JsonViewFilter.WhistListView.class,JsonViewFilter.EndDeviceView.class,JsonViewFilter.StationView.class,JsonViewFilter.NewEndDeviceView.class})	
	private String code;
	
	@JsonView({JsonViewFilter.WhistListView.class,JsonViewFilter.EndDeviceView.class,JsonViewFilter.StationView.class,JsonViewFilter.NewEndDeviceView.class})	
	private String ipAddress;
	
	@JsonView({JsonViewFilter.EndDeviceView.class,JsonViewFilter.StationView.class,JsonViewFilter.NewEndDeviceView.class})
	private String name;
	
	@JsonView({JsonViewFilter.EndDeviceView.class,JsonViewFilter.StationView.class,JsonViewFilter.NewEndDeviceView.class})
	private UriScheme uriScheme;
	
	@JsonView({JsonViewFilter.EndDeviceView.class,JsonViewFilter.StationView.class,JsonViewFilter.NewEndDeviceView.class})
	private int port;

	@JsonAnySetter
	public void setFirmwareVersion(String version) {
		this.version = version;
	}
	
	@JsonView({JsonViewFilter.EndDeviceView.class,JsonViewFilter.StationView.class,JsonViewFilter.NewEndDeviceView.class})
	private AccessPointState status;
	
	@JsonView({JsonViewFilter.EndDeviceView.class,JsonViewFilter.StationView.class})
	private int endDevicesCount;
	
	@JsonView({JsonViewFilter.WhistListView.class,JsonViewFilter.EndDeviceView.class,JsonViewFilter.StationView.class,JsonViewFilter.NewEndDeviceView.class})	
	private Date lastConnectionDate;

	@JsonProperty(value="sGatewayStatus")
	@JsonView({JsonViewFilter.EndDeviceView.class,JsonViewFilter.StationView.class})
	private SGatewayState sGatewayStatus;
	
	@JsonView({JsonViewFilter.EndDeviceView.class})
	private Station station;

	@JsonIgnore
	public SGatewayState getSGatewayStatus() {
		return this.sGatewayStatus;
	}
	
	public void setStation(Station station) {
		this.station  = new Station();
		this.station.setId(station.getId());
		this.station.setCode(station.getCode());
		this.station.setName(station.getName());
		this.station.setDescription(station.getDescription());
		this.station.setZoneId(station.getZoneId());
		this.station.setDivisionCode(station.getDivisionCode());
		this.station.setWhiteListEnabled(station.isWhiteListEnabled());
		this.station.setWhiteListUpdateTime(station.getWhiteListUpdateTime());
		this.station.setIpNtpServer(station.getIpNtpServer());
		this.station.setStationConfig(station.getStationConfig());
		this.station.setLbsEnabled(station.isLbsEnabled());
	}
}