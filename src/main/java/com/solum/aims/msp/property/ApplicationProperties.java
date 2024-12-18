package com.solum.aims.msp.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter @Getter
@Component
@ConfigurationProperties(ApplicationProperties.PREFIX)
public class ApplicationProperties  extends  AimsMetroMspProperties{

	public static final String PREFIX = AimsMetroMspProperties.PREFIX;

	private String mmsPath;

	private ConnectionInfo connectionAims = new ConnectionInfo();
	private ConnectionInfo connectionMsp = new ConnectionInfo();

	private String backupPath;
	private String prRoot;

	private String countryCodeDefault;
	private String storeNumberDefault;
	private String salesLineDefault;

	@Setter @Getter
	public static class ConnectionInfo {
		private String schema = "http";
		private String hostName;
		private String port;
		private String path;
	}
	
	

	private boolean mspUse = true;
}
