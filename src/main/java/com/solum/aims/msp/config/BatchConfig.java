package com.solum.aims.msp.config;

import com.solum.aims.msp.infrastructure.BatchDataSource;
import com.solum.aims.msp.infrastructure.BatchDataSourceFactoryBean;
import com.solum.aims.msp.infrastructure.BatchJobListener;
import com.solum.aims.msp.infrastructure.BatchJobRepositoryFactoryBean;
import com.solum.aims.msp.infrastructure.BatchJobRepositoryFactoryBean.TablePrefix;
import com.solum.aims.msp.infrastructure.batch.BatchJobRepositoryUtils;
import com.solum.aims.msp.infrastructure.batch.SimpleAimsJobLauncher;
import com.solum.aims.msp.property.BatchProperties;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
@ImportResource(locations = "classpath:/config/batch/job/*.xml")
public class BatchConfig {

	private static final int logicalThreadCount = Runtime.getRuntime().availableProcessors();

	@Autowired
	private DataSource dataSource;

	@Autowired
	private PlatformTransactionManager transactionManager;

	@Autowired
	private BatchProperties properties;

	@Bean
	public BatchDataSource batchDataSource() throws Exception {
		BatchDataSourceFactoryBean batchDataSourceFactory = new BatchDataSourceFactoryBean(dataSource);
		batchDataSourceFactory.setEmbedded(properties.isEmbedded());
		return batchDataSourceFactory.getObject();
	}

	/*
	 * Processing M1 file Batch - processingM1JobRepository -
	 * processingM1JobTaskExecutor - processingM1JobLauncher -
	 * processingM1JobRepositoryUtils - processingM1JobListener
	 */
	@Bean
	public BatchJobRepositoryFactoryBean processingM1JobRepository() throws Exception {
		BatchJobRepositoryFactoryBean jobRepositoryFactory = new BatchJobRepositoryFactoryBean(batchDataSource());
		jobRepositoryFactory.setTransactionManager(transactionManager);
		jobRepositoryFactory.setTablePrefix(TablePrefix.BATCH_PROCESSING_M1_);
		jobRepositoryFactory.setValidateTransactionState(false);
		return jobRepositoryFactory;
	}

	@Bean
	public TaskExecutor processingM1JobTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//		executor.setCorePoolSize(1);
		executor.setCorePoolSize(Math.max(logicalThreadCount,
				Math.round(logicalThreadCount * properties.getProcessorJob().getThreadPoolScaleFactor())));
		return executor;
	}

	@Bean
	public JobLauncher processingM1JobLauncher() throws Exception {
		SimpleAimsJobLauncher jobLauncher = new SimpleAimsJobLauncher();
		jobLauncher.setJobRepository(processingM1JobRepository().getObject());
		jobLauncher.setTaskExecutor(processingM1JobTaskExecutor());
		return jobLauncher;
	}

	@Bean
	public BatchJobRepositoryUtils processingM1JobRepositoryUtils() throws Exception {
		return new BatchJobRepositoryUtils(processingM1JobRepository());
	}

	@Bean
	@JobScope
	public BatchJobListener processingM1JobListener() throws Exception {
		BatchJobListener jobListener = new BatchJobListener();
		jobListener.setJobRepositoryUtils(processingM1JobRepositoryUtils());
		return jobListener;
	}

	/*
	 * Outbound AIMS Batch - outboundAimsJobRepository - outboundAimsJobTaskExecutor
	 * - outboundAimsJobLauncher - outboundAimsJobRepositoryUtils -
	 * outboundAimsJobListener
	 */
	@Bean
	public BatchJobRepositoryFactoryBean outboundAimsJobRepository() throws Exception {
		BatchJobRepositoryFactoryBean jobRepositoryFactory = new BatchJobRepositoryFactoryBean(batchDataSource());
		jobRepositoryFactory.setTransactionManager(transactionManager);
		jobRepositoryFactory.setTablePrefix(TablePrefix.BATCH_OUTBOUND_AIMS_);
		jobRepositoryFactory.setValidateTransactionState(false);
		return jobRepositoryFactory;
	}

	@Bean
	public TaskExecutor outboundAimsJobTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		int threadCount = Math.max(logicalThreadCount,
				Math.round(logicalThreadCount * properties.getOutboundLinkerJob().getThreadPoolScaleFactor()));
		executor.setCorePoolSize(threadCount);
		return executor;
	}

	@Bean
	public JobLauncher outboundAimsJobLauncher() throws Exception {
		SimpleAimsJobLauncher jobLauncher = new SimpleAimsJobLauncher();
		jobLauncher.setJobRepository(outboundAimsJobRepository().getObject());
		jobLauncher.setTaskExecutor(outboundAimsJobTaskExecutor());
		return jobLauncher;
	}

	@Bean
	public BatchJobRepositoryUtils outboundAimsJobRepositoryUtils() throws Exception {
		return new BatchJobRepositoryUtils(outboundAimsJobRepository());
	}

	@Bean
	@JobScope
	public BatchJobListener outboundAimsJobListener() throws Exception {
		BatchJobListener jobListener = new BatchJobListener();
		jobListener.setJobRepositoryUtils(outboundAimsJobRepositoryUtils());
		return jobListener;
	}

	/*
	 * Outbound MSP Batch - outboundMspJobRepository - outboundMspJobTaskExecutor -
	 * outboundMspJobLauncher - outboundMspJobRepositoryUtils -
	 * outboundMspJobListener
	 */
	@Bean
	public BatchJobRepositoryFactoryBean outboundMspJobRepository() throws Exception {
		BatchJobRepositoryFactoryBean jobRepositoryFactory = new BatchJobRepositoryFactoryBean(batchDataSource());
		jobRepositoryFactory.setTransactionManager(transactionManager);
		jobRepositoryFactory.setTablePrefix(TablePrefix.BATCH_OUTBOUND_MSP_);
		jobRepositoryFactory.setValidateTransactionState(false);
		return jobRepositoryFactory;
	}

	@Bean
	public TaskExecutor outboundMspJobTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//		executor.setCorePoolSize(logicalThreadCount);
		executor.setCorePoolSize(Math.max(logicalThreadCount,
				Math.round(logicalThreadCount * properties.getOutboundLinkerJob().getThreadPoolScaleFactor())));
		return executor;
	}

	@Bean
	public JobLauncher outboundMspJobLauncher() throws Exception {
		SimpleAimsJobLauncher jobLauncher = new SimpleAimsJobLauncher();
		jobLauncher.setJobRepository(outboundMspJobRepository().getObject());
		jobLauncher.setTaskExecutor(outboundMspJobTaskExecutor());
		return jobLauncher;
	}

	@Bean
	public BatchJobRepositoryUtils outboundMspJobRepositoryUtils() throws Exception {
		return new BatchJobRepositoryUtils(outboundMspJobRepository());
	}

	@Bean
	@JobScope
	public BatchJobListener outboundMspJobListener() throws Exception {
		BatchJobListener jobListener = new BatchJobListener();
		jobListener.setJobRepositoryUtils(outboundMspJobRepositoryUtils());
		return jobListener;
	}
}
