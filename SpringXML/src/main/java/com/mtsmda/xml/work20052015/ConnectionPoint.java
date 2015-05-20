package com.mtsmda.xml.work20052015;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by c-DMITMINZ on 5/20/2015.
 */
@XmlRootElement(name = "ConnectionPoint")
public class ConnectionPoint {

    private String id;
    private String path;

    public ConnectionPoint() {
    }

    @XmlAttribute(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlAttribute(name = "Path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}