package com.solum.aims.msp.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity(name="file_result")
@Getter @Setter
public class FileResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(generator="fileResultSeqGenerator")
	@SequenceGenerator(name="fileResultSeqGenerator", sequenceName="file_result_seq", allocationSize=1)
	private Long id;
	
	private String	name;
	
	@Enumerated(EnumType.STRING)
	private	ResultType	result = ResultType.NOT_PROCESSED;
	
	private	int	total = -1;
	
	private	int	success = -1;
	
	private	int	fail = -1;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date completed;

	public enum ResultType {
		NOT_PROCESSED,
		SUCCESS,
		PARTIAL_SUCCESS,
		FAIL
	}
}
