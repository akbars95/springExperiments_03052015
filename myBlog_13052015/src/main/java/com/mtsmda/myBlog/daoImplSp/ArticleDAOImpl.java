package com.mtsmda.myBlog.daoImplSp;

import com.mtsmda.myBlog.SP.BlogStoredProcedure;
import com.mtsmda.myBlog.dao.ArticleDAO;
import com.mtsmda.myBlog.model.*;
import com.mtsmda.myBlog.model.dbConst.ArticleDbConst;
import com.mtsmda.myBlog.model.dbConst.ArticleDbConst.*;
import com.mtsmda.myBlog.model.dbConst.AuthorDbConst;
import com.mtsmda.myBlog.model.dbConst.CategoryDbConst;
import com.mtsmda.myBlog.model.dbConst.SubCategoryDbConst;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.mtsmda.myBlog.model.dbConst.CaptchaDbConst.CaptchaSPName.SELECT_CAPTCHA;
import static com.mtsmda.myBlog.utils.ProjectUtil.getGregorianCalendarFromString;

/**
 * Created by c-DMITMINZ on 02.07.2015.
 */
public class ArticleDAOImpl implements ArticleDAO {

    private static final Logger logger = Logger.getLogger(ArticleDAOImpl.class);

    private JdbcTemplate jdbcTemplate;

    private DataSource dataSource;

    private BlogStoredProcedure blogStoredProcedure;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

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
        logger.info(this.getClass().getCanonicalName() + ".getArticle(Integer articleId)");
        Article article = null;
        ModelWrapper<Article> articleModelWrapper = null;

        List<SqlParameter> sqlParameters = new ArrayList<SqlParameter>();
        sqlParameters.add(ArticleSPParamName.SQL_PARAMETER_ID);

        blogStoredProcedure = new BlogStoredProcedure(dataSource, ArticleSPName.SELECT_ARTICLE, sqlParameters);
        Map<String, Object> contactsMap = blogStoredProcedure.execute(articleId);
        getResultFromSP(contactsMap, ArticleSPName.SELECT_ARTICLE, articleModelWrapper);

        blogStoredProcedure = new BlogStoredProcedure(dataSource, ArticleSPName.SELECT_TAGS_FOR_ARTICLE, sqlParameters);
        contactsMap = blogStoredProcedure.execute(articleId);
        getResultFromSP(contactsMap, ArticleSPName.SELECT_TAGS_FOR_ARTICLE, articleModelWrapper);

        return article;
    }

    @Override
    public List<Article> getAllArticle() {
        logger.info(this.getClass().getCanonicalName() + ".getAllArticle()");
        ModelWrapper<Article> articleModelWrapper = null;
        blogStoredProcedure = new BlogStoredProcedure(dataSource, ArticleSPName.SELECT_ALL_ARTICLE, null);
        Map<String, Object> contactsMap = blogStoredProcedure.execute();
        getResultFromSP(contactsMap, ArticleSPName.SELECT_ALL_ARTICLE, articleModelWrapper);
        if (articleModelWrapper != null && articleModelWrapper.getList() != null && !articleModelWrapper.getList().isEmpty()) {
            logger.info(articleModelWrapper.getList().size() + " articles");
            return articleModelWrapper.getList();
        }
        logger.info("ERROR! " + articleModelWrapper.getList().size() + " articles");
        return articleModelWrapper.getList();
    }

    private ModelWrapper<Article> getResultFromSP(Map<String, Object> contactsMap, String spName, ModelWrapper<Article> articleModelWrapper) {
        List<Article> articles = new ArrayList<Article>();
        if (!contactsMap.isEmpty()) {
            int i = 0;
            for (String key : contactsMap.keySet()) {
                i++;
                if (key != null && contactsMap.get(key) != null && contactsMap.get(key) instanceof List<?>) {
                    List<?> resultListWithContact = (List<?>) contactsMap.get(key);
                    if (!resultListWithContact.isEmpty()) {
                        for (int j = 0; j < resultListWithContact.size(); j++) {
                            if (resultListWithContact.get(j) instanceof Map) {
                                Map<String, Object> tableFieldMap = (Map<String, Object>) resultListWithContact.get(j);
                                if (spName.equals(ArticleSPName.SELECT_ALL_ARTICLE) || spName.equals(ArticleSPName.SELECT_ALL_ARTICLE)) {
                                    Article article = new Article();

                                    Author author = new Author();
                                    article.setAuthor(author);

                                    SubCategory subCategory = new SubCategory();
                                    article.setSubCategory(subCategory);

                                    article.setIdArticle(Integer.parseInt(tableFieldMap.get(ArticleFieldName.ARTICLE_ID).toString()));
                                    article.setArticleName(tableFieldMap.get(ArticleFieldName.ARTICLE_NAME).toString());
                                    article.setArticleHtmltext(tableFieldMap.get(ArticleFieldName.ARTICLE_HTMLTEXT).toString());
                                    try {
                                        article.setArticleCreatedDate(getGregorianCalendarFromString(tableFieldMap.get(ArticleFieldName.ARTICLE_CREATED_DATE).toString()));
                                        article.setArticleLastUpdatedDate(getGregorianCalendarFromString(tableFieldMap.get(ArticleFieldName.ARTICLE_LAST_UPDATED_DATE).toString()));
                                    } catch (Exception e) {
                                        logger.error("ERROR parsing date from string - " + e.getMessage());
                                    }

                                    author.setAuthorFirstname(tableFieldMap.get(AuthorDbConst.AuthorFieldName.AUTHOR_SP_AUTHORNAME).toString());

                                    subCategory.setSubcategoryName(tableFieldMap.get(SubCategoryDbConst.SubCategoryFieldName.SUBCATEGORY_NAME).toString());

                                    if (spName.equals(ArticleSPName.SELECT_ALL_ARTICLE)) {
                                        Category category = new Category();
                                        category.setCategoryName(tableFieldMap.get(CategoryDbConst.CategoryFieldName.CATEGORY_NAME).toString());
                                        subCategory.setCategory(category);
                                    }

                                    articles.add(article);
                                }else if(spName.equals(ArticleSPName.SELECT_TAGS_FOR_ARTICLE)){
                                    
                                }

                            }
                        }


                    }
                }
                if (i == 1) {
                    break;
                }
            }
        }
        articleModelWrapper = new ModelWrapper<Article>(articles);
        return articleModelWrapper;
    }

    /**
     * resultIUD
     * I - Insert
     * U - Update
     * D - Delete
     */
    private boolean resultIUD(Map<String, Object> contactsMap) {
        if (!contactsMap.isEmpty()) {
            int i = 0;
            for (String key : contactsMap.keySet()) {
                i++;
                if (key != null && contactsMap.get(key) != null && contactsMap.get(key) instanceof Integer) {
                    if (((Integer) contactsMap.get(key)).equals(1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}