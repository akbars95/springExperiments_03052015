package com.mtsmda.springCore.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by MTSMDA on 15.05.2015.
 */
@Configuration
public class ConfigurationJavaPerson {

    @Bean(name = "personPetrov")
    public Person getPerson(){
        Person person = new Person();
        person.setFirstName("Petr");
        person.setLastName("Petrov");

        return person;
    }

}
