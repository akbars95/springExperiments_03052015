package com.mtsmda.xml.work20052015;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by c-DMITMINZ on 5/20/2015.
 */
public class ConverterWork {

    public void convertFromObjectToXML(Jaxb2Marshaller jaxb2Marshaller, Object object, String filePathOut) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(filePathOut));
        StreamResult streamResult = new StreamResult(fileOutputStream);
        jaxb2Marshaller.marshal(object, streamResult);
    }

    public Object convertFromXMLToObject(Jaxb2Marshaller jaxb2Marshaller, String filePathOut) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new File(filePathOut));
        StreamSource streamSource = new StreamSource(fileInputStream);
        Object object = jaxb2Marshaller.unmarshal(streamSource);
        return object;
    }

}
