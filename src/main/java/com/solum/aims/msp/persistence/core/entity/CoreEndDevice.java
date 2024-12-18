package com.solum.aims.msp.persistence.core.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.hibernate.annotations.LazyGroup;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.solum.aims.msp.persistence.core.entity.Content.CompressionType;
import com.solum.aims.msp.persistence.core.entity.Content.ContentType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "enddevice")
public class CoreEndDevice extends CoreEntity {
	protected static final long serialVersionUID = 1L;

	public static final int DEFAULT_NUMBER_OF_BUTTONS = 4;
	public static final long DEFAULT_LED_JOBNUMBER = 0L; // HexCode: FFFFFF00

	@Column(unique = true, name = "mac_address")
	private String macAddress;

	@Enumerated(EnumType.STRING)
	private EndDeviceType type;
	@Enumerated(EnumType.STRING)
	private EndDeviceState state = EndDeviceState.UNASSIGNED;

	@Enumerated(EnumType.STRING)
	private MessageType messageType;

	@Enumerated(EnumType.STRING)
	private UnassignMode unassignMode;

	private String statusUpdateTime;
	private Date processUpdateTime;
	private long messageSequence;
	private String messageGroupId;
	private int displayWidth;
	private int displayHeight;
	@Transient
	private int totalPage;
	private int currentPage = -1;
	private int returnPage = -1;
	private int exceptionPage = -1;

	@Column(name = "\"mode\"")
	private long mode;

	private boolean reactive;
	private String nfcData;
	private boolean isSchedule;

	@OneToMany(mappedBy = "endDevice", cascade = CascadeType.REMOVE)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Collection<Content> contents = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accesspoint_id")
	@LazyToOne(LazyToOneOption.NO_PROXY)
	@LazyGroup("EndDevice.accessPoint")
//	private Accesspoint accessPoint;
	private Accesspoint accesspoint;

	@ManyToOne // (fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name = "station_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	// @LazyToOne(LazyToOneOption.NO_PROXY)
	// @LazyGroup("EndDevice.station")
	private Station station;

	public void setMacAddress(String macAddress) {
		if (macAddress != null) {
			this.macAddress = macAddress;
		}
	}

	public void setNfcData(String nfcData) {
		if (this.type.isNfc() == true && nfcData != null) {
			this.nfcData = nfcData;
		}
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = setPage(currentPage, this.currentPage);
	}

	public void setReturnPage(int returnPage) {
		this.returnPage = setPage(returnPage, this.returnPage);
	}

	public void setExceptionPage(int exceptionPage) {
		this.exceptionPage = setPage(exceptionPage, this.exceptionPage);
	}

	private int setPage(int source, int target) {
		if (source < 0) {
			if (target < 0) {
				target = CoreEndDevice.getDefaultIndex(ContentType.DEFAULT);
			}
		} else {
			target = source;
		}

		return target;
	}

	public static int getDefaultIndex(ContentType contentType) {
		return switch (contentType) {
		case SCHEDULE -> 0;
		case NFC -> 97;
		case LED -> 99;
		default -> 1;
		};
	}

	public enum EndDeviceState implements State {
		PROCESSING, SUCCESS, TIMEOUT, UNASSIGNING, UNASSIGNED, NONE
	}

	public enum MessageType {
		UNASSIGN(0), ASSIGN(1), DELETE(3);

		@Getter
		private int value;

		MessageType(int value) {
			this.value = value;
		}
	}

	/**
	 * Enum defined for specific types of E-Paper tag.
	 * <p>
	 * The format is as follows:
	 * <ul>
	 * <li>(Category, Hex Value, Display Width, Display Height, Total Page, Class
	 * Type, Color Type, Compression Type, Rotation CW, Resolution, Flip, NFC
	 * support, 12-digit Type Code, 16-digit Type Code, 17-digit Type Code)
	 * </ul>
	 *
	 * @author Solu-M
	 * @since November 11, 2015
	 * @version 1.0
	 */
	@Getter
	public enum EndDeviceType {
		/******************************************************
		 * Legacy Labels
		 ******************************************************/
		// Freezer
		GRAPHIC_2_2_FREEZER(Category.IMAGE, "91", 212, 104, 1, ClassType.SEMCO, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 111, false, false, "2C1", "FFFF"),
		GRAPHIC_2_9_FREEZER(Category.IMAGE, "92", 296, 128, 1, ClassType.SEMCO, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 112, false, false, "2D1", "FFFF"),

		// Mono Color
		GRAPHIC_1_6(Category.IMAGE, "E5", 152, 152, 3, ClassType.SEMCO, ColorType.BINARY, CompressionType.DEFLATE, 0,
				91, false, false, "141", "FFFF"),
		GRAPHIC_1_6_HD(Category.IMAGE, "85", 200, 200, 3, ClassType.SEMCO, ColorType.BINARY, CompressionType.DEFLATE,
				180, 184, false, false, "101", "1601"),
		GRAPHIC_2_2(Category.IMAGE, "86", 212, 104, 3, ClassType.SEMCO, ColorType.BINARY, CompressionType.DEFLATE, 270,
				111, false, false, "201", "2201"),
		GRAPHIC_2_6(Category.IMAGE, "B0", 296, 152, 3, ClassType.SEMCO, ColorType.BINARY, CompressionType.DEFLATE, 270,
				117, false, false, "3D1", "FFFF"),
		GRAPHIC_2_7(Category.IMAGE, "80", 264, 176, 3, ClassType.SEMCO, ColorType.BINARY, CompressionType.DEFLATE, 270,
				117, false, false, "2E1", "FFFF"),
		GRAPHIC_2_9(Category.IMAGE, "87", 296, 128, 3, ClassType.SEMCO, ColorType.BINARY, CompressionType.DEFLATE, 270,
				112, false, false, "281", "2901"),
		GRAPHIC_3_3(Category.IMAGE, "88", 300, 200, 3, ClassType.MARVELL, ColorType.BINARY, CompressionType.DEFLATE,
				270, 110, false, false, "301", "FFFF"),
		GRAPHIC_4_2(Category.IMAGE, "89", 400, 300, 3, ClassType.MARVELL, ColorType.BINARY, CompressionType.DEFLATE, 0,
				120, false, false, "401", "4201"),
		GRAPHIC_4_3(Category.IMAGE, "F2", 522, 152, 3, ClassType.SEMCO, ColorType.BINARY, CompressionType.DEFLATE, 270,
				126, false, false, "4A1", "FFFF"),
		GRAPHIC_5_7(Category.IMAGE, "8A", 600, 200, 3, ClassType.MARVELL, ColorType.BINARY, CompressionType.DEFLATE, 0,
				110, false, false, "501", "FFFF"),
		GRAPHIC_6_0(Category.IMAGE, "8B", 600, 448, 3, ClassType.MARVELL, ColorType.BINARY, CompressionType.DEFLATE, 0,
				128, false, false, "641", "FFFF"),
		GRAPHIC_6_0_HD(Category.IMAGE, "83", 1024, 758, 3, ClassType.MARVELL, ColorType.BINARY, CompressionType.DEFLATE,
				0, 212, false, false, "600", "6000"), // be discontinued
		GRAPHIC_7_4(Category.IMAGE, "8C", 480, 800, 3, ClassType.MARVELL, ColorType.BINARY, CompressionType.DEFLATE, 0,
				126, false, false, "704", "FFFF"),
		GRAPHIC_13_3(Category.IMAGE, "E9", 1200, 1600, 3, ClassType.MARVELL, ColorType.BINARY, CompressionType.DEFLATE,
				270, 150, false, false, "941", "FFFF"),

		// Mono Color + NFC
		GRAPHIC_1_6_NFC(Category.IMAGE, "E6", 152, 152, 3, ClassType.SEMCO, ColorType.BINARY, CompressionType.DEFLATE,
				0, 91, false, true, "143", "FFFF"),
		GRAPHIC_1_6_HD_NFC(Category.IMAGE, "B5", 200, 200, 3, ClassType.SEMCO, ColorType.BINARY,
				CompressionType.DEFLATE, 180, 184, false, true, "103", "FFFF"),
		GRAPHIC_2_2_NFC(Category.IMAGE, "B6", 212, 104, 3, ClassType.SEMCO, ColorType.BINARY, CompressionType.DEFLATE,
				270, 111, false, true, "203", "FFFF"),
		GRAPHIC_2_6_NFC(Category.IMAGE, "B0", 296, 152, 3, ClassType.SEMCO, ColorType.BINARY, CompressionType.DEFLATE,
				270, 117, false, true, "3D3", "FFFF"),
		GRAPHIC_2_7_NFC(Category.IMAGE, "80", 264, 176, 3, ClassType.SEMCO, ColorType.BINARY, CompressionType.DEFLATE,
				270, 117, false, true, "2E3", "FFFF"),
		GRAPHIC_2_9_NFC(Category.IMAGE, "B7", 296, 128, 3, ClassType.SEMCO, ColorType.BINARY, CompressionType.DEFLATE,
				270, 112, false, true, "283", "FFFF"),
		GRAPHIC_3_3_NFC(Category.IMAGE, "B8", 300, 200, 3, ClassType.MARVELL, ColorType.BINARY, CompressionType.DEFLATE,
				270, 110, false, true, "303", "FFFF"),
		GRAPHIC_4_2_NFC(Category.IMAGE, "B9", 400, 300, 3, ClassType.MARVELL, ColorType.BINARY, CompressionType.DEFLATE,
				0, 120, false, true, "403", "FFFF"),
		GRAPHIC_4_3_NFC(Category.IMAGE, "F2", 522, 152, 3, ClassType.SEMCO, ColorType.BINARY, CompressionType.DEFLATE,
				270, 126, false, true, "4A3", "FFFF"),
		GRAPHIC_5_7_NFC(Category.IMAGE, "BA", 600, 200, 3, ClassType.MARVELL, ColorType.BINARY, CompressionType.DEFLATE,
				0, 110, false, true, "503", "FFFF"),
		GRAPHIC_6_0_NFC(Category.IMAGE, "BB", 600, 448, 3, ClassType.MARVELL, ColorType.BINARY, CompressionType.DEFLATE,
				0, 128, false, true, "643", "FFFF"),
		GRAPHIC_7_4_NFC(Category.IMAGE, "BC", 480, 800, 3, ClassType.MARVELL, ColorType.BINARY, CompressionType.DEFLATE,
				0, 126, false, true, "705", "FFFF"),
		GRAPHIC_7_5_NFC(Category.IMAGE, "83", 384, 640, 3, ClassType.MARVELL, ColorType.BINARY, CompressionType.DEFLATE,
				270, 100, false, true, "733", "FFFF"),
		GRAPHIC_13_3_NFC(Category.IMAGE, "E9", 1200, 1600, 3, ClassType.MARVELL, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 150, false, true, "943", "FFFF"),

		// Red Color
		GRAPHIC_1_6_RED(Category.IMAGE, "D7", 152, 152, 3, ClassType.MARVELL, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 91, false, false, "161", "FFFF"),
		GRAPHIC_2_2_RED(Category.IMAGE, "D8", 212, 104, 3, ClassType.MARVELL, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 111, true, false, "211", "FFFF"),
		GRAPHIC_2_6_RED(Category.IMAGE, "B1", 296, 152, 3, ClassType.SEMCO, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 117, false, false, "3E1", "FFFF"),
		GRAPHIC_2_7_RED(Category.IMAGE, "81", 264, 176, 3, ClassType.SEMCO, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 117, false, false, "2F1", "FFFF"),
		GRAPHIC_2_9_RED(Category.IMAGE, "A2", 296, 128, 3, ClassType.MARVELL, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 112, true, false, "291", "2911"),
		GRAPHIC_3_3_RED(Category.IMAGE, "A3", 300, 200, 3, ClassType.MARVELL, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 110, true, false, "311", "3311"),
		GRAPHIC_4_2_RED(Category.IMAGE, "A4", 400, 300, 3, ClassType.SEMCO, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 120, false, false, "411", "4211"),
		GRAPHIC_4_3_RED(Category.IMAGE, "F2", 522, 152, 3, ClassType.SEMCO, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 126, false, false, "4B1", "FFFF"),
		GRAPHIC_5_7_RED(Category.IMAGE, "A5", 600, 200, 3, ClassType.MARVELL, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 110, false, false, "511", "FFFF"),
		GRAPHIC_6_0_RED(Category.IMAGE, "A7", 600, 448, 3, ClassType.MARVELL, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 128, false, false, "651", "FFFF"),
		GRAPHIC_7_4_RED(Category.IMAGE, "A8", 480, 800, 3, ClassType.MARVELL, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 126, false, false, "714", "FFFF"),
		GRAPHIC_13_3_RED(Category.IMAGE, "E9", 1200, 1600, 3, ClassType.MARVELL, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 150, false, false, "951", "FFFF"),

		// Red Color + NFC
		GRAPHIC_1_6_RED_NFC(Category.IMAGE, "DC", 152, 152, 3, ClassType.MARVELL, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 91, false, true, "163", "1631"),
		GRAPHIC_2_2_RED_NFC(Category.IMAGE, "C1", 212, 104, 3, ClassType.MARVELL, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 111, true, true, "213", "FFFF"),
		GRAPHIC_2_6_RED_NFC(Category.IMAGE, "B1", 296, 152, 3, ClassType.SEMCO, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 117, false, true, "3E3", "FFFF"),
		GRAPHIC_2_7_RED_NFC(Category.IMAGE, "81", 264, 176, 3, ClassType.SEMCO, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 117, false, true, "2F3", "FFFF"),
		GRAPHIC_2_9_RED_NFC(Category.IMAGE, "C2", 296, 128, 3, ClassType.MARVELL, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 112, true, true, "293", "FFFF"),
		GRAPHIC_3_3_RED_NFC(Category.IMAGE, "C3", 300, 200, 3, ClassType.MARVELL, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 110, true, true, "313", "FFFF"),
		GRAPHIC_4_2_RED_NFC(Category.IMAGE, "C4", 400, 300, 3, ClassType.SEMCO, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 120, false, true, "413", "FFFF"),
		GRAPHIC_4_3_RED_NFC(Category.IMAGE, "F2", 522, 152, 3, ClassType.SEMCO, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 126, false, true, "4B3", "FFFF"),
		GRAPHIC_5_7_RED_NFC(Category.IMAGE, "C5", 600, 200, 3, ClassType.MARVELL, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 110, false, true, "513", "FFFF"),
		GRAPHIC_6_0_RED_NFC(Category.IMAGE, "C7", 600, 448, 3, ClassType.MARVELL, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 128, false, true, "653", "FFFF"),
		GRAPHIC_7_4_RED_NFC(Category.IMAGE, "C8", 480, 800, 3, ClassType.MARVELL, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 126, false, true, "715", "FFFF"),
		GRAPHIC_7_5_RED_NFC(Category.IMAGE, "84", 384, 640, 3, ClassType.MARVELL, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 100, false, true, "743", "FFFF"),
		GRAPHIC_13_3_RED_NFC(Category.IMAGE, "E9", 1200, 1600, 3, ClassType.MARVELL, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 150, false, true, "953", "FFFF"),

