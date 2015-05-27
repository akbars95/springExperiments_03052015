package com.mtsmda.springCore;

/**
 * Created by MTSMDA on 26.05.2015.
 */
public class SpringProperties {

    private String country;
    private String city;

    public SpringProperties() {

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}