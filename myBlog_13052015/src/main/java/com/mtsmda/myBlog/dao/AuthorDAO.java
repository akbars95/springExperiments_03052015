package com.mtsmda.myBlog.dao;

import com.mtsmda.myBlog.model.Author;

import java.util.List;

/**
 * Created by c-DMITMINZ on 6/16/2015.
 */
public interface AuthorDAO {

    public boolean saveOrUpdateAuthor(Author author);

    public boolean deleteAuthor(Integer authorId);

    public Author getAuthor(Integer authorId);

    public List<Author> getAllAuthor();

}