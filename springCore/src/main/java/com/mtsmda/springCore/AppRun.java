package com.mtsmda.springCore;

import com.mtsmda.springCore.java.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by MTSMDA on 13.05.2015.
 */
public class AppRun {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        System.out.println(helloWorldService.sayHello());

        Person person = (Person) applicationContext.getBean("personIvanov");
        System.out.println(person);

        System.out.println(person.getPersonAddress().toString());


    }

}