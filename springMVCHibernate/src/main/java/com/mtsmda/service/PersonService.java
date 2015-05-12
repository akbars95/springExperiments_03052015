package com.mtsmda.service;

import com.mtsmda.model.Person;

import java.util.List;

/**
 * Created by dmitriim on 5/12/2015.
 */
public interface PersonService {

    public void addPerson(Person p);
    public void updatePerson(Person p);
    public List<Person> listPersons();
    public Person getPersonById(int id);
    public void removePerson(int id);

}