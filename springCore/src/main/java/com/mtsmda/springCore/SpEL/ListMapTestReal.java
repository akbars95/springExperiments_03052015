package com.mtsmda.springCore.SpEL;

/**
 * Created by MTSMDA on 06.06.2015.
 */
public class ListMapTestReal {

    private String listString;

    private String mapString;

    public ListMapTestReal() {

    }

    public String getListString() {
        return listString;
    }

    public void setListString(String listString) {
        this.listString = listString;
    }

    public String getMapString() {
        return mapString;
    }

    public void setMapString(String mapString) {
        this.mapString = mapString;
    }

    @Override
    public String toString() {
        return "ListMapTestReal{" +
                "listString='" + listString + '\'' +
                ", mapString='" + mapString + '\'' +
                '}';
    }
}