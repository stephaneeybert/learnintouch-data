package com.thalasoft.learnintouch.data.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.thalasoft.learnintouch.data.condition.DbOracle;
import com.thalasoft.learnintouch.data.condition.EnvTest;

@EnvTest
@DbOracle
@Configuration
@PropertySource({ "classpath:oracle/data-source-test.properties" })
public class DatabaseOracleTestProperties extends AbstractDatabaseProperties {

  private static Logger logger = LoggerFactory.getLogger(DatabaseOracleTestProperties.class);

  public DatabaseOracleTestProperties() {
    logger.debug("===========>> Loading the classpath oracle/data-source-test.properties file");
  }

}
