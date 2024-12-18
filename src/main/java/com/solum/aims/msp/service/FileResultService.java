package com.solum.aims.msp.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.solum.aims.msp.persistence.entity.FileResult;
import com.solum.aims.msp.persistence.entity.FileResult.ResultType;


public interface FileResultService<T extends FileResult> {

	T saveFileResult(T entity);

	Collection<T> findFileResult(String name);
	
	T getOne(Long id);
	
	Collection<T> getAllFileResult();
	
	void postProcess(String dataFileName, int totalRow, List<Integer> failRows, Date created, Date completed);
	
	Page<T> getAllPageable(Pageable pageable);
	
	Page<T> getByName(String name, Pageable pageable);
	
	Page<T> getByFiltering(ResultType result, Date start, Date end, Pageable pageable);
	
	void deleteResult(List<Long> ids);
}
