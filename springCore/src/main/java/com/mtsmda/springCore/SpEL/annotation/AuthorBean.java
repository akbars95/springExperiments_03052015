package com.mtsmda.springCore.SpEL.annotation;

import com.mtsmda.springCore.SpEL.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by MTSMDA on 04.06.2015.
 */
@Component(value = "AuthorBean")
public class AuthorBean {

    @Value(value = "15982")
    private Integer idAuthor;

    @Value(value = "J.S")
    private String name;

    @Value(value = "#{BookBean.name}")
    private String bookTitle;

    public AuthorBean() {

    }

    public Integer getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Integer idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    @Override
    public String toString() {
        return "AuthorBean{" +
                "idAuthor=" + idAuthor +
                ", name='" + name + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                '}';
    }
}