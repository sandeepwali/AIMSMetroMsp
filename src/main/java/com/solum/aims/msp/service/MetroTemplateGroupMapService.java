package com.solum.aims.msp.service;

import com.solum.aims.msp.persistence.entity.MetroTemplateGroupMap;

import java.util.Collection;

public interface MetroTemplateGroupMapService {

    public MetroTemplateGroupMap save(MetroTemplateGroupMap entity);

    public Collection<MetroTemplateGroupMap> findByName(String typeName);

    public Collection<MetroTemplateGroupMap> findByGroupName(String groupName);

    public void delete(MetroTemplateGroupMap entity);

    public void deleteByName(String typeName);

    public void deleteByGroupName(String groupName);
}
