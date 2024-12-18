package com.solum.aims.msp.config;

import com.solum.aims.msp.infrastructure.AimsJobLauncher;
import com.solum.aims.msp.infrastructure.batch.MessageEndPointChain;
import com.solum.aims.msp.infrastructure.batch.activator.OutboundAimsJobMessageEndPointChain;
import com.solum.aims.msp.infrastructure.batch.activator.OutboundMspJobMessageEndPointChain;
import com.solum.aims.msp.infrastructure.batch.activator.ProcessingM1MessageEndPointChain;
import com.solum.aims.msp.property.IntegrationProperties;
import org.springframework.batch.core.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.filters.ChainFileListFilter;
import org.springframework.integration.file.filters.LastModifiedFileListFilter;
import org.springframework.integration.file.filters.SimplePatternFileListFilter;
import org.springframework.messaging.MessageChannel;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.io.File;
import java.util.Arrays;

@Configuration
@EnableIntegration
public class IntegrationConfig {

	@Autowired
	private IntegrationProperties properties;
	
	/*
	 * Defined Message channels.
	 *  - processingM1FileFilterChannel.
	 *  - processingM1Channel
	 *  - sendingProductImageChannel
	 *  - sendingUnlinkChannel
	 *  - requestProductImageChannel
	 *  - requestReleaseImageChannel
	 */
	@Bean
	public MessageChannel processingM1FileFilterChannel() {
		return new DirectChannel();
	}
	
	@Bean
	public MessageChannel processingM1Channel() {
		return new DirectChannel();
	}
	
	@Bean
	public MessageChannel sendingProductImageChannel() {
		return new DirectChannel();
	}
	
	@Bean
	public MessageChannel sendingUnlinkChannel() {
		return new DirectChannel();
	}
	
	@Bean
	public MessageChannel requestProductImageChannel() {
		return new DirectChannel();
	}
	
	@Bean
	public MessageChannel requestReleaseImageChannel() {
		return new DirectChannel();
	}
	
	/*
	 * Defined Channel Adapters
	 *  - ProcessingM1FileChannelAdapter.
	 *  
	 */
	@Bean
	public TaskExecutor m1FilePollerTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(1);
		return executor;
	}
	
	@Bean
	@InboundChannelAdapter(channel = "processingM1FileFilterChannel",
			poller = @Poller(taskExecutor="m1FilePollerTaskExecutor",
							maxMessagesPerPoll="10"))
	public MessageSource<File> processingM1FileChannelAdapter() {
		FileReadingMessageSource messageSource = new FileReadingMessageSource(properties.getFile().getInput().getQueueSize());
		messageSource.setDirectory(properties.getFile().getInput().getPath());
		messageSource.setAutoCreateDirectory(true);
		messageSource.setUseWatchService(true);
		messageSource.setFilter(chainFileListFilter());
		return messageSource;
	}
	
	private ChainFileListFilter<File> chainFileListFilter() {
		ChainFileListFilter<File> chainFileListFilter = new ChainFileListFilter<>();
		chainFileListFilter.addFilters(Arrays.asList(new SimplePatternFileListFilter("*." + "m1"),
													new LastModifiedFileListFilter(properties.getFile().getInput().getAge())));
		return chainFileListFilter;
	}
	
	/*
	 * Message Endpoints
	 *  - processingM1MessageEndPointChain
	 *  - outboundAimsMessageEndPointChain
	 *  - outboundMspMessageEndPointChain
	 */
	@Bean
	public MessageEndPointChain processingM1MessageEndPointChain(@Value("#{processingM1JobLauncher}") AimsJobLauncher jobLauncher,
			 													 @Value("#{processingM1Job}") Job job) {
		ProcessingM1MessageEndPointChain messageEndpointChain = new ProcessingM1MessageEndPointChain();
		messageEndpointChain.setJobLauncher(jobLauncher);
		messageEndpointChain.setJob(job);
		return messageEndpointChain;
	}
	
	@Bean
	public MessageEndPointChain outboundAimsMessageEndPointChain(@Value("#{outboundAimsJobLauncher}") AimsJobLauncher jobLauncher,
			 													 @Value("#{outboundAimsJob}") Job job) {
		OutboundAimsJobMessageEndPointChain messageEndpointChain = new OutboundAimsJobMessageEndPointChain();
		messageEndpointChain.setJobLauncher(jobLauncher);
		messageEndpointChain.setJob(job);
		return messageEndpointChain;
	}
	
	@Bean
	public MessageEndPointChain outboundMspMessageEndPointChain(@Value("#{outboundMspJobLauncher}") AimsJobLauncher jobLauncher,
			 													 @Value("#{outboundMspJob}") Job job) {
		OutboundMspJobMessageEndPointChain messageEndpointChain = new OutboundMspJobMessageEndPointChain();
		messageEndpointChain.setJobLauncher(jobLauncher);
		messageEndpointChain.setJob(job);
		return messageEndpointChain;
	}
}
