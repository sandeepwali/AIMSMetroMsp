package com.solum.aims.msp.persistence.repository;

import com.solum.aims.msp.persistence.entity.Template;
import com.solum.aims.msp.persistence.entity.embeddable.TemplateCompositePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateRepository extends JpaRepository<Template, TemplateCompositePK> {

}
