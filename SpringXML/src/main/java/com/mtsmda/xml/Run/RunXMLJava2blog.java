package com.mtsmda.xml.Run;

import com.mtsmda.xml.java2blog.Converter;
import com.mtsmda.xml.java2blog.Country;
import com.mtsmda.xml.java2blog.State;
import com.mtsmda.xml.work20052015.ConverterWork;
import com.mtsmda.xml.work20052015.Properties;
import com.mtsmda.xml.work20052015.Property;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.bind.Marshaller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by c-DMITMINZ on 5/20/2015.
 */
public class RunXMLJava2blog {

    private static final String FILE_NAME_XML = "java2blog.xml";

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("oxm-spring.xml");
        Jaxb2Marshaller jaxb2Marshaller = (Jaxb2Marshaller) applicationContext.getBean("jaxbMarshallerJava2blog");

       /* Map<String, Object> marshallerProperties = new HashMap<String, Object>();
        marshallerProperties.put(Marshaller.JAXB_ENCODING, "UTF-8");
        marshallerProperties.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxb2Marshaller.setMarshallerProperties(marshallerProperties);*/

        Country country = new Country();
        country.setCountryName("USA");
        country.setCountryPopulation(300000000.0);

        List<State> states = new ArrayList<State>();
        country.setStates(states);
        states.add(new State("Washington", 500000));

        try {
            Converter.convertFromObjectToXML(jaxb2Marshaller, country, FILE_NAME_XML);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}