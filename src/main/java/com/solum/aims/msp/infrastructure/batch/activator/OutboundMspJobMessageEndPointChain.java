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
public class OutboundMspJobMessageEndPointChain extends MessageEndPointChain {

	@ServiceActivator(inputChannel="requestProductImageChannel")
	@Retryable(interceptor="retryInterceptor")
	public void launchingGateRequestingProductImage(String param) throws IOException {

		try {
			jobLauncher.run(
					job, 
					new JobParametersBuilder()
						.addString("launchtime", KeyGenerator.getKeyByDateFormat())
						.addString("jobType", "REQUEST_PRODUCT_IMAGE")
						.addString(MESSAGE_KEY, param)
						.toJobParameters());
		} catch (JobExecutionException e) {
			log.error("", e);
		}
	}

	@ServiceActivator(inputChannel="requestReleaseImageChannel")
	@Retryable(interceptor="retryInterceptor")
	public void launchingGatewayRequestingReleaseImage(String param) throws IOException {

		try {
			jobLauncher.run(
					job, 
					new JobParametersBuilder()
						.addString("launchtime", KeyGenerator.getKeyByDateFormat())
						.addString("jobType", "REQUEST_RELEASE_IMAGE")
						.addString(MESSAGE_KEY, param)
						.toJobParameters());
		} catch (JobExecutionException e) {
			log.error("", e);
		}
	}

	@Override
	public void initialize() {}
}
