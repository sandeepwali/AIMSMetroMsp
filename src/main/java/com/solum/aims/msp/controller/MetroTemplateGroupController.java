package com.solum.aims.msp.controller;

import com.solum.aims.msp.comstant.Constants;
import com.solum.aims.msp.config.exception.NotSupportException;
import com.solum.aims.msp.config.exception.ResourceNotFoundException;
import com.solum.aims.msp.controller.parameter.template.TemplateGroupListParam;
import com.solum.aims.msp.controller.parameter.template.TemplateGroupNameListParam;
import com.solum.aims.msp.controller.parameter.template.TemplateGroupParam;
import com.solum.aims.msp.controller.request.DeleteTemplateGroupParam;
import com.solum.aims.msp.controller.request.EditTemplateGroupParam;
import com.solum.aims.msp.controller.request.TemplateGroupMapParam;
import com.solum.aims.msp.controller.response.AimsApiResponse;
import com.solum.aims.msp.persistence.entity.MetroTemplateGroup;
import com.solum.aims.msp.persistence.entity.MetroTemplateGroupMap;
import com.solum.aims.msp.persistence.entity.TemplateType;
import com.solum.aims.msp.persistence.entity.embeddable.MetroTemplateGroupMapCompositePK;
import com.solum.aims.msp.service.MetroTemplateGroupMapService;
import com.solum.aims.msp.service.MetroTemplateGroupService;
import com.solum.aims.msp.service.MetroTemplateService;
import com.solum.aims.msp.service.TemplateTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.security.InvalidParameterException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(value = { "/common" })
public class MetroTemplateGroupController {

	@Autowired
	TemplateTypeService templateTypeService;
	@Autowired
	MetroTemplateGroupMapService metroTemplateGroupMapService;
	@Autowired
	private MetroTemplateService templateService;

	@Autowired
	private MetroTemplateGroupService templateGroupService;

	@Value("${aims.msp.msp-use}")
	private Boolean isMspEnabled;

	@GetMapping(value = "/templates/mapping/group")
	public ResponseEntity<TemplateGroupParam> getTemplateGroups(@RequestParam(required = false) String company,
			@RequestParam(required = false) String name,
			@PageableDefault(page = 0, size = 10, sort = "name", direction = org.springframework.data.domain.Sort.Direction.ASC) Pageable pageable) {

		log.info("Rest Request to Get All Template Mapping{}");
		try {
			Page<MetroTemplateGroup> groups;

			if (name == null)
				groups = templateGroupService.findAll(pageable);
			else
				groups = templateGroupService.findByName(name, pageable);

			TemplateGroupParam group = new TemplateGroupParam();

			List<TemplateGroupListParam> groupList = groups.stream().map(p -> {
				TemplateGroupListParam groupAll = new TemplateGroupListParam();

				groupAll.setGroupName(p.getName());
				groupAll.setLastModifiedDate(p.getLastModified());
				groupAll.setModel(p.getModel());

				return groupAll;

			}).collect(Collectors.toList());

			group.setGroupList(groupList);
			group.setResponseCode(Constants.OK);
			group.setResponseMessage("Successfully get template group list.");

			HttpHeaders header = new HttpHeaders();

			header.setContentType(MediaType.APPLICATION_JSON);
			header.set("X-size", String.valueOf(groups.getSize()));
			header.set("X-totalElements", String.valueOf(groups.getTotalElements()));
			header.set("X-totalPages", String.valueOf(groups.getTotalPages()));
			header.set("X-number", String.valueOf(groups.getNumber()));
			header.set("X-total-count", String.valueOf(groupList.size()));

			if (groupList.isEmpty()) {
				return ResponseEntity.noContent().header("X-total-count", "0").build();

			} else {
				return ResponseEntity.ok().headers(header).body(group);
			}

		} catch (HttpClientErrorException e) {
			return ResponseEntity.status(e.getStatusCode()).build();

		} catch (Exception e) {
			log.error("Exception : {}", e.getMessage());

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.header("X-Exception-Type", e.getClass().toString()).header("X-Exception-Cause", e.getMessage())
					.build();
		}
	}

