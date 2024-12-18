package com.solum.aims.msp.persistence.entity.embeddable;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode
@Embeddable
public class ArticleCompositePK implements Serializable{

	private static final long serialVersionUID = 1L;

	public ArticleCompositePK() {}
	
	public ArticleCompositePK(String stationCode, String articleId) {
		this.stationCode = stationCode;
		this.articleId = articleId;
	}
	
	@Column(name = "station_code")
	private String stationCode;
	
	@Column(name = "article_id")
	private String articleId;
}
