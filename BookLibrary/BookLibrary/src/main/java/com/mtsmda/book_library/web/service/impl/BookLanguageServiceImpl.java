package com.mtsmda.book_library.web.service.impl;

import com.mtsmda.book_library.web.dao.BookLanguageDAO;
import com.mtsmda.book_library.web.model.Book;
import com.mtsmda.book_library.web.model.BookLanguage;
import com.mtsmda.book_library.web.service.BookLanguageService;

import java.util.List;

/**
 * Created by MTSMDA on 26.10.2015.
 */
public class BookLanguageServiceImpl implements BookLanguageService{

    private BookLanguageDAO bookLanguageDAO;

    public boolean insertBookLanguage(BookLanguage bookLanguage) {
        return bookLanguageDAO.insertBookLanguage(bookLanguage);
    }

    public boolean updateBookLanguage(BookLanguage bookLanguage) {
        return bookLanguageDAO.updateBookLanguage(bookLanguage);
    }

    public boolean deleteBookLanguage(BookLanguage bookLanguage) {
        return bookLanguageDAO.deleteBookLanguage(bookLanguage);
    }

    public BookLanguage getBookLanguageById(Integer bookLanguageId) {
        return bookLanguageDAO.getBookLanguageById(bookLanguageId);
    }

    public List<BookLanguage> getBookLanguages() {
        return bookLanguageDAO.getBookLanguages();
    }
}