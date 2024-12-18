package com.solum.aims.msp.persistence.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.Column;
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

@JsonInclude(Include.NON_NULL)
@Setter
@Getter
@Entity(name="metro_content")
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "width", "height", "color", "page", "article_id" }) })
public class MetroContent {

	@Id
//	@Id
	@GeneratedValue(generator = "metro_content_seq")
	@SequenceGenerator(allocationSize = 1, name = "metro_content_seq")
	private Long id;

	private int width;

	private int height;

	private int color;

	private int model;

	private String type;

	@Column(length = 1024 * 1024 * 1024)
	private String content;

	private int page;

	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "article_id")
	private MetroArticle article;

	@Override
	public String toString() {
		return "MetroArticle [id=" + this.getId() + ", width=" + this.getWidth() + ", height=" + this.getHeight()
				+ ", color=" + this.getColor() + ", model=" + this.getModel() + ", type=" + this.getType() + ", page="
				+ this.getPage() + ", content=" + this.getContent()
				+ (null == this.getArticle() ? "" : ", article=" + this.getArticle().toString()) + "]";
	}

}