		// Yellow Color
		GRAPHIC_1_6_YEL(Category.IMAGE, "85", 152, 152, 3, ClassType.SEMCO, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 91, false, false, "351", "FFFF"),
		GRAPHIC_2_2_YEL(Category.IMAGE, "86", 212, 104, 3, ClassType.SEMCO, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 111, true, false, "371", "FFFF"),
		GRAPHIC_2_6_YEL(Category.IMAGE, "B1", 296, 152, 3, ClassType.SEMCO, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 117, false, false, "3F1", "FFFF"),
		GRAPHIC_2_7_YEL(Category.IMAGE, "C9", 264, 176, 3, ClassType.SEMCO, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 117, false, false, "3A1", "FFFF"),
		GRAPHIC_2_9_YEL(Category.IMAGE, "87", 296, 128, 3, ClassType.SEMCO, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 112, true, false, "3C1", "FFFF"),
		GRAPHIC_3_3_YEL(Category.IMAGE, "E7", 300, 200, 3, ClassType.SEMCO, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 112, true, false, "461", "FFFF"),
		GRAPHIC_4_2_YEL(Category.IMAGE, "A4", 400, 300, 3, ClassType.MARVELL, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 120, false, false, "421", "FFFF"),
		GRAPHIC_4_3_YEL(Category.IMAGE, "F2", 522, 152, 3, ClassType.SEMCO, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 126, false, false, "4C1", "FFFF"),
		GRAPHIC_6_0_YEL(Category.IMAGE, "C7", 600, 448, 3, ClassType.MARVELL, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 128, false, false, "661", "FFFF"),
		GRAPHIC_7_5_YEL(Category.IMAGE, "84", 384, 640, 3, ClassType.MARVELL, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 100, false, false, "751", "FFFF"),
		GRAPHIC_13_3_YEL(Category.IMAGE, "E9", 1200, 1600, 3, ClassType.MARVELL, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 150, false, false, "961", "FFFF"),
		GRAPHIC_4_2_YEL_243(Category.IMAGE, "82", 400, 300, 3, ClassType.SEMCO, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 112, false, false, "491", "FFFF"),
		GRAPHIC_6_0_YEL_243(Category.IMAGE, "E8", 600, 448, 3, ClassType.SEMCO, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 128, false, false, "561", "FFFF"),

		GRAPHIC_1_6_YEL_NFC(Category.IMAGE, "B5", 152, 152, 3, ClassType.SEMCO, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 91, false, true, "353", "FFFF"),
		GRAPHIC_2_2_YEL_NFC(Category.IMAGE, "B6", 212, 104, 3, ClassType.SEMCO, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 111, true, true, "373", "FFFF"),
		GRAPHIC_2_6_YEL_NFC(Category.IMAGE, "B1", 296, 152, 3, ClassType.SEMCO, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 117, false, true, "3F3", "FFFF"),
		GRAPHIC_2_7_YEL_NFC(Category.IMAGE, "C9", 264, 176, 3, ClassType.SEMCO, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 117, false, true, "3A3", "FFFF"),
		GRAPHIC_2_9_YEL_NFC(Category.IMAGE, "B7", 296, 128, 3, ClassType.SEMCO, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 112, true, true, "3C3", "FFFF"),
		GRAPHIC_3_3_YEL_NFC(Category.IMAGE, "E7", 300, 200, 3, ClassType.SEMCO, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 112, true, true, "463", "FFFF"),
		GRAPHIC_4_2_YEL_NFC(Category.IMAGE, "C4", 400, 300, 3, ClassType.MARVELL, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 120, false, true, "423", "FFFF"),
		GRAPHIC_4_3_YEL_NFC(Category.IMAGE, "F2", 522, 152, 3, ClassType.SEMCO, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 126, false, true, "4C3", "FFFF"),
		GRAPHIC_6_0_YEL_NFC(Category.IMAGE, "C7", 600, 448, 3, ClassType.MARVELL, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 128, false, true, "663", "FFFF"),
		GRAPHIC_7_5_YEL_NFC(Category.IMAGE, "84", 384, 640, 3, ClassType.MARVELL, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 100, false, true, "753", "FFFF"),
		GRAPHIC_13_3_YEL_NFC(Category.IMAGE, "E9", 1200, 1600, 3, ClassType.MARVELL, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 150, false, true, "963", "FFFF"),
		GRAPHIC_4_2_YEL_NFC_243(Category.IMAGE, "B2", 400, 300, 3, ClassType.SEMCO, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 112, false, true, "493", "FFFF"),
		GRAPHIC_6_0_YEL_NFC_243(Category.IMAGE, "E8", 600, 448, 3, ClassType.SEMCO, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 128, false, true, "563", "FFFF"),

		// Mono Color, SEMCO
		GRAPHIC_3_3_243(Category.IMAGE, "E7", 300, 200, 3, ClassType.SEMCO, ColorType.BINARY, CompressionType.DEFLATE,
				270, 109, false, false, "441", "FFFF"),
		GRAPHIC_4_2_243(Category.IMAGE, "82", 400, 300, 3, ClassType.SEMCO, ColorType.BINARY, CompressionType.DEFLATE,
				0, 112, false, false, "471", "FFFF"),
		GRAPHIC_6_0_243(Category.IMAGE, "E8", 600, 448, 3, ClassType.SEMCO, ColorType.BINARY, CompressionType.DEFLATE,
				0, 128, false, false, "541", "FFFF"),
		GRAPHIC_3_3_NFC_243(Category.IMAGE, "E7", 300, 200, 3, ClassType.SEMCO, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 109, false, true, "443", "FFFF"),
		GRAPHIC_4_2_NFC_243(Category.IMAGE, "B2", 400, 300, 3, ClassType.SEMCO, ColorType.BINARY,
				CompressionType.DEFLATE, 0, 112, false, true, "473", "FFFF"),
		GRAPHIC_6_0_NFC_243(Category.IMAGE, "E8", 600, 448, 3, ClassType.SEMCO, ColorType.BINARY,
				CompressionType.DEFLATE, 0, 128, false, true, "543", "FFFF"),

		// RED Color, SEMCO
		GRAPHIC_1_6_RED_243(Category.IMAGE, "85", 152, 152, 3, ClassType.SEMCO, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 91, false, false, "341", "FFFF"),
		GRAPHIC_2_2_RED_243(Category.IMAGE, "86", 212, 104, 3, ClassType.SEMCO, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 111, true, false, "361", "FFFF"),
		GRAPHIC_2_9_RED_243(Category.IMAGE, "87", 296, 128, 3, ClassType.SEMCO, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 112, true, false, "3B1", "FFFF"),
		GRAPHIC_3_3_RED_243(Category.IMAGE, "E7", 300, 200, 3, ClassType.SEMCO, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 112, true, false, "451", "FFFF"),
		GRAPHIC_4_2_RED_243(Category.IMAGE, "82", 400, 300, 3, ClassType.SEMCO, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 112, false, false, "481", "FFFF"),
		GRAPHIC_6_0_RED_243(Category.IMAGE, "E8", 600, 448, 3, ClassType.SEMCO, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 128, false, false, "551", "FFFF"),

		// RED Color + NFC, SEMCO
		GRAPHIC_1_6_RED_NFC_243(Category.IMAGE, "B5", 152, 152, 3, ClassType.SEMCO, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 91, false, true, "343", "FFFF"),
		GRAPHIC_2_2_RED_NFC_243(Category.IMAGE, "B6", 212, 104, 3, ClassType.SEMCO, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 111, true, true, "363", "FFFF"),
		GRAPHIC_2_9_RED_NFC_243(Category.IMAGE, "B7", 296, 128, 3, ClassType.SEMCO, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 112, true, true, "3B3", "FFFF"),
		GRAPHIC_3_3_RED_NFC_243(Category.IMAGE, "E7", 300, 200, 3, ClassType.SEMCO, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 112, true, true, "453", "FFFF"),
		GRAPHIC_4_2_RED_NFC_243(Category.IMAGE, "B2", 400, 300, 3, ClassType.SEMCO, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 112, false, true, "483", "FFFF"),
		GRAPHIC_6_0_RED_NFC_243(Category.IMAGE, "E8", 600, 448, 3, ClassType.SEMCO, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 128, false, true, "553", "FFFF"),

		// REWE 7SEG
		SEGMENT7_SMALL(Category.SEGMENT, "04", 0, 0, 1, ClassType.SEMCO, ColorType.NONE, CompressionType.NONE, 0, 0,
				false, false, "0", "0"),
		SEGMENT7_MIDDLE(Category.SEGMENT, "03", 0, 0, 1, ClassType.SEMCO, ColorType.NONE, CompressionType.NONE, 0, 0,
				false, false, "1", "1"),
		SEGMENT7_LARGE(Category.SEGMENT, "03", 0, 0, 1, ClassType.SEMCO, ColorType.NONE, CompressionType.NONE, 0, 0,
				false, false, "2", "2"),
		SEGMENT7_FREEZER(Category.SEGMENT, "0A", 0, 0, 1, ClassType.SEMCO, ColorType.NONE, CompressionType.NONE, 0, 0,
				false, false, "3", "3"),
		SEGMENT7_DIGIT4(Category.SEGMENT, "01", 0, 0, 1, ClassType.SEMCO, ColorType.NONE, CompressionType.NONE, 0, 0,
				false, false, "4", "4"),

		MULTI_SEGMENT_1_0(Category.MULTI_SEGMENT, "0E", 0, 0, 1, ClassType.SEMCO, ColorType.NONE, CompressionType.NONE,
				0, 0, false, false, "041", "FFFF"), // Shoe label
		MULTI_SEGMENT_1_0_INT_RT(Category.MULTI_SEGMENT, "10", 0, 0, 1, ClassType.TI, ColorType.NONE,
				CompressionType.NONE, 0, 0, false, false, "056", "FFFF"), // Gen3-TI, Non NFC, 7Seg

		/******************************************************
		 * Real Time Labels
		 ******************************************************/
		// Freezer, REALTIME
		GRAPHIC_2_2_FREEZER_RT(Category.IMAGE, "21", 212, 104, 3, ClassType.TI_FREEZER, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 111, false, false, "851", "FFFF"),
		GRAPHIC_2_9_FREEZER_RT(Category.IMAGE, "22", 296, 128, 3, ClassType.TI_FREEZER, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 112, false, false, "861", "FFFF"),
		GRAPHIC_2_9_FREEZER_HD_RT(Category.IMAGE, "74", 384, 168, 3, ClassType.TI_FREEZER, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 112, false, false, "761", "FFFF"),

		// Freezer + NFC, REALTIME
		GRAPHIC_2_2_NFC_FREEZER_RT(Category.IMAGE, "21", 212, 104, 3, ClassType.TI_FREEZER, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 111, false, true, "853", "FFFF"),
		M3_GRAPHIC_2_2_NFC_FREEZER_RT(Category.IMAGE, "21", 296, 160, 3, ClassType.TI_FREEZER, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 111, false, true, "858", "FFFF"),
		GRAPHIC_2_9_NFC_FREEZER_RT(Category.IMAGE, "22", 296, 128, 3, ClassType.TI_FREEZER, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 112, false, true, "863", "FFFF"),
		GRAPHIC_2_9_NFC_FREEZER_HD_RT(Category.IMAGE, "74", 384, 168, 3, ClassType.TI_FREEZER, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 112, false, true, "763", "FFFF"),
		M3_GRAPHIC_2_9_NFC_FREEZER_RT(Category.IMAGE, "22", 384, 168, 3, ClassType.TI_FREEZER, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 112, false, true, "868", "FFFF"),

		// MONO, REALTIME
		GRAPHIC_1_6_HD_RT(Category.IMAGE, "20", 200, 200, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE, 0,
				184, false, false, "841", "FFFF"),
		GRAPHIC_1_6_RT(Category.IMAGE, "30", 152, 152, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE, 0,
				91, false, false, "A01", "FFFF"),
		GRAPHIC_2_2_RT(Category.IMAGE, "31", 212, 104, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE, 270,
				111, false, false, "A11", "FFFF"),
		GRAPHIC_2_6_RT(Category.IMAGE, "3C", 296, 152, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE, 270,
				125, false, false, "AC1", "FFFF"),
		GRAPHIC_2_7_RT(Category.IMAGE, "33", 264, 176, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE, 270,
				117, false, false, "A31", "FFFF"),
		GRAPHIC_2_9_RT(Category.IMAGE, "32", 296, 128, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE, 270,
				112, false, false, "A21", "FFFF"),
		GRAPHIC_3_3_RT(Category.IMAGE, "34", 300, 200, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE, 270,
				110, false, false, "A41", "FFFF"),
		GRAPHIC_4_2_RT(Category.IMAGE, "35", 400, 300, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE, 0,
				120, false, false, "A51", "FFFF"),
		GRAPHIC_4_3_RT(Category.IMAGE, "D0", 522, 152, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE, 270,
				125, false, false, "AF1", "FFFF"),
		GRAPHIC_4_3_TAPGO_RT(Category.IMAGE, "2F", 152, 522, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE,
				180, 125, false, false, "DD1", "FFFF"),
		GRAPHIC_5_7_RT(Category.IMAGE, "36", 600, 200, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE, 270,
				110, false, false, "A61", "FFFF"),
		GRAPHIC_6_0_RT(Category.IMAGE, "37", 600, 448, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE, 0,
				128, false, false, "A71", "FFFF"),
		GRAPHIC_6_0_RT_V2(Category.IMAGE, "38", 600, 448, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE, 0,
				128, false, false, "A81", "FFFF"),
		GRAPHIC_7_5_RT(Category.IMAGE, "3A", 384, 640, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE, 270,
				100, false, false, "AA1", "FFFF"),
		GRAPHIC_7_5_HD_RT(Category.IMAGE, "39", 528, 880, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE,
				270, 137, false, false, "A91", "FFFF"),
		GRAPHIC_7_5_HR_RT(Category.IMAGE, "66", 480, 800, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE,
				270, 126, false, false, "D91", "FFFF"),
		GRAPHIC_11_6_RT(Category.IMAGE, "3D", 640, 960, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE, 270,
				100, false, false, "AD1", "FFFF"),
		GRAPHIC_13_3_RT(Category.IMAGE, "3B", 1200, 1600, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE,
				270, 150, false, false, "AB1", "FFFF"),

