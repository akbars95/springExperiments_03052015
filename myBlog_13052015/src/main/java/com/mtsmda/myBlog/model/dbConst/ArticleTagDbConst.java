package com.mtsmda.myBlog.model.dbConst;

import com.mtsmda.myBlog.model.ArticleTag;
import org.springframework.jdbc.core.SqlParameter;

import java.sql.Types;

import static com.mtsmda.myBlog.model.dbConst.CommonConst.PARAM_IN;

/**
 * Created by c-DMITMINZ on 6/11/2015.
 */
public interface ArticleTagDbConst {

    public interface ArticleTagFieldName {

        public static final String ARTICLETAG_ID = "articletag_id";
        public static final String ARTICLE_ID = "article_id";
        public static final String TAG_ID = "tag_id";

    }

    public interface ArticleTagSPName {

        public static final String INSERT_ARTICLE = "InsertArticleTag";
        public static final String UPDATE_ARTICLE = "UpdateArticleTag";
        public static final String DELETE_ARTICLE = "DeleteArticleTag";
        public static final String SELECT_ALL_ARTICLE = "SelectAllArticleTag";
        public static final String SELECT_ARTICLE = "SelectArticleTag";

    }

    public interface ArticleTagSPParamName {

        public static final SqlParameter SQL_PARAMETER_ARTICLETAG_ID = new SqlParameter(ArticleTagFieldName.ARTICLETAG_ID + PARAM_IN, Types.INTEGER);
        public static final SqlParameter SQL_PARAMETER_ARTICLE_ID = new SqlParameter(ArticleTagFieldName.ARTICLE_ID + PARAM_IN, Types.INTEGER);
        public static final SqlParameter SQL_PARAMETER_TAG_ID = new SqlParameter(ArticleTagFieldName.TAG_ID + PARAM_IN, Types.INTEGER);

    }

}
