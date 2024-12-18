package com.solum.aims.msp.service.impl;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.solum.aims.msp.persistence.entity.FileResult;
import com.solum.aims.msp.persistence.entity.FileResult.ResultType;
import com.solum.aims.msp.persistence.repository.FileResultRepository;
import com.solum.aims.msp.service.FileResultService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("fileResultService")
public class FileResultServiceImpl<T extends FileResult> implements FileResultService<T> {

	@Value("${customer.file.result.log:NONE}")
	private String customerFileResultLog;	
	
	@Value("${customer.file.backup.path}")
	private String customerFileBackupPath;
	
	@Autowired
	private	FileResultRepository<T>	fileResultRepository;
	
	@Override
	public T saveFileResult(T entity) {
		return fileResultRepository.save(entity);
	}
	@Override
	public Collection<T> findFileResult(String name) {
		return fileResultRepository.findByName(name);
	}

	@Override
	public T getOne(Long id) {
		return fileResultRepository.findById(id).orElse(null);
	}

	@Override
	public Collection<T> getAllFileResult() {
		return fileResultRepository.findAll();
	}

	@Override
	public void postProcess(String dataFileName, int totalRow, List<Integer> failRows, Date created, Date completed) {
		switch(customerFileResultLog) {
		case "FILE": writeResultFile(dataFileName, totalRow, failRows, created, completed); break;
		case "DB": writeResultDB(dataFileName, totalRow, failRows, created, completed); break; 
		}
		
	}

	private	void writeResultFile(String dataFileName, int totalRow, List<Integer> failRows, Date created, Date completed) {
		
		String	resultFileName = new StringBuilder(customerFileBackupPath).append("/")
				.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))).append("/")
				.append(FilenameUtils.removeExtension(dataFileName))
				.append(".result")
				.toString();
		
		try(PrintWriter writer = new PrintWriter(new FileWriter(resultFileName, true))) {
			
			//writer.printf("[ %s ]\n", LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
			SimpleDateFormat format1 = new SimpleDateFormat ("HH:mm:ss");
			writer.printf("[%s ~ %s]\n", format1.format(created), format1.format(completed));
			
			if (totalRow > 0) {
				writer.printf("Total Data Count : %d\n", totalRow);
				writer.printf("Success Count : %d\n", totalRow - failRows.size());
				writer.printf("Fail Count : %d\n", failRows.size());
				if (failRows.size() > 0) {
					writer.printf("\t>>> Failed Index : %s\n", failRows.toString());
				}				
			}else {
				writer.printf("Fail to process this file : %s\n", dataFileName);
			}
			
		}catch(Exception e) {
			log.warn("Fail to write result about {} processing", dataFileName);
		}
		
	}
	
	private	void writeResultDB(String dataFileName, int totalRow, List<Integer> failRows, Date created, Date completed) {
		
		@SuppressWarnings("unchecked")
		T	fileResult = (T)(new FileResult());
		
		fileResult.setName(dataFileName);
		fileResult.setCreated(created);
		fileResult.setCompleted(completed);
		
		if (totalRow < 0) {
			fileResult.setResult(ResultType.FAIL);
		}else {
			if (totalRow > 0 && failRows.size()==0) {
				fileResult.setResult(ResultType.SUCCESS);
			}else if ((totalRow - failRows.size()) > 0 && failRows.size() > 0) {
				fileResult.setResult(ResultType.PARTIAL_SUCCESS);
				
			}else if (totalRow > 0 && totalRow == failRows.size()) {
				fileResult.setResult(ResultType.FAIL);
			}
			
			fileResult.setTotal(totalRow);
			fileResult.setSuccess(totalRow - failRows.size());
			fileResult.setFail(failRows.size());
		}
		
		this.saveFileResult(fileResult);
		
	}
	
	@Override
	public Page<T> getAllPageable(Pageable pageable) {
		return fileResultRepository.findAll(pageable);
	}
	
	@Override
	public Page<T> getByName(String name, Pageable pageable) {
		return fileResultRepository.findByNameIgnoreCaseContaining(name, pageable);
	}
	
	@Override
	public Page<T> getByFiltering(ResultType result, Date start, Date end, Pageable pageable) {
		if(ResultType.NOT_PROCESSED == result) {
			return fileResultRepository.findByCreatedBetween(start, end, pageable);
		} else {
			return fileResultRepository.findByResultAndCreatedBetween(result, start, end, pageable);
		}
	}
	
	@Override
	public void deleteResult(List<Long> ids) {
		ids.forEach(id->{
			try {
				fileResultRepository.deleteById(id);
			} catch(Exception e) {
				return;
			}
		});
	}
	
}
