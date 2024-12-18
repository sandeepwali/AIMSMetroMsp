package com.solum.aims.msp.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "metro_enddevice")
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "code" }) })
@Setter
@Getter
public class MetroEnddevice {

	@Id
	@GeneratedValue(generator = "metro_enddevice_seq")
	@SequenceGenerator(allocationSize = 1, name = "metro_enddevice_seq")
	private Long id;

	private String code;

	private String type;

	private int width;

	private int height;

	private int color;

	private int model;

	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name="article_id")
	private MetroArticle article;

	@Override
	public String toString() {
		return "MetroEnddevice [id=" + this.getId() + ", code=" + this.getCode() + ", type=" + this.getType()
				+ ", width=" + this.getWidth() + ", height=" + this.getHeight() + ", color=" + this.getColor()
				+ ", model=" + this.getModel() + ", article=" + this.getArticle().toString() + "]";
	}
}