	@PostMapping(value = "/templates/mapping/group")
	public ResponseEntity<AimsApiResponse> addTemplateGroup(@RequestParam(required = false) String company,
			@RequestBody TemplateGroupMapParam param) {

		AimsApiResponse aimsApiResponse = new AimsApiResponse();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		aimsApiResponse.setCustomBatchId(sdf.format(date));
		int registerCount = 0;
		try {
			if (!(templateGroupService.getTemplateGroupByName(param.getGroupName()).isPresent())
					&& ObjectUtils.isEmpty(templateService.getByModel(param.getModel()))) {
				// Create empty template group

				templateService.saveTemplateGroup(param.getGroupName(), "cs", param.getModel());

			}

			Optional<MetroTemplateGroup> opTemplateGroup = templateService.getTemplateGroupByName(param.getGroupName());
			if (!opTemplateGroup.isPresent()) {
				return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
			}

			// Remove the previous Link
			templateService.deleteByGroupName(param.getGroupName());

			// Create New Link
			for (String templateName : param.getTemplateNameList()) {

				/**
				 * TODO we need to call DashBoard Template API and Rest call for that
				 */
				TemplateType templateType = templateTypeService.findByTypeName(templateName);

				if (templateType == null) {
					log.warn("There is no template type whose name is '{}'", templateType);
					continue;
				}

				MetroTemplateGroupMap groupMap = new MetroTemplateGroupMap();
				MetroTemplateGroupMapCompositePK mapPK = new MetroTemplateGroupMapCompositePK();

				mapPK.setName(templateName);
				mapPK.setStationCode(Constants.DEFAULT_STATION_CODE);
				mapPK.setGroupName(param.getGroupName());

				groupMap.setId(mapPK);
				metroTemplateGroupMapService.save(groupMap);

				registerCount++;
			}
			aimsApiResponse.setResponseCode(Constants.OK);
			aimsApiResponse.setResponseMessage("The data has been updated successfully");
			aimsApiResponse.setTemplates(param.getTemplateNameList());
			return new ResponseEntity<>(aimsApiResponse, HttpStatus.OK);

		} catch (InvalidParameterException e) {
			aimsApiResponse.setResponseCode(Constants.METHOD_NOT_ALLOWED);
			aimsApiResponse.setResponseMessage("Template Group can't found.");
			return new ResponseEntity<>(aimsApiResponse, HttpStatus.METHOD_NOT_ALLOWED);

		} catch (NotSupportException e) {
			aimsApiResponse.setResponseCode(Constants.NOT_ACCEPTABLE);
			aimsApiResponse
					.setResponseMessage("In this environment, APIs related to Template Group are not acceptable.");
			return new ResponseEntity<>(aimsApiResponse, HttpStatus.NOT_ACCEPTABLE);

		} catch (HttpClientErrorException e) {
			return ResponseEntity.status(e.getStatusCode()).build();

		} catch (Exception e) {
			log.error("Exception : {}", e.getMessage());

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.header("X-Exception-Type", e.getClass().toString()).header("X-Exception-Cause", e.getMessage())
					.build();
		}
	}

	@PutMapping(value = "/templates/mapping/group")
	public ResponseEntity<AimsApiResponse> addTemplateGroup(@RequestParam(required = false) String company,
			@RequestParam(required = true) String group, @RequestBody EditTemplateGroupParam param) {

		AimsApiResponse aimsApiResponse = new AimsApiResponse();
		int updateCount = 0;
		try {
			if (!templateGroupService.getTemplateGroupByName(group).isPresent()) {
				throw new InvalidParameterException();
			}

			TemplateGroupMapParam request = new TemplateGroupMapParam();
			request.setGroupName(group);
			request.setTemplateNameList(param.getTemplateNameList());

			Optional<MetroTemplateGroup> opTemplateGroup = templateService.getTemplateGroupByName(group);
			if (!opTemplateGroup.isPresent()) {
				return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
			}

			// Remove the previous Link
			metroTemplateGroupMapService.deleteByGroupName(group);

			// Create New Link
			for (String templateName : param.getTemplateNameList()) {
				/**
				 * TODO we need to call DashBoard Template API and Rest call for that
				 */
				TemplateType templateType = templateTypeService.findByTypeName(templateName);

				if (templateType == null) {
					log.warn("There is no template type whose name is '{}'", templateType);
					continue;
				}

				MetroTemplateGroupMap groupMap = new MetroTemplateGroupMap();
				MetroTemplateGroupMapCompositePK mapPK = new MetroTemplateGroupMapCompositePK();

				mapPK.setName(templateName);
				mapPK.setStationCode(Constants.DEFAULT_STATION_CODE);
				mapPK.setGroupName(group);

				groupMap.setId(mapPK);
				metroTemplateGroupMapService.save(groupMap);

				updateCount++;
			}
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm");
			aimsApiResponse.setCustomBatchId(sdf.format(date));
			aimsApiResponse.setResponseCode(Constants.OK);
			aimsApiResponse.setResponseMessage("The data has been updated successfully");
			aimsApiResponse.setTemplates(param.getTemplateNameList());
			return new ResponseEntity<>(aimsApiResponse, HttpStatus.OK);

		} catch (InvalidParameterException e) {
			aimsApiResponse.setResponseCode(Constants.METHOD_NOT_ALLOWED);
			aimsApiResponse.setResponseMessage("Template Group can't found.");
			return new ResponseEntity<>(aimsApiResponse, HttpStatus.METHOD_NOT_ALLOWED);

		} catch (NotSupportException e) {
			aimsApiResponse.setResponseCode(Constants.NOT_ACCEPTABLE);
			aimsApiResponse
					.setResponseMessage("In this environment, APIs related to Template Group are not acceptable.");
			return new ResponseEntity<>(aimsApiResponse, HttpStatus.NOT_ACCEPTABLE);

		} catch (HttpClientErrorException e) {
			return ResponseEntity.status(e.getStatusCode()).build();

		} catch (Exception e) {
			log.error("Exception : {}", e.getMessage());

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.header("X-Exception-Type", e.getClass().toString()).header("X-Exception-Cause", e.getMessage())
					.build();
		}
	}

