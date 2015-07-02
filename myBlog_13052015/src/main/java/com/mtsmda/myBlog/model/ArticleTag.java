package com.mtsmda.myBlog.model;

/**
 * Created by c-DMITMINZ on 02.07.2015.
 */
public class ArticleTag {

    private Article article;
    private Tag tag;

    public ArticleTag() {

    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}