package com.mtsmda.springCore.collectionMerging;

import java.util.List;

/**
 * Created by MTSMDA on 31.05.2015.
 */
public class PersonCM {

    private List<AddressCM> addressCMList;

    public List<AddressCM> getAddressCMList() {
        return addressCMList;
    }

    public void setAddressCMList(List<AddressCM> addressCMList) {
        this.addressCMList = addressCMList;
    }

    @Override
    public String toString() {
        return "PersonCM{" +
                "addressCMList=" + addressCMList +
                '}';
    }
}