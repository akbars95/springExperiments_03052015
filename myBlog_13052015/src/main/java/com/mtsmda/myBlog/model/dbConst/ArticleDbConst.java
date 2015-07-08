package com.mtsmda.myBlog.model.dbConst;

import org.springframework.jdbc.core.SqlParameter;

import java.sql.Types;

import static com.mtsmda.myBlog.model.dbConst.CommonConst.PARAM_IN;

/**
 * Created by c-DMITMINZ on 6/11/2015.
 */
public interface ArticleDbConst {

    public interface ArticleFieldName {

        public static final String ARTICLE_ID = "article_id";
        public static final String ARTICLE_SUBCATEGORY_ID = "subcategory_id";
        public static final String ARTICLE_NAME = "article_name";
        public static final String ARTICLE_HTMLTEXT = "article_htmltext";
        public static final String ARTICLE_AUTHOR_ID = "article_author_id";
        public static final String ARTICLE_CREATED_DATE = "article_created_date";
        public static final String ARTICLE_LAST_UPDATED_DATE = "article_last_updated_date";
        public static final String ARTICLE_ARTICLECOUNT_REWIEW = "articleCount_rewiew";

    }

    public interface ArticleSPName {

        public static final String INSERT_ARTICLE = "InsertArticle";
        public static final String UPDATE_ARTICLE = "UpdateArticle";
        public static final String DELETE_ARTICLE = "DeleteArticle";
        public static final String SELECT_ALL_ARTICLE = "SelectAllArticle";
        public static final String SELECT_ARTICLE = "SelectArticle";
        public static final String SELECT_TAGS_FOR_ARTICLE = "SelectTagsForArticle";

    }

    public interface ArticleSPParamName {

        public static final SqlParameter SQL_PARAMETER_ID = new SqlParameter(ArticleFieldName.ARTICLE_ID + PARAM_IN, Types.INTEGER);
        public static final SqlParameter SQL_PARAMETER_ARTICLE_SUBCATEGORY_ID = new SqlParameter(ArticleFieldName.ARTICLE_SUBCATEGORY_ID + PARAM_IN, Types.INTEGER);
        public static final SqlParameter SQL_PARAMETER_ARTICLE_NAME = new SqlParameter(ArticleFieldName.ARTICLE_NAME + PARAM_IN, Types.VARCHAR);
        public static final SqlParameter SQL_PARAMETER_ARTICLE_HTMLTEXT = new SqlParameter(ArticleFieldName.ARTICLE_HTMLTEXT + PARAM_IN, Types.VARCHAR);
        public static final SqlParameter SQL_PARAMETER_ARTICLE_AUTHOR_ID = new SqlParameter(ArticleFieldName.ARTICLE_AUTHOR_ID + PARAM_IN, Types.INTEGER);
        public static final SqlParameter SQL_PARAMETER_ARTICLE_CREATED_DATE = new SqlParameter(ArticleFieldName.ARTICLE_CREATED_DATE + PARAM_IN, Types.DATE);
        public static final SqlParameter SQL_PARAMETER_ARTICLE_LAST_UPDATED_DATE = new SqlParameter(ArticleFieldName.ARTICLE_LAST_UPDATED_DATE + PARAM_IN, Types.DATE);
        public static final SqlParameter SQL_PARAMETER_ARTICLE_ARTICLECOUNT_REWIEW = new SqlParameter(ArticleFieldName.ARTICLE_ARTICLECOUNT_REWIEW + PARAM_IN, Types.INTEGER);

    }

}