	@DeleteMapping(value = "/templates/mapping/group")
	public ResponseEntity<AimsApiResponse> deleteTemplateGroup(@RequestParam(required = false) String company,
			@RequestBody DeleteTemplateGroupParam param) {

		AimsApiResponse aimsApiResponse = new AimsApiResponse();

		try {
			for (String templateGroup : param.getTemplateGroupDeleteList()) {
				if (!templateService.getTemplateGroupByName(templateGroup).isPresent()) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				}else {
					templateService.deleteTemplateGroupByName(templateGroup);
					aimsApiResponse = AimsApiResponse.builder().responseCode(Constants.OK).responseMessage(
							new StringBuilder("Delete a template group(").append(templateGroup).append(")").toString())
							.build();
				}
			}

			aimsApiResponse.setResponseCode(Constants.OK);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm");
			aimsApiResponse.setCustomBatchId(sdf.format(date));
			aimsApiResponse.setTemplates(param.getTemplateGroupDeleteList());
			aimsApiResponse.setResponseMessage("The data has been deleted successfully");
			return new ResponseEntity<>(aimsApiResponse, HttpStatus.OK);

		} catch (ResourceNotFoundException e) {
			aimsApiResponse.setResponseCode(Constants.NOT_FOUND);
			aimsApiResponse.setResponseMessage("Can't find template infomation.");
			return new ResponseEntity<>(aimsApiResponse, HttpStatus.NOT_FOUND);

		} catch (NotSupportException e) {
			aimsApiResponse.setResponseCode(Constants.NOT_ACCEPTABLE);
			aimsApiResponse.setResponseMessage("Can't delete template.");
			return new ResponseEntity<>(aimsApiResponse, HttpStatus.NOT_ACCEPTABLE);

		} catch (HttpClientErrorException e) {
			return ResponseEntity.status(e.getStatusCode()).build();

		} catch (Exception e) {
			log.error("Exception : {}", e.getMessage());

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.header("X-Exception-Type", e.getClass().toString()).header("X-Exception-Cause", e.getMessage())
					.build();
		}
	}

	@GetMapping(value = "/templates/mapping/group/detail")
	public ResponseEntity<TemplateGroupNameListParam> getTemplatesByGroup(
			@RequestParam(required = false) String company, @RequestParam(required = true) String group) {

		try {

			List<String> templates = templateGroupService.findTemplateByGroup(group);

			TemplateGroupNameListParam response = new TemplateGroupNameListParam();

			response.setTemplateNameList(templates);
			response.setResponseCode(Constants.OK);
			response.setResponseMessage("Successfully get template list.");

			HttpHeaders header = new HttpHeaders();

			header.setContentType(MediaType.APPLICATION_JSON);
			header.set("X-total-count", String.valueOf(templates.size()));

			if (templates.isEmpty()) {
				return ResponseEntity.noContent().header("X-total-count", "0").build();

			} else {
				return ResponseEntity.ok().headers(header).body(response);
			}

		} catch (HttpClientErrorException e) {
			return ResponseEntity.status(e.getStatusCode()).build();

		} catch (Exception e) {
			log.error("Exception : {}", e.getMessage());

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.header("X-Exception-Type", e.getClass().toString()).header("X-Exception-Cause", e.getMessage())
					.build();
		}
	}

}