		// MONO + NFC, REALTIME
		GRAPHIC_1_6_NFC_HD_RT(Category.IMAGE, "20", 200, 200, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 0, 184, false, true, "843", "FFFF"),
		GRAPHIC_1_6_NFC_RT(Category.IMAGE, "30", 152, 152, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE,
				0, 91, false, true, "A03", "FFFF"),
		M3_GRAPHIC_1_6_NFC_RT(Category.IMAGE, "30", 200, 200, 7, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 0, 184, false, true, "848", "FFFF"),
		GRAPHIC_2_2_NFC_RT(Category.IMAGE, "31", 212, 104, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE,
				270, 111, false, true, "A13", "FFFF"),
		M3_GRAPHIC_2_2_NFC_RT(Category.IMAGE, "31", 296, 160, 7, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 111, false, true, "A18", "FFFF"),
		GRAPHIC_2_6_NFC_RT(Category.IMAGE, "3C", 296, 152, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE,
				270, 125, false, true, "AC3", "FFFF"),
		GRAPHIC_2_7_NFC_RT(Category.IMAGE, "33", 264, 176, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE,
				270, 117, false, true, "A33", "FFFF"),
		GRAPHIC_2_9_NFC_RT(Category.IMAGE, "32", 296, 128, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE,
				270, 112, false, true, "A23", "FFFF"),
		M3_GRAPHIC_2_9_NFC_RT(Category.IMAGE, "3C", 384, 168, 7, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 112, false, true, "A28", "FFFF"),
		GRAPHIC_3_3_NFC_RT(Category.IMAGE, "34", 300, 200, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE,
				270, 110, false, true, "A43", "FFFF"),
		GRAPHIC_4_2_NFC_RT(Category.IMAGE, "35", 400, 300, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE,
				0, 120, false, true, "A53", "FFFF"),
		M3_GRAPHIC_4_2_NFC_RT(Category.IMAGE, "35", 400, 300, 7, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 0, 120, false, true, "A58", "FFFF"),
		GRAPHIC_4_3_NFC_RT(Category.IMAGE, "D0", 522, 152, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE,
				270, 125, false, true, "AF3", "FFFF"),
		GRAPHIC_4_3_NFC_TAPGO_RT(Category.IMAGE, "2F", 152, 522, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 180, 125, false, true, "DD3", "FFFF"),
		M3_GRAPHIC_4_3_NFC_RT(Category.IMAGE, "6F", 522, 152, 7, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 125, false, true, "AF8", "FFFF"),
		GRAPHIC_5_7_NFC_RT(Category.IMAGE, "36", 600, 200, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE,
				270, 110, false, true, "A63", "FFFF"),
		GRAPHIC_6_0_NFC_RT(Category.IMAGE, "37", 600, 448, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE,
				0, 128, false, true, "A73", "FFFF"),
		GRAPHIC_6_0_NFC_RT_V2(Category.IMAGE, "38", 600, 448, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 0, 128, false, true, "A83", "FFFF"),
		GRAPHIC_7_5_NFC_RT(Category.IMAGE, "3A", 384, 640, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE,
				270, 100, false, true, "AA3", "FFFF"),
		GRAPHIC_7_5_NFC_HD_RT(Category.IMAGE, "39", 528, 880, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 137, false, true, "A93", "FFFF"),
		GRAPHIC_7_5_NFC_HR_RT(Category.IMAGE, "66", 480, 800, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 126, false, true, "D93", "FFFF"),
		M3_GRAPHIC_7_5_NFC_RT(Category.IMAGE, "66", 480, 800, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 126, false, true, "D98", "FFFF"),
		GRAPHIC_11_6_NFC_RT(Category.IMAGE, "3D", 640, 960, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE,
				270, 100, false, true, "AD3", "FFFF"),
		M3_GRAPHIC_11_6_NFC_RT(Category.IMAGE, "3D", 640, 960, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 100, false, true, "AD8", "FFFF"),
		GRAPHIC_13_3_NFC_RT(Category.IMAGE, "3B", 1200, 1600, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 150, false, true, "AB3", "FFFF"),

		// RED, REALTIME
		GRAPHIC_1_6_RED_RT(Category.IMAGE, "30", 152, 152, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 91, false, false, "B01", "FFFF"),
		GRAPHIC_1_6_RED_HD_RT(Category.IMAGE, "65", 200, 200, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 184, false, false, "D01", "FFFF"),
		GRAPHIC_2_2_RED_RT(Category.IMAGE, "31", 212, 104, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 111, false, false, "B11", "FFFF"),
		GRAPHIC_2_6_RED_RT(Category.IMAGE, "3C", 296, 152, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 125, false, false, "BC1", "FFFF"),
		GRAPHIC_2_7_RED_RT(Category.IMAGE, "33", 264, 176, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 117, false, false, "B31", "FFFF"),
		GRAPHIC_2_9_RED_RT(Category.IMAGE, "32", 296, 128, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 112, false, false, "B21", "FFFF"),
		GRAPHIC_3_3_RED_RT(Category.IMAGE, "34", 300, 200, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 110, false, false, "B41", "FFFF"),
		GRAPHIC_4_2_RED_RT(Category.IMAGE, "35", 400, 300, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 120, false, false, "B51", "FFFF"),
		GRAPHIC_4_3_RED_RT(Category.IMAGE, "D0", 522, 152, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 125, false, false, "BF1", "FFFF"),
		GRAPHIC_4_3_RED_TAPGO_RT(Category.IMAGE, "2F", 152, 522, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 180, 125, false, false, "ED1", "FFFF"),
		GRAPHIC_5_7_RED_RT(Category.IMAGE, "36", 600, 200, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 110, false, false, "B61", "FFFF"),
		GRAPHIC_6_0_RED_RT(Category.IMAGE, "37", 600, 448, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 128, false, false, "B71", "FFFF"),
		GRAPHIC_6_0_RED_RT_V2(Category.IMAGE, "38", 600, 448, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 128, false, false, "B81", "FFFF"),
		GRAPHIC_7_5_RED_RT(Category.IMAGE, "3A", 384, 640, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 100, false, false, "BA1", "FFFF"),
		GRAPHIC_7_5_RED_HD_RT(Category.IMAGE, "39", 528, 880, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 137, false, false, "B91", "FFFF"),
		GRAPHIC_7_5_RED_HR_RT(Category.IMAGE, "66", 480, 800, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 126, false, false, "E91", "FFFF"),
		GRAPHIC_11_6_RED_RT(Category.IMAGE, "3D", 640, 960, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 100, false, false, "BD1", "FFFF"),
		GRAPHIC_13_3_RED_RT(Category.IMAGE, "3B", 1200, 1600, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 150, false, false, "BB1", "FFFF"),

		// RED + NFC, REALTIME
		GRAPHIC_1_6_RED_NFC_RT(Category.IMAGE, "30", 152, 152, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 91, false, true, "B03", "FFFF"),
		GRAPHIC_1_6_RED_NFC_HD_RT(Category.IMAGE, "65", 200, 200, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 184, false, true, "D03", "FFFF"),
		M3_GRAPHIC_1_6_RED_NFC_RT(Category.IMAGE, "30", 200, 200, 7, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 184, false, true, "B08", "FFFF"),
		GRAPHIC_2_2_RED_NFC_RT(Category.IMAGE, "31", 212, 104, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 111, false, true, "B13", "FFFF"),
		M3_GRAPHIC_2_2_RED_NFC_RT(Category.IMAGE, "31", 296, 160, 7, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 111, false, true, "B18", "FFFF"),
		GRAPHIC_2_6_RED_NFC_RT(Category.IMAGE, "3C", 296, 152, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 125, false, true, "BC3", "FFFF"),
		GRAPHIC_2_7_RED_NFC_RT(Category.IMAGE, "33", 264, 176, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 117, false, true, "B33", "FFFF"),
		GRAPHIC_2_9_RED_NFC_RT(Category.IMAGE, "32", 296, 128, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 112, false, true, "B23", "FFFF"),
		M3_GRAPHIC_2_9_RED_NFC_RT(Category.IMAGE, "3C", 384, 168, 7, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 112, false, true, "B28", "FFFF"),
		GRAPHIC_3_3_RED_NFC_RT(Category.IMAGE, "34", 300, 200, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 110, false, true, "B43", "FFFF"),
		GRAPHIC_4_2_RED_NFC_RT(Category.IMAGE, "35", 400, 300, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 120, false, true, "B53", "FFFF"),
		M3_GRAPHIC_4_2_RED_NFC_RT(Category.IMAGE, "35", 400, 300, 7, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 120, false, true, "B58", "FFFF"),
		GRAPHIC_4_3_RED_NFC_RT(Category.IMAGE, "D0", 522, 152, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 125, false, true, "BF3", "FFFF"),
		GRAPHIC_4_3_RED_TAPGO_NFC_RT(Category.IMAGE, "2F", 152, 522, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 180, 125, false, true, "ED3", "FFFF"),
		M3_GRAPHIC_4_3_RED_NFC_RT(Category.IMAGE, "6F", 522, 152, 7, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 125, false, true, "BF8", "FFFF"),
		GRAPHIC_5_7_RED_NFC_RT(Category.IMAGE, "36", 600, 200, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 110, false, true, "B63", "FFFF"),
		GRAPHIC_6_0_RED_NFC_RT(Category.IMAGE, "37", 600, 448, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 128, false, true, "B73", "FFFF"),
		GRAPHIC_6_0_RED_NFC_RT_V2(Category.IMAGE, "38", 600, 448, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 128, false, true, "B83", "FFFF"),
		GRAPHIC_7_5_RED_NFC_RT(Category.IMAGE, "3A", 384, 640, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 100, false, true, "BA3", "FFFF"),
		GRAPHIC_7_5_RED_NFC_HD_RT(Category.IMAGE, "39", 528, 880, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 137, false, true, "B93", "FFFF"),
		GRAPHIC_7_5_RED_NFC_HR_RT(Category.IMAGE, "66", 480, 800, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 126, false, true, "E93", "FFFF"),
		M3_GRAPHIC_7_5_RED_NFC_RT(Category.IMAGE, "66", 480, 800, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 126, false, true, "E98", "FFFF"),
		GRAPHIC_11_6_RED_NFC_RT(Category.IMAGE, "3D", 640, 960, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 100, false, true, "BD3", "FFFF"),
		M3_GRAPHIC_11_6_RED_NFC_RT(Category.IMAGE, "3D", 640, 960, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 100, false, true, "BD8", "FFFF"),
		GRAPHIC_13_3_RED_NFC_RT(Category.IMAGE, "3B", 1200, 1600, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 150, false, true, "BB3", "FFFF"),

		// YELLOW, REALTIME
		GRAPHIC_1_6_YEL_RT(Category.IMAGE, "30", 152, 152, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 91, false, false, "C01", "FFFF"),
		GRAPHIC_1_6_YEL_HD_RT(Category.IMAGE, "65", 200, 200, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 184, false, false, "E01", "FFFF"),
		GRAPHIC_2_2_YEL_RT(Category.IMAGE, "31", 212, 104, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 111, false, false, "C11", "FFFF"),
		GRAPHIC_2_6_YEL_RT(Category.IMAGE, "3C", 296, 152, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 125, false, false, "CC1", "FFFF"),
		GRAPHIC_2_7_YEL_RT(Category.IMAGE, "33", 264, 176, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 117, false, false, "C31", "FFFF"),
		GRAPHIC_2_9_YEL_RT(Category.IMAGE, "32", 296, 128, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 112, false, false, "C21", "FFFF"),
		GRAPHIC_3_3_YEL_RT(Category.IMAGE, "34", 300, 200, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 110, false, false, "C41", "FFFF"),
		GRAPHIC_4_2_YEL_RT(Category.IMAGE, "35", 400, 300, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 120, false, false, "C51", "FFFF"),
		GRAPHIC_4_3_YEL_TAPGO_RT(Category.IMAGE, "2F", 152, 522, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 180, 125, false, false, "FD1", "FFFF"),
		GRAPHIC_5_7_YEL_RT(Category.IMAGE, "36", 600, 200, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 110, false, false, "C61", "FFFF"),
		GRAPHIC_6_0_YEL_RT(Category.IMAGE, "37", 600, 448, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 128, false, false, "C71", "FFFF"),
		GRAPHIC_6_0_YEL_RT_V2(Category.IMAGE, "38", 600, 448, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 128, false, false, "C81", "FFFF"),
		GRAPHIC_7_5_YEL_RT(Category.IMAGE, "3A", 384, 640, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 100, false, false, "CA1", "FFFF"),
		GRAPHIC_7_5_YEL_HD_RT(Category.IMAGE, "39", 528, 880, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 137, false, false, "C91", "FFFF"),
		GRAPHIC_7_5_YEL_HR_RT(Category.IMAGE, "66", 480, 800, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 126, false, false, "F91", "FFFF"),
		GRAPHIC_11_6_YEL_RT(Category.IMAGE, "3D", 640, 960, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 100, false, false, "CD1", "FFFF"),
		GRAPHIC_13_3_YEL_RT(Category.IMAGE, "3B", 1200, 1600, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 150, false, false, "CB1", "FFFF"),

