package com.mtsmda.xml.Run;

import com.mtsmda.xml.jaxbSpring.Departament;
import com.mtsmda.xml.jaxbSpring.Employee;
import com.mtsmda.xml.jaxbSpring.JAXBConverter;
import com.mtsmda.xml.testingWork.Customer;
import com.mtsmda.xml.testingWork.XMLConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.bind.Marshaller;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by c-DMITMINZ on 5/20/2015.
 */
public class RunXMLJAXB {

    private static final String FILE_NAME_XML = "employee.xml";

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("oxm-spring.xml");
        Jaxb2Marshaller jaxb2Marshaller = (Jaxb2Marshaller) applicationContext.getBean("jaxbMarshaller");

        Map<String, Object> marshallerProperties = new HashMap<String, Object>();
        marshallerProperties.put(Marshaller.JAXB_ENCODING, "UTF-8");
        marshallerProperties.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxb2Marshaller.setMarshallerProperties(marshallerProperties);

        Employee employee = new Employee();
        employee.setId("1");
        employee.setName("Ivan");

        Employee employee2 = new Employee();
        employee2.setId("2");
        employee2.setName("Petr");

        Departament departament = new Departament();
        departament.setDepartamentId("1");
        departament.setDepartamentName("JAVA");

        employee.setDepartament(departament);
        employee2.setDepartament(departament);

        JAXBConverter jaxbConverter = new JAXBConverter();
        try {
            jaxbConverter.convertFromObjectToXML(jaxb2Marshaller, employee, FILE_NAME_XML);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}