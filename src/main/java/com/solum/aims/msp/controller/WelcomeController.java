package com.solum.aims.msp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
@Slf4j
public class WelcomeController {

	@Autowired
	private String aimsMspVersion;

	@Autowired
	private String aimsMspRevision;
	@Value("${aims.msp.msp-use}")
	private Boolean isMspEnabled;

	@RequestMapping
	public @ResponseBody String index() {
		return "Welcome AIMS METRO MSP module";
	}

	@GetMapping("heartbeat")
	public ResponseEntity<?> getMetroMspStatus() {
		log.info("REST request to get Metro MSP Status");
		Map<String,String> map = new HashMap<>();
		map.put("version",aimsMspVersion);
		map.put("revision",aimsMspRevision);
		map.put("msp-use", String.valueOf(isMspEnabled));
		return ResponseEntity.ok(map);

	}
}
