package com.mtsmda.myBlog.model.dbConst;

import org.springframework.jdbc.core.SqlParameter;

import java.sql.Types;

import static com.mtsmda.myBlog.model.dbConst.CommonConst.PARAM_IN;

/**
 * Created by c-DMITMINZ on 6/11/2015.
 */
public interface CommentDbConst {

    public interface CommentFieldName {

        public static final String COMMENT_ID = "comment_id";
        public static final String COMMENT_AUTHOR_ID = "comment_author_id";
        public static final String COMMENT_CREATED_DATE = "comment_created_date";
        public static final String COMMENT_TEXT = "comment_text";

    }

    public interface CommentSPName {

        public static final String INSERT_COMMENT = "InsertComment";
        public static final String UPDATE_COMMENT = "UpdateComment";
        public static final String DELETE_COMMENT = "DeleteComment";
        public static final String SELECT_ALL_COMMENT = "SelectAllComment";
        public static final String SELECT_COMMENT = "SelectComment";

    }

    public interface CommentSPParamName {

        public static final SqlParameter SQL_PARAMETER_COMMENT_ID = new SqlParameter(CommentFieldName.COMMENT_ID + PARAM_IN, Types.INTEGER);
        public static final SqlParameter SQL_PARAMETER_COMMENT_AUTHOR_ID = new SqlParameter(CommentFieldName.COMMENT_AUTHOR_ID + PARAM_IN, Types.INTEGER);
        public static final SqlParameter SQL_PARAMETER_COMMENT_CREATED_DATE = new SqlParameter(CommentFieldName.COMMENT_CREATED_DATE + PARAM_IN, Types.DATE);
        public static final SqlParameter SQL_PARAMETER_COMMENT_TEXT = new SqlParameter(CommentFieldName.COMMENT_TEXT + PARAM_IN, Types.VARCHAR);

    }

}
