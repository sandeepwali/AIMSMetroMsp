package com.solum.aims.msp.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.solum.aims.msp.property.OptionalDataSourceProperties;

@Configuration
@EnableJpaRepositories(basePackages = "com.solum.aims.msp.persistence.core.repository", entityManagerFactoryRef = "coreEntityManager", transactionManagerRef = "transactionCoreManager")

public class CoreDataSourceConfig {
	@Autowired
	private OptionalDataSourceProperties optionalDataSourceProperties;

	@Autowired
	private HibernateJpaVendorAdapter aimsVenderAdapter;

	@Autowired
	private Properties aimsJpaProperties;

	@Bean
	@ConfigurationProperties(prefix = "core.datasource")
	public DataSource coreDataSource() {
		DatabasePlatform databasePlatform = DatabasePlatform.getFromDialect(optionalDataSourceProperties.getPlatform());
		return DataSourceBuilder.create().driverClassName(databasePlatform.getDriverClassName())
				.url(String.format(databasePlatform.getDataSourceUrl(),
						optionalDataSourceProperties.getCore().getIp().isEmpty() == false
								? optionalDataSourceProperties.getCore().getIp()
								: optionalDataSourceProperties.getIp(),
						optionalDataSourceProperties.getCore().getPort().isEmpty() == false
								? optionalDataSourceProperties.getCore().getPort()
								: optionalDataSourceProperties.getPort().isEmpty() == false
										? optionalDataSourceProperties.getPort()
										: String.valueOf(databasePlatform.getPort()),
						optionalDataSourceProperties.getCore().getName()))
				.username(optionalDataSourceProperties.getCore().getUsername().isEmpty() == false
						? optionalDataSourceProperties.getCore().getUsername()
						: optionalDataSourceProperties.getUsername())
				.password(optionalDataSourceProperties.getCore().getPassword().isEmpty() == false
						? optionalDataSourceProperties.getCore().getPassword()
						: optionalDataSourceProperties.getPassword())
				.build();
	}

	@Bean
	LocalContainerEntityManagerFactoryBean coreEntityManager() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(coreDataSource());
		factory.setPackagesToScan(new String[] { "com.solum.aims.msp.persistence.core.entity" });
		factory.setJpaVendorAdapter(aimsVenderAdapter);
		factory.setJpaProperties(aimsJpaProperties);

		return factory;
	}

	@Bean("transactionCoreManager")
	public PlatformTransactionManager coreTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(coreEntityManager().getObject());
		return transactionManager;
	}
}