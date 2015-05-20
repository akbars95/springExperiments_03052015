package com.mtsmda.xml.java2blog;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by c-DMITMINZ on 5/20/2015.
 */
@XmlRootElement(name = "country")
@XmlType(propOrder = {"countryName", "countryPopulation", "states"})
public class Country {

    private String countryName;
    private double countryPopulation;
    private List<State> states;

    public Country() {
    }

    @XmlElement
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @XmlElement
    public double getCountryPopulation() {
        return countryPopulation;
    }

    public void setCountryPopulation(double countryPopulation) {
        this.countryPopulation = countryPopulation;
    }

    @XmlElementWrapper(name = "states")
    @XmlElement(name = "state")
    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }
}
