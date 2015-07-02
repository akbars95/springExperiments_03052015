package com.mtsmda.myBlog.model.dbConst;

import org.springframework.jdbc.core.SqlParameter;

import java.sql.Types;

import static com.mtsmda.myBlog.model.dbConst.CommonConst.PARAM_IN;

/**
 * Created by c-DMITMINZ on 6/11/2015.
 */
public interface CategoryDbConst {

    public interface CategoryFieldName {

        public static final String CATEGORY_ID = "category_id";
        public static final String CATEGORY_NAME = "category_name";
        public static final String CATEGORY_DESCRIPTION = "category_description";

    }

    public interface CategorySPName {

        public static final String INSERT_CATEGORY = "InsertCategory";
        public static final String UPDATE_CATEGORY = "UpdateCategory";
        public static final String DELETE_CATEGORY = "DeleteCategory";
        public static final String SELECT_ALL_CATEGORY = "SelectAllCategory";
        public static final String SELECT_CATEGORY = "SelectCategory";

    }

    public interface CategorySPParamName {

        public static final SqlParameter SQL_PARAMETER_CATEGORY_ID = new SqlParameter(CategoryFieldName.CATEGORY_ID + PARAM_IN, Types.INTEGER);
        public static final SqlParameter SQL_PARAMETER_CATEGORY_NAME = new SqlParameter(CategoryFieldName.CATEGORY_NAME + PARAM_IN, Types.VARCHAR);
        public static final SqlParameter SQL_PARAMETER_CATEGORY_DESCRIPTION = new SqlParameter(CategoryFieldName.CATEGORY_DESCRIPTION + PARAM_IN, Types.VARCHAR);

    }

}
