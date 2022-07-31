package com.thalasoft.learnintouch.data.config;

import org.springframework.beans.factory.annotation.Value;

public abstract class AbstractDatabaseProperties implements DatabaseProperties {

  @Value("${" + PropertyNames.CONFIG_HIBERNATE_DIALECT + "}")
  private String hibernateDialect;
  @Value("${" + PropertyNames.CONFIG_HIBERNATE_HBM2DDL_AUTO + "}")
  private String hibernateHbm2ddlAuto;
  @Value("${" + PropertyNames.CONFIG_DATA_SOURCE_DRIVER + "}")
  private String hibernateDriverClassName;
  @Value("${" + PropertyNames.CONFIG_DATA_SOURCE_URL + "}")
  private String dataSourceUrl;
  @Value("${" + PropertyNames.CONFIG_DATA_SOURCE_USERNAME + "}")
  private String dataSourceUsername;
  @Value("${" + PropertyNames.CONFIG_DATA_SOURCE_PASSWORD + "}")
  private String dataSourcePassword;

  public String getHibernateDialect() {
    return hibernateDialect;
  }

  public String getHibernateHbm2ddlAuto() {
    return hibernateHbm2ddlAuto;
  }

  public String getHibernateDriverClassName() {
    return hibernateDriverClassName;
  }

  public String getDataSourceUrl() {
    return dataSourceUrl;
  }

  public String getDataSourceUsername() {
    return dataSourceUsername;
  }

  public String getDataSourcePassword() {
    return dataSourcePassword;
  }

}
