package com.solum.aims.msp.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;
import org.hibernate.type.SqlTypes;

import com.solum.aims.msp.persistence.entity.embeddable.ArticleCompositePK;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@DynamicInsert
@DynamicUpdate
public class Article implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ArticleCompositePK id;

	@Audited
	@Column(length = 512)
	private String name;

	@Audited
	@Column(name = "nfc_url")
	private String nfcUrl;

	@Audited
	@Column(length = 1024 * 1024 * 1024)
	private String data;

	@Audited
	@Column(name = "custom_batch_id")
	private String customBatchId;

	@Audited
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date created;

	@Audited
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified")
	private Date lastModified;

	@Audited
	@Column(name = "reserved_one")
	private String reservedOne;

	@Audited
	@Column(name = "reserved_two")
	private String reservedTwo;

	@Audited
	@Column(name = "reserved_three")
	private String reservedThree;

//	@Type(type = "json")
	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "nvarchar")
	private String reserved;

	public Article() {
		super();
	}

	public Article(String name, String nfcUrl, String data) {
		super();
		this.name = name;
		this.nfcUrl = nfcUrl;
		this.data = data;
	}

}
