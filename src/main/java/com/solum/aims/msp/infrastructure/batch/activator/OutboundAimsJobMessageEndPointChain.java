package com.solum.aims.msp.infrastructure.batch.activator;

import com.solum.aims.msp.infrastructure.batch.MessageEndPointChain;
import com.solum.aims.msp.util.KeyGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.retry.annotation.Retryable;

import java.io.IOException;

@Slf4j
public class OutboundAimsJobMessageEndPointChain extends MessageEndPointChain {

	@ServiceActivator(inputChannel="sendingProductImageChannel")
	@Retryable(interceptor="retryInterceptor")
	public void launchingGateSendingImage(String enddeviceId) throws IOException {

		try {
			jobLauncher.run(
					job, 
					new JobParametersBuilder()
						.addString("launchtime", KeyGenerator.getKeyByDateFormat())
						.addString("jobType", "SENDING_IMAGE")
						.addString(MESSAGE_KEY, enddeviceId)
						.toJobParameters());
		} catch (JobExecutionException e) {
			log.error("", e);
		}
	}

	@ServiceActivator(inputChannel="sendingUnlinkChannel")
	@Retryable(interceptor="retryInterceptor")
	public void launchingGatewaySendingUnlink(String labelCode) throws IOException {

		try {
			jobLauncher.run(
					job, 
					new JobParametersBuilder()
						.addString("launchtime", KeyGenerator.getKeyByDateFormat())
						.addString("jobType", "SENDING_UNLINK")
						.addString(MESSAGE_KEY, labelCode)
						.toJobParameters());
		} catch (JobExecutionException e) {
			log.error("", e);
		}
	}
	
	@Override
	public void initialize() {}
}
