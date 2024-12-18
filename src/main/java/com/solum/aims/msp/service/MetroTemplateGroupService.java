package com.solum.aims.msp.service;

import com.solum.aims.msp.controller.request.MetroGroupResponse;
import com.solum.aims.msp.persistence.entity.MetroTemplateGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MetroTemplateGroupService {
	public MetroTemplateGroup saveTemplateGroup(MetroTemplateGroup group);

	public MetroTemplateGroup saveTemplateGroup(String groupName, String description);

	public Optional<MetroTemplateGroup> getTemplateGroupByName(String groupName);

	public void deleteTemplateGroupByName(String groupName);

	public Page<MetroTemplateGroup> findAll(Pageable pageable);

	public Page<MetroTemplateGroup> findByName(String name, Pageable pageable);

	List<String> findTemplateByGroup(String group);

	MetroGroupResponse getByModel(Integer model);
}
