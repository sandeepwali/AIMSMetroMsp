package com.solum.aims.msp.service;

import com.solum.aims.msp.persistence.entity.TemplateType;

import java.util.List;

public interface TemplateTypeService {

	public TemplateType findByTypeNameAndTemplateSize(String typeName, String templateSize);

	public List<TemplateType> findByTypeNameContainsAndTemplateSizeContains(String typeName, String templateSize);

	public List<TemplateType> findByTemplateSizeContains(String templateSize);

	public TemplateType findByTypeName(String typeName);

	public TemplateType save(TemplateType param);

	public void delete(TemplateType param);
}
