package com.mtsmda.myBlog.model;

import java.util.GregorianCalendar;

/**
 * Created by c-DMITMINZ on 02.07.2015.
 */
public class Author {

    private Integer idAuthor;
    private String authorLastname;
    private String authorFirstname;
    private String authorMiddlename;
    private String authorEmail;
    private String authorSex;
    private GregorianCalendar authorDateOfBirth;

    public Author() {

    }

    public Integer getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Integer idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getAuthorLastname() {
        return authorLastname;
    }

    public void setAuthorLastname(String authorLastname) {
        this.authorLastname = authorLastname;
    }

    public String getAuthorFirstname() {
        return authorFirstname;
    }

    public void setAuthorFirstname(String authorFirstname) {
        this.authorFirstname = authorFirstname;
    }

    public String getAuthorMiddlename() {
        return authorMiddlename;
    }

    public void setAuthorMiddlename(String authorMiddlename) {
        this.authorMiddlename = authorMiddlename;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getAuthorSex() {
        return authorSex;
    }

    public void setAuthorSex(String authorSex) {
        this.authorSex = authorSex;
    }

    public GregorianCalendar getAuthorDateOfBirth() {
        return authorDateOfBirth;
    }

    public void setAuthorDateOfBirth(GregorianCalendar authorDateOfBirth) {
        this.authorDateOfBirth = authorDateOfBirth;
    }
}