package com.mtsmda.myBlog.model.dbConst;

import org.springframework.jdbc.core.SqlParameter;

import java.sql.Types;

import static com.mtsmda.myBlog.model.dbConst.CommonConst.PARAM_IN;

/**
 * Created by c-DMITMINZ on 6/11/2015.
 */
public interface SubCategoryDbConst {

    public interface SubCategoryFieldName {

        public static final String SUBCATEGORY_ID = "subcategory_id";
        public static final String CATEGORY_ID = "category_id";
        public static final String SUBCATEGORY_NAME = "subcategory_name";
        public static final String SUBCATEGORY_DESCRIPTION = "subcategory_description";

    }

    public interface SubCategorySPName {

        public static final String INSERT_SUBCATEGORY = "InsertSubCategory";
        public static final String UPDATE_SUBCATEGORY = "UpdateSubCategory";
        public static final String DELETE_SUBCATEGORY = "DeleteSubCategory";
        public static final String SELECT_ALL_SUBCATEGORY = "SelectAllSubCategory";
        public static final String SELECT_SUBCATEGORY = "SelectSubCategory";

    }

    public interface SubCategorySPParamName {

    public static final SqlParameter SQL_PARAMETER_SUBCATEGORY_ID = new SqlParameter(SubCategoryFieldName.SUBCATEGORY_ID + PARAM_IN, Types.INTEGER);
    public static final SqlParameter SQL_PARAMETER_CATEGORY_ID = new SqlParameter(SubCategoryFieldName.CATEGORY_ID + PARAM_IN, Types.INTEGER);
    public static final SqlParameter SQL_PARAMETER_SUBCATEGORY_NAME = new SqlParameter(SubCategoryFieldName.SUBCATEGORY_NAME + PARAM_IN, Types.VARCHAR);
    public static final SqlParameter SQL_PARAMETER_SUBCATEGORY_DESCRIPTION = new SqlParameter(SubCategoryFieldName.SUBCATEGORY_DESCRIPTION + PARAM_IN, Types.VARCHAR);

    }

}
