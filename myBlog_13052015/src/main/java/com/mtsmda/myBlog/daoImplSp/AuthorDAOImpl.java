package com.mtsmda.myBlog.daoImplSp;

import com.mtsmda.myBlog.dao.AuthorDAO;
import com.mtsmda.myBlog.model.Author;

import java.util.List;

/**
 * Created by c-DMITMINZ on 02.07.2015.
 */
public class AuthorDAOImpl implements AuthorDAO {

    @Override
    public boolean saveOrUpdateAuthor(Author author) {
        return false;
    }

    @Override
    public boolean deleteAuthor(Integer authorId) {
        return false;
    }

    @Override
    public Author getAuthor(Integer authorId) {
        return null;
    }

    @Override
    public List<Author> getAllAuthor() {
        return null;
    }

}