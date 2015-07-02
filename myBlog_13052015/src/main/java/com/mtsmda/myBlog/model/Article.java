package com.mtsmda.myBlog.model;

import java.util.GregorianCalendar;

/**
 * Created by c-DMITMINZ on 02.07.2015.
 */
public class Article {

    private Integer idArticle;
    private SubCategory subCategory;
    private String articleName;
    private String articleHtmltext;
    private Author author;
    private GregorianCalendar articleCreatedDate;
    private GregorianCalendar articleLastUpdatedDate;

    public Article() {

    }

    public Integer getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Integer idArticle) {
        this.idArticle = idArticle;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleHtmltext() {
        return articleHtmltext;
    }

    public void setArticleHtmltext(String articleHtmltext) {
        this.articleHtmltext = articleHtmltext;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public GregorianCalendar getArticleCreatedDate() {
        return articleCreatedDate;
    }

    public void setArticleCreatedDate(GregorianCalendar articleCreatedDate) {
        this.articleCreatedDate = articleCreatedDate;
    }

    public GregorianCalendar getArticleLastUpdatedDate() {
        return articleLastUpdatedDate;
    }

    public void setArticleLastUpdatedDate(GregorianCalendar articleLastUpdatedDate) {
        this.articleLastUpdatedDate = articleLastUpdatedDate;
    }
}
