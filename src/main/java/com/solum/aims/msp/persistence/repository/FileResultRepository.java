package com.solum.aims.msp.persistence.repository;

import com.solum.aims.msp.persistence.entity.FileResult;
import com.solum.aims.msp.persistence.entity.FileResult.ResultType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;


@Repository("fileResultRepository")
public interface FileResultRepository<T extends FileResult> extends JpaRepository<T, Long> {

	public Collection<T> findByName(String name);

	public Page<T> findByNameIgnoreCaseContaining(String name, Pageable pageable);
	
	public Page<T> findByCreatedBetween(Date start, Date end, Pageable pageable);
	
	public Page<T> findByResultAndCreatedBetween(ResultType resultType, Date start, Date end, Pageable pageable);
}
