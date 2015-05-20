package com.mtsmda.xml.work20052015;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by c-DMITMINZ on 5/20/2015.
 */
@XmlRootElement(name = "Targets")
public class Target {

    private ExternalStorage externalStorage;

    public Target() {

    }

    @XmlElement(name = "ExternalStorage")
    public ExternalStorage getExternalStorage() {
        return externalStorage;
    }

    public void setExternalStorage(ExternalStorage externalStorage) {
        this.externalStorage = externalStorage;
    }

}