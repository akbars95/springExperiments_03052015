package com.mtsmda.daoImpl;

import com.mtsmda.SP.SPContactImpl;
import com.mtsmda.dao.ContactDAO;
import com.mtsmda.model.Contact;
import com.mtsmda.model.tableField.ContactFieldName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by c-DMITMINZ on 6/2/2015.
 */
public class ContactDAOImplSP implements ContactDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    private SPContactImpl spContact;

    @Autowired
    public ContactDAOImplSP(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        spContact = new SPContactImpl(dataSource);
    }

    public void saveOrUpdate(Contact contact) {
        if (contact.getId() != null && contact.getId() > 0) {
            String sqlUpdate = "UPDATE contact SET name=?, email=?, address=?, telephone=? WHERE contact_id=?";
            jdbcTemplate.update(sqlUpdate, contact.getName(), contact.getEmail(), contact.getAddress(), contact.getTelephone(), contact.getId());
        } else {
            String sqlInsert = "INSERT INTO contact (name, email, address, telephone) VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(sqlInsert, contact.getName(), contact.getEmail(), contact.getAddress(), contact.getTelephone());
        }
    }

    public void delete(Integer contactId) {
        String sqlDelete = "DELETE FROM contact WHERE contact_id=?";
        jdbcTemplate.update(sqlDelete, contactId);
    }

    public Contact getContact(Integer contactId) {
        String sqlContact = "SELECT * FROM contact WHERE contact_id = " + contactId;

        return jdbcTemplate.query(sqlContact, new ResultSetExtractor<Contact>() {
            public Contact extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                Contact contact = new Contact();

                contact.setId(resultSet.getInt("contact_id"));
                contact.setName(resultSet.getString("name"));
                contact.setEmail(resultSet.getString("email"));
                contact.setAddress(resultSet.getString("address"));
                contact.setTelephone(resultSet.getString("telephone"));

                return contact;
            }
        });
    }

    public List<Contact> getContacts() {
        List<Contact> contacts = new ArrayList<>();
        Map<String, Object> contactsMap = spContact.execute();

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
                                contact.setId(Integer.parseInt(tableFieldMap.get(ContactFieldName.CONTACT_ID).toString()));
                                contact.setName(tableFieldMap.get(ContactFieldName.NAME).toString());
                                contact.setEmail(tableFieldMap.get(ContactFieldName.EMAIL).toString());
                                contact.setAddress(tableFieldMap.get(ContactFieldName.ADDRESS).toString());
                                contact.setTelephone(tableFieldMap.get(ContactFieldName.TELEPHONE).toString());
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
}