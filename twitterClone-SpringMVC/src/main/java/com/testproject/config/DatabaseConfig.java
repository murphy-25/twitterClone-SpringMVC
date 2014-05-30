package com.testproject.config;

import com.testproject.services.LoginServiceImpl;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import javax.sql.DataSource;

@Component
@ComponentScan(basePackages = "com.testproject")
@EnableWebMvc
@PropertySource("/WEB-INF/db.properties")
public class DatabaseConfig {
    @Value("${db.driverClassName}")private String driverClassName;
    @Value("${db.databaseUrl}")private String databaseUrl;
    @Value("${db.databaseUsername}")private String databaseUsername;
    @Value("${db.databasePassword}")private String databasePassword;

    @Bean
    public LoginServiceImpl loginServiceImpl() {
        LoginServiceImpl ls = new LoginServiceImpl();
        ls.setDataSource(dataSource());
        return ls;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(databaseUrl);
        dataSource.setUsername(databaseUsername);
        dataSource.setPassword(databasePassword);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }
}
