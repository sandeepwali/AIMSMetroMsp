package com.solum.aims.msp.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(IntegrationProperties.PREFIX)
@Setter @Getter
public class IntegrationProperties extends AimsMetroMspProperties {
	public static final String TYPE = "integration";
	public static final String PREFIX = AimsMetroMspProperties.PREFIX + "." + TYPE;

	private QueueChannel queueChannel = new QueueChannel();
	private Aggregator aggregator = new Aggregator();
	private File file = new File();

	@Getter @Setter
	public static class QueueChannel {
		private boolean messageStore = false;
		private InboundLinkerJob inboundLinkerJob = new InboundLinkerJob();
		private OutboundLinkerJob outboundLinkerJob = new OutboundLinkerJob();

		@Getter @Setter
		public static class InboundLinkerJob {
			private boolean deduplicate;
			private boolean logging = false;
		}

		@Getter @Setter
		public static class OutboundLinkerJob {
			private boolean deduplicate = true;
			private boolean logging = false;
		}
	}

	@Getter @Setter
	public static class Aggregator {
		private int fixedDelay = 1000;
		private int maxMessagesPerPoll = 100;
	}

	@Getter @Setter
	public static class File {
		private Input input = new Input();
		private Backup backup = new Backup();
		private Skip skip = new Skip();

		@Getter @Setter
		public static class Input {
			public static final String EXTENSION = "m1";

			private java.io.File path;
			private int age = 2;
			private int queueSize = 30;
			private int recoverCount = 5;
		}

		@Getter @Setter
		public static class Backup {
			private boolean enable = false;
			private java.io.File path;
		}

		@Getter @Setter
		public static class Skip {
			private boolean enable = false;
		}
	}
}
