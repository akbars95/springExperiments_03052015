package com.mtsmda.myBlog.dao;

import com.mtsmda.myBlog.model.Article;
import com.mtsmda.myBlog.model.Article;

import java.util.List;

/**
 * Created by c-DMITMINZ on 6/16/2015.
 */
public interface ArticleDAO {

    public boolean saveOrUpdateArticle(Article article);

    public boolean deleteArticle(Integer articleId);

    public Article getArticle(Integer articleId);

    public List<Article> getAllArticle();

}