package com.mtsmda.springCore.SpEL;

/**
 * Created by MTSMDA on 04.06.2015.
 */
public class Author {

    private Integer idAuthor;

    private String name;

    private Book book;

    private String bookTitle;

    private String bookInfo;

    public Author() {

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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(String bookInfo) {
        this.bookInfo = bookInfo;
    }


    @Override
    public String toString() {
        return "Author{" +
                "idAuthor=" + idAuthor +
                ", name='" + name + '\'' +
                ", book=" + book +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookInfo='" + bookInfo + '\'' +
                '}';
    }
}