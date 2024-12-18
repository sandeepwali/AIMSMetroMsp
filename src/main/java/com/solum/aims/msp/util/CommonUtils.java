package com.solum.aims.msp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import com.solum.aims.msp.message.MetroRequestChannelMessage;
import com.solum.aims.msp.persistence.entity.MetroArticle;
import com.solum.aims.msp.persistence.entity.MetroEnddevice;
import com.solum.aims.msp.property.ApplicationProperties;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CommonUtils {

	@Autowired
	private ApplicationProperties properties;
	@Autowired
	private MessageChannel sendingProductImageChannel;

	@Autowired
	private AimsObjectMapper objectMapper;

	@Autowired
	private MessageChannel requestProductImageChannel;

	public void requestToMetroMSP(MetroArticle metroArticle, MetroEnddevice metroEnddevice) throws Exception {
		log.info("Sending the default product image.");
		// Default Image
		sendingProductImageChannel.send(MessageBuilder.withPayload(metroEnddevice.getCode() + "-1").build());

		// Request Image
		MetroRequestChannelMessage message = new MetroRequestChannelMessage();
		message.setCountryCode(metroArticle.getCountryCode());
		message.setStoreNumber(metroArticle.getStoreNumber());
		message.setSalesLine(metroArticle.getSalesLine());
		message.setArticleId(metroArticle.getArticleId());

		message.getContent().setWidth(metroEnddevice.getWidth());
		message.getContent().setHeight(metroEnddevice.getHeight());
		message.getContent().setColor(metroEnddevice.getColor());
		message.getContent().setModel(metroEnddevice.getModel());
		message.getContent().setType(metroEnddevice.getType());

		message.setContents(null);

		log.info("Sending the request for the product image to MSP.({})", message.toString());

		if (properties.isMspUse()) {
			requestProductImageChannel
					.send(MessageBuilder.withPayload(objectMapper.writeValueAsString(message)).build());
		}
	}
}
