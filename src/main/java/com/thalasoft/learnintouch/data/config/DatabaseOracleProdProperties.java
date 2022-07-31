package com.thalasoft.learnintouch.data.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.thalasoft.learnintouch.data.condition.DbOracle;
import com.thalasoft.learnintouch.data.condition.EnvProd;

@EnvProd
@DbOracle
@Configuration
@PropertySource({ "classpath:oracle/data-source-prod.properties" })
public class DatabaseOracleProdProperties extends AbstractDatabaseProperties {

	private static Logger logger = LoggerFactory.getLogger(DatabaseOracleProdProperties.class);

	public DatabaseOracleProdProperties() {
		logger.debug("===========>> Loading the classpath oracle/data-source-prod.properties file");
	}

}
