package com.thalasoft.learnintouch.data.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.thalasoft.learnintouch.data.condition.DbMySQL;
import com.thalasoft.learnintouch.data.condition.EnvTest;

@EnvTest
@DbMySQL
@Configuration
@PropertySource({ "classpath:mysql/data-source-test.properties" })
public class DatabaseMySQLTestProperties extends AbstractDatabaseProperties {

  private static Logger logger = LoggerFactory.getLogger(DatabaseMySQLTestProperties.class);

  public DatabaseMySQLTestProperties() {
    logger.debug("===========>> Loading the classpath mysql/data-source-test.properties file");
  }

}
