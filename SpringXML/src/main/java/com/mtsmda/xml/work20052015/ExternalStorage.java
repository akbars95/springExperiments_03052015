package com.mtsmda.xml.work20052015;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by c-DMITMINZ on 5/20/2015.
 */
@XmlRootElement(name = "ExternalStorage")
public class ExternalStorage {

    private ConnectionPoints connectionPoints;

    public ExternalStorage() {
    }

    @XmlElement(name = "ConnectionPoints")
    public ConnectionPoints getConnectionPoints() {
        return connectionPoints;
    }

    public void setConnectionPoints(ConnectionPoints connectionPoints) {
        this.connectionPoints = connectionPoints;
    }
}
