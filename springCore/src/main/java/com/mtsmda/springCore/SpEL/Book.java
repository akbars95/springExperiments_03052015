package com.mtsmda.springCore.SpEL;

/**
 * Created by MTSMDA on 04.06.2015.
 */
public class Book {

    private Integer idBook;

    private String name;

    public Book() {

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
        return "Book{" +
                "idBook=" + idBook +
                ", name='" + name + '\'' +
                '}';
    }

    public String getFullBookInfo(String authorName){
        return authorName + " there book is - " + getName() + " #" + getIdBook();
    }
}