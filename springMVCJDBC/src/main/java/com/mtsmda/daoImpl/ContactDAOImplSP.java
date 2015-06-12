package com.mtsmda.daoImpl;

import com.mtsmda.SP.SPContactImpl;
import com.mtsmda.dao.ContactDAO;
import com.mtsmda.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.mtsmda.model.helper.ContactHelper.ContactFieldName.*;
import static com.mtsmda.model.helper.ContactHelper.ContactSPName.*;
import static com.mtsmda.model.helper.ContactHelper.ContactSPParamName.*;

/**
 * Created by c-DMITMINZ on 6/2/2015.
 */
public class ContactDAOImplSP implements ContactDAO {

    private JdbcTemplate jdbcTemplate;

    /*@Autowired*/
    private DataSource dataSource;

    private SPContactImpl spContact;

    @Autowired
    public ContactDAOImplSP(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void saveOrUpdate(Contact contact) {
        List<SqlParameter> sqlParameters = new ArrayList<SqlParameter>();
        sqlParameters.add(SQL_PARAMETER_NAME);
        sqlParameters.add(SQL_PARAMETER_EMAIL);
        sqlParameters.add(SQL_PARAMETER_ADDRESS);
        sqlParameters.add(SQL_PARAMETER_TELEPHONE);
        if (contact.getId() != null && contact.getId() > 0) {
            sqlParameters.add(SQL_PARAMETER_ID);
            spContact = new SPContactImpl(dataSource, UPDATE_CONTACT, sqlParameters);
            Map<String, Object> contactsMap = spContact.execute(contact.getName(), contact.getEmail(), contact.getAddress(), contact.getTelephone(), contact.getId());
            System.out.println(resultIUD(contactsMap));
        } else {
            spContact = new SPContactImpl(dataSource, INSERT_CONTACT, sqlParameters);
            Map<String, Object> contactsMap = spContact.execute(contact.getName(), contact.getEmail(), contact.getAddress(), contact.getTelephone());
            System.out.println(resultIUD(contactsMap));
        }
    }

    public void delete(Integer contactId) {
        List<SqlParameter> sqlParameters = new ArrayList<SqlParameter>();
        sqlParameters.add(SQL_PARAMETER_ID);
        spContact = new SPContactImpl(dataSource, DELETE_CONTACT, sqlParameters);
        Map<String, Object> contactsMap = spContact.execute(contactId);
        System.out.println(resultIUD(contactsMap));
}

    public Contact getContact(Integer contactId) {
        List<Contact> contacts = null;
        List<SqlParameter> sqlParameters = new ArrayList<SqlParameter>();
        sqlParameters.add(SQL_PARAMETER_ID);
        spContact = new SPContactImpl(dataSource, SELECT_CONTACT, sqlParameters);
        Map<String, Object> contactsMap = spContact.execute(contactId);
        contacts = getResultFromSP(contactsMap, contacts);
        return contacts.get(0);
    }

    public List<Contact> getContacts() {
        List<Contact> contacts = null;
        spContact = new SPContactImpl(dataSource, SELECT_ALL_CONTACTS, null);
        Map<String, Object> contactsMap = spContact.execute();
        contacts = getResultFromSP(contactsMap, contacts);
        return contacts;
    }

    private List<Contact> getResultFromSP(Map<String, Object> contactsMap, List<Contact> contacts) {
        contacts = new ArrayList<Contact>();
        if (!contactsMap.isEmpty()) {
            int i = 0;
            for (String key : contactsMap.keySet()) {
                i++;
                if (key != null && contactsMap.get(key) != null && contactsMap.get(key) instanceof List<?>) {
                    List<?> resultListWithContact = (List<?>) contactsMap.get(key);
                    if (!resultListWithContact.isEmpty()) {
                        for (int j = 0; j < resultListWithContact.size(); j++) {
                            if (resultListWithContact.get(j) instanceof Map) {
                                Map<String, Object> tableFieldMap = (Map<String, Object>) resultListWithContact.get(j);
                                Contact contact = new Contact();
                                contact.setId(Integer.parseInt(tableFieldMap.get(CONTACT_ID).toString()));
                                contact.setName(tableFieldMap.get(CONTACT_NAME).toString());
                                contact.setEmail(tableFieldMap.get(CONTACT_EMAIL).toString());
                                contact.setAddress(tableFieldMap.get(CONTACT_ADDRESS).toString());
                                contact.setTelephone(tableFieldMap.get(CONTACT_TELEPHONE).toString());
                                contacts.add(contact);
                            }
                        }


                    }
                }
                if (i == 1) {
                    break;
                }
            }
        }
        return contacts;
    }

    /**
     * resultIUD
     * I - Insert
     * U - Update
     * D - Delete
     */
    private boolean resultIUD(Map<String, Object> contactsMap) {
        if (!contactsMap.isEmpty()) {
            int i = 0;
            for (String key : contactsMap.keySet()) {
                i++;
                if (key != null && contactsMap.get(key) != null && contactsMap.get(key) instanceof Integer) {
                    if (((Integer) contactsMap.get(key)).equals(1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}