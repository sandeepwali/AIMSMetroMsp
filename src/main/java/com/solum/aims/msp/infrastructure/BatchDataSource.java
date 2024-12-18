package com.solum.aims.msp.infrastructure;

import lombok.Getter;
import lombok.Setter;

import javax.sql.DataSource;

@Setter @Getter
public class BatchDataSource {

	private DataSource dataSource;
	private boolean isEmbedded;
}
