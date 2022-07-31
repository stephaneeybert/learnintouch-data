package com.thalasoft.learnintouch.data.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.thalasoft.learnintouch.data.condition.DbMySQL;
import com.thalasoft.learnintouch.data.condition.EnvAcceptance;

@EnvAcceptance
@DbMySQL
@Configuration
@PropertySource({ "classpath:mysql/data-source-acceptance.properties" })
public class DatabaseMySQLAcceptanceProperties extends AbstractDatabaseProperties {

	private static Logger logger = LoggerFactory.getLogger(DatabaseMySQLAcceptanceProperties.class);

	public DatabaseMySQLAcceptanceProperties() {
    logger.debug("===========>> Loading the classpath mysql/data-source-acceptance.properties file");
	}
	
}
