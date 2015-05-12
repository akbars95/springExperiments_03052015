package com.mtsmda.blog.bd.dao;

import com.mtsmda.blog.bd.model.Category;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dmitriim on 5/12/2015.
 */
@Repository
public class CategoryDAOImpl implements CategoryDAO{

    private static final Logger LOGGER = Logger.getLogger(CategoryDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public boolean save(Category category) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            Transaction transaction = session.beginTransaction();
            session.persist(category);
            transaction.commit();
            session.close();
            LOGGER.info("Save Category");
        }
        catch (Exception e){
            LOGGER.error("Error save Category - " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean update(Category category) {
        return false;
    }

    public boolean delete(Category category) {
        try {
            if(category != null){
                sessionFactory.getCurrentSession().delete(category);
                LOGGER.info("Delete category object - " + category.toString());
            }
        }
        catch (Exception e){
            LOGGER.error("Error delete Category - " + e.getMessage());
            return false;
        }
        return true;
    }

    public List<Category> categories() {
        LOGGER.error("get all Categories - ");
        return sessionFactory.getCurrentSession().createQuery("from Category").list();
    }

    public Category getCategory(Category category) {
        return null;
    }
}
