package com.solum.aims.msp.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(basePackages = {
		"com.solum.aims.msp.persistence.repository" }, entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager")
public class DataSourceConfig {

	@Value("${database.platform}")
	private String dataSourcPlatform;

	@Value("${database.ip}")
	private String dataSourceIp;

	@Value("${database.port:}")
	private String dataSourcePort;

	@Value("${database.msp.name}")
	private String dataSourceName;

	@Value("${msp.maximum.connection.pool}")
	private Integer maximumConnectionPool;

	@Value("${msp.idle.timeout}")
	private Integer idleTimeout;

	@Value("${msp.minimum.idle}")
	private Integer minimumIdle;
	@Value("${msp.connection.timeout}")
	private Integer connectionTimeout;
	@Autowired
	private HibernateJpaVendorAdapter aimsVenderAdapter;
	
	@Autowired
	private Properties aimsJpaProperties;

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {

		DatabasePlatform databasePlatform = DatabasePlatform.getFromDialect(dataSourcPlatform);


		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName(databasePlatform.getDriverClassName());

		dataSource.setJdbcUrl(String.format(databasePlatform.getDataSourceUrl(), dataSourceIp,
				dataSourcePort.isEmpty() == false ? dataSourcePort : String.valueOf(databasePlatform.getPort()),
				dataSourceName));

		((HikariDataSource) dataSource).setMaximumPoolSize(maximumConnectionPool);
		((HikariDataSource) dataSource).setIdleTimeout(idleTimeout);
		dataSource.setMinimumIdle(minimumIdle);
		((HikariDataSource) dataSource).setConnectionTimeout(connectionTimeout);

		return dataSource;
	}

	@Bean @Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan(new String[] {"com.solum.aims.msp.persistence.entity"});
	
		factory.setJpaVendorAdapter(aimsVenderAdapter);
		factory.setJpaProperties(aimsJpaProperties);
	
		return factory;
	}
	
	@Bean @Primary
	public PlatformTransactionManager transactionManager() {
		EntityManagerFactory factory = entityManagerFactory().getObject();
		return new JpaTransactionManager(factory);
	}

}
