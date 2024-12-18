package com.solum.aims.msp.infrastructure.batch.task;

import com.solum.aims.msp.message.MetroMessage;
import com.solum.aims.msp.property.IntegrationProperties;
import com.solum.aims.msp.util.KeyGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

@Slf4j
@Component
public class FileBackupProcessTasklet implements Tasklet, InitializingBean {

	@Autowired
	private IntegrationProperties properties;
	
	@Override
	public void afterPropertiesSet() throws Exception {}

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
		MetroMessage metroMessage = (MetroMessage) chunkContext
													.getStepContext()
													.getStepExecution()
													.getJobExecution()
													.getExecutionContext()
													.get("MetroMessage");
		
		File messageFile = new File(metroMessage.getMessageFilePath());
		File infoFile = new File(metroMessage.getStartPath());
		
		if(properties.getFile().getBackup().isEnable() == false) {
			
			log.info("Deleting file : {}, {}", messageFile.getName(), infoFile.getName());
			
			FileUtils.deleteQuietly(messageFile);
			FileUtils.deleteQuietly(infoFile);
		} else {
			String destPath = 
					properties.getFile().getBackup().getPath().toString() + "/" + KeyGenerator.getKeyByDateFormat() + ".";
			
			log.info("Moving backup director with prefix({}) : {}, {}"
					, destPath
					, messageFile.getName()
					, infoFile.getName());
			
			FileUtils.moveFile(messageFile, new File(destPath + messageFile.getName()));
			FileUtils.moveFile(infoFile, new File(destPath + infoFile.getName()));
		}
		
		return RepeatStatus.FINISHED;
	}
}
