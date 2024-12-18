package com.solum.aims.msp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solum.aims.msp.persistence.entity.MetroArticle;
import com.solum.aims.msp.persistence.entity.MetroEnddevice;
import com.solum.aims.msp.property.ApplicationProperties;
import com.solum.aims.msp.service.MetroArticleService;
import com.solum.aims.msp.service.MetroEnddeviceService;
import com.solum.aims.msp.util.CommonUtils;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/")
@Slf4j
public class ForceImageRequestController {

	@Autowired
	private ApplicationProperties properties;
	@Autowired
	private MetroArticleService metroArticleService;
	@Autowired
	private CommonUtils commonUtils;

	@Autowired
	private MetroEnddeviceService metroEnddeviceService;

	@PostMapping("force-image")
	public ResponseEntity<String> updateImageOne(@RequestParam String articleId) {
		log.info("Rest Request to force image to MSP for article  id : {}", articleId);
		MetroArticle metroArticle = metroArticleService.getByStationAndArticleId(properties.getCountryCodeDefault(),
				properties.getStoreNumberDefault(), properties.getSalesLineDefault(), articleId);

		if (ObjectUtils.isEmpty(metroArticle)) {
			new ResponseEntity<>("No Article Found ", HttpStatus.NO_CONTENT);
		} else {
			List<MetroEnddevice> metroEnddevices = metroEnddeviceService.getByArticleId(metroArticle.getId());
			if (!ObjectUtils.isEmpty(metroEnddevices)) {
				for (MetroEnddevice enddevice : metroEnddevices) {
					MetroEnddevice metroEnddevice = metroEnddeviceService.getByLabelCode(enddevice.getCode());

					try {
						commonUtils.requestToMetroMSP(metroArticle, metroEnddevice);
					} catch (Exception e) {
						log.error("Exception from request to force image update {} ", e.getMessage());
					}

				}
			} else {
				new ResponseEntity<>("No Labels linked with this article ", HttpStatus.NO_CONTENT);
			}

		}
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
}
