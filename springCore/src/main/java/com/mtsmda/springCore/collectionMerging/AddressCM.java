package com.mtsmda.springCore.collectionMerging;

/**
 * Created by MTSMDA on 31.05.2015.
 */
public class AddressCM {
    private String city;

    public AddressCM(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "AddressCM{" +
                "city='" + city + '\'' +
                '}';
    }
}