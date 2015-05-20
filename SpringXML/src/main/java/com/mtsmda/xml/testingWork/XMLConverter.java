package com.mtsmda.xml.testingWork;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by c-DMITMINZ on 5/19/2015.
 */
public class XMLConverter {
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;

    public Marshaller getMarshaller() {
        return marshaller;
    }

    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    public Unmarshaller getUnmarshaller() {
        return unmarshaller;
    }

    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    public void convertFromObjectToXML(Object object, String filePath) throws Exception{
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        try{
            getMarshaller().marshal(object, new StreamResult(fileOutputStream));
        }
        finally {
            if(fileOutputStream != null){
                fileOutputStream.close();
            }
        }
    }

    public Object convertFromXMLToObject(String filePathXML) throws Exception{
        FileInputStream fileInputStream = new FileInputStream(filePathXML);
        Object object = null;
        try{
            object = getUnmarshaller().unmarshal(new StreamSource(filePathXML));
        }
        finally {
            if(fileInputStream != null){
                fileInputStream.close();
            }
        }
        return object;
    }

}