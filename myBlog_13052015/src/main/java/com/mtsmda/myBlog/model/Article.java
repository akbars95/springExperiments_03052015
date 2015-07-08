package com.mtsmda.myBlog.model;

import java.util.GregorianCalendar;
import java.util.List;

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
    private Integer articleCountRewiew;
    private List<Tag> tags;

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

    public Integer getArticleCountRewiew() {
        return articleCountRewiew;
    }

    public void setArticleCountRewiew(Integer articleCountRewiew) {
        this.articleCountRewiew = articleCountRewiew;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
