package com.mtsmda.xml.work20052015;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by c-DMITMINZ on 5/20/2015.
 */
@XmlRootElement(name = "Properties")
public class Properties {

    private String category;
    private List<Property> properties;

    public Properties() {
    }

    @XmlAttribute(name = "Category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @XmlElement(name = "Property")
    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}