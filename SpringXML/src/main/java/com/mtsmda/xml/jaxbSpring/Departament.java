package com.mtsmda.xml.jaxbSpring;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by c-DMITMINZ on 5/20/2015.
 */
@XmlRootElement(name = "departament")
public class Departament {
    private String departamentId;
    private String departamentName;

    public Departament() {
    }

    @XmlAttribute(name = "DEPARTAMENT_ID")
    public String getDepartamentId() {
        return departamentId;
    }

    public void setDepartamentId(String departamentId) {
        this.departamentId = departamentId;
    }

    @XmlElement(name = "departament_name")
    public String getDepartamentName() {
        return departamentName;
    }

    public void setDepartamentName(String departamentName) {
        this.departamentName = departamentName;
    }
}
