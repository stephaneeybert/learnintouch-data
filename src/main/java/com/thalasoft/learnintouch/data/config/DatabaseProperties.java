package com.thalasoft.learnintouch.data.config;

public interface DatabaseProperties {

    public String getHibernateDialect();
    
    public String getHibernateHbm2ddlAuto();

    public String getHibernateDriverClassName();

    public String getDataSourceUrl();

    public String getDataSourceUsername();

    public String getDataSourcePassword();

}
