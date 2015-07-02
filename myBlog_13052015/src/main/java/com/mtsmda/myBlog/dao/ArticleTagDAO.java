package com.mtsmda.myBlog.dao;

import com.mtsmda.myBlog.model.ArticleTag;

import java.util.List;

/**
 * Created by c-DMITMINZ on 6/16/2015.
 */
public interface ArticleTagDAO {

    public boolean saveOrUpdateArticleTag(ArticleTag articleTag);

    public boolean deleteArticleTag(Integer articleTagId);

    public ArticleTag getArticleTag(Integer articleTagId);

    public List<ArticleTag> getAllArticleTag();

}