package com.solum.aims.msp.service.impl;

import com.solum.aims.msp.controller.response.MetroTemplateGroupResponse;
import com.solum.aims.msp.persistence.entity.MetroTemplateGroup;
import com.solum.aims.msp.persistence.repository.MetroTemplateGroupMapRepository;
import com.solum.aims.msp.persistence.repository.MetroTemplateGroupRepository;
import com.solum.aims.msp.service.MetroTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MetroTemplateServiceImpl implements MetroTemplateService {

	@Autowired
	MetroTemplateGroupRepository repository;

	@Autowired
	MetroTemplateGroupMapRepository groupMapRepository;

	@Override
	public List<MetroTemplateGroupResponse> getTemplatesGroup() {

		List<MetroTemplateGroupResponse> responses = new ArrayList<>();

		List<MetroTemplateGroup> metroTemplateGroups = repository.findAll();
		for (MetroTemplateGroup template : metroTemplateGroups) {
			MetroTemplateGroupResponse response = new MetroTemplateGroupResponse();
			response.setDescription(template.getDescription());
			response.setModel(template.getModel());
			response.setName(template.getName());
			response.setCreated(new SimpleDateFormat("yyyy-MM-dd").format(template.getCreated()));
			response.setLastModified(new SimpleDateFormat("yyyy-MM-dd").format(template.getLastModified()));
			responses.add(response);
		}
		return responses;

	}

	@Override
	public Optional<MetroTemplateGroup> getTemplateGroupByName(String groupName) {
		return repository.findById(groupName);
	}

	@Override
	public MetroTemplateGroup saveTemplateGroup(String groupName, String description, Integer model) {
		MetroTemplateGroup templateGroup = new MetroTemplateGroup();
		templateGroup.setName(groupName);
		templateGroup.setDescription(description);
		templateGroup.setModel(model);
		return repository.save(templateGroup);
	}

	@Override
	public void deleteTemplateGroupByName(String groupName) {
		repository.deleteById(groupName);
		repository.removeTemplateGroupMapping(groupName);
	}

	@Override
	public void deleteByGroupName(String groupName) {
		groupMapRepository.deleteByIdGroupName(groupName);
	}

	@Override
	public MetroTemplateGroup getByModel(Integer model) {

		return repository.findByModel(model);

	}

}
