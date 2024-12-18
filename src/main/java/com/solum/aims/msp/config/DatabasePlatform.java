package com.solum.aims.msp.config;

import lombok.Getter;

@Getter
public enum DatabasePlatform {
	ORACLE("oracle.jdbc.driver.OracleDriver", 1521, "jdbc:oracle:thin:@//%s:%s/%s", "select 1 from dual"),
	POSTGRESQL("org.postgresql.Driver", 5432, "jdbc:postgresql://%s:%s/%s?rewriteBatchedInserts=true", "SELECT 1"),
	SQLSERVER("com.microsoft.sqlserver.jdbc.SQLServerDriver", 1433, "jdbc:sqlserver://%s:%s;DatabaseName=%s;sendStringParametersAsUnicode=false", "SELECT 1");

	private String driverClassName;
	private int port;
	private String dataSourceUrl;
	private String validationQuery;

	DatabasePlatform(String driverClassName, int port, String dataSourceUrl, String validationQuery) {
		this.driverClassName = driverClassName;
		this.port = port;
		this.dataSourceUrl = dataSourceUrl;
		this.validationQuery = validationQuery;
	}

	public static DatabasePlatform getFromDialect(String dialect) {
		String upperCasedDialect = dialect.toUpperCase();

		if (upperCasedDialect.contains(DatabasePlatform.ORACLE.toString())) {
			return DatabasePlatform.ORACLE;
		} else if (upperCasedDialect.contains(DatabasePlatform.POSTGRESQL.toString())) {
			return DatabasePlatform.POSTGRESQL;
		} else if (upperCasedDialect.contains(DatabasePlatform.SQLSERVER.toString())) {
			return DatabasePlatform.SQLSERVER;
		}

		return null;
	}
}