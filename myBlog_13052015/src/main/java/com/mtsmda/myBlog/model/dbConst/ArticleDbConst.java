package com.mtsmda.myBlog.model.dbConst;

import org.springframework.jdbc.core.SqlParameter;

import java.sql.Types;

import static com.mtsmda.myBlog.model.dbConst.CommonConst.PARAM_IN;

/**
 * Created by c-DMITMINZ on 6/11/2015.
 */
public interface ArticleDbConst {

    public interface CaptchaFieldName {

        public static final String CAPTCHA_ID = "captcha_id";
        public static final String CAPTCHA_PATH_TO_IMAGE = "captcha_pathToImage";
        public static final String CAPTCHA_VALUE_CAPTCHA = "captcha_valueCaptcha";

    }

    public interface CaptchaSPName {

        public static final String INSERT_CAPTCHA = "InsertCaptcha";
        public static final String UPDATE_CAPTCHA = "UpdateCaptcha";
        public static final String DELETE_CAPTCHA = "DeleteCaptcha";
        public static final String SELECT_ALL_CAPTCHA = "SelectAllCaptcha";
        public static final String SELECT_CAPTCHA = "SelectCaptcha";
        public static final String SELECT_RANDOM_CAPTCHA = "SelectRandomCaptcha";
        public static final String CHECK_CAPTCHA = "CheckCaptcha";

    }

    public interface CaptchaSPParamName {

        public static final SqlParameter SQL_PARAMETER_ID = new SqlParameter(CaptchaFieldName.CAPTCHA_ID + PARAM_IN, Types.INTEGER);
        public static final SqlParameter SQL_PARAMETER_CAPTCHA_PATH_TO_IMAGE = new SqlParameter(CaptchaFieldName.CAPTCHA_PATH_TO_IMAGE + PARAM_IN, Types.VARCHAR);
        public static final SqlParameter SQL_PARAMETER_CAPTCHA_VALUE_CAPTCHA = new SqlParameter(CaptchaFieldName.CAPTCHA_VALUE_CAPTCHA + PARAM_IN, Types.VARCHAR);
//        public static final SqlInOutParameter SQL_PARAMETER_RESULT_INOUT = new SqlInOutParameter("result" + PARAM_INOUT, Types.INTEGER);

    }

}
