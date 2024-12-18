package com.solum.aims.msp.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;


@Slf4j
@Configuration
public class ApplicationEventListener {

	@EventListener(classes=ApplicationReadyEvent.class)
	public void onApplicationEvent(ApplicationReadyEvent event) {
		log.info("AIMS METRO MSP Module started.");
	}
}