		// YELLOW + NFC, REALTIME
		GRAPHIC_1_6_YEL_NFC_RT(Category.IMAGE, "30", 152, 152, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 91, false, true, "C03", "FFFF"),
		GRAPHIC_1_6_YEL_NFC_HD_RT(Category.IMAGE, "65", 200, 200, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 184, false, true, "E03", "FFFF"),
		M3_GRAPHIC_1_6_YEL_NFC_RT(Category.IMAGE, "30", 200, 200, 7, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 184, false, true, "C08", "FFFF"),
		GRAPHIC_2_2_YEL_NFC_RT(Category.IMAGE, "31", 212, 104, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 111, false, true, "C13", "FFFF"),
		M3_GRAPHIC_2_2_YEL_NFC_RT(Category.IMAGE, "31", 296, 160, 7, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 111, false, true, "C18", "FFFF"),
		GRAPHIC_2_6_YEL_NFC_RT(Category.IMAGE, "3C", 296, 152, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 125, false, true, "CC3", "FFFF"),
		GRAPHIC_2_7_YEL_NFC_RT(Category.IMAGE, "33", 264, 176, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 117, false, true, "C33", "FFFF"),
		GRAPHIC_2_9_YEL_NFC_RT(Category.IMAGE, "32", 296, 128, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 112, false, true, "C23", "FFFF"),
		M3_GRAPHIC_2_9_YEL_NFC_RT(Category.IMAGE, "3C", 384, 168, 7, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 112, false, true, "C28", "FFFF"),
		GRAPHIC_3_3_YEL_NFC_RT(Category.IMAGE, "34", 300, 200, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 110, false, true, "C43", "FFFF"),
		GRAPHIC_4_2_YEL_NFC_RT(Category.IMAGE, "35", 400, 300, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 120, false, true, "C53", "FFFF"),
		M3_GRAPHIC_4_2_YEL_NFC_RT(Category.IMAGE, "35", 400, 300, 7, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 120, false, true, "C58", "FFFF"),
		GRAPHIC_4_3_YEL_NFC_TAPGO_RT(Category.IMAGE, "2F", 152, 522, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 180, 125, false, true, "FD3", "FFFF"),
		M3_GRAPHIC_4_3_YEL_NFC_RT(Category.IMAGE, "6F", 522, 152, 7, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 125, false, true, "CF8", "FFFF"),
		GRAPHIC_5_7_YEL_NFC_RT(Category.IMAGE, "36", 600, 200, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 110, false, true, "C63", "FFFF"),
		GRAPHIC_6_0_YEL_NFC_RT(Category.IMAGE, "37", 600, 448, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 128, false, true, "C73", "FFFF"),
		GRAPHIC_6_0_YEL_NFC_RT_V2(Category.IMAGE, "38", 600, 448, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 128, false, true, "C83", "FFFF"),
		GRAPHIC_7_5_YEL_NFC_RT(Category.IMAGE, "3A", 384, 640, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 100, false, true, "CA3", "FFFF"),
		GRAPHIC_7_5_YEL_NFC_HD_RT(Category.IMAGE, "39", 528, 880, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 137, false, true, "C93", "FFFF"),
		GRAPHIC_7_5_YEL_NFC_HR_RT(Category.IMAGE, "66", 480, 800, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 126, false, true, "F93", "FFFF"),
		M3_GRAPHIC_7_5_YEL_NFC_RT(Category.IMAGE, "66", 480, 800, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 126, false, true, "F98", "FFFF"),
		GRAPHIC_11_6_YEL_NFC_RT(Category.IMAGE, "3D", 640, 960, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 100, false, true, "CD3", "FFFF"),
		M3_GRAPHIC_11_6_YEL_NFC_RT(Category.IMAGE, "3D", 640, 960, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 100, false, true, "CD8", "FFFF"),
		GRAPHIC_13_3_YEL_NFC_RT(Category.IMAGE, "3B", 1200, 1600, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 150, false, true, "CB3", "FFFF"),

		/******************************************************
		 * Integrated Real Time Labels
		 ******************************************************/
		// Freezer, INT REALTIME
		GRAPHIC_2_2_FREEZER_INT_RT(Category.IMAGE, "25", 212, 104, 3, ClassType.TI_FREEZER, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 111, false, false, "856", "FFFF"),
		GRAPHIC_2_9_FREEZER_INT_RT(Category.IMAGE, "26", 296, 128, 3, ClassType.TI_FREEZER, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 112, false, false, "866", "FFFF"),
		GRAPHIC_2_9_FREEZER_HD_INT_RT(Category.IMAGE, "64", 384, 168, 3, ClassType.TI_FREEZER, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 112, false, false, "766", "FFFF"),

		// Freezer + NFC, INT REALTIME
		GRAPHIC_2_2_NFC_FREEZER_INT_RT(Category.IMAGE, "25", 212, 104, 3, ClassType.TI_FREEZER, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 111, false, true, "857", "FFFF"),
		M3_GRAPHIC_2_2_NFC_FREEZER_INT_RT(Category.IMAGE, "25", 296, 160, 3, ClassType.TI_FREEZER, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 111, false, true, "85E", "FFFF"),
		GRAPHIC_2_9_NFC_FREEZER_INT_RT(Category.IMAGE, "26", 296, 128, 3, ClassType.TI_FREEZER, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 112, false, true, "867", "FFFF"),
		GRAPHIC_2_9_NFC_FREEZER_HD_INT_RT(Category.IMAGE, "64", 384, 168, 3, ClassType.TI_FREEZER, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 112, false, true, "767", "FFFF"),
		M3_GRAPHIC_2_9_NFC_FREEZER_INT_RT(Category.IMAGE, "26", 384, 168, 3, ClassType.TI_FREEZER, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 112, false, true, "86E", "FFFF"),

		// Illumination, MONO + NFC, INT REALTIME
		GRAPHIC_2_2_NFC_ILLUM_INT_RT(Category.IMAGE, "28", 212, 104, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 111, false, true, "A1A", "FFFF"),
		GRAPHIC_2_6_NFC_ILLUM_INT_RT(Category.IMAGE, "2A", 296, 152, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 125, false, true, "ACA", "FFFF"),
		GRAPHIC_2_9_NFC_ILLUM_INT_RT(Category.IMAGE, "29", 296, 128, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 112, false, true, "A2A", "FFFF"),

		// Illumination, RED + NFC, INT REALTIME
		GRAPHIC_2_2_RED_NFC_ILLUM_INT_RT(Category.IMAGE, "28", 212, 104, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 111, false, true, "B1A", "FFFF"),
		GRAPHIC_2_6_RED_NFC_ILLUM_INT_RT(Category.IMAGE, "2A", 296, 152, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 125, false, true, "BCA", "FFFF"),
		GRAPHIC_2_9_RED_NFC_ILLUM_INT_RT(Category.IMAGE, "29", 296, 128, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 112, false, true, "B2A", "FFFF"),

		// Illumination, YELLOW + NFC, INT REALTIME
		GRAPHIC_2_2_YEL_NFC_ILLUM_INT_RT(Category.IMAGE, "28", 212, 104, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 111, false, true, "C1A", "FFFF"),
		GRAPHIC_2_6_YEL_NFC_ILLUM_INT_RT(Category.IMAGE, "2A", 296, 152, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 125, false, true, "CCA", "FFFF"),
		GRAPHIC_2_9_YEL_NFC_ILLUM_INT_RT(Category.IMAGE, "29", 296, 128, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 112, false, true, "C2A", "FFFF"),

		// MONO, INT REALTIME
		GRAPHIC_1_3_INT_RT(Category.IMAGE, "63", 200, 144, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE,
				270, 153, false, false, "DC6", "FFFF"),
		GRAPHIC_1_6_HD_INT_RT(Category.IMAGE, "23", 200, 200, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 0, 184, false, false, "846", "FFFF"),
		GRAPHIC_1_6_INT_RT(Category.IMAGE, "40", 152, 152, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE,
				0, 91, false, false, "A06", "FFFF"),
		GRAPHIC_2_2_INT_RT(Category.IMAGE, "41", 212, 104, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE,
				270, 111, false, false, "A16", "FFFF"),
		GRAPHIC_2_2_TAPGO_INT_RT(Category.IMAGE, "2C", 212, 104, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 111, false, false, "DE6", "FFFF"),
		GRAPHIC_2_6_INT_RT(Category.IMAGE, "4C", 296, 152, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE,
				270, 125, false, false, "AC6", "FFFF"),
		GRAPHIC_2_6_SEC_INT_RT(Category.IMAGE, "4E", 152, 296, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 180, 125, false, false, "AE6", "FFFF"),
		GRAPHIC_2_7_INT_RT(Category.IMAGE, "43", 264, 176, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE,
				270, 117, false, false, "A36", "FFFF"),
		GRAPHIC_2_9_INT_RT(Category.IMAGE, "42", 296, 128, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE,
				270, 112, false, false, "A26", "FFFF"),
		GRAPHIC_3_3_INT_RT(Category.IMAGE, "44", 300, 200, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE,
				270, 110, false, false, "A46", "FFFF"),
		GRAPHIC_4_2_INT_RT(Category.IMAGE, "45", 400, 300, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE,
				0, 120, false, false, "A56", "FFFF"),
		GRAPHIC_4_3_INT_RT(Category.IMAGE, "60", 522, 152, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE,
				270, 125, false, false, "AF6", "FFFF"),
		GRAPHIC_4_3_TAPGO_INT_RT(Category.IMAGE, "2E", 152, 522, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 180, 125, false, false, "DD6", "FFFF"),
		GRAPHIC_5_7_INT_RT(Category.IMAGE, "46", 600, 200, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE,
				270, 110, false, false, "A66", "FFFF"),
		GRAPHIC_6_0_INT_RT(Category.IMAGE, "47", 600, 448, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE,
				0, 128, false, false, "A76", "FFFF"),
		GRAPHIC_6_0_INT_RT_V2(Category.IMAGE, "48", 600, 448, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 0, 128, false, false, "A86", "FFFF"),
		GRAPHIC_7_5_INT_RT(Category.IMAGE, "4A", 384, 640, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE,
				270, 100, false, false, "AA6", "FFFF"),
		GRAPHIC_7_5_INT_HD_RT(Category.IMAGE, "49", 528, 880, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 137, false, false, "A96", "FFFF"),
		GRAPHIC_7_5_INT_HR_RT(Category.IMAGE, "67", 480, 800, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 126, false, false, "D96", "FFFF"),
		GRAPHIC_11_6_INT_RT(Category.IMAGE, "4D", 640, 960, 3, ClassType.TI, ColorType.BINARY, CompressionType.DEFLATE,
				270, 100, false, false, "AD6", "FFFF"),
		GRAPHIC_13_3_INT_RT(Category.IMAGE, "4B", 1200, 1600, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 150, false, false, "AB6", "FFFF"),

		// MONO + NFC, INT REALTIME
		GRAPHIC_1_3_NFC_INT_RT(Category.IMAGE, "63", 200, 144, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 153, false, true, "DC7", "FFFF"),
		GRAPHIC_1_6_NFC_HD_INT_RT(Category.IMAGE, "23", 200, 200, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 0, 184, false, true, "847", "FFFF"),
		GRAPHIC_1_6_NFC_INT_RT(Category.IMAGE, "40", 152, 152, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 0, 91, false, true, "A07", "FFFF"),
		M3_GRAPHIC_1_6_NFC_INT_RT(Category.IMAGE, "40", 200, 200, 7, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 0, 184, false, true, "84E", "FFFF"),
		GRAPHIC_2_2_NFC_INT_RT(Category.IMAGE, "41", 212, 104, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 111, false, true, "A17", "FFFF"),
		GRAPHIC_2_2_NFC_TAPGO_INT_RT(Category.IMAGE, "2C", 212, 104, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 111, false, true, "DE7", "FFFF"),
		M3_GRAPHIC_2_2_NFC_INT_RT(Category.IMAGE, "41", 296, 160, 7, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 111, false, true, "A1E", "FFFF"),
		GRAPHIC_2_6_NFC_INT_RT(Category.IMAGE, "4C", 296, 152, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 125, false, true, "AC7", "FFFF"),
		GRAPHIC_2_6_NFC_SEC_INT_RT(Category.IMAGE, "4E", 152, 296, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 180, 125, false, true, "AE7", "FFFF"),
		GRAPHIC_2_7_NFC_INT_RT(Category.IMAGE, "43", 264, 176, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 117, false, true, "A37", "FFFF"),
		GRAPHIC_2_9_NFC_INT_RT(Category.IMAGE, "42", 296, 128, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 112, false, true, "A27", "FFFF"),
		M3_GRAPHIC_2_9_NFC_INT_RT(Category.IMAGE, "42", 384, 168, 7, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 112, false, true, "A2E", "FFFF"),
		GRAPHIC_3_3_NFC_INT_RT(Category.IMAGE, "44", 300, 200, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 110, false, true, "A47", "FFFF"),
		GRAPHIC_4_2_NFC_INT_RT(Category.IMAGE, "45", 400, 300, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 0, 120, false, true, "A57", "FFFF"),
		M3_GRAPHIC_4_2_NFC_INT_RT(Category.IMAGE, "45", 400, 300, 7, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 0, 120, false, true, "A5E", "FFFF"),
		GRAPHIC_4_3_NFC_INT_RT(Category.IMAGE, "60", 522, 152, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 125, false, true, "AF7", "FFFF"),
		GRAPHIC_4_3_NFC_TAPGO_INT_RT(Category.IMAGE, "2E", 152, 522, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 180, 125, false, true, "DD7", "FFFF"),
		GRAPHIC_5_7_NFC_INT_RT(Category.IMAGE, "46", 600, 200, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 110, false, true, "A67", "FFFF"),
		GRAPHIC_6_0_NFC_INT_RT(Category.IMAGE, "47", 600, 448, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 0, 128, false, true, "A77", "FFFF"),
		GRAPHIC_6_0_NFC_INT_RT_V2(Category.IMAGE, "48", 600, 448, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 0, 128, false, true, "A87", "FFFF"),
		M3_GRAPHIC_6_0_NFC_INT_RT(Category.IMAGE, "47", 600, 448, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 0, 128, false, true, "A7E", "FFFF"),
		GRAPHIC_7_5_NFC_INT_RT(Category.IMAGE, "4A", 384, 640, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 100, false, true, "AA7", "FFFF"),
		GRAPHIC_7_5_NFC_INT_HD_RT(Category.IMAGE, "49", 528, 880, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 137, false, true, "A97", "FFFF"),
		GRAPHIC_7_5_NFC_INT_HR_RT(Category.IMAGE, "67", 480, 800, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 126, false, true, "D97", "FFFF"),
		GRAPHIC_11_6_NFC_INT_RT(Category.IMAGE, "4D", 640, 960, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 100, false, true, "AD7", "FFFF"),
		GRAPHIC_13_3_NFC_INT_RT(Category.IMAGE, "4B", 1200, 1600, 3, ClassType.TI, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 150, false, true, "AB7", "FFFF"),

