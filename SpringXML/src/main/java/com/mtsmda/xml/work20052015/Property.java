package com.mtsmda.xml.work20052015;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by c-DMITMINZ on 5/20/2015.
 */
@XmlRootElement(name = "Property")
public class Property {
    private String name;

    public Property() {
    }

    @XmlAttribute(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
