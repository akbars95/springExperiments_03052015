package com.mtsmda.xml.java2blog;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by c-DMITMINZ on 5/20/2015.
 */
@XmlRootElement(namespace = "com.mtsmda.xml.java2blog")
public class State {
    private String stateName;
    private long statePopulation;

    public State() {

    }

    public State(String stateName, long statePopulation) {
        this.stateName = stateName;
        this.statePopulation = statePopulation;
    }

    @XmlElement(name = "state_name")
    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @XmlElement(name = "state_population")
    public long getStatePopulation() {
        return statePopulation;
    }

    public void setStatePopulation(long statePopulation) {
        this.statePopulation = statePopulation;
    }
}