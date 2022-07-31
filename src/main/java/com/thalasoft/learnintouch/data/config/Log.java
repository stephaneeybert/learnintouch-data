package com.thalasoft.learnintouch.data.config;

import java.io.IOException;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.net.SMTPAppender;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.FileAppender;
import ch.qos.logback.core.rolling.RollingFileAppender;

@Configuration
public class Log {

	private final static String PATTERN = "%date %-5level [%thread] %logger{36} %m%n %rEx";
	
	@Bean 
    public static LoggerContext loggerContext() {
        return (LoggerContext) LoggerFactory.getILoggerFactory();
    }

	@Bean (initMethod = "start", destroyMethod = "stop")
    public static PatternLayoutEncoder encoder (LoggerContext ctx) {
        PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setContext(ctx);
        encoder.setPattern(PATTERN);
        return encoder;
    }
	
	@Bean (initMethod = "start", destroyMethod = "stop")
    public static ConsoleAppender consoleAppender (LoggerContext loggerContext, PatternLayoutEncoder encoder) {
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setContext(loggerContext);
        consoleAppender.setEncoder(encoder);
        return consoleAppender;
    }
    
	@Bean (initMethod = "start", destroyMethod = "stop")
    public static FileAppender fileAppender(LoggerContext loggerContext, PatternLayoutEncoder encoder) throws IOException {
        RollingFileAppender fileAppender = new RollingFileAppender();
        fileAppender.setContext(loggerContext);
        fileAppender.setEncoder(encoder);
        fileAppender.setFile("build.log");
        return fileAppender;
    }

	@Bean (initMethod = "start", destroyMethod = "stop")
    public static SMTPAppender mailAppender(LoggerContext context) {
        SMTPAppender mailAppender = new SMTPAppender();
        mailAppender.setContext(context);
        mailAppender.setName("GmailAppender");
        mailAppender.setSMTPHost("smtp.gmail.com");
        mailAppender.setSMTPPort(465); // 587
        mailAppender.setSTARTTLS(true);
        mailAppender.setUsername("stephanethetechie@gmail.com");
        mailAppender.setPassword("xxxxxx");
        mailAppender.setFrom("stephanethetechie@gmail.com");
        mailAppender.addTo("stephanethetechie@gmail.com");
        mailAppender.setSubject("[LOG] Java - learnintouch");
        PatternLayout patternLayout = new PatternLayout();
        patternLayout.setPattern(PATTERN);
        mailAppender.setLayout(patternLayout);
        return mailAppender;
    }

    @Bean
    public static Logger registerThalasoftLogger(LoggerContext loggerContext, ConsoleAppender consoleAppender, FileAppender fileAppender) throws IOException {
    	Logger logger = loggerContext.getLogger("com.thalasoft");
        logger.setLevel(Level.DEBUG); // Display the application loggers
        logger.addAppender(consoleAppender);
        logger.addAppender(fileAppender);
        return logger;
    }
    
    @Bean
    public static Logger registerSpringLogger(LoggerContext loggerContext, ConsoleAppender consoleAppender) {
    	Logger logger = loggerContext.getLogger("org.springframework");
    	logger.setLevel(Level.OFF);
    	logger.addAppender(consoleAppender);
    	return logger;
    }
    
    @Bean
    public static Logger registerJdbcSqlOnlyLogger(LoggerContext loggerContext, ConsoleAppender consoleAppender, FileAppender fileAppender) throws IOException {
    	Logger logger = loggerContext.getLogger("jdbc.sqlonly");
        logger.setLevel(Level.DEBUG); // Display the sql statements with their parameters values
        logger.addAppender(consoleAppender);
        logger.addAppender(fileAppender);
        return logger;
    }

    @Bean
    public static Logger registerHibernateTypeLogger(LoggerContext loggerContext, ConsoleAppender consoleAppender) {
    	Logger logger = loggerContext.getLogger("org.hibernate.type");
        logger.setLevel(Level.OFF);
        logger.addAppender(consoleAppender);
        return logger;
    }
    
    @Bean
    public static Logger registerHibernateSqlLogger(LoggerContext loggerContext, ConsoleAppender consoleAppender) {
    	Logger logger = loggerContext.getLogger("org.hibernate.SQL");
        logger.setLevel(Level.OFF);
        logger.addAppender(consoleAppender);
        return logger;
    }

    @Bean
    public static Logger registerLog4JdbcLogger(LoggerContext loggerContext, ConsoleAppender consoleAppender) throws IOException {
    	Logger logger = loggerContext.getLogger("log4jdbc.debug");
        logger.setLevel(Level.OFF);
        logger.addAppender(consoleAppender);
        return logger;
    }

}
