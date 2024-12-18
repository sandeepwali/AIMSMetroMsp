package com.solum.aims.msp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;

@Configuration
public class WebMvcConfig extends DelegatingWebMvcConfiguration {

	@Override
	protected void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS").allowedHeaders("*")
				.allowedOrigins("*").maxAge(Long.MAX_VALUE)
				.exposedHeaders("X-total-count", "X-size", "X-totalElements", "X-totalPages", "X-number");
		super.addCorsMappings(registry);
	}

}