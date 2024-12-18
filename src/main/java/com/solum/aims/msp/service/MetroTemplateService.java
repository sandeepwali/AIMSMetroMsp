package com.solum.aims.msp.service;

import com.solum.aims.msp.controller.response.MetroTemplateGroupResponse;
import com.solum.aims.msp.persistence.entity.MetroTemplateGroup;

import java.util.List;
import java.util.Optional;

public interface MetroTemplateService {

	List<MetroTemplateGroupResponse> getTemplatesGroup();

	public MetroTemplateGroup saveTemplateGroup(String groupName, String description, Integer model);

	public Optional<MetroTemplateGroup> getTemplateGroupByName(String groupName);

	public void deleteTemplateGroupByName(String groupName);

	public void deleteByGroupName(String groupName);

	public MetroTemplateGroup getByModel(Integer model);
}
