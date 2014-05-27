package com.testproject.config;

import com.testproject.interfaces.LoginService;
import com.testproject.services.LoginServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.testproject")
@EnableWebMvc
    public class WebConfig extends WebMvcConfigurerAdapter{

        @Bean
        public ViewResolver getViewResolver() {
            InternalResourceViewResolver resolver = new InternalResourceViewResolver();
            resolver.setPrefix("/WEB-INF/pages/");
            resolver.setSuffix(".jsp");
            return resolver;
        }

        @Bean
        public LoginService loginService() {
            return new LoginServiceImpl();
        }

        @Bean LocalValidatorFactoryBean validatorFactoryBean() {
            return new LocalValidatorFactoryBean();
        }

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/resources/***").addResourceLocations("/resources/bootstrap").setCachePeriod(31556926);
        }

        @Override
        public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
            configurer.enable();
        }
    }
