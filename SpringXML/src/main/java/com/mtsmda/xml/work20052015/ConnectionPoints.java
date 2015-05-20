package com.mtsmda.xml.work20052015;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by c-DMITMINZ on 5/20/2015.
 */
@XmlRootElement(name = "ConnectionPoints")
public class ConnectionPoints {

    @XmlElement(name = "ConnectionPoint")
    private ConnectionPoint connectionPoint;

}
