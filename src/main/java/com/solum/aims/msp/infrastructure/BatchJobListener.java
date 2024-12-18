package com.solum.aims.msp.infrastructure;

import com.solum.aims.msp.infrastructure.batch.BatchJobRepositoryUtils;
import lombok.Setter;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class BatchJobListener implements JobExecutionListener {

	private static final int logicalThreadCount = Runtime.getRuntime().availableProcessors();
	
	@Setter
	private BatchJobRepositoryUtils jobRepositoryUtils;
	
	@Override
	public void beforeJob(JobExecution jobExecution) {}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getId() % (logicalThreadCount * 3) == 0) {
			jobRepositoryUtils.purgeJobExecutions();
		}
	}

}
