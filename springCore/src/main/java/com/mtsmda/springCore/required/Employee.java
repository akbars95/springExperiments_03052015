package com.mtsmda.springCore.required;

import org.springframework.beans.factory.annotation.Required;

/**
 * Created by MTSMDA on 27.05.2015.
 */
public class Employee {
    private Integer id;
    private String name;

    public Employee() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    @Required
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}