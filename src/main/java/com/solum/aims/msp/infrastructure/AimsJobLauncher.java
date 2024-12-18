package com.solum.aims.msp.infrastructure;

import com.solum.aims.msp.infrastructure.batch.JobExecutionParameters;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;

public interface AimsJobLauncher extends JobLauncher {
	JobExecution run(Job job, JobParameters jobParameters, JobExecutionParameters jobExecutionParameters) throws JobExecutionAlreadyRunningException;
}