		// RED, INT REALTIME
		GRAPHIC_1_3_RED_INT_RT(Category.IMAGE, "63", 200, 144, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 153, false, false, "EC6", "FFFF"),
		GRAPHIC_1_6_RED_INT_RT(Category.IMAGE, "40", 152, 152, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 91, false, false, "B06", "FFFF"),
		GRAPHIC_1_6_RED_HD_INT_RT(Category.IMAGE, "62", 200, 200, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 184, false, false, "D06", "FFFF"),
		GRAPHIC_1_6_RED_TAPGO_INT_RT(Category.IMAGE, "2D", 152, 152, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 91, false, false, "EF6", "FFFF"),
		GRAPHIC_1_6_RED_MEDAL_INT_RT(Category.IMAGE, "62", 200, 200, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 125, false, false, "D06", "FFFF"),
		GRAPHIC_2_2_RED_INT_RT(Category.IMAGE, "41", 212, 104, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 111, false, false, "B16", "FFFF"),
		GRAPHIC_2_2_RED_TAPGO_INT_RT(Category.IMAGE, "2C", 212, 104, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 111, false, false, "EE6", "FFFF"),
		GRAPHIC_2_6_RED_INT_RT(Category.IMAGE, "4C", 296, 152, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 125, false, false, "BC6", "FFFF"),
		GRAPHIC_2_6_RED_SEC_INT_RT(Category.IMAGE, "4E", 152, 296, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 180, 125, false, false, "BE6", "FFFF"),
		GRAPHIC_2_7_RED_INT_RT(Category.IMAGE, "43", 264, 176, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 117, false, false, "B36", "FFFF"),
		GRAPHIC_2_9_RED_INT_RT(Category.IMAGE, "42", 296, 128, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 112, false, false, "B26", "FFFF"),
		GRAPHIC_3_3_RED_INT_RT(Category.IMAGE, "44", 300, 200, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 110, false, false, "B46", "FFFF"),
		GRAPHIC_4_2_RED_INT_RT(Category.IMAGE, "45", 400, 300, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 120, false, false, "B56", "FFFF"),
		GRAPHIC_4_3_RED_INT_RT(Category.IMAGE, "60", 522, 152, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 125, false, false, "BF6", "FFFF"),
		GRAPHIC_4_3_RED_TAPGO_INT_RT(Category.IMAGE, "2E", 152, 522, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 180, 125, false, false, "ED6", "FFFF"),
		GRAPHIC_5_7_RED_INT_RT(Category.IMAGE, "46", 600, 200, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 110, false, false, "B66", "FFFF"),
		GRAPHIC_6_0_RED_INT_RT(Category.IMAGE, "47", 600, 448, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 128, false, false, "B76", "FFFF"),
		GRAPHIC_6_0_RED_INT_RT_V2(Category.IMAGE, "48", 600, 448, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 128, false, false, "B86", "FFFF"),
		GRAPHIC_7_5_RED_INT_RT(Category.IMAGE, "4A", 384, 640, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 100, false, false, "BA6", "FFFF"),
		GRAPHIC_7_5_RED_INT_HD_RT(Category.IMAGE, "49", 528, 880, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 137, false, false, "B96", "FFFF"),
		GRAPHIC_7_5_RED_INT_HR_RT(Category.IMAGE, "67", 480, 800, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 126, false, false, "E96", "FFFF"),
		GRAPHIC_11_6_RED_INT_RT(Category.IMAGE, "4D", 640, 960, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 100, false, false, "BD6", "FFFF"),
		GRAPHIC_13_3_RED_INT_RT(Category.IMAGE, "4B", 1200, 1600, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 150, false, false, "BB6", "FFFF"),

		// RED + NFC, INT REALTIME
		GRAPHIC_1_3_RED_NFC_INT_RT(Category.IMAGE, "63", 200, 144, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 153, false, true, "EC7", "FFFF"),
		GRAPHIC_1_6_RED_NFC_INT_RT(Category.IMAGE, "40", 152, 152, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 91, false, true, "B07", "FFFF"),
		GRAPHIC_1_6_RED_NFC_HD_INT_RT(Category.IMAGE, "62", 200, 200, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 184, false, true, "D07", "FFFF"),
		GRAPHIC_1_6_RED_NFC_TAPGO_INT_RT(Category.IMAGE, "2D", 152, 152, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 91, false, true, "EF7", "FFFF"),
		GRAPHIC_1_6_RED_NFC_MEDAL_INT_RT(Category.IMAGE, "62", 200, 200, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 125, false, true, "D07", "FFFF"),
		M3_GRAPHIC_1_6_RED_NFC_INT_RT(Category.IMAGE, "40", 200, 200, 7, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 184, false, true, "B0E", "FFFF"),
		GRAPHIC_2_2_RED_NFC_INT_RT(Category.IMAGE, "41", 212, 104, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 111, false, true, "B17", "FFFF"),
		GRAPHIC_2_2_RED_NFC_TAPGO_INT_RT(Category.IMAGE, "2C", 212, 104, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 111, false, true, "EE7", "FFFF"),
		M3_GRAPHIC_2_2_RED_NFC_INT_RT(Category.IMAGE, "41", 296, 160, 7, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 111, false, true, "B1E", "FFFF"),
		GRAPHIC_2_6_RED_NFC_INT_RT(Category.IMAGE, "4C", 296, 152, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 125, false, true, "BC7", "FFFF"),
		GRAPHIC_2_6_RED_NFC_SEC_INT_RT(Category.IMAGE, "4E", 152, 296, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 180, 125, false, true, "BE7", "FFFF"),
		GRAPHIC_2_7_RED_NFC_INT_RT(Category.IMAGE, "43", 264, 176, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 117, false, true, "B37", "FFFF"),
		GRAPHIC_2_9_RED_NFC_INT_RT(Category.IMAGE, "42", 296, 128, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 112, false, true, "B27", "FFFF"),
		M3_GRAPHIC_2_9_RED_NFC_INT_RT(Category.IMAGE, "42", 384, 168, 7, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 112, false, true, "B2E", "FFFF"),
		GRAPHIC_3_3_RED_NFC_INT_RT(Category.IMAGE, "44", 300, 200, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 110, false, true, "B47", "FFFF"),
		GRAPHIC_4_2_RED_NFC_INT_RT(Category.IMAGE, "45", 400, 300, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 120, false, true, "B57", "FFFF"),
		M3_GRAPHIC_4_2_RED_NFC_INT_RT(Category.IMAGE, "45", 400, 300, 7, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 120, false, true, "B5E", "FFFF"),
		GRAPHIC_4_3_RED_NFC_INT_RT(Category.IMAGE, "60", 522, 152, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 125, false, true, "BF7", "FFFF"),
		GRAPHIC_4_3_RED_NFC_TAPGO_INT_RT(Category.IMAGE, "2E", 152, 522, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 180, 125, false, true, "ED7", "FFFF"),
		GRAPHIC_5_7_RED_NFC_INT_RT(Category.IMAGE, "46", 600, 200, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 110, false, true, "B67", "FFFF"),
		GRAPHIC_6_0_RED_NFC_INT_RT(Category.IMAGE, "47", 600, 448, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 128, false, true, "B77", "FFFF"),
		GRAPHIC_6_0_RED_NFC_INT_RT_V2(Category.IMAGE, "48", 600, 448, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 128, false, true, "B87", "FFFF"),
		M3_GRAPHIC_6_0_RED_NFC_INT_RT(Category.IMAGE, "47", 600, 448, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 128, false, true, "B7E", "FFFF"),
		GRAPHIC_7_5_RED_NFC_INT_RT(Category.IMAGE, "4A", 384, 640, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 100, false, true, "BA7", "FFFF"),
		GRAPHIC_7_5_RED_NFC_INT_HD_RT(Category.IMAGE, "49", 528, 880, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 137, false, true, "B97", "FFFF"),
		GRAPHIC_7_5_RED_NFC_INT_HR_RT(Category.IMAGE, "67", 480, 800, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 126, false, true, "E97", "FFFF"),
		GRAPHIC_11_6_RED_NFC_INT_RT(Category.IMAGE, "4D", 640, 960, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 100, false, true, "BD7", "FFFF"),
		GRAPHIC_13_3_RED_NFC_INT_RT(Category.IMAGE, "4B", 1200, 1600, 3, ClassType.TI, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 150, false, true, "BB7", "FFFF"),

		// YELLOW, INT REALTIME
		GRAPHIC_1_3_YEL_INT_RT(Category.IMAGE, "63", 200, 144, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 153, false, false, "FC6", "FFFF"),
		GRAPHIC_1_6_YEL_INT_RT(Category.IMAGE, "40", 152, 152, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 91, false, false, "C06", "FFFF"),
		GRAPHIC_1_6_YEL_HD_INT_RT(Category.IMAGE, "62", 200, 200, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 184, false, false, "E06", "FFFF"),
		GRAPHIC_1_6_YEL_TAPGO_INT_RT(Category.IMAGE, "2D", 152, 152, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 91, false, false, "FF6", "FFFF"),
		GRAPHIC_1_6_YEL_MEDAL_INT_RT(Category.IMAGE, "62", 200, 200, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 125, false, false, "E06", "FFFF"),
		GRAPHIC_2_2_YEL_INT_RT(Category.IMAGE, "41", 212, 104, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 111, false, false, "C16", "FFFF"),
		GRAPHIC_2_2_YEL_TAPGO_INT_RT(Category.IMAGE, "2C", 212, 104, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 111, false, false, "FE6", "FFFF"),
		GRAPHIC_2_6_YEL_INT_RT(Category.IMAGE, "4C", 296, 152, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 125, false, false, "CC6", "FFFF"),
		GRAPHIC_2_6_YEL_SEC_INT_RT(Category.IMAGE, "4E", 152, 296, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 180, 125, false, false, "CE6", "FFFF"),
		GRAPHIC_2_7_YEL_INT_RT(Category.IMAGE, "43", 264, 176, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 117, false, false, "C36", "FFFF"),
		GRAPHIC_2_9_YEL_INT_RT(Category.IMAGE, "42", 296, 128, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 112, false, false, "C26", "FFFF"),
		GRAPHIC_3_3_YEL_INT_RT(Category.IMAGE, "44", 300, 200, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 110, false, false, "C46", "FFFF"),
		GRAPHIC_4_2_YEL_INT_RT(Category.IMAGE, "45", 400, 300, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 120, false, false, "C56", "FFFF"),
		GRAPHIC_4_3_YEL_INT_RT(Category.IMAGE, "60", 522, 152, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 125, false, false, "CF6", "FFFF"),
		GRAPHIC_4_3_YEL_TAPGO_INT_RT(Category.IMAGE, "2E", 152, 522, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 180, 125, false, false, "FD6", "FFFF"),
		GRAPHIC_5_7_YEL_INT_RT(Category.IMAGE, "46", 600, 200, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 110, false, false, "C66", "FFFF"),
		GRAPHIC_6_0_YEL_INT_RT(Category.IMAGE, "47", 600, 448, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 128, false, false, "C76", "FFFF"),
		GRAPHIC_6_0_YEL_INT_RT_V2(Category.IMAGE, "48", 600, 448, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 128, false, false, "C86", "FFFF"),
		GRAPHIC_7_5_YEL_INT_RT(Category.IMAGE, "4A", 384, 640, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 100, false, false, "CA6", "FFFF"),
		GRAPHIC_7_5_YEL_INT_HD_RT(Category.IMAGE, "49", 528, 880, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 137, false, false, "C96", "FFFF"),
		GRAPHIC_7_5_YEL_INT_HR_RT(Category.IMAGE, "67", 480, 800, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 126, false, false, "F96", "FFFF"),
		GRAPHIC_11_6_YEL_INT_RT(Category.IMAGE, "4D", 640, 960, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 100, false, false, "CD6", "FFFF"),
		GRAPHIC_13_3_YEL_INT_RT(Category.IMAGE, "4B", 1200, 1600, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 150, false, false, "CB6", "FFFF"),

		// YELLOW + NFC, INT REALTIME
		GRAPHIC_1_3_YEL_NFC_INT_RT(Category.IMAGE, "63", 200, 144, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 153, false, true, "FC7", "FFFF"),
		GRAPHIC_1_6_YEL_NFC_INT_RT(Category.IMAGE, "40", 152, 152, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 91, false, true, "C07", "FFFF"),
		GRAPHIC_1_6_YEL_NFC_HD_INT_RT(Category.IMAGE, "62", 200, 200, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 184, false, true, "E07", "FFFF"),
		GRAPHIC_1_6_YEL_NFC_TAPGO_INT_RT(Category.IMAGE, "2D", 152, 152, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 91, false, true, "FF7", "FFFF"),
		GRAPHIC_1_6_YEL_NFC_MEDAL_INT_RT(Category.IMAGE, "62", 200, 200, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 125, false, true, "E07", "FFFF"),
		M3_GRAPHIC_1_6_YEL_NFC_INT_RT(Category.IMAGE, "40", 200, 200, 7, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 184, false, true, "C0E", "FFFF"),
		GRAPHIC_2_2_YEL_NFC_INT_RT(Category.IMAGE, "41", 212, 104, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 111, false, true, "C17", "FFFF"),
		GRAPHIC_2_2_YEL_NFC_TAPGO_INT_RT(Category.IMAGE, "2C", 212, 104, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 111, false, true, "FE7", "FFFF"),
		M3_GRAPHIC_2_2_YEL_NFC_INT_RT(Category.IMAGE, "41", 296, 160, 7, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 111, false, true, "C1E", "FFFF"),
		GRAPHIC_2_6_YEL_NFC_INT_RT(Category.IMAGE, "4C", 296, 152, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 125, false, true, "CC7", "FFFF"),
		GRAPHIC_2_6_YEL_NFC_SEC_INT_RT(Category.IMAGE, "4E", 152, 296, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 180, 125, false, true, "CE7", "FFFF"),
		GRAPHIC_2_7_YEL_NFC_INT_RT(Category.IMAGE, "43", 264, 176, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 117, false, true, "C37", "FFFF"),
		GRAPHIC_2_9_YEL_NFC_INT_RT(Category.IMAGE, "42", 296, 128, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 112, false, true, "C27", "FFFF"),
		M3_GRAPHIC_2_9_YEL_NFC_INT_RT(Category.IMAGE, "42", 384, 168, 7, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 112, false, true, "C2E", "FFFF"),
		GRAPHIC_3_3_YEL_NFC_INT_RT(Category.IMAGE, "44", 300, 200, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 110, false, true, "C47", "FFFF"),
		GRAPHIC_4_2_YEL_NFC_INT_RT(Category.IMAGE, "45", 400, 300, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 120, false, true, "C57", "FFFF"),
		M3_GRAPHIC_4_2_YEL_NFC_INT_RT(Category.IMAGE, "45", 400, 300, 7, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 120, false, true, "C5E", "FFFF"),
		GRAPHIC_4_3_YEL_NFC_INT_RT(Category.IMAGE, "60", 522, 152, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 125, false, true, "CF7", "FFFF"),
		GRAPHIC_4_3_YEL_NFC_TAPGO_INT_RT(Category.IMAGE, "2E", 152, 522, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 180, 125, false, true, "FD7", "FFFF"),
		GRAPHIC_5_7_YEL_NFC_INT_RT(Category.IMAGE, "46", 600, 200, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 110, false, true, "C67", "FFFF"),
		GRAPHIC_6_0_YEL_NFC_INT_RT(Category.IMAGE, "47", 600, 448, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 128, false, true, "C77", "FFFF"),
		GRAPHIC_6_0_YEL_NFC_INT_RT_V2(Category.IMAGE, "48", 600, 448, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 128, false, true, "C87", "FFFF"),
		M3_GRAPHIC_6_0_YEL_NFC_INT_RT(Category.IMAGE, "47", 600, 448, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 128, false, true, "C7E", "FFFF"),
		GRAPHIC_7_5_YEL_NFC_INT_RT(Category.IMAGE, "4A", 384, 640, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 100, false, true, "CA7", "FFFF"),
		GRAPHIC_7_5_YEL_NFC_INT_HD_RT(Category.IMAGE, "49", 528, 880, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 137, false, true, "C97", "FFFF"),
		GRAPHIC_7_5_YEL_NFC_INT_HR_RT(Category.IMAGE, "67", 480, 800, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 126, false, true, "F97", "FFFF"),
		GRAPHIC_11_6_YEL_NFC_INT_RT(Category.IMAGE, "4D", 640, 960, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 100, false, true, "CD7", "FFFF"),
		GRAPHIC_13_3_YEL_NFC_INT_RT(Category.IMAGE, "4B", 1200, 1600, 3, ClassType.TI, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 150, false, true, "CB7", "FFFF"),

