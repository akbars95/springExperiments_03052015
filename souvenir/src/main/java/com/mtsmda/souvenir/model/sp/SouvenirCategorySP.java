package com.mtsmda.souvenir.model.sp;

import org.springframework.jdbc.core.SqlParameter;

import java.sql.Types;

/**
 * Created by c-DMITMINZ on 29.01.2016.
 */
public class SouvenirCategorySP {

    public static final String INSERT_SOUVENIR_CATEGORY_SP_NAME = "insertCategory";
    public static final String UPDATE_SOUVENIR_CATEGORY_SP_NAME = "updateCategory";
    public static final String DELETE_SOUVENIR_CATEGORY_SP_NAME = "deleteCategoryById";
    public static final String GET_SOUVENIR_CATEGORY_SP_NAME = "getCategoryById";
    public static final String GET_ALL_SOUVENIR_CATEGORIES_SP_NAME = "getAllCategories";


    public static final String SOUVENIR_CATEGORY_IN_SP_PARAM_NAME = "souvenir_categoryIN";
    public static final String SOUVENIR_CATEGORY_ID_IN_SP_PARAM_NAME = "souvenir_category_idIN";


    public static final SqlParameter SOUVENIR_CATEGORY_IN_SP_SQL_PARAM = new SqlParameter(SOUVENIR_CATEGORY_IN_SP_PARAM_NAME, Types.VARCHAR);
    public static final SqlParameter SOUVENIR_CATEGORY_ID_IN_SP_SQL_PARAM = new SqlParameter(SOUVENIR_CATEGORY_ID_IN_SP_PARAM_NAME, Types.INTEGER);


}