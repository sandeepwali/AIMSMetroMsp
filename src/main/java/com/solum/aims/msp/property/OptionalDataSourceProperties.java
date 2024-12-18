package com.solum.aims.msp.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter @Setter
@ConfigurationProperties(OptionalDataSourceProperties.PREFIX)
public class OptionalDataSourceProperties {
	
	public static final String PREFIX = "database";

	// common database properties in aims.properties file.
	private String ip;
	private String port;
	private String username;
	private String password;
	private String platform;

	// Each service optionally has its own database properties.
	// It has a higher priority than the default properties.
	private DbConfig core = new DbConfig();
//	private DbConfig portal = new DbConfig();

	@Getter @Setter
    public static class DbConfig {
       private String ip = "";
	   private String port = "";
	   private String username = "";
	   private String password = "";
	   private String name = "";
    }
}
