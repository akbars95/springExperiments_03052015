package com.mtsmda.springCore.java;

import com.mtsmda.springCore.HelloWorldService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by MTSMDA on 15.05.2015.
 */
public class RunAppJavaConfig {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppJavaConfig.class);
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService5");
        System.out.println(helloWorldService.sayHello());

        Person person = (Person) applicationContext.getBean("personPetrov");
        System.out.println(person);

    }

}
