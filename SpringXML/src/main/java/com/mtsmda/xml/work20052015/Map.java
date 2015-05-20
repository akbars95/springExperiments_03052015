package com.mtsmda.xml.work20052015;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by c-DMITMINZ on 5/20/2015.
 */
@XmlRootElement(name = "Map")
/*@XmlType(propOrder = {})*/
public class Map {

    private String version;
    private String modelVersion;
    private String lastCPID;

    private List<Properties> propertiesList;

    /*private Target target;*/

    public Map() {
    }

    @XmlAttribute(name = "Version")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @XmlAttribute(name = "ModelVersion")
    public String getModelVersion() {
        return modelVersion;
    }

    public void setModelVersion(String modelVersion) {
        this.modelVersion = modelVersion;
    }

    @XmlAttribute(name = "LastCPID")
    public String getLastCPID() {
        return lastCPID;
    }

    public void setLastCPID(String lastCPID) {
        this.lastCPID = lastCPID;
    }

    /*@XmlElementWrapper(name = "Properties" )
    @XmlElement(name = "Property")*/
    @XmlElement(name = "Properties")
    public List<Properties> getPropertiesList() {
        return propertiesList;
    }

    public void setPropertiesList(List<Properties> propertiesList) {
        this.propertiesList = propertiesList;
    }

    /*@XmlElement(name = "Targets")
    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }*/
}