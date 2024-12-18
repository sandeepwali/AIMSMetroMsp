package com.solum.aims.msp.infrastructure.batch;

import com.solum.aims.msp.infrastructure.AimsJobLauncher;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.core.task.TaskExecutor;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map.Entry;

@Slf4j
@Setter
public class SimpleAimsJobLauncher implements AimsJobLauncher {

	private JobRepository jobRepository;
	private TaskExecutor taskExecutor;
	
	@Override
	public JobExecution run(Job job, JobParameters jobParameters) throws JobExecutionAlreadyRunningException,
			JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		return run(job, jobParameters, new JobExecutionParametersBuilder().toJobExecutionParameters());
	}

	@Override
	public JobExecution run(Job job, JobParameters jobParameters, JobExecutionParameters jobExecutionParameters)
			throws JobExecutionAlreadyRunningException {
		JobExecution jobExecution = null;

		try {
			jobExecution = runInternal(job, jobParameters, jobExecutionParameters);
		} catch (JobExecutionException e) {
			if (e instanceof JobExecutionAlreadyRunningException) {
				throw (JobExecutionAlreadyRunningException) e;
			}

			log.error(e.getMessage());
		}

		return jobExecution;
	}

	private JobExecution runInternal(Job job, JobParameters jobParameters, JobExecutionParameters jobExecutionParameters) throws JobExecutionException {
		Assert.notNull(job, "The Job must not be null.");
		Assert.notNull(jobParameters, "The JobParameters must not be null.");

		JobExecution jobExecution;
		JobExecution lastJobExecution = jobRepository.getLastJobExecution(job.getName(), jobParameters);

		if (lastJobExecution != null) {
			if (job.isRestartable() == false) {
				throw new JobRestartException("JobInstance already exists and is not restartable");
			}

			for (StepExecution execution : lastJobExecution.getStepExecutions()) {
				if (execution.getStatus() == BatchStatus.UNKNOWN) {
					throw new JobRestartException("Step [" + execution.getStepName() + "] is of status UNKNOWN");
				}
			}
		}

		job.getJobParametersValidator().validate(jobParameters);
		jobExecution = jobRepository.createJobExecution(job.getName(), jobParameters);

		for (Entry<String, Object> entry : jobExecutionParameters.getParameterMap().entrySet()) {
			jobExecution.getExecutionContext().put(entry.getKey(), entry.getValue());
		}

		try {
			taskExecutor.execute(() -> {
				try {
					String taskExecutorToString = ((ThreadPoolTaskExecutor) taskExecutor).getThreadPoolExecutor().toString();
					log.info("{}TaskExecutor={}", job.getName(), taskExecutorToString.substring(taskExecutorToString.indexOf('[')));
					job.execute(jobExecution);
				} catch (Throwable t) {
					log.info("Job: [{}] failed unexpectedly and fatally with the following parameters: [{}]", job, jobParameters, t);
					jobExecution.setStatus(BatchStatus.FAILED);
					jobExecution.setExitStatus(ExitStatus.FAILED.addExitDescription(t));
//					jobExecution.setEndTime(new Date());
					jobExecution.setEndTime(LocalDateTime.now());
					jobRepository.update(jobExecution);

					if (t instanceof RuntimeException) {
						throw (RuntimeException) t;
					} else {
						throw (Error) t;
					}
				}
			});
		} catch (TaskRejectedException e) {
			jobExecution.upgradeStatus(BatchStatus.FAILED);

			if (jobExecution.getExitStatus().equals(ExitStatus.UNKNOWN)) {
				jobExecution.setExitStatus(ExitStatus.FAILED.addExitDescription(e));
			}

			jobRepository.update(jobExecution);
		}

		return jobExecution;
	}
}
