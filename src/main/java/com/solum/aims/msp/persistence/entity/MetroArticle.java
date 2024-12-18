package com.solum.aims.msp.persistence.entity;

import java.util.Collection;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity(name="metro_article")
@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames = {"country_code", "store_number", "sales_line", "article_id"})
		})
@Setter @Getter
public class MetroArticle {

//	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@GeneratedValue(generator = "metro_article_seq")
	@SequenceGenerator(allocationSize = 1, name = "metro_article_seq")
	private Long id;
	@Column(name = "country_code")
	private String countryCode;
	@Column(name = "store_number")
	private String storeNumber;
	@Column(name = "sales_line")
	private String salesLine;
	@Column(name = "article_id")
	private String articleId;
	
	@Column(length=1024*1024*1024)
	private Map<String, String> data;
	
	@OneToMany(mappedBy="article", fetch=FetchType.EAGER)
	private Collection<MetroEnddevice> enddevices;
	
	@OneToMany(mappedBy="article", fetch=FetchType.EAGER)
	private Collection<MetroContent> contents;
	
	public String getAimsStationCode() {
		return new StringBuilder()
				.append(this.countryCode).append("_").append(this.storeNumber)
				.toString();
	}
	
	@Override
	public String toString() {
		return "MetroArticle [id=" + this.getId() 
		+ ", countryCode=" + this.getCountryCode() 
		+ ", storeNumber=" + this.getStoreNumber() 
		+ ", salesLine=" + this.getSalesLine()
		+ ", articleId=" + this.getArticleId()
		+ ", data=" + this.getData()
		+ "]";
	}


	public MetroArticle() {
		super();
	}

	public MetroArticle(String countryCode, String storeNumber, String salesLine, String articleId) {
		super();
		this.countryCode = countryCode;
		this.storeNumber = storeNumber;
		this.salesLine = salesLine;
		this.articleId = articleId;
	}

}
