package com.thalasoft.learnintouch.data.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.thalasoft.learnintouch.data.condition.DbH2;
import com.thalasoft.learnintouch.data.condition.EnvTest;

@EnvTest
@DbH2
@Configuration
@PropertySource({ "classpath:h2/data-source-test.properties" })
public class DatabaseH2TestProperties extends AbstractDatabaseProperties {

  private static Logger logger = LoggerFactory.getLogger(DatabaseH2TestProperties.class);

  public DatabaseH2TestProperties() {
    logger.debug("===========>> Loading the classpath h2/data-source-test.properties file");
  }
  
}
