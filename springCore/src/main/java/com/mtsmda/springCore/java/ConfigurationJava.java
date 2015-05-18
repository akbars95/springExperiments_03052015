package com.mtsmda.springCore.java;

import com.mtsmda.springCore.HelloWorldService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by MTSMDA on 15.05.2015.
 */
@Configuration
public class ConfigurationJava {

    @Bean(name = "helloWorldService5")
    public HelloWorldService helloWorldService(){
        HelloWorldService helloWorldService = new HelloWorldService();
        helloWorldService.setName("Ivanov");
        return helloWorldService;
    }

}