		/******************************************************
		 * N-System Labels
		 ******************************************************/
		// Freezer, N-System
		NEWTON_GRAPHIC_2_2_FREEZER(Category.IMAGE, "20", 296, 160, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 156, false, true, "80D", "FFFF"),
		NEWTON_GRAPHIC_2_6_FREEZER(Category.IMAGE, "21", 360, 184, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 152, false, true, "81D", "FFFF"),
		NEWTON_GRAPHIC_2_9_FREEZER(Category.IMAGE, "22", 384, 168, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 144, false, true, "82D", "FFFF"),
		NEWTON_GRAPHIC_3_52_FREEZER(Category.IMAGE, "23", 384, 180, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 120, false, true, "83D", "FFFF"),
		NEWTON_GRAPHIC_5_85_FREEZER(Category.IMAGE, "24", 792, 272, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 0, 145, false, true, "84D", "FFFF"),

		// Freezer + NFC, N-System
		NEWTON_GRAPHIC_2_2_NFC_FREEZER(Category.IMAGE, "20", 296, 160, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 156, false, true, "809", "FFFF"),
		NEWTON_GRAPHIC_2_6_NFC_FREEZER(Category.IMAGE, "21", 360, 184, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 152, false, true, "819", "FFFF"),
		NEWTON_GRAPHIC_2_9_NFC_FREEZER(Category.IMAGE, "22", 384, 168, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 144, false, true, "829", "FFFF"),
		NEWTON_GRAPHIC_3_52_NFC_FREEZER(Category.IMAGE, "23", 384, 180, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 120, false, true, "839", "FFFF"),
		NEWTON_GRAPHIC_5_85_NFC_FREEZER(Category.IMAGE, "24", 792, 272, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 0, 145, false, true, "849", "FFFF"),

		// MONO, N-System
		NEWTON_GRAPHIC_0_97_LITE(Category.IMAGE, "6C", 184, 88, 3, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 210, false, false, "D6C", "FFFF"),
		NEWTON_GRAPHIC_0_97(Category.IMAGE, "6C", 184, 88, 3, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 210, false, false, "D6B", "FFFF"),
		NEWTON_GRAPHIC_1_3_PEGHOOK_LITE(Category.IMAGE, "4D", 144, 200, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 180, 189, false, false, "ADC", "FFFF"),
		NEWTON_GRAPHIC_1_3_PEGHOOK(Category.IMAGE, "4D", 144, 200, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 180, 189, false, false, "ADB", "FFFF"),
		NEWTON_GRAPHIC_1_6(Category.IMAGE, "40", 200, 200, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 0, 188, false, true, "A0D", "FFFF"),
		NEWTON_GRAPHIC_2_2_LITE(Category.IMAGE, "51", 250, 122, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 130, false, true, "D1D", "FFFF"),
		NEWTON_GRAPHIC_2_2(Category.IMAGE, "41", 296, 160, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 156, false, true, "A1D", "FFFF"),
		NEWTON_GRAPHIC_2_6(Category.IMAGE, "43", 360, 184, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 152, false, true, "A3D", "FFFF"),
		NEWTON_GRAPHIC_2_7(Category.IMAGE, "44", 300, 200, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 133, false, true, "A4D", "FFFF"),
		NEWTON_GRAPHIC_2_9(Category.IMAGE, "42", 384, 168, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 144, false, true, "A2D", "FFFF"),
		NEWTON_GRAPHIC_2_9_TAPGO_LITE(Category.IMAGE, "4E", 384, 168, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 144, false, false, "AEC", "FFFF"),
		NEWTON_GRAPHIC_2_9_TAPGO(Category.IMAGE, "4E", 384, 168, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 144, false, false, "AEB", "FFFF"),
		NEWTON_GRAPHIC_3_52_LITE(Category.IMAGE, "62", 384, 180, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 120, false, false, "D2C", "FFFF"),
		NEWTON_GRAPHIC_3_52(Category.IMAGE, "62", 384, 180, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 120, false, false, "D2B", "FFFF"),
		NEWTON_GRAPHIC_3_7(Category.IMAGE, "45", 240, 416, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 129, false, true, "A5D", "FFFF"),
		NEWTON_GRAPHIC_4_2(Category.IMAGE, "46", 400, 300, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 0, 120, false, true, "A6D", "FFFF"),
		NEWTON_GRAPHIC_4_3(Category.IMAGE, "47", 522, 152, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 125, false, true, "A7D", "FFFF"),
		NEWTON_GRAPHIC_4_3_TAPGO_LITE(Category.IMAGE, "4F", 152, 522, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 0, 125, false, false, "AFC", "FFFF"),
		NEWTON_GRAPHIC_4_3_TAPGO(Category.IMAGE, "4F", 152, 522, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 0, 125, false, false, "AFB", "FFFF"),
		NEWTON_GRAPHIC_5_85(Category.IMAGE, "63", 792, 272, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 0, 145, false, true, "D3D", "FFFF"),
		NEWTON_GRAPHIC_6_0(Category.IMAGE, "48", 600, 448, 3, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 0, 132, false, true, "A8D", "FFFF"),
		NEWTON_GRAPHIC_6_0_NEW(Category.IMAGE, "50", 648, 480, 3, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 0, 138, false, true, "D0D", "FFFF"),
		NEWTON_GRAPHIC_7_5_HR(Category.IMAGE, "4C", 480, 800, 3, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 126, false, true, "ACD", "FFFF"),
		NEWTON_GRAPHIC_7_5_HD(Category.IMAGE, "49", 528, 880, 3, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 137, false, true, "A9D", "FFFF"),
		NEWTON_GRAPHIC_9_7(Category.IMAGE, "64", 672, 960, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 121, false, true, "D4D", "FFFF"),
		NEWTON_GRAPHIC_11_6(Category.IMAGE, "4A", 640, 960, 3, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 100, false, true, "AAD", "FFFF"),
		NEWTON_DUAL_GRAPHIC_11_6_LITE(Category.IMAGE, "72", 640, 960, 2, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 100, false, false, "D8C", "FFFF"),
		NEWTON_DUAL_GRAPHIC_11_6(Category.IMAGE, "72", 640, 960, 2, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 100, false, false, "D8B", "FFFF"),
		NEWTON_GRAPHIC_12_2(Category.IMAGE, "65", 768, 960, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 103, false, true, "D5D", "FFFF"),
		NEWTON_GRAPHIC_13_3(Category.IMAGE, "4B", 1200, 1600, 3, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 150, false, true, "ABD", "FFFF"),

		// MONO + NFC, N-System
		NEWTON_GRAPHIC_1_6_NFC(Category.IMAGE, "40", 200, 200, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 0, 188, false, true, "A09", "FFFF"),
		NEWTON_GRAPHIC_2_2_NFC_LITE(Category.IMAGE, "51", 250, 122, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 130, false, true, "D19", "FFFF"),
		NEWTON_GRAPHIC_2_2_NFC(Category.IMAGE, "41", 296, 160, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 156, false, true, "A19", "FFFF"),
		NEWTON_X_GRAPHIC_2_2_NFC_LITE(Category.IMAGE, "6E", 296, 160, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 156, false, true, "00D", "FFFF"),
		NEWTON_X_GRAPHIC_2_2_NFC(Category.IMAGE, "6E", 296, 160, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 156, false, true, "009", "FFFF"),
		NEWTON_GRAPHIC_2_6_NFC(Category.IMAGE, "43", 360, 184, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 152, false, true, "A39", "FFFF"),
		NEWTON_GRAPHIC_2_7_NFC(Category.IMAGE, "44", 300, 200, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 133, false, true, "A49", "FFFF"),
		NEWTON_GRAPHIC_2_9_NFC(Category.IMAGE, "42", 384, 168, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 144, false, true, "A29", "FFFF"),
		NEWTON_GRAPHIC_3_52_NFC_LITE(Category.IMAGE, "62", 384, 180, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 120, false, true, "D2D", "FFFF"),
		NEWTON_GRAPHIC_3_52_NFC(Category.IMAGE, "62", 384, 180, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 120, false, true, "D29", "FFFF"),
		NEWTON_GRAPHIC_3_7_NFC(Category.IMAGE, "45", 240, 416, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 129, false, true, "A59", "FFFF"),
		NEWTON_GRAPHIC_4_2_NFC(Category.IMAGE, "46", 400, 300, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 0, 120, false, true, "A69", "FFFF"),
		NEWTON_GRAPHIC_4_3_NFC(Category.IMAGE, "47", 522, 152, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 125, false, true, "A79", "FFFF"),
		NEWTON_GRAPHIC_4_3_NFC_LITE_3BTN(Category.IMAGE, "70", 522, 152, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 125, false, true, "D7D", "FFFF"),
		NEWTON_GRAPHIC_4_3_NFC_3BTN(Category.IMAGE, "70", 522, 152, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 125, false, true, "D79", "FFFF"),
		NEWTON_GRAPHIC_5_85_NFC(Category.IMAGE, "63", 792, 272, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 0, 145, false, true, "D39", "FFFF"),
		NEWTON_GRAPHIC_6_0_NFC(Category.IMAGE, "48", 600, 448, 3, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 0, 132, false, true, "A89", "FFFF"),
		NEWTON_GRAPHIC_6_0_NFC_NEW(Category.IMAGE, "50", 648, 480, 3, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 0, 138, false, true, "D09", "FFFF"),
		NEWTON_GRAPHIC_7_5_NFC_HR(Category.IMAGE, "4C", 480, 800, 3, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 126, false, true, "AC9", "FFFF"),
		NEWTON_GRAPHIC_7_5_NFC_HD(Category.IMAGE, "49", 528, 880, 3, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 137, false, true, "A99", "FFFF"),
		NEWTON_GRAPHIC_9_7_NFC(Category.IMAGE, "64", 672, 960, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 121, false, true, "D49", "FFFF"),
		NEWTON_GRAPHIC_11_6_NFC(Category.IMAGE, "4A", 640, 960, 3, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 100, false, true, "AA9", "FFFF"),
		NEWTON_GRAPHIC_12_2_NFC(Category.IMAGE, "65", 768, 960, 7, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 103, false, true, "D59", "FFFF"),
		NEWTON_GRAPHIC_13_3_NFC(Category.IMAGE, "4B", 1200, 1600, 3, ClassType.N_SYSTEM, ColorType.BINARY,
				CompressionType.DEFLATE, 270, 150, false, true, "AB9", "FFFF"),

