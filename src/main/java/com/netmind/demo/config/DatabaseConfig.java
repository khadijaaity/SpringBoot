package com.netmind.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DatabaseConfig {

	static final Logger logger = LoggerFactory.getLogger(DatabaseConfig.class);

	private String url;
	private String username;
	private String password;
	private String driverClassName;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Profile("dev")
	@Bean
	public String devDatabaseConnection() {
		logger.info(url);
		logger.info(username);
		logger.info(password);
		logger.info(driverClassName);
		return url;
	}

	@Profile("pro")
	@Bean
	public String prodDatabaseConnection() {
		logger.info(url);
		logger.info(username);
		logger.info(password);
		logger.info(driverClassName);
		return url;
	}
}
