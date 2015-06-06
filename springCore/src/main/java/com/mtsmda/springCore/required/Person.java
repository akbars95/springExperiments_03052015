package com.mtsmda.springCore.required;

import org.springframework.beans.factory.annotation.Required;

/**
 * Created by MTSMDA on 27.05.2015.
 */
public class Person {
    private Integer id;
    private Employee employee;

    public Person() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    @Required
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", employee=" + employee +
                '}';
    }
}