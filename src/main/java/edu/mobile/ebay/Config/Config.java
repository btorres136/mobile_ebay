package edu.mobile.ebay.Config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class Config {

    @Bean
    public DataSource getDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/mobile_ebay");
        dataSourceBuilder.username("mobile_ebay");
        dataSourceBuilder.password("54896732So7865*");
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        return dataSourceBuilder.build();
    }

    @Bean
    public ViewResolver internalResourcesViewResolver(){
        InternalResourceViewResolver bean =  new InternalResourceViewResolver();
        bean.setPrefix("/WEB-INF/JSP/");
        bean.setSuffix(".jsp");
        return bean;
    }
}