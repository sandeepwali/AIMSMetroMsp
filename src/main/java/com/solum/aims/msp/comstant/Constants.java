package com.solum.aims.msp.comstant;

public class Constants {
	public static final String NEW_LINE = System.getProperty("line.separator");
	public static final String UNDERSCORE = "_";
	public static final String SEMICOLON = ";";
	public static final String COLON = ".";
	public static final String COMMA = ",";
	public static final String SLASH = "/";
	public static final String PIPELINE = "|";
	public static final String SPACE = " ";
	public static final String EMPTYSPACE = "";
	public static final String EQUAL = "=";
	public static final String DOUBLE_QUAT = "\"";
	public static final String SINGLE_QUAT = "\'";

	public static final String DEFAULT_STATION_CODE = "DEFAULT_STATION_CODE";

	public static final String KRSFN = "license/rings";
	public static final String KRPFN = "license/ringp";
	public static final String KID = "solum";
	public static final String KPP = "solum1!";

	public static final String XSDFILE = "configuration/customer/standard-article-xml-schema.xsd";

	/*
	 * Http Response Code
	 */
	public static final String OK = "200";
	public static final String NO_CONTENTS = "200";
	public static final String IM_USED = "226";
	public static final String BAD_REQUEST = "400";
	public static final String UNAUTHORIZED = "401";
	public static final String PAYMENT_REQUIRED = "402";
	public static final String NOT_FOUND = "404";
	public static final String METHOD_NOT_ALLOWED = "405";
	public static final String NOT_ACCEPTABLE = "406";
	public static final String CONFLICT = "409";
	public static final String LOCKED = "423";
	public static final String EXISTING_SESSION = "444";
	public static final String INTERNAL_SERVER_ERROR = "500";

	public class TablePrefix {
		public static final String PORTAL = "AP_";
		public static final String CUSTOM = "CT_";
	}

	/**
	 * Interface result code
	 */
	public static class InterfaceResponseCode {
		public static final String SUCCESS = "00";
		public static final String JSON_FORMAT_ERROR = "10";
		public static final String PARAMETER_NOT_FOUND = "11";
		public static final String INCORRECT_PARAMETER_VALUE = "12";
		public static final String UNKNOWN_ERROR = "FF";

		public static class PDA {
			/**
			 * Product result code
			 */
			public static class Product {
				public static final String PRODUCT_NOT_FOUND = "01";
			}

			/**
			 * Single assign result code
			 */
			public static class Assign {
				/**
				 * assigned already
				 */
				public static final String ASSIGNED = "01";
				/**
				 * result code of incorrect layout id or layout is '0' with not found default
				 * layout)
				 */
				public static final String NOT_FOUND_LAYOUT_INFO = "02";
				/**
				 * one to many assign or 7 segment assign result code
				 */
				public static final String INVALID_TAG_TYPE = "03";
				public static final String DATA_NOT_FOUND = "04";
				public static final String INVALID_DATA = "05";
			}

			/**
			 * multiple assign result code
			 */
			public static class MultiAssign {
				/**
				 * assigned already
				 */
				public static final String ASSIGNED = "01";
				/**
				 * result code of incorrect layout id or layout is '0' with not found default
				 * layout)
				 */
				public static final String NOT_FOUND_LAYOUT_INFO = "02";
			}

			/**
			 * when find layout list
			 */
			public static class LayoutList {
				public static final String DATA_NOT_FOUND = "01";
			}

			/**
			 * when find layout
			 */
			public static class Layout {
				public static final String DATA_NOT_FOUND = "01";
			}

			/**
			 * find tag
			 */
			public static class Tag {
				public static final String DATA_NOT_FOUND = "01";
			}

			/**
			 * find tag location
			 */
			public static class TagLocation {
				public static final String DATA_NOT_FOUND = "01";
			}

			/**
			 * find island tag list
			 */
			public static class IslandTagList {
				public static final String DATA_NOT_FOUND = "01";
			}

			/**
			 * find island product list
			 */
			public static class IslandProductList {
				public static final String DATA_NOT_FOUND = "01";
			}

			/**
			 * un-assign base tag
			 */
			public static class UnassignTag {
				/**
				 * not found tag
				 */
				public static final String DATA_NOT_FOUND = "01";
				public static final String NOT_ASSIGNED_TAG = "02";
				public static final String IN_PROGRESS_UNASSIGN = "03";
			}

			/**
			 * un-assign base product
			 */
			public static class UnassignProduct {
				public static final String DATA_NOT_FOUND = "01";
			}

			/**
			 * PDA login
			 */
			public static class Login {
				public static final String ID_NOT_FOUND = "01";
				public static final String INCORRECT_PASSWORD = "02";
			}
		}
	}
}