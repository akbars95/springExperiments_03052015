package com.mtsmda.book_library.web.dao;

import java.util.List;

import com.mtsmda.book_library.web.domain.BookLanguage;

/**
 * Created by MTSMDA on 26.10.2015.
 */
public interface BookLanguageDAO {

    public boolean insertBookLanguage(BookLanguage bookLanguage);
    public boolean updateBookLanguage(BookLanguage bookLanguage);
    public boolean deleteBookLanguage(BookLanguage bookLanguage);

    public BookLanguage getBookLanguageById(Integer bookLanguageId);
    public List<BookLanguage> getBookLanguages();

}