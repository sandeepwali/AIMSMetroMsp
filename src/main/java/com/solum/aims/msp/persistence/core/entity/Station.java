package com.solum.aims.msp.persistence.core.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonView;
import com.solum.aims.core.entity.embeddable.StationWhiteListElement;
import com.solum.aims.msp.util.JsonViewFilter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@JsonInclude(Include.NON_EMPTY)
@JsonView({ JsonViewFilter.EndDeviceView.class })
@SqlResultSetMapping(name = "StationWhiteListElementResultSet", classes = {
		@ConstructorResult(targetClass = StationWhiteListElement.class, columns = {
				@ColumnResult(name = "code", type = String.class), @ColumnResult(name = "mac", type = String.class),
				@ColumnResult(name = "update_time", type = Date.class),
				@ColumnResult(name = "add_time", type = Date.class) }) })
public class Station extends CoreEntity {
	private static final long serialVersionUID = 1L;

	public static final String DEFAULT_STATION_CODE = "DEFAULT_STATION_CODE";
	public static final long INITIAL_JOBNUMBER = 0;
	public static final long EXCLUDED_JOBNUMBER = -1;

	@JsonInclude(Include.NON_NULL)
	private String name;
	private String company;
	@JsonInclude(Include.NON_NULL)
	private String description;
	@Column(name = "zone_id")
	private String zoneId;
	@Column(name="division_code")
	private int divisionCode;
	@Column(name="white_list_enabled")
	private boolean whiteListEnabled;
	@Column(name = "lbs_enabled")
	private boolean lbsEnabled;
	@Column(name = "white_list_update_time")
	private Date whiteListUpdateTime;
	private String country;
	private String region;
	private String city;

	@Column(name = "station_config", columnDefinition = "clob")
	private String stationConfig;

	@Transient
	private WhiteListFetchType whiteListFetchType = WhiteListFetchType.NONE;

	@Column(name = "ip_ntp_server")
	private String ipNtpServer;

	@Transient
	private StationState state;

	@ElementCollection
	@CollectionTable(name = "station_white_list", joinColumns = @JoinColumn(name = "station_id"))
	@MapKeyColumn(name = "code", insertable = false, updatable = false)
	@JdbcTypeCode(SqlTypes.JSON)
	private Map<String, StationWhiteListElement> whiteList = new HashMap<>();

	@OneToMany(mappedBy = "station", cascade = CascadeType.REMOVE)
	private Collection<Accesspoint> accessPoints = new ArrayList<>();

	public void setDivisionCode(int divisionCode) {
		this.divisionCode = divisionCode == 47806 ? 47807 : divisionCode;
	}

	public void setWhiteListEnabled(boolean whiteListEnabled) {
		this.whiteListEnabled = whiteListEnabled;
		this.whiteListFetchType = whiteListEnabled ? WhiteListFetchType.NOT_READY : WhiteListFetchType.NONE;
	}

	public void setWhiteList(Map<String, StationWhiteListElement> whiteList) {
		this.whiteList = whiteList;
	}

	public enum WhiteListFetchType {
		NONE, NOT_READY, FULL, ADD, DELETE
	}

	public enum StationState implements State {
	}
}