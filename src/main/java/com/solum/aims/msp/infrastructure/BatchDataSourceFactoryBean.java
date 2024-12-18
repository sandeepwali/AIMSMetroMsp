package com.solum.aims.msp.infrastructure;

import com.solum.aims.msp.infrastructure.BatchJobRepositoryFactoryBean.TablePrefix;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class BatchDataSourceFactoryBean implements FactoryBean<BatchDataSource>, InitializingBean {

	private BatchDataSource dataSource = new BatchDataSource();
	private List<String> scripts = new ArrayList<>();

	public BatchDataSourceFactoryBean(DataSource dataSource) {
		this.dataSource.setDataSource(dataSource);
		this.scripts.add(TablePrefix.BATCH_PROCESSING_M1_.getScript());
		this.scripts.add(TablePrefix.BATCH_OUTBOUND_AIMS_.getScript());
		this.scripts.add(TablePrefix.BATCH_OUTBOUND_MSP_.getScript());
	}

	public void setEmbedded(boolean isEmbedded) {
		if (isEmbedded == false) {
			return;
		}

		this.dataSource.setDataSource(new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
											.setName("embedded_batch_db")
											.addScripts(this.scripts.toArray(new String[this.scripts.size()]))
											.continueOnError(true)
											.build());
	}
	
	@Override
	public BatchDataSource getObject() throws Exception {
		return this.dataSource;
	}

	@Override
	public Class<BatchDataSource> getObjectType() {
		return BatchDataSource.class;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(this.dataSource, "DataSource must not be null.");
	}
}
