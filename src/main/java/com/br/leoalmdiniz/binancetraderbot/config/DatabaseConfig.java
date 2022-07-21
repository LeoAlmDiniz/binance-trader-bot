package com.br.leoalmdiniz.binancetraderbot.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ConfigurationProperties(prefix = "ladbinance.database")
public class DatabaseConfig {

	private String url;
	private String driverClassName;
	private String username;
	private String password;
	
	@Bean
	public DataSource dataSource() throws IOException {
		var hikariConfig = new HikariConfig();
		hikariConfig.setJdbcUrl(url);
		hikariConfig.setDriverClassName(driverClassName);
		hikariConfig.setUsername(username);
		hikariConfig.setPassword(password);
		return new HikariDataSource(hikariConfig);	
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
