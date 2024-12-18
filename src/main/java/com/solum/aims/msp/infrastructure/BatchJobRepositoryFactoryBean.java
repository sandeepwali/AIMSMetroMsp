package com.solum.aims.msp.infrastructure;

import lombok.Getter;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;

import javax.sql.DataSource;

@Getter
public class BatchJobRepositoryFactoryBean extends JobRepositoryFactoryBean {
	private DataSource dataSource;
	private TablePrefix tablePrefix = TablePrefix.DEFAULT;
	
	public BatchJobRepositoryFactoryBean(BatchDataSource dataSource) {
		this.dataSource = dataSource.getDataSource();
		super.setDataSource(this.dataSource);
	}

	public void setTablePrefix(TablePrefix tablePrefix) {
		this.tablePrefix = tablePrefix;
		super.setTablePrefix(this.tablePrefix.toString());
	}
	
	
	@Getter
	public enum TablePrefix {
		DEFAULT("classpath:config/db/hsql/batch-jobrepository.sql"),
		
		BATCH_PROCESSING_M1_("classpath:config/db/hsql/processing-m1-job-repository.sql"),
		BATCH_OUTBOUND_AIMS_("classpath:config/db/hsql/outbound-aims-job-repository.sql"),
		BATCH_OUTBOUND_MSP_("classpath:config/db/hsql/outbound-msp-job-repository.sql");
		
		private String script;
		
		TablePrefix(String script) {
			this.script = script;
		}
	}
}
