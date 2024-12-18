package com.solum.aims.msp.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties(BatchProperties.PREFIX)
@Getter @Setter
public class BatchProperties extends AimsMetroMspProperties {
	public static final String TYPE = "batch";
	public static final String PREFIX = AimsMetroMspProperties.PREFIX + "." + TYPE;

	private boolean isEmbedded = true;
	private ProcessorJob processorJob = new ProcessorJob();
	private InboundLinkerJob inboundLinkerJob = new InboundLinkerJob();
	private OutboundLinkerJob outboundLinkerJob = new OutboundLinkerJob();
	private Skip skip = new Skip();

	@Getter @Setter
	public static class ProcessorJob {
		private float threadPoolScaleFactor = 1;
		private int maxMessagesPerPoll=10;
		private int commitInterval = Math.max(1, Runtime.getRuntime().availableProcessors() - 1);
		private boolean useStationParam = true;
	}

	@Getter @Setter
	public static class InboundLinkerJob {
		private float threadPoolScaleFactor = 1;
		private int fixedDelay=1000;
		private int maxMessagesPerPoll=100;
	}

	@Getter @Setter
	public static class OutboundLinkerJob {
		private float threadPoolScaleFactor = 1;
		private int fixedDelay=1000;
		private int maxMessagesPerPoll=20;
		private DataSize maxContractSize;
		private int maxContractCount;
	}

	@Getter @Setter
	public static class Skip {
		private int limit = 2147483647;
		private List<String> exceptions = new ArrayList<>();
	}
}