		// RED, N-System
		NEWTON_GRAPHIC_0_97_RED_LITE(Category.IMAGE, "6C", 184, 88, 3, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 210, false, false, "E6C", "FFFF"),
		NEWTON_GRAPHIC_0_97_RED(Category.IMAGE, "6C", 184, 88, 3, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 210, false, false, "E6B", "FFFF"),
		NEWTON_GRAPHIC_1_3_RED_PEGHOOK_LITE(Category.IMAGE, "4D", 144, 200, 7, ClassType.N_SYSTEM,
				ColorType.TERNARY_RED, CompressionType.DEFLATE, 180, 189, false, false, "BDC", "FFFF"),
		NEWTON_GRAPHIC_1_3_RED_PEGHOOK(Category.IMAGE, "4D", 144, 200, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 180, 189, false, false, "BDB", "FFFF"),
		NEWTON_GRAPHIC_1_6_RED(Category.IMAGE, "40", 200, 200, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 188, false, true, "B0D", "FFFF"),
		NEWTON_GRAPHIC_2_2_RED_LITE(Category.IMAGE, "51", 250, 122, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 130, false, true, "E1D", "FFFF"),
		NEWTON_GRAPHIC_2_2_RED(Category.IMAGE, "41", 296, 160, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 156, false, true, "B1D", "FFFF"),
		NEWTON_GRAPHIC_2_6_RED(Category.IMAGE, "43", 360, 184, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 152, false, true, "B3D", "FFFF"),
		NEWTON_GRAPHIC_2_7_RED(Category.IMAGE, "44", 300, 200, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 133, false, true, "B4D", "FFFF"),
		NEWTON_GRAPHIC_2_9_RED(Category.IMAGE, "42", 384, 168, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 144, false, true, "B2D", "FFFF"),
		NEWTON_GRAPHIC_2_9_RED_TAPGO_LITE(Category.IMAGE, "4E", 384, 168, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 144, false, false, "BEC", "FFFF"),
		NEWTON_GRAPHIC_2_9_RED_TAPGO(Category.IMAGE, "4E", 384, 168, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 144, false, false, "BEB", "FFFF"),
		NEWTON_GRAPHIC_3_52_RED_LITE(Category.IMAGE, "62", 384, 180, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 120, false, false, "E2C", "FFFF"),
		NEWTON_GRAPHIC_3_52_RED(Category.IMAGE, "62", 384, 180, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 120, false, false, "E2B", "FFFF"),
		NEWTON_GRAPHIC_3_7_RED(Category.IMAGE, "45", 240, 416, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 129, false, true, "B5D", "FFFF"),
		NEWTON_GRAPHIC_4_2_RED(Category.IMAGE, "46", 400, 300, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 120, false, true, "B6D", "FFFF"),
		NEWTON_GRAPHIC_4_3_RED(Category.IMAGE, "47", 522, 152, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 125, false, true, "B7D", "FFFF"),
		NEWTON_GRAPHIC_4_3_RED_TAPGO_LITE(Category.IMAGE, "4F", 152, 522, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 125, false, false, "BFC", "FFFF"),
		NEWTON_GRAPHIC_4_3_RED_TAPGO(Category.IMAGE, "4F", 152, 522, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 125, false, false, "BFB", "FFFF"),
		NEWTON_GRAPHIC_5_85_RED(Category.IMAGE, "63", 792, 272, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 145, false, true, "E3D", "FFFF"),
		NEWTON_GRAPHIC_6_0_RED(Category.IMAGE, "48", 600, 448, 3, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 132, false, true, "B8D", "FFFF"),
		NEWTON_GRAPHIC_6_0_RED_NEW(Category.IMAGE, "50", 648, 480, 3, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 138, false, true, "E0D", "FFFF"),
		NEWTON_GRAPHIC_7_5_RED_HR(Category.IMAGE, "4C", 480, 800, 3, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 126, false, true, "BCD", "FFFF"),
		NEWTON_GRAPHIC_7_5_RED_HD(Category.IMAGE, "49", 528, 880, 3, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 137, false, true, "B9D", "FFFF"),
		NEWTON_GRAPHIC_9_7_RED(Category.IMAGE, "64", 672, 960, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 121, false, true, "E4D", "FFFF"),
		NEWTON_GRAPHIC_11_6_RED(Category.IMAGE, "4A", 640, 960, 3, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 100, false, true, "BAD", "FFFF"),
		NEWTON_DUAL_GRAPHIC_11_6_RED_LITE(Category.IMAGE, "72", 640, 960, 2, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 100, false, false, "E8C", "FFFF"),
		NEWTON_DUAL_GRAPHIC_11_6_RED(Category.IMAGE, "72", 640, 960, 2, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 100, false, false, "E8B", "FFFF"),
		NEWTON_GRAPHIC_12_2_RED(Category.IMAGE, "65", 768, 960, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 103, false, true, "E5D", "FFFF"),
		NEWTON_GRAPHIC_13_3_RED(Category.IMAGE, "4B", 1200, 1600, 3, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 150, false, true, "BBD", "FFFF"),

		// RED + NFC, N-System
		NEWTON_GRAPHIC_1_6_RED_NFC(Category.IMAGE, "40", 200, 200, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 188, false, true, "B09", "FFFF"),
		NEWTON_GRAPHIC_2_2_RED_NFC_LITE(Category.IMAGE, "51", 250, 122, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 130, false, true, "E19", "FFFF"),
		NEWTON_GRAPHIC_2_2_RED_NFC(Category.IMAGE, "41", 296, 160, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 156, false, true, "B19", "FFFF"),
		NEWTON_X_GRAPHIC_2_2_RED_NFC_LITE(Category.IMAGE, "6E", 296, 160, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 156, false, true, "10D", "FFFF"),
		NEWTON_X_GRAPHIC_2_2_RED_NFC(Category.IMAGE, "6E", 296, 160, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 156, false, true, "109", "FFFF"),
		NEWTON_GRAPHIC_2_6_RED_NFC(Category.IMAGE, "43", 360, 184, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 152, false, true, "B39", "FFFF"),
		NEWTON_GRAPHIC_2_7_RED_NFC(Category.IMAGE, "44", 300, 200, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 133, false, true, "B49", "FFFF"),
		NEWTON_GRAPHIC_2_9_RED_NFC(Category.IMAGE, "42", 384, 168, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 144, false, true, "B29", "FFFF"),
		NEWTON_GRAPHIC_3_52_RED_NFC_LITE(Category.IMAGE, "62", 384, 180, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 120, false, true, "E2D", "FFFF"),
		NEWTON_GRAPHIC_3_52_RED_NFC(Category.IMAGE, "62", 384, 180, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 120, false, true, "E29", "FFFF"),
		NEWTON_GRAPHIC_3_7_RED_NFC(Category.IMAGE, "45", 240, 416, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 129, false, true, "B59", "FFFF"),
		NEWTON_GRAPHIC_4_2_RED_NFC(Category.IMAGE, "46", 400, 300, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 120, false, true, "B69", "FFFF"),
		NEWTON_GRAPHIC_4_3_RED_NFC(Category.IMAGE, "47", 522, 152, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 125, false, true, "B79", "FFFF"),
		NEWTON_GRAPHIC_4_3_RED_NFC_LITE_3BTN(Category.IMAGE, "70", 522, 152, 7, ClassType.N_SYSTEM,
				ColorType.TERNARY_RED, CompressionType.DEFLATE, 270, 125, false, true, "E7D", "FFFF"),
		NEWTON_GRAPHIC_4_3_RED_NFC_3BTN(Category.IMAGE, "70", 522, 152, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 125, false, true, "E79", "FFFF"),
		NEWTON_GRAPHIC_5_85_RED_NFC(Category.IMAGE, "63", 792, 272, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 145, false, true, "E39", "FFFF"),
		NEWTON_GRAPHIC_6_0_RED_NFC(Category.IMAGE, "48", 600, 448, 3, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 132, false, true, "B89", "FFFF"),
		NEWTON_GRAPHIC_6_0_RED_NFC_NEW(Category.IMAGE, "50", 648, 480, 3, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 0, 138, false, true, "E09", "FFFF"),
		NEWTON_GRAPHIC_7_5_RED_NFC_HR(Category.IMAGE, "4C", 480, 800, 3, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 126, false, true, "BC9", "FFFF"),
		NEWTON_GRAPHIC_7_5_RED_NFC_HD(Category.IMAGE, "49", 528, 880, 3, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 137, false, true, "B99", "FFFF"),
		NEWTON_GRAPHIC_9_7_RED_NFC_HD(Category.IMAGE, "64", 672, 960, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 121, false, true, "E49", "FFFF"),
		NEWTON_GRAPHIC_11_6_RED_NFC(Category.IMAGE, "4A", 640, 960, 3, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 100, false, true, "BA9", "FFFF"),
		NEWTON_GRAPHIC_12_2_RED_NFC(Category.IMAGE, "65", 768, 960, 7, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 103, false, true, "E59", "FFFF"),
		NEWTON_GRAPHIC_13_3_RED_NFC(Category.IMAGE, "4B", 1200, 1600, 3, ClassType.N_SYSTEM, ColorType.TERNARY_RED,
				CompressionType.DEFLATE, 270, 150, false, true, "BB9", "FFFF"),

		// YELLOW, N-System
		NEWTON_GRAPHIC_0_97_YEL_LITE(Category.IMAGE, "6C", 184, 88, 3, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 210, false, false, "F6C", "FFFF"),
		NEWTON_GRAPHIC_0_97_YEL(Category.IMAGE, "6C", 184, 88, 3, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 210, false, false, "F6B", "FFFF"),
		NEWTON_GRAPHIC_1_3_YEL_PEGHOOK_LITE(Category.IMAGE, "4D", 144, 200, 7, ClassType.N_SYSTEM,
				ColorType.TERNARY_YELLOW, CompressionType.DEFLATE, 180, 189, false, false, "CDC", "FFFF"),
		NEWTON_GRAPHIC_1_3_YEL_PEGHOOK(Category.IMAGE, "4D", 144, 200, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 180, 189, false, false, "CDB", "FFFF"),
		NEWTON_GRAPHIC_1_6_YEL(Category.IMAGE, "40", 200, 200, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 188, false, true, "C0D", "FFFF"),
		NEWTON_GRAPHIC_2_2_YEL_LITE(Category.IMAGE, "51", 250, 122, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 130, false, true, "F1D", "FFFF"),
		NEWTON_GRAPHIC_2_2_YEL(Category.IMAGE, "41", 296, 160, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 156, false, true, "C1D", "FFFF"),
		NEWTON_GRAPHIC_2_6_YEL(Category.IMAGE, "43", 360, 184, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 152, false, true, "C3D", "FFFF"),
		NEWTON_GRAPHIC_2_7_YEL(Category.IMAGE, "44", 300, 200, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 133, false, true, "C4D", "FFFF"),
		NEWTON_GRAPHIC_2_9_YEL(Category.IMAGE, "42", 384, 168, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 144, false, true, "C2D", "FFFF"),
		NEWTON_GRAPHIC_2_9_YEL_TAPGO_LITE(Category.IMAGE, "4E", 384, 168, 7, ClassType.N_SYSTEM,
				ColorType.TERNARY_YELLOW, CompressionType.DEFLATE, 270, 144, false, false, "CEC", "FFFF"),
		NEWTON_GRAPHIC_2_9_YEL_TAPGO(Category.IMAGE, "4E", 384, 168, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 144, false, false, "CEB", "FFFF"),
		NEWTON_GRAPHIC_3_52_YEL_LITE(Category.IMAGE, "62", 384, 180, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 120, false, false, "F2C", "FFFF"),
		NEWTON_GRAPHIC_3_52_YEL(Category.IMAGE, "62", 384, 180, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 120, false, false, "F2B", "FFFF"),
		NEWTON_GRAPHIC_3_7_YEL(Category.IMAGE, "45", 240, 416, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 129, false, true, "C5D", "FFFF"),
		NEWTON_GRAPHIC_4_2_YEL(Category.IMAGE, "46", 400, 300, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 120, false, true, "C6D", "FFFF"),
		NEWTON_GRAPHIC_4_3_YEL(Category.IMAGE, "47", 522, 152, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 125, false, true, "C7D", "FFFF"),
		NEWTON_GRAPHIC_4_3_YEL_TAPGO_LITE(Category.IMAGE, "4F", 152, 522, 7, ClassType.N_SYSTEM,
				ColorType.TERNARY_YELLOW, CompressionType.DEFLATE, 0, 125, false, false, "CFC", "FFFF"),
		NEWTON_GRAPHIC_4_3_YEL_TAPGO(Category.IMAGE, "4F", 152, 522, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 125, false, false, "CFB", "FFFF"),
		NEWTON_GRAPHIC_5_85_YEL(Category.IMAGE, "63", 792, 272, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 145, false, true, "F3D", "FFFF"),
		NEWTON_GRAPHIC_6_0_YEL(Category.IMAGE, "48", 600, 448, 3, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 132, false, true, "C8D", "FFFF"),
		NEWTON_GRAPHIC_6_0_YEL_NEW(Category.IMAGE, "50", 648, 480, 3, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 138, false, true, "F0D", "FFFF"),
		NEWTON_GRAPHIC_7_5_YEL_HR(Category.IMAGE, "4C", 480, 800, 3, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 126, false, true, "CCD", "FFFF"),
		NEWTON_GRAPHIC_7_5_YEL_HD(Category.IMAGE, "49", 528, 880, 3, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 137, false, true, "C9D", "FFFF"),
		NEWTON_GRAPHIC_9_7_YEL(Category.IMAGE, "64", 672, 960, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 121, false, true, "F4D", "FFFF"),
		NEWTON_GRAPHIC_11_6_YEL(Category.IMAGE, "4A", 640, 960, 3, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 100, false, true, "CAD", "FFFF"),
		NEWTON_DUAL_GRAPHIC_11_6_YEL_LITE(Category.IMAGE, "72", 640, 960, 2, ClassType.N_SYSTEM,
				ColorType.TERNARY_YELLOW, CompressionType.DEFLATE, 270, 100, false, false, "F8C", "FFFF"),
		NEWTON_DUAL_GRAPHIC_11_6_YEL(Category.IMAGE, "72", 640, 960, 2, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 100, false, false, "F8B", "FFFF"),
		NEWTON_GRAPHIC_12_2_YEL(Category.IMAGE, "65", 768, 960, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 103, false, true, "F5D", "FFFF"),
		NEWTON_GRAPHIC_13_3_YEL(Category.IMAGE, "4B", 1200, 1600, 3, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 150, false, true, "CBD", "FFFF"),

		// YELLOW + NFC, N-System
		NEWTON_GRAPHIC_1_6_YEL_NFC(Category.IMAGE, "40", 200, 200, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 188, false, true, "C09", "FFFF"),
		NEWTON_GRAPHIC_2_2_YEL_NFC_LITE(Category.IMAGE, "51", 250, 122, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 130, false, true, "F19", "FFFF"),
		NEWTON_GRAPHIC_2_2_YEL_NFC(Category.IMAGE, "41", 296, 160, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 156, false, true, "C19", "FFFF"),
		NEWTON_X_GRAPHIC_2_2_YEL_NFC_LITE(Category.IMAGE, "6E", 296, 160, 7, ClassType.N_SYSTEM,
				ColorType.TERNARY_YELLOW, CompressionType.DEFLATE, 270, 156, false, true, "20D", "FFFF"),
		NEWTON_X_GRAPHIC_2_2_YEL_NFC(Category.IMAGE, "6E", 296, 160, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 156, false, true, "209", "FFFF"),
		NEWTON_GRAPHIC_2_6_YEL_NFC(Category.IMAGE, "43", 360, 184, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 152, false, true, "C39", "FFFF"),
		NEWTON_GRAPHIC_2_7_YEL_NFC(Category.IMAGE, "44", 300, 200, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 133, false, true, "C49", "FFFF"),
		NEWTON_GRAPHIC_2_9_YEL_NFC(Category.IMAGE, "42", 384, 168, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 144, false, true, "C29", "FFFF"),
		NEWTON_GRAPHIC_3_52_YEL_NFC_LITE(Category.IMAGE, "62", 384, 180, 7, ClassType.N_SYSTEM,
				ColorType.TERNARY_YELLOW, CompressionType.DEFLATE, 270, 120, false, true, "F2D", "FFFF"),
		NEWTON_GRAPHIC_3_52_YEL_NFC(Category.IMAGE, "62", 384, 180, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 120, false, true, "F29", "FFFF"),
		NEWTON_GRAPHIC_3_7_YEL_NFC(Category.IMAGE, "45", 240, 416, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 129, false, true, "C59", "FFFF"),
		NEWTON_GRAPHIC_4_2_YEL_NFC(Category.IMAGE, "46", 400, 300, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 120, false, true, "C69", "FFFF"),
		NEWTON_GRAPHIC_4_3_YEL_NFC(Category.IMAGE, "47", 522, 152, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 125, false, true, "C79", "FFFF"),
		NEWTON_GRAPHIC_4_3_YEL_NFC_LITE_3BTN(Category.IMAGE, "70", 522, 152, 7, ClassType.N_SYSTEM,
				ColorType.TERNARY_YELLOW, CompressionType.DEFLATE, 270, 125, false, true, "F7D", "FFFF"),
		NEWTON_GRAPHIC_4_3_YEL_NFC_3BTN(Category.IMAGE, "70", 522, 152, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 125, false, true, "F79", "FFFF"),
		NEWTON_GRAPHIC_5_85_YEL_NFC(Category.IMAGE, "63", 792, 272, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 145, false, true, "F39", "FFFF"),
		NEWTON_GRAPHIC_6_0_YEL_NFC(Category.IMAGE, "48", 600, 448, 3, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 132, false, true, "C89", "FFFF"),
		NEWTON_GRAPHIC_6_0_YEL_NFC_NEW(Category.IMAGE, "50", 648, 480, 3, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 0, 138, false, true, "F09", "FFFF"),
		NEWTON_GRAPHIC_7_5_YEL_NFC_HR(Category.IMAGE, "4C", 480, 800, 3, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 126, false, true, "CC9", "FFFF"),
		NEWTON_GRAPHIC_7_5_YEL_NFC_HD(Category.IMAGE, "49", 528, 880, 3, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 137, false, true, "C99", "FFFF"),
		NEWTON_GRAPHIC_9_7_YEL_NFC(Category.IMAGE, "64", 672, 960, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 121, false, true, "F49", "FFFF"),
		NEWTON_GRAPHIC_11_6_YEL_NFC(Category.IMAGE, "4A", 640, 960, 3, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 100, false, true, "CA9", "FFFF"),
		NEWTON_GRAPHIC_12_2_YEL_NFC(Category.IMAGE, "65", 768, 960, 7, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 103, false, true, "F59", "FFFF"),
		NEWTON_GRAPHIC_13_3_YEL_NFC(Category.IMAGE, "4B", 1200, 1600, 3, ClassType.N_SYSTEM, ColorType.TERNARY_YELLOW,
				CompressionType.DEFLATE, 270, 150, false, true, "CB9", "FFFF"),

