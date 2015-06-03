package com.mtsmda.daoImpl;

import com.mtsmda.dao.ContactDAO;
import com.mtsmda.model.Contact;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by c-DMITMINZ on 6/2/2015.
 */
public class ContactDAOImpl implements ContactDAO {

    private JdbcTemplate jdbcTemplate;

    public ContactDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
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
        String sqlListContacts = "SELECT * FROM contact";
        List<Contact> contacts = jdbcTemplate.query(sqlListContacts, new RowMapper<Contact>() {

            public Contact mapRow(ResultSet resultSet, int i) throws SQLException {
                Contact contact = new Contact();

                contact.setId(resultSet.getInt("contact_id"));
                contact.setName(resultSet.getString("name"));
                contact.setEmail(resultSet.getString("email"));
                contact.setAddress(resultSet.getString("address"));
                contact.setTelephone(resultSet.getString("telephone"));

                return contact;
            }
        });
        return contacts;
    }
}