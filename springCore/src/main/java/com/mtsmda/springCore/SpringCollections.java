package com.mtsmda.springCore;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by MTSMDA on 23.05.2015.
 */
public class SpringCollections {

    private List<String> listCountries;

    private Set<String> footbalClubNames;

    private Map<String, String> abbreviationAndFullName;

    private Properties dbProperties;

    public List<String> getListCountries() {
        return listCountries;
    }

    public void setListCountries(List<String> listCountries) {
        this.listCountries = listCountries;
    }

    public Set<String> getFootbalClubNames() {
        return footbalClubNames;
    }

    public void setFootbalClubNames(Set<String> footbalClubNames) {
        this.footbalClubNames = footbalClubNames;
    }

    public Map<String, String> getAbbreviationAndFullName() {
        return abbreviationAndFullName;
    }

    public void setAbbreviationAndFullName(Map<String, String> abbreviationAndFullName) {
        this.abbreviationAndFullName = abbreviationAndFullName;
    }

    public Properties getDbProperties() {
        return dbProperties;
    }

    public void setDbProperties(Properties dbProperties) {
        this.dbProperties = dbProperties;
    }
}