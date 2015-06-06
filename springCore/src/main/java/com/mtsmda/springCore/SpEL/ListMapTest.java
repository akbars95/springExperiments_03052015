package com.mtsmda.springCore.SpEL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MTSMDA on 06.06.2015.
 */
public class ListMapTest {

    private List<String> strings;
    private Map<String, String> stringStringMap;
    public String email;

    public ListMapTest() {
        strings = new ArrayList<String>();
        strings.add("1f");
        strings.add("2f");
        strings.add("3f");

        stringStringMap = new HashMap<String, String>();
        stringStringMap.put("1f", "first");
        stringStringMap.put("2f", "second");

        email = "ivan.ivanov@mail.ru";

    }

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    public Map<String, String> getStringStringMap() {
        return stringStringMap;
    }

    public void setStringStringMap(Map<String, String> stringStringMap) {
        this.stringStringMap = stringStringMap;
    }

    @Override
    public String toString() {
        return "ListMapTest{" +
                "strings=" + strings +
                ", stringStringMap=" + stringStringMap +
                '}';
    }
}