		// 4 Color, N-System
		NEWTON_DUAL_GRAPHIC_8_2_BIT2_4C_LITE(Category.IMAGE, "71", 576, 1024, 2, ClassType.N_SYSTEM, ColorType.BIT2_4C,
				CompressionType.DEFLATE, 270, 144, false, false, "99C", "FFFF"),
		NEWTON_DUAL_GRAPHIC_8_2_BIT2_4C(Category.IMAGE, "71", 576, 1024, 2, ClassType.N_SYSTEM, ColorType.BIT2_4C,
				CompressionType.DEFLATE, 270, 144, false, false, "99B", "FFFF"),

		// 4 Color + NFC, N-System
		NEWTON_GRAPHIC_1_6_BIT2_4C_NFC_LITE(Category.IMAGE, "66", 168, 168, 7, ClassType.N_SYSTEM, ColorType.BIT2_4C,
				CompressionType.DEFLATE, 0, 144, false, true, "92D", "FFFF"),
		NEWTON_GRAPHIC_1_6_BIT2_4C_NFC(Category.IMAGE, "66", 168, 168, 7, ClassType.N_SYSTEM, ColorType.BIT2_4C,
				CompressionType.DEFLATE, 0, 144, false, true, "929", "FFFF"),
		NEWTON_GRAPHIC_2_4_BIT2_4C_NFC_LITE(Category.IMAGE, "67", 296, 168, 7, ClassType.N_SYSTEM, ColorType.BIT2_4C,
				CompressionType.DEFLATE, 270, 144, false, true, "93D", "FFFF"),
		NEWTON_GRAPHIC_2_4_BIT2_4C_NFC(Category.IMAGE, "67", 296, 168, 7, ClassType.N_SYSTEM, ColorType.BIT2_4C,
				CompressionType.DEFLATE, 270, 144, false, true, "939", "FFFF"),
		NEWTON_GRAPHIC_3_0_BIT2_4C_NFC_LITE(Category.IMAGE, "68", 400, 168, 7, ClassType.N_SYSTEM, ColorType.BIT2_4C,
				CompressionType.DEFLATE, 270, 144, false, true, "94D", "FFFF"),
		NEWTON_GRAPHIC_3_0_BIT2_4C_NFC(Category.IMAGE, "68", 400, 168, 7, ClassType.N_SYSTEM, ColorType.BIT2_4C,
				CompressionType.DEFLATE, 270, 144, false, true, "949", "FFFF"),
		NEWTON_GRAPHIC_4_4_BIT2_4C_NFC_LITE(Category.IMAGE, "69", 512, 368, 3, ClassType.N_SYSTEM, ColorType.BIT2_4C,
				CompressionType.DEFLATE, 0, 144, false, true, "95D", "FFFF"),
		NEWTON_GRAPHIC_4_4_BIT2_4C_NFC(Category.IMAGE, "69", 512, 368, 3, ClassType.N_SYSTEM, ColorType.BIT2_4C,
				CompressionType.DEFLATE, 0, 144, false, true, "959", "FFFF"),
		NEWTON_GRAPHIC_6_0_BIT2_4C_NFC_LITE(Category.IMAGE, "6F", 600, 448, 3, ClassType.N_SYSTEM, ColorType.BIT2_4C,
				CompressionType.DEFLATE, 0, 132, false, true, "98D", "FFFF"),
		NEWTON_GRAPHIC_6_0_BIT2_4C_NFC(Category.IMAGE, "6F", 600, 448, 3, ClassType.N_SYSTEM, ColorType.BIT2_4C,
				CompressionType.DEFLATE, 0, 132, false, true, "989", "FFFF"),
		NEWTON_GRAPHIC_7_3_BIT2_4C_NFC_LITE(Category.IMAGE, "6B", 480, 800, 3, ClassType.N_SYSTEM, ColorType.BIT2_4C,
				CompressionType.DEFLATE, 270, 144, false, true, "97D", "FFFF"),
		NEWTON_GRAPHIC_7_3_BIT2_4C_NFC(Category.IMAGE, "6B", 480, 800, 3, ClassType.N_SYSTEM, ColorType.BIT2_4C,
				CompressionType.DEFLATE, 270, 144, false, true, "979", "FFFF"),
		NEWTON_GRAPHIC_8_2_BIT2_4C_NFC_LITE(Category.IMAGE, "6A", 576, 1024, 3, ClassType.N_SYSTEM, ColorType.BIT2_4C,
				CompressionType.DEFLATE, 270, 144, false, true, "96D", "FFFF"),
		NEWTON_GRAPHIC_8_2_BIT2_4C_NFC(Category.IMAGE, "6A", 576, 1024, 3, ClassType.N_SYSTEM, ColorType.BIT2_4C,
				CompressionType.DEFLATE, 270, 144, false, true, "969", "FFFF"),

		// 7 Color, N-System
		NEWTON_GRAPHIC_6_0_BIT4_7C_LITE(Category.IMAGE, "61", 600, 448, 7, ClassType.N_SYSTEM, ColorType.BIT4_7C,
				CompressionType.DEFLATE, 0, 132, false, false, "91C", "FFFF"),
		NEWTON_GRAPHIC_6_0_BIT4_7C(Category.IMAGE, "61", 600, 448, 7, ClassType.N_SYSTEM, ColorType.BIT4_7C,
				CompressionType.DEFLATE, 0, 132, false, false, "91B", "FFFF"),

		// 7 Color + NFC, N-System
		NEWTON_GRAPHIC_6_0_BIT4_7C_NFC_LITE(Category.IMAGE, "61", 600, 448, 7, ClassType.N_SYSTEM, ColorType.BIT4_7C,
				CompressionType.DEFLATE, 0, 132, false, true, "91D", "FFFF"),
		NEWTON_GRAPHIC_6_0_BIT4_7C_NFC(Category.IMAGE, "61", 600, 448, 7, ClassType.N_SYSTEM, ColorType.BIT4_7C,
				CompressionType.DEFLATE, 0, 132, false, true, "919", "FFFF");

		private Category category;
		private String hexValue;
		private int displayWidth;
		private int displayHeight;
		private int totalPage;
		private ClassType classType;
		private ColorType colorType;
		private CompressionType compressionType;
		private int rotation;
		private int resolution;
		private boolean isFlip;
		private boolean isNfc;
		private String[] typeCode;

		EndDeviceType(Category category, String hexValue, int dispayWidth, int displayHeight, int totalPage,
				ClassType classType, ColorType colorType, CompressionType compressionType, int rotation, int resolution,
				boolean isFlip, boolean isNfc, String... typeCode) {
			this.category = category;
			this.hexValue = hexValue;
			this.displayWidth = dispayWidth;
			this.displayHeight = displayHeight;
			this.totalPage = totalPage;
			this.classType = classType;
			this.colorType = colorType;
			this.compressionType = compressionType;
			this.rotation = rotation;
			this.resolution = resolution;
			this.isFlip = isFlip;
			this.isNfc = isNfc;
			this.typeCode = typeCode;
		}

		public enum Category {
			SEGMENT(1), IMAGE(3), MULTI_SEGMENT(4);

			@Getter
			private int value;

			Category(int value) {
				this.value = value;
			}
		}

		public enum ColorType {
			NONE, BINARY, TERNARY, TERNARY_RED, TERNARY_GREEN, TERNARY_BLUE, TERNARY_YELLOW, BIT2_4C, BIT4_7C
		}

		public enum ClassType {
			SEMCO(0), MARVELL(1), TI(2), TI_FREEZER(3), N_SYSTEM(5);

			@Getter
			private int value;

			ClassType(int value) {
				this.value = value;
			}
		}

		public enum DriverType {
			SSD1606, SSD1607, UC8154, UC8157, UC8151, UC8159, UC8176, IT8951, PDI2P7, PDI7P4
		}

		@Getter
		public enum CodeDigit {
			TWELVE(12, 0), FOURTEEN(14, 0), SIXTEEN(16, 1), SEVENTEEN(17, 0), EIGHTEEN(18, 1);

			private final int value;
			private final int index;

			CodeDigit(int value, int index) {
				this.value = value;
				this.index = index;
			}

			public static CodeDigit valueOf(int intValue) {
				return Arrays.stream(values()).filter(codeDigit -> codeDigit.value == intValue).findAny().orElse(null);
			}
		}
	}

	public enum UpdateStatus {
		JSON_ARRAYSIZE_MISMATCH(-14), NONE(-2), FAIL(-1), ACTIVATION_FAIL_0(0), // Activation Fail(Data on DB)
		SUCCESS(1), ACTIVATION_SUCCESS_2(2), // Activation Success(Data on DB)
		RESULT_3(3), RESULT_4(4), ACTIVATION_SUCCESS_5(5), ACTIVATION_FAIL_6(6), ACTIVATION_SUCCESS_7(7),
		BUTTON_REPORT(8), ALIVE_REPORT(9), RESULT_10(10),
		// Error Code From Gateway
		PACKET_TX_SUCCESS(11), // GWAY_WAIT_FOR_F4(Image packet tx done)
		PACKET_TX_FAIL(12), // GWAY_MCPS_CFM (Image packet tx fail)
		RESULT_13(13), // GWAY_PARAM_ERROR(Page info error in DB)
		RESULT_14(14), // GWAY_FRAG_TX_ERROR(Not used)
		RESULT_15(15), // GWAY_WAIT_TAG_REBOOT(OTA packet tx done)
		RESULT_16(16), // GWAY_DB_FILE_ERROR(sgate.db read error)
		RESULT_17(17), // GWAY_WAIT_FOR_F9(Multi-7seg packet tx done)
		ENDDEVICE_TIMEOUT(18), RESULT_19(19), RESULT_20(20),
		// Error Code From EndDevice
		PARTIAL_PACKET_FAIL(21), RESULT_22(22), // SEQ_NO_MISMATCH_FAIL
		RESULT_23(23), // PARSING_FAIL
		INVALID_PAGE_COUNT(24), INVALID_CRC(25), RESULT_26(26), // INSUFFICENT_IMAGE_SIZE_FAIL
		EPD_DISP_FAIL(27), RESULT_28(28), // UPDATE_FRONT_PAGE_FAIL
		PACKET_SIZE_OVERFLOW(29), HDR_FAIL(30), RESULT_31(31), // PAGE_CNT_MISMATCH_FAIL
		RESULT_32(32), // FLASH_PAGE_RESTORE_FAIL
		RESULT_33(33), // FPIDX_MORETHAN_PAGE_CNT_FAIL
		RESULT_34(34), // COMP_TYPE_NOT_SUPPORTED_FAIL
		RESULT_35(35), // FP_NOT_MATCH_WITH_PAGE_NO_FAIL
		DECOMPRESSION_FAIL(36), RESULT_37(37), // FLASH_DISPBUF_RESTORE_FAIL
		RESULT_38(38), // PARTIAL_IMG_UPDATE_FAIL
		NFC_WRITE_FAIL(39), INVALID_IMG_SIZE(40), RESULT_41(41), // SAVE_FULL_PAGE_TO_FLASH_FAIL
		RESULT_42(42), // STS_F4_FAIL
		RESULT_43(43), // INVALID_IMAGE_DIMENSION
		RESULT_44(44), // INVALID_STX_STY_WIDTH_HEIGHT
		INVALID_BITS_DEPTH(45), INVALID_LABEL_TYPE(46), RESULT_47(47), // NO_PKTS
		RESULT_48(48), // COMPSIZE_MORE_THAN_4K
		RESULT_49(49), // DECOMP_IMAGE_NOT_SUPPORTED_FAIL
		RESULT_50(50), // UD_FLASH_OK_FRONT_PAGE_FAIL
		RESULT_51(51), // BEEPER_PAGE_0
		EPD_PANEL_CRACK(52), RESULT_53(53), // NON_NFC_DATA
		RESULT_54(54), RESULT_55(55);

		@Getter
		private final int value;

		UpdateStatus(final int value) {
			this.value = value;
		}

		public static UpdateStatus parseInt(int intValue) {
			return Arrays.stream(values()).filter(updateStatus -> updateStatus.value == intValue).findAny()
					.orElse(UpdateStatus.NONE);
		}
	}

	@Getter
	public enum UnassignMode {
		NORMAL(0), DORMANT(4);

		private int value;

		UnassignMode(int value) {
			this.value = value;
		}
	}
}