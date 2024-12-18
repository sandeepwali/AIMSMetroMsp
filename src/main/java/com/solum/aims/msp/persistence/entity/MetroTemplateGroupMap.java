package com.solum.aims.msp.persistence.entity;


import java.io.Serializable;

import com.solum.aims.msp.persistence.entity.embeddable.MetroTemplateGroupMapCompositePK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name="metro_template_group_map")
@Getter @Setter

public class MetroTemplateGroupMap implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MetroTemplateGroupMapCompositePK id;
}