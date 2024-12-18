package com.solum.aims.msp.service.impl;

import com.solum.aims.msp.persistence.entity.TemplateType;
import com.solum.aims.msp.persistence.repository.TemplateTypeRepository;
import com.solum.aims.msp.service.TemplateTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("templateTypeService")
public class TemplateTypeServiceImpl implements TemplateTypeService {

    @Autowired
    protected TemplateTypeRepository templateTypeRepository;

    public TemplateType findByTypeNameAndTemplateSize(String typeName, String templateSize) {
        return templateTypeRepository.findByTypeNameAndTemplateSize(typeName, templateSize);
    }

    public List<TemplateType> findByTypeNameContainsAndTemplateSizeContains(String typeName, String templateSize) {
        return templateTypeRepository.findByTypeNameContainsAndTemplateSizeContains(typeName, templateSize);
    }

    public List<TemplateType> findByTemplateSizeContains(String templateSize) {
        return templateTypeRepository.findByTemplateSizeContains(templateSize);
    }

    public TemplateType findByTypeName(String typeName) {

        return templateTypeRepository.findByTypeName(typeName);
    }



    @Override
    public TemplateType save(TemplateType entity) {
        return templateTypeRepository.save(entity);
    }

    @Override
    public void delete(TemplateType entity) {
        templateTypeRepository.delete(entity);
    }
}
