package com.mtsmda.config;

import com.mtsmda.dao.ContactDAO;
import com.mtsmda.daoImpl.ContactDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

/**
 * Created by c-DMITMINZ on 6/3/2015.
 */

/*@Configuration
@ComponentScan(basePackages = "com.mtsmda")
@EnableWebMvc*/
public class MVCConfiguration /*extends WebMvcConfigurerAdapter*/{

    /*@Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/views/");
        internalResourceViewResolver.setSuffix(".jsp");

        return internalResourceViewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources*//**").addResourceLocations("/resources/");
    }

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    public ContactDAO getContactDAO(){
        return new ContactDAOImpl(getDataSource());
    }*/

}