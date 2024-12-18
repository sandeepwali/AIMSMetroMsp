package com.solum.aims.msp.service.impl;

import com.solum.aims.msp.controller.request.MetroGroupResponse;
import com.solum.aims.msp.persistence.entity.MetroTemplateGroup;
import com.solum.aims.msp.persistence.repository.MetroTemplateGroupRepository;
import com.solum.aims.msp.service.MetroTemplateGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MetroTemplateGroupServiceImpl implements MetroTemplateGroupService {
	@Autowired
	protected MetroTemplateGroupRepository templateGroupRepository;

	@Override
	public MetroTemplateGroup saveTemplateGroup(MetroTemplateGroup group) {
		return templateGroupRepository.save(group);
	}

	@Override
	public MetroTemplateGroup saveTemplateGroup(String groupName, String description) {
		MetroTemplateGroup templateGroup = new MetroTemplateGroup();

		templateGroup.setName(groupName);
		templateGroup.setDescription(description);

		return templateGroupRepository.save(templateGroup);
	}

	@Override
	public Optional<MetroTemplateGroup> getTemplateGroupByName(String groupName) {
		return templateGroupRepository.findById(groupName);
	}

	@Override
	public void deleteTemplateGroupByName(String groupName) {
		templateGroupRepository.deleteById(groupName);
		templateGroupRepository.removeTemplateGroupMapping(groupName);
	}

	@Override
	public Page<MetroTemplateGroup> findAll(Pageable pageable) {
		return templateGroupRepository.findAll(pageable);
	}

	@Override
	public Page<MetroTemplateGroup> findByName(String name, Pageable pageable) {
		return templateGroupRepository.findByNameContains(name, pageable);
	}

	@Override
	public List<String> findTemplateByGroup(String groupName) {
		return templateGroupRepository.findTemplateByGroup(groupName);
	}

	@Override
	public MetroGroupResponse getByModel(Integer model) {
		List<Object[]> myObjects = templateGroupRepository.findByModelAndGroupName(model);

		MetroGroupResponse r = new MetroGroupResponse();
		List<String> models = new ArrayList<>();
		for (Object[] object : myObjects) {
			String module = (String) object[1];

			r.setGroupName((String) object[0]);
			r.setModel((Integer) object[2]);
			models.add(module);

		}
		r.setTemplateNameList(models);


		return r;

	}

}
