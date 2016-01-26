package com.mtsmda.souvenir.model.sp;

import org.springframework.jdbc.core.SqlParameter;

import java.sql.Types;

/**
 * Created by MTSMDA on 19.11.2015.
 */
public class SouvenirSP {

    public static final String SELECT_SOUVENIR_SP_NAME = "selectSouvenir";


    public static final String SOUVENIR_ID_IN_SP_PARAM_NAME = "souvenirIdIN";


    public static final SqlParameter SOUVENIR_ID_IN_SP_SQL_PARAM = new SqlParameter(SOUVENIR_ID_IN_SP_PARAM_NAME, Types.INTEGER);

}