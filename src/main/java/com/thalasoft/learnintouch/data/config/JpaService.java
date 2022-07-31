package com.thalasoft.learnintouch.data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.thalasoft.learnintouch.data.service.jpa.AdminModuleServiceImpl;
import com.thalasoft.learnintouch.data.service.jpa.AdminServiceImpl;
import com.thalasoft.learnintouch.data.service.jpa.NewsPaperServiceImpl;
import com.thalasoft.learnintouch.data.service.jpa.NewsPublicationServiceImpl;
import com.thalasoft.learnintouch.data.service.jpa.NewsStoryServiceImpl;
import com.thalasoft.learnintouch.data.service.jpa.UserAccountServiceImpl;

@Configuration
public class JpaService {

    @Bean
    public AdminServiceImpl adminService() {
        return new AdminServiceImpl();
    }
    
    @Bean
    public AdminModuleServiceImpl adminModuleService() {
        return new AdminModuleServiceImpl();
    }

    @Bean
    public NewsStoryServiceImpl newsStoryService() {
        return new NewsStoryServiceImpl();
    }
    
    @Bean
    public NewsPaperServiceImpl newsPaperService() {
        return new NewsPaperServiceImpl();
    }
    
    @Bean
    public NewsPublicationServiceImpl newsPublicationService() {
        return new NewsPublicationServiceImpl();
    }
    
    @Bean
    public UserAccountServiceImpl userAccountService() {
        return new UserAccountServiceImpl();
    }

}
