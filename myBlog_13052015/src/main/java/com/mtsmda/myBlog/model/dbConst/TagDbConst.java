package com.mtsmda.myBlog.model.dbConst;

import org.springframework.jdbc.core.SqlParameter;

import java.sql.Types;

import static com.mtsmda.myBlog.model.dbConst.CommonConst.PARAM_IN;

/**
 * Created by c-DMITMINZ on 6/11/2015.
 */
public interface TagDbConst {

    public interface TagFieldName {

        public static final String TAG_ID = "tag_id";
        public static final String TAG_NAME = "tag_name";

    }

    public interface TagSPName {

        public static final String INSERT_TAG = "InsertTag";
        public static final String UPDATE_TAG = "UpdateTag";
        public static final String DELETE_TAG = "DeleteTag";
        public static final String SELECT_ALL_TAG = "SelectAllTag";
        public static final String SELECT_TAG = "SelectTag";

    }

    public interface TagSPParamName {

        public static final SqlParameter SQL_PARAMETER_TAG_ID = new SqlParameter(TagFieldName.TAG_ID + PARAM_IN, Types.INTEGER);
        public static final SqlParameter SQL_PARAMETER_TAG_NAME = new SqlParameter(TagFieldName.TAG_NAME + PARAM_IN, Types.VARCHAR);
    }

}
