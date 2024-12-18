package com.solum.aims.msp.infrastructure.batch;

import com.solum.aims.msp.infrastructure.BatchJobRepositoryFactoryBean;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.repository.dao.AbstractJdbcBatchMetadataDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
public class BatchJobRepositoryUtils extends AbstractJdbcBatchMetadataDao {

	public BatchJobRepositoryUtils(BatchJobRepositoryFactoryBean jobRepositoryFactory) {
		super.setJdbcTemplate(new JdbcTemplate(jobRepositoryFactory.getDataSource()));
		super.setTablePrefix(jobRepositoryFactory.getTablePrefix().toString());
	}

	@Transactional(propagation= Propagation.REQUIRES_NEW)
	public void purgeJobExecutions() {
		try {
			getJdbcTemplate().queryForList(getQuery("SELECT job_execution_id, job_instance_id FROM %PREFIX%job_execution WHERE end_time IS NOT null")).forEach(mapEntry -> {
				long jobExecutionId = (long) mapEntry.get("job_execution_id");
				long jobInstanceId = (long) mapEntry.get("job_instance_id");

				getJdbcTemplate().update(getQuery(Purge.STEP_EXECUTION_CONTEXT.getSql()), jobExecutionId);
				getJdbcTemplate().update(getQuery(Purge.STEP_EXECUTION.getSql()), jobExecutionId);
				getJdbcTemplate().update(getQuery(Purge.JOB_EXECUTION_CONTEXT.getSql()), jobExecutionId);
				getJdbcTemplate().update(getQuery(Purge.JOB_EXECUTION_PARAMS.getSql()), jobExecutionId);
				getJdbcTemplate().update(getQuery(Purge.JOB_EXECUTION.getSql()), jobExecutionId);
				getJdbcTemplate().update(getQuery(Purge.JOB_INSTANCE.getSql()), jobInstanceId);
			});
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	private enum Purge {
		STEP_EXECUTION_CONTEXT("DELETE FROM %PREFIX%step_execution_context WHERE step_execution_id in (SELECT step_execution_id FROM %PREFIX%step_execution WHERE job_execution_id=?)"),
		STEP_EXECUTION("DELETE FROM %PREFIX%step_execution WHERE job_execution_id=?"),
		JOB_EXECUTION_CONTEXT("DELETE FROM %PREFIX%job_execution_context WHERE job_execution_id=?"),
		JOB_EXECUTION_PARAMS("DELETE FROM %PREFIX%job_execution_params WHERE job_execution_id=?"),
		JOB_EXECUTION("DELETE FROM %PREFIX%job_execution WHERE job_execution_id=?"),
		JOB_INSTANCE("DELETE FROM %PREFIX%job_instance WHERE job_instance_id=?");

		@Getter
		private String sql;

		private Purge(String sql) {
			this.sql = sql;
		}
	}
}
