package com.mtsmda.myBlog.daoImplSp;

import com.mtsmda.myBlog.dao.ArticleDAO;
import com.mtsmda.myBlog.model.Article;

import java.util.List;

/**
 * Created by c-DMITMINZ on 02.07.2015.
 */
public class ArticleDAOImpl implements ArticleDAO {


    @Override
    public boolean saveOrUpdateArticle(Article article) {
        return false;
    }

    @Override
    public boolean deleteArticle(Integer articleId) {
        return false;
    }

    @Override
    public Article getArticle(Integer articleId) {
        return null;
    }

    @Override
    public List<Article> getAllArticle() {
        return null;
    }
}