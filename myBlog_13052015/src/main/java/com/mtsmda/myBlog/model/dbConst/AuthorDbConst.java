package com.mtsmda.myBlog.model.dbConst;

import org.springframework.jdbc.core.SqlParameter;

import java.sql.Types;

import static com.mtsmda.myBlog.model.dbConst.CommonConst.PARAM_IN;

/**
 * Created by c-DMITMINZ on 6/11/2015.
 */
public interface AuthorDbConst {

    public interface AuthorFieldName {

        public static final String AUTHOR_ID = "author_id";
        public static final String AUTHOR_LASTNAME = "author_lastname";
        public static final String AUTHOR_FIRSTNAME = "author_firstname";
        public static final String AUTHOR_MIDDLENAME = "author_middlename";
        public static final String AUTHOR_EMAIL = "author_email";
        public static final String AUTHOR_SEX = "author_sex";
        public static final String AUTHOR_DATEOFBIRTH = "author_dateOfBirth";

    }

    public interface AuthorSPName {

        public static final String INSERT_AUTHOR = "InsertAuthor";
        public static final String UPDATE_AUTHOR = "UpdateAuthor";
        public static final String DELETE_AUTHOR = "DeleteAuthor";
        public static final String SELECT_ALL_AUTHOR = "SelectAllAuthor";
        public static final String SELECT_AUTHOR = "SelectAuthor";

    }

    public interface AuthorSPParamName {

        public static final SqlParameter SQL_PARAMETER_AUTHOR_ID = new SqlParameter(AuthorFieldName.AUTHOR_ID + PARAM_IN, Types.INTEGER);
        public static final SqlParameter SQL_PARAMETER_AUTHOR_LASTNAME = new SqlParameter(AuthorFieldName.AUTHOR_LASTNAME + PARAM_IN, Types.VARCHAR);
        public static final SqlParameter SQL_PARAMETER_AUTHOR_FIRSTNAME = new SqlParameter(AuthorFieldName.AUTHOR_FIRSTNAME + PARAM_IN, Types.VARCHAR);
        public static final SqlParameter SQL_PARAMETER_AUTHOR_MIDDLENAME = new SqlParameter(AuthorFieldName.AUTHOR_MIDDLENAME + PARAM_IN, Types.VARCHAR);
        public static final SqlParameter SQL_PARAMETER_AUTHOR_EMAIL = new SqlParameter(AuthorFieldName.AUTHOR_EMAIL + PARAM_IN, Types.VARCHAR);
        public static final SqlParameter SQL_PARAMETER_AUTHOR_SEX = new SqlParameter(AuthorFieldName.AUTHOR_SEX + PARAM_IN, Types.VARCHAR);
        public static final SqlParameter SQL_PARAMETER_AUTHOR_DATEOFBIRTH = new SqlParameter(AuthorFieldName.AUTHOR_DATEOFBIRTH + PARAM_IN, Types.DATE);

    }

}
