package com.solum.aims.msp.infrastructure.batch.task;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.solum.aims.msp.message.MetroMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Locale;

@Slf4j
@Component
public class ProcessingM1Tasklet implements Tasklet, InitializingBean {

	@Autowired
	private CSVParser csvParserM1;
	
	@Override
	public void afterPropertiesSet() throws Exception {}

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
		String messageFilePath = (String) chunkContext.getStepContext().getJobParameters().get("m1FilePath");
		
		BufferedReader messageFileBufferedReader = 
				new BufferedReader(new InputStreamReader(new FileInputStream(messageFilePath),"UTF8"));
		
		CSVReader messageFileCsvReader = new CSVReaderBuilder(messageFileBufferedReader)
				.withSkipLines(CSVReader.DEFAULT_SKIP_LINES)
				.withCSVParser(csvParserM1)
				.withKeepCarriageReturn(CSVReader.DEFAULT_KEEP_CR)
				.withVerifyReader(CSVReader.DEFAULT_VERIFY_READER)
				.withMultilineLimit(CSVReader.DEFAULT_MULTILINE_LIMIT)
				.withErrorLocale(Locale.getDefault())
				.build();
		
		String [] values = messageFileCsvReader.readNext();
		if(null != values && values.length == 5) {
			MetroMessage metroMessage = new MetroMessage();
			metroMessage.setMessageFilePath(messageFilePath);
			
			metroMessage.setPfiMessage(values[0].toUpperCase());
			metroMessage.setSign(values[1]);
			metroMessage.setDataPath(values[2]);
			metroMessage.setStartPath(values[3]);
			metroMessage.setAnswerPath(values[4]);
			
			log.info("MetroMessage : [{}]", metroMessage.toString());
			
			chunkContext
				.getStepContext()
				.getStepExecution()
				.getJobExecution()
				.getExecutionContext()
				.put("MetroMessage", metroMessage);
			
			chunkContext
				.getStepContext()
				.getStepExecution()
				.getJobExecution()
				.getExecutionContext()
				.putString("pfiMessageType", metroMessage.getPfiMessage().toString());
		} else {
			log.warn("The message file({}) is not valid.[{}]", messageFilePath, values);
			
			contribution.getStepExecution().setTerminateOnly();
//			contribution.getStepExecution().getJobExecution().stop();
			contribution.getStepExecution().getJobExecution().isStopping();
		}
		
		messageFileCsvReader.close();
		
		return RepeatStatus.FINISHED;
	}
}
