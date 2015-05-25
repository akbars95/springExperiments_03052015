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

        System.out.println(applicationContext.getBean("PersonAddressP").toString());

        scopeSpringRun(applicationContext);
        collectionSpringRun(applicationContext);
        springCollectionsCreaterRun(applicationContext);
    }

    private static void scopeSpringRun(ApplicationContext applicationContext) {
        SpringSingleton springSingleton = (SpringSingleton) applicationContext.getBean("springSingleton");
        System.out.println(springSingleton.getCarModel());

        SpringPrototype springPrototype = (SpringPrototype) applicationContext.getBean("springPrototype");
        System.out.println(springPrototype.getCarMarka());
    }

    private static void collectionSpringRun(ApplicationContext applicationContext) {
        SpringCollections springCollections = (SpringCollections) applicationContext.getBean("springCollections");
        System.out.println(springCollections.getAbbreviationAndFullName().getClass().getCanonicalName() + " - " + springCollections.getAbbreviationAndFullName());
        System.out.println(springCollections.getDbProperties().getClass().getCanonicalName() + " - " + springCollections.getDbProperties());
        System.out.println(springCollections.getFootbalClubNames().getClass().getCanonicalName() + " - " + springCollections.getFootbalClubNames());
        System.out.println(springCollections.getListCountries().getClass().getCanonicalName() + " - " + springCollections.getListCountries());
    }

    private static void springCollectionsCreaterRun(ApplicationContext applicationContext) {
        SpringCollectionsCreater springCollectionsCreater = (SpringCollectionsCreater) applicationContext.getBean("springCollectionsCreater");
        System.out.println(springCollectionsCreater.getList());
        System.out.println(springCollectionsCreater.getSet());
        System.out.println(springCollectionsCreater.getMap());
        System.out.println("_____");
        SpringCollectionsCreater springCollectionsCreaterAlter = (SpringCollectionsCreater) applicationContext.getBean("springCollectionsCreaterAlter");
        System.out.println(springCollectionsCreaterAlter.getList());
        System.out.println(springCollectionsCreaterAlter.getSet());
        System.out.println(springCollectionsCreaterAlter.getMap());

    }

}