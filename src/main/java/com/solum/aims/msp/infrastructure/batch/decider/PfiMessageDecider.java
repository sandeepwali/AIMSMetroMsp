package com.solum.aims.msp.infrastructure.batch.decider;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.stereotype.Component;

@Component
public class PfiMessageDecider implements JobExecutionDecider {

	@Override
	public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
		String pfiMessageType = stepExecution.getJobExecution().getExecutionContext().getString("pfiMessageType");
		return new FlowExecutionStatus(pfiMessageType);
	}
}
