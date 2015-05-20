package com.mtsmda.xml.java2blog;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by c-DMITMINZ on 5/20/2015.
 */
public class Converter {

    public static <T> void convertFromObjectToXML(Jaxb2Marshaller jaxb2Marshaller, T object, String filePathOut) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(filePathOut));
        StreamResult streamResult = new StreamResult(fileOutputStream);
        jaxb2Marshaller.marshal(object, streamResult);
    }

    public static <T> T convertFromXMLToObject(Jaxb2Marshaller jaxb2Marshaller, String filePathOut) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new File(filePathOut));
        StreamSource streamSource = new StreamSource(fileInputStream);
        T object = (T)jaxb2Marshaller.unmarshal(streamSource);
        return object;
    }

}