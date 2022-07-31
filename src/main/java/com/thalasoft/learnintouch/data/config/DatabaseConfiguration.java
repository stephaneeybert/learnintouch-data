package com.thalasoft.learnintouch.data.config;

import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ch.qos.logback.ext.spring.ApplicationContextHolder;

import com.mchange.v2.c3p0.ComboPooledDataSource;
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
import com.thalasoft.toolbox.spring.PackageBeanNameGenerator;

@Configuration
@EnableTransactionManagement
@ComponentScan(nameGenerator = PackageBeanNameGenerator.class, basePackages = { "com.thalasoft.learnintouch.data.config" })
@EnableJpaRepositories(basePackages = { "com.thalasoft.learnintouch.data.jpa" }, repositoryFactoryBeanClass  = com.thalasoft.learnintouch.data.jpa.repository.GenericRepositoryFactoryBean.class)
public class DatabaseConfiguration {

//	private HikariConfig hikariConfig;
	
    @Autowired
    private DatabaseProperties databaseProperties;

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(databaseProperties.getHibernateDriverClassName());
        dataSource.setJdbcUrl(databaseProperties.getDataSourceUrl());
        dataSource.setUser(databaseProperties.getDataSourceUsername());
        dataSource.setPassword(databaseProperties.getDataSourcePassword());
        dataSource.setAcquireIncrement(5);
        dataSource.setMaxStatementsPerConnection(20);
        dataSource.setMaxStatements(100);
        dataSource.setMinPoolSize(2);
        dataSource.setMaxPoolSize(5);
        return dataSource;
    }

//    @Bean
//    public HikariConfig hikariConfig() {
//    	HikariConfig hikariConfig = new HikariConfig();
//    	hikariConfig.setMaximumPoolSize(5);
//    	hikariConfig.setDataSourceClassName(databaseProperties.getHibernateDriverClassName());
//    	hikariConfig.addDataSourceProperty("url", databaseProperties.getDataSourceUrl());
//    	hikariConfig.addDataSourceProperty("user", databaseProperties.getDataSourceUsername());
//    	hikariConfig.addDataSourceProperty("password", databaseProperties.getDataSourcePassword());
//    	return hikariConfig;
//    }
    
//    @Bean
//    public DataSource dataSource() {
////	    HikariDataSource dataSource = new HikariDataSource();
////	    dataSource.setMaximumPoolSize(5);
////	    dataSource.setDataSourceClassName(databaseProperties.getHibernateDriverClassName());
////	    dataSource.addDataSourceProperty("serverName", databaseProperties.getDataSourceUrl());
////	    dataSource.addDataSourceProperty("user", databaseProperties.getDataSourceUsername());
////	    dataSource.addDataSourceProperty("password", databaseProperties.getDataSourcePassword());    
//    	HikariDataSource dataSource = new HikariDataSource(hikariConfig);
//	    return dataSource;
//    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws PropertyVetoException {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabasePlatform(databaseProperties.getHibernateDialect());
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setGenerateDdl(false);

        Map<String, String> jpaPropertiesMap = new HashMap<String, String>();
        jpaPropertiesMap.put("hibernate.dialect", databaseProperties.getHibernateDialect());
        jpaPropertiesMap.put("hibernate.use_sql_comments", "true");
        jpaPropertiesMap.put("hibernate.show_sql", "false");
        jpaPropertiesMap.put("hibernate.format_sql", "true");
        jpaPropertiesMap.put("hibernate.hbm2ddl.auto", databaseProperties.getHibernateHbm2ddlAuto());
        jpaPropertiesMap.put("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");
        jpaPropertiesMap.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
        jpaPropertiesMap.put("hibernate.c3p0.min_size", "5");
        jpaPropertiesMap.put("hibernate.c3p0.max_size", "20");
        jpaPropertiesMap.put("hibernate.c3p0.timeout", "1000");
        jpaPropertiesMap.put("hibernate.c3p0.max_statements", "50");
        jpaPropertiesMap.put("hibernate.ejb.interceptor", "com.thalasoft.learnintouch.data.jpa.AuditLogInterceptor");
        
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setPackagesToScan("com.thalasoft.learnintouch.data.jpa.domain");
        factoryBean.setJpaPropertyMap(jpaPropertiesMap);
        String[] mappingsResources = new String[] {"typedef.hbm.xml"};        
        factoryBean.setMappingResources(mappingsResources);
        factoryBean.setDataSource(dataSource());
        return factoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        try {
            transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        } catch (Exception x) {
            throw new RuntimeException(x);
        }
        return transactionManager;
    }

    @Bean 
    public HibernateExceptionTranslator hibernateExceptionTranslator(){ 
      return new HibernateExceptionTranslator(); 
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
       return new PropertySourcesPlaceholderConfigurer();
    }
    
    @Bean
    public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
    	return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public ApplicationContextHolder applicationContextHolder() {
    	return new ApplicationContextHolder();
    }
    
}
