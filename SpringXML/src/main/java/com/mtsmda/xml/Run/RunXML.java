package com.mtsmda.xml.Run;

import com.mtsmda.xml.testingWork.Customer;
import com.mtsmda.xml.testingWork.XMLConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by c-DMITMINZ on 5/20/2015.
 */
public class RunXML {

    private static final String FILE_NAME_XML = "customer.xml";

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("oxm-spring.xml");
        XMLConverter xmlConverter = (XMLConverter) applicationContext.getBean("XMLConverter");
        Customer customer = new Customer();
        customer.setName("Ionel");
        customer.setAddress("Chisinau");
        customer.setAge(19);

        try {
            xmlConverter.convertFromObjectToXML(customer, FILE_NAME_XML);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
             Customer customer1 = (Customer) xmlConverter.convertFromXMLToObject(FILE_NAME_XML);
            System.out.println(customer1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        StringBuilder stringBuilder = new StringBuilder("webar.niculescu");
        System.out.println(stringBuilder.reverse());
    }

}