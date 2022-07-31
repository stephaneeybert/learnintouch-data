package com.thalasoft.learnintouch.data.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.thalasoft.learnintouch.data.condition.DbMySQL;
import com.thalasoft.learnintouch.data.condition.EnvPreProd;

@EnvPreProd
@DbMySQL
@Configuration
@PropertySource({ "classpath:mysql/data-source-preprod.properties" })
public class DatabaseMySQLPreProdProperties extends AbstractDatabaseProperties {

	private static Logger logger = LoggerFactory.getLogger(DatabaseMySQLPreProdProperties.class);

	public DatabaseMySQLPreProdProperties() {
    logger.debug("===========>> Loading the classpath mysql/data-source-preprod.properties file");
	}
	
}
