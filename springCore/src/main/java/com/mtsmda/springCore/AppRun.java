package com.mtsmda.springCore;

import com.mtsmda.springCore.SpEL.*;
import com.mtsmda.springCore.SpEL.annotation.AuthorBean;
import com.mtsmda.springCore.SpEL.annotation.BookBean;
import com.mtsmda.springCore.autowire.Car;
import com.mtsmda.springCore.autowire.Dog;
import com.mtsmda.springCore.autowire.Elephant;
import com.mtsmda.springCore.autowire.Frog;
import com.mtsmda.springCore.autowire.annotation.Tiger;
import com.mtsmda.springCore.collectionMerging.PersonCM;
import com.mtsmda.springCore.java.Person;
import com.mtsmda.springCore.properties.DBConfig;
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
        /*springDateInject(applicationContext);*/
        springProperties(applicationContext);
        springInheritance(applicationContext);
        double c = 7;
        Object ob = c;
        System.out.println(ob.getClass().getCanonicalName());
        springRequired(applicationContext);
        springProperties2(applicationContext);
        springLivecycle(applicationContext);
        springCollectionMerging(applicationContext);
        springAutowire(applicationContext);
        springSpEL(applicationContext);
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

    private static void springDateInject(ApplicationContext applicationContext) {
        SpringDateInject springDateInject = (SpringDateInject) applicationContext.getBean("springDateInject");
        System.out.println(springDateInject.getDate());
    }

    private static void springProperties(ApplicationContext applicationContext) {
        SpringProperties springProperties = (SpringProperties) applicationContext.getBean("springProperties");
        System.out.println(springProperties.getCountry() + " - " + springProperties.getCity());
    }

    private static void springInheritance(ApplicationContext applicationContext) {
        SpringInheritanceAnimal springInheritanceAnimal = (SpringInheritanceAnimal) applicationContext.getBean("animal");
        System.out.println(springInheritanceAnimal.getAnimalColor() + " - " + springInheritanceAnimal.getAnimalName() + " - " + springInheritanceAnimal.getAnimalType());

        SpringInheritanceAnimal springInheritanceAnimalCat = (SpringInheritanceAnimal) applicationContext.getBean("catAnimal");
        System.out.println(springInheritanceAnimalCat.getAnimalColor() + " - " + springInheritanceAnimalCat.getAnimalName() + " - " + springInheritanceAnimalCat.getAnimalColor());

        SpringInheritanceAnimalAbstract springInheritanceAnimalCatAbstract = (SpringInheritanceAnimalAbstract) applicationContext.getBean("catAnimalAbstract");
        System.out.println(springInheritanceAnimalCatAbstract.getAnimalColor() + " - " + springInheritanceAnimalCatAbstract.getAnimalName() + " - " + springInheritanceAnimalCatAbstract.getAnimalColor());
    }

    private static void springRequired(ApplicationContext applicationContext) {
        com.mtsmda.springCore.required.Person person = (com.mtsmda.springCore.required.Person) applicationContext.getBean("person");
        System.out.println(person);
    }

    private static void springProperties2(ApplicationContext applicationContext) {
        /*DBConfig dbConfig = (DBConfig) applicationContext.getBean("dbConfig");
        System.out.println(dbConfig);*/
    }

    private static void springLivecycle(ApplicationContext applicationContext) {
        SpringLivecycle springLivecycle = (SpringLivecycle) applicationContext.getBean("springLivecycle");
        System.out.println(springLivecycle);

        SpringLivecycle springLivecycle1 = new SpringLivecycle();
        springLivecycle1.setName("Ivan");
        springLivecycle1.setPrice(new Double(19.8));
        System.out.println(springLivecycle1);
    }

    private static void springCollectionMerging(ApplicationContext applicationContext) {
        PersonCM personCM = (PersonCM) applicationContext.getBean("personCM");
        System.out.println(personCM);
        System.out.println(personCM.getAddressCMList().size());
    }

    private static void springAutowire(ApplicationContext applicationContext) {
        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car);

        Dog dog = (Dog) applicationContext.getBean("dog");
        System.out.println(dog);

        /*Elephant elephant = (Elephant) applicationContext.getBean("elephant");
        System.out.println(elephant);*/

        Frog frog = (Frog) applicationContext.getBean("frog");
        System.out.println(frog);

        Tiger tiger = (Tiger) applicationContext.getBean("tiger");
        System.out.println(tiger);

        Tiger tiger2 = (Tiger) applicationContext.getBean("tiger2");
        System.out.println(tiger);
    }

    private static void springSpEL(ApplicationContext applicationContext){
        Author author = (Author)applicationContext.getBean("author");
        System.out.println(author);

        BookBean bookBean = (BookBean)applicationContext.getBean("BookBean");
        System.out.println(bookBean);

        AuthorBean authorBean = (AuthorBean)applicationContext.getBean("AuthorBean");
        System.out.println(authorBean);

        Author authorNew = (Author)applicationContext.getBean("authorNew");
        System.out.println(authorNew.getBookInfo());

        Numbers numbers = (Numbers)applicationContext.getBean("numbers");
        System.out.println(numbers);

        System.out.println("\n");

        Operators operators = (Operators)applicationContext.getBean("operators");
        System.out.println(operators);

        TernaryOperator ternaryOperator = (TernaryOperator)applicationContext.getBean("ternaryOperator");
        System.out.println(ternaryOperator);

        ListMapTest listMapTest = (ListMapTest)applicationContext.getBean("listMapTest");
        System.out.println(listMapTest);

        ListMapTestReal listMapTestReal = (ListMapTestReal) applicationContext.getBean("listMapTestReal");
        System.out.println(listMapTestReal);


        ExpressionParserApp expressionParserApp = new ExpressionParserApp();

    }
}