package com.solum.aims.msp.service.impl;

import com.solum.aims.msp.persistence.entity.MetroTemplateGroupMap;
import com.solum.aims.msp.persistence.repository.MetroTemplateGroupMapRepository;
import com.solum.aims.msp.service.MetroTemplateGroupMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MetroTemplateGroupMapServiceImpl implements MetroTemplateGroupMapService {

    @Autowired
    private MetroTemplateGroupMapRepository templateGroupMapRepository;

    @Override
    public MetroTemplateGroupMap save(MetroTemplateGroupMap entity) {
        return templateGroupMapRepository.save(entity);
    }

    @Override
    public Collection<MetroTemplateGroupMap> findByName(String typeName) {
        return templateGroupMapRepository.findByIdName(typeName);
    }

    @Override
    public Collection<MetroTemplateGroupMap> findByGroupName(String groupName) {
        return templateGroupMapRepository.findByIdGroupName(groupName);
    }

    @Override
    public void delete(MetroTemplateGroupMap entity) {
        templateGroupMapRepository.delete(entity);
    }

    @Override
    public void deleteByName(String typeName) {
        templateGroupMapRepository.deleteByIdName(typeName);
    }

    @Override
    public void deleteByGroupName(String groupName) {
        templateGroupMapRepository.deleteByIdGroupName(groupName);
    }
}
