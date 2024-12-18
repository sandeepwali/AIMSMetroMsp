package com.solum.aims.msp.infrastructure.batch.activator;

import com.solum.aims.msp.infrastructure.batch.MessageEndPointChain;
import com.solum.aims.msp.service.AimsMspRestTemplateService;
import com.solum.aims.msp.util.KeyGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.ServiceActivator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;

@Slf4j
public class ProcessingM1MessageEndPointChain extends MessageEndPointChain {
	@Autowired
	private AimsMspRestTemplateService restTemplateService;

	@Filter(inputChannel="processingM1FileFilterChannel", outputChannel="processingM1Channel")
	public boolean payLoadExistenceFilter(File file) {
		return Files.exists(file.toPath(), LinkOption.NOFOLLOW_LINKS) == true || Files.notExists(file.toPath(), LinkOption.NOFOLLOW_LINKS) == false;
	}
	
	@ServiceActivator(inputChannel="processingM1Channel")
	public void launchingGateway(File file) throws IOException {
		log.info("@ServiceActivator processingM1Channel - {}", file);
		while (true) {
			Integer statusCode = restTemplateService.getPortalStatus();
			if (statusCode == 200) {
				break;
			}
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				log.error("Exception from checking for portal status before processing m1 or i1 file {}",
						e.getMessage());
				Thread.currentThread().interrupt();

			}
		}
		try {
			jobLauncher.run(
					job, 
					new JobParametersBuilder()
						.addString("launchtime", KeyGenerator.getKeyByDateFormat())
						.addString("m1FilePath", file.toString())
						.toJobParameters());
		} catch (JobExecutionException e) {
			log.error("", e);
			Files.deleteIfExists(Paths.get(file.toString()));
		}
	}
	
	@Override
	protected void initialize() {}
}
