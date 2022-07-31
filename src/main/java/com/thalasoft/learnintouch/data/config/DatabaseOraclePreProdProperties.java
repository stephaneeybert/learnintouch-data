package com.thalasoft.learnintouch.data.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.thalasoft.learnintouch.data.condition.DbOracle;
import com.thalasoft.learnintouch.data.condition.EnvPreProd;

@EnvPreProd
@DbOracle
@Configuration
@PropertySource({ "classpath:oracle/data-source-preprod.properties" })
public class DatabaseOraclePreProdProperties extends AbstractDatabaseProperties {

	private static Logger logger = LoggerFactory.getLogger(DatabaseOraclePreProdProperties.class);

	public DatabaseOraclePreProdProperties() {
		logger.debug("===========>> Loading the classpath oracle/data-source-preprod.properties file");
	}

}
