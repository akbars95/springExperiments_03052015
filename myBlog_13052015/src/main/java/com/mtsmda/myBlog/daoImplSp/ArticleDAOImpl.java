package com.mtsmda.myBlog.daoImplSp;

import com.mtsmda.myBlog.SP.BlogStoredProcedure;
import com.mtsmda.myBlog.dao.ArticleDAO;
import com.mtsmda.myBlog.model.Article;
import com.mtsmda.myBlog.model.Author;
import com.mtsmda.myBlog.model.SubCategory;
import com.mtsmda.myBlog.model.dbConst.ArticleDbConst;
import com.mtsmda.myBlog.model.dbConst.ArticleDbConst.*;
import com.mtsmda.myBlog.model.dbConst.AuthorDbConst;
import com.mtsmda.myBlog.model.dbConst.SubCategoryDbConst;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

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
        return null;
    }

    @Override
    public List<Article> getAllArticle() {
        logger.info(this.getClass().getCanonicalName() + ".getAllArticle()");
        List<Article> articles = null;
        blogStoredProcedure = new BlogStoredProcedure(dataSource, ArticleDbConst.ArticleSPName.SELECT_ALL_ARTICLE, null);
        Map<String, Object> contactsMap = blogStoredProcedure.execute();
        getResultFromSP(contactsMap, articles);
        if (articles != null && !articles.isEmpty()) {
            logger.info(articles.size() + " articles");
            return articles;
        }
        logger.info("ERROR! " + articles.size() + " articles");
        return null;
    }

    private void getResultFromSP(Map<String, Object> contactsMap, List<Article> articles) {
        articles = new ArrayList<Article>();
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

                                articles.add(article);
                            }
                        }


                    }
                }
                if (i == 1) {
                    break;
                }
            }
        }
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