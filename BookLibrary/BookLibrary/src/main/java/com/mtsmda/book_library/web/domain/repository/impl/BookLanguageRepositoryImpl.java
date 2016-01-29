package com.mtsmda.book_library.web.domain.repository.impl;

import com.mtsmda.book_library.web.domain.BookLanguage;
import com.mtsmda.book_library.web.domain.repository.BookLanguageRepository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MTSMDA on 26.10.2015.
 */
@Repository
public class BookLanguageRepositoryImpl implements BookLanguageRepository {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public boolean insertBookLanguage(BookLanguage bookLanguage) {
        try{
            Session session = this.sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(bookLanguage);
            transaction.commit();
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean updateBookLanguage(BookLanguage bookLanguage) {
        try{
            Session session = this.sessionFactory.getCurrentSession();
            session.update(bookLanguage);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean deleteBookLanguage(BookLanguage bookLanguage) {
        try{
            Session session = this.sessionFactory.getCurrentSession();
            session.delete(bookLanguage);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    public BookLanguage getBookLanguageById(Integer bookLanguageId) {
        BookLanguage bookLanguage = null;
        try{
            Session session = this.sessionFactory.getCurrentSession();
            bookLanguage = (BookLanguage)session.load(BookLanguage.class, bookLanguageId);
        }
        catch (Exception e){
            return null;
        }
        return bookLanguage;
    }

    public List<BookLanguage> getBookLanguages() {
        List<BookLanguage> bookLanguages = null;
        try{
            Session session = this.sessionFactory.getCurrentSession();
            bookLanguages = session.createQuery("from BookLanguage").list();
        }
        catch (Exception e){
            return null;
        }
        return bookLanguages;
    }
}