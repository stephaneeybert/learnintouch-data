package com.thalasoft.learnintouch.data.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.thalasoft.learnintouch.data.condition.DbMySQL;
import com.thalasoft.learnintouch.data.condition.EnvProd;

@EnvProd
@DbMySQL
@Configuration
@PropertySource({ "classpath:mysql/data-source-prod.properties" })
public class DatabaseMySQLProdProperties extends AbstractDatabaseProperties {

	private static Logger logger = LoggerFactory.getLogger(DatabaseMySQLProdProperties.class);

	public DatabaseMySQLProdProperties() {
    logger.debug("===========>> Loading the classpath mysql/data-source-prod.properties file");
	}
	
}
