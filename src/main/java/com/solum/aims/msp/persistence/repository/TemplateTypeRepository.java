package com.solum.aims.msp.persistence.repository;

import com.solum.aims.msp.persistence.entity.TemplateType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TemplateTypeRepository extends JpaRepository<TemplateType, String> {

	public TemplateType findByTypeNameAndTemplateSize(String typeName, String templateSize);

	public List<TemplateType> findByTypeNameContainsAndTemplateSizeContains(String typeName, String templateSize);

	public List<TemplateType> findByTemplateSizeContains(String templateSize);

	public TemplateType findByTypeName(String typeName);

}
