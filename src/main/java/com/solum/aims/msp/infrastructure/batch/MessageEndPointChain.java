package com.solum.aims.msp.infrastructure.batch;

import com.solum.aims.msp.infrastructure.AimsJobLauncher;
import lombok.Setter;
import org.springframework.batch.core.Job;

@Setter
public abstract class MessageEndPointChain {

	public static final String MESSAGE_KEY = "message";
	public static final String CONTRACTS_KEY = "contracts";

	protected Job job;
	protected AimsJobLauncher jobLauncher;

	protected abstract void initialize();
}
