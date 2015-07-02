package com.mtsmda.myBlog.daoImplSp;

import com.mtsmda.myBlog.dao.ArticleTagDAO;
import com.mtsmda.myBlog.model.ArticleTag;

import java.util.List;

/**
 * Created by c-DMITMINZ on 02.07.2015.
 */
public class ArticleTagDAOImpl implements ArticleTagDAO {

    @Override
    public boolean saveOrUpdateArticleTag(ArticleTag articleTag) {
        return false;
    }

    @Override
    public boolean deleteArticleTag(Integer articleTagId) {
        return false;
    }

    @Override
    public ArticleTag getArticleTag(Integer articleTagId) {
        return null;
    }

    @Override
    public List<ArticleTag> getAllArticleTag() {
        return null;
    }

}