package com.mtsmda.springCore.SpEL.annotation;

import com.mtsmda.springCore.SpEL.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by MTSMDA on 04.06.2015.
 */
@Component(value = "BookBean")
public class BookBean {

    @Value(value = "26498")
    private Integer idBook;

    @Value(value = "Java 9")
    private String name;

    public BookBean() {

    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BookBean{" +
                "idBook=" + idBook +
                ", name='" + name + '\'' +
                '}';
    }
}