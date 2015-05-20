package com.mtsmda.xml.Run;

import com.mtsmda.xml.jaxbSpring.Departament;
import com.mtsmda.xml.jaxbSpring.Employee;
import com.mtsmda.xml.jaxbSpring.JAXBConverter;
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
public class RunXMLWork {

    private static final String FILE_NAME_XML = "work.xml";

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("oxm-spring.xml");
        Jaxb2Marshaller jaxb2Marshaller = (Jaxb2Marshaller) applicationContext.getBean("jaxbMarshallerWork");

        Map<String, Object> marshallerProperties = new HashMap<String, Object>();
        marshallerProperties.put(Marshaller.JAXB_ENCODING, "UTF-8");
        marshallerProperties.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxb2Marshaller.setMarshallerProperties(marshallerProperties);

        //Map
        com.mtsmda.xml.work20052015.Map mapWork = new com.mtsmda.xml.work20052015.Map();
        mapWork.setVersion("3");
        mapWork.setModelVersion("4");
        mapWork.setLastCPID("4656");
        List<Properties> propertiesList = new ArrayList<Properties>();

        //Properties
        Properties propertiesBusinessGroups = new Properties();
        propertiesBusinessGroups.setCategory("BusinessGroups");
        List<Property> propertyList = new ArrayList<Property>();
        propertiesList.add(propertiesBusinessGroups);
        mapWork.setPropertiesList(propertiesList);

        Property property1 = new Property();
        property1.setName("1/ID");
        propertyList.add(property1);


       ConverterWork converterWork = new ConverterWork();
        try {
            converterWork.convertFromObjectToXML(jaxb2Marshaller, mapWork, FILE_NAME_XML);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Object object = converterWork.convertFromXMLToObject(jaxb2Marshaller, "E:\\simple\\j06052015\\springExperiments_03052015\\SpringXML\\src\\main\\resources\\work\\RRM_CSV_to_ECHCF_Pharmacy.xml");
            if(object instanceof com.mtsmda.xml.work20052015.Map){
                com.mtsmda.xml.work20052015.Map map = (com.mtsmda.xml.work20052015.Map)object;
                System.out.println(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}