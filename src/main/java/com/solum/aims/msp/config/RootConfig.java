package com.solum.aims.msp.config;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.ICSVParser;
import com.solum.aims.msp.property.ApplicationProperties;
import com.solum.aims.msp.util.AimsObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Configuration
@PropertySources({
		@PropertySource(value="file:${aims.root.path}/env/aims.properties"),
		@PropertySource(value="file:${aims.root.path}/env/aims.metro.properties")
})
@ImportResource("classpath:/metro-integration.xml")
public class RootConfig {

	@Autowired
	private ApplicationProperties properties;

	@Bean
	public String aimsMspVersion(@Value("${aims.msp.version:DevelopVersion}") String version) {
		return version;
	}

	@Bean
	public String aimsMspRevision(@Value("${aims.msp.revision:DevelopRevision}") String revision) {
		return revision;
	}

	@Bean
	public CSVParser csvParserM1() {
		return new CSVParserBuilder()
				.withSeparator(',')
				.withQuoteChar(ICSVParser.DEFAULT_QUOTE_CHARACTER)
				.withEscapeChar('|')
//				.withEscapeChar(ICSVParser.DEFAULT_ESCAPE_CHARACTER)
				.withStrictQuotes(ICSVParser.DEFAULT_STRICT_QUOTES)
				.withIgnoreLeadingWhiteSpace(ICSVParser.DEFAULT_IGNORE_LEADING_WHITESPACE)
				.withIgnoreQuotations(ICSVParser.DEFAULT_IGNORE_QUOTATIONS)
				.withFieldAsNull(ICSVParser.DEFAULT_NULL_FIELD_INDICATOR)
				.withErrorLocale(Locale.getDefault())
				.build();
	}

	@Bean
	public CSVParser csvParserI1() {
		return new CSVParserBuilder()
				.withSeparator('')
				.withQuoteChar(ICSVParser.DEFAULT_QUOTE_CHARACTER)
				.withEscapeChar(ICSVParser.DEFAULT_ESCAPE_CHARACTER)
				.withStrictQuotes(ICSVParser.DEFAULT_STRICT_QUOTES)
				.withIgnoreLeadingWhiteSpace(ICSVParser.DEFAULT_IGNORE_LEADING_WHITESPACE)
				.withIgnoreQuotations(true)
				.withFieldAsNull(ICSVParser.DEFAULT_NULL_FIELD_INDICATOR)
				.withErrorLocale(Locale.getDefault())
				.build();
	}

	@Bean
	public AimsObjectMapper objectMapper() {
		return new AimsObjectMapper();
	}

	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		return new MappingJackson2HttpMessageConverter(objectMapper());
	}

	@Bean
	public RestTemplate restTemplate() {
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		messageConverters.add(mappingJackson2HttpMessageConverter());

		return new RestTemplate(messageConverters);
	}

	@Bean
	public String aimsUrl() {
		if(null == properties.getConnectionAims().getPort() || properties.getConnectionAims().getPort().isEmpty()) {
			return new StringBuilder(properties.getConnectionAims().getSchema())
					.append("://").append(properties.getConnectionAims().getHostName())
					.toString();
		} else {
			return new StringBuilder(properties.getConnectionAims().getSchema())
					.append("://").append(properties.getConnectionAims().getHostName())
					.append(":").append(properties.getConnectionAims().getPort())
					.append(properties.getConnectionAims().getPath())
					.toString();
		}
	}

	@Bean
	public String mspUrl() {
		if(null == properties.getConnectionMsp().getPort() || properties.getConnectionMsp().getPort().isEmpty()) {
			return new StringBuilder(properties.getConnectionMsp().getSchema())
					.append("://").append(properties.getConnectionMsp().getHostName())
					.append("/endpointType/input/dataProvider/esl/dataSource/solum")
					.toString();
		} else {
			return new StringBuilder(properties.getConnectionMsp().getSchema())
					.append("://").append(properties.getConnectionMsp().getHostName())
					.append(":").append(properties.getConnectionMsp().getPort())
					.append("/endpointType/input/dataProvider/esl/dataSource/solum")
					.toString();
		}
	}
	
	@Bean
	public HibernateJpaVendorAdapter aimsVenderAdapter() {
		HibernateJpaVendorAdapter venderAdapter = new HibernateJpaVendorAdapter();
		venderAdapter.setGenerateDdl(false);
		venderAdapter.setShowSql(false);
		return venderAdapter;
	}
}
