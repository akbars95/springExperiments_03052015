package com.mtsmda.dao;

import com.mtsmda.model.Contact;

import java.util.List;

/**
 * Created by c-DMITMINZ on 6/2/2015.
 */
public interface ContactDAO {

    public void saveOrUpdate(Contact contact);

    public void delete(Integer contactId);

    public Contact getContact(Integer contactId);

    public List<Contact> getContacts();

}