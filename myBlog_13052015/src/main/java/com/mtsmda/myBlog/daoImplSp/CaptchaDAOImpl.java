package com.mtsmda.myBlog.daoImplSp;

import com.mtsmda.myBlog.SP.BlogStoredProcedure;
import com.mtsmda.myBlog.dao.CaptchaDAO;
import com.mtsmda.myBlog.model.Captcha;
import com.mtsmda.myBlog.model.dbConst.CaptchaDbConst;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.mtsmda.myBlog.model.dbConst.CaptchaDbConst.CaptchaFieldName.*;
import static com.mtsmda.myBlog.model.dbConst.CaptchaDbConst.CaptchaSPName.*;

/**
 * Created by c-DMITMINZ on 6/11/2015.
 */
public class CaptchaDAOImpl implements CaptchaDAO {

    private static final Logger logger = Logger.getLogger(CaptchaDAOImpl.class);

    private JdbcTemplate jdbcTemplate;

    private DataSource dataSource;

    private BlogStoredProcedure blogStoredProcedure;

    @Autowired
    public CaptchaDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    @Override
    public void saveOrUpdateCaptcha(Captcha captcha) {

    }

    @Override
    public void deleteCaptcha(Integer captchaId) {

    }

    @Override
    public Captcha getCaptcha(Integer captchaId) {
        logger.info(this.getClass().getCanonicalName() + ".getCaptcha(Integer captchaId)");

        List<Captcha> captchaList = null;
        Captcha captcha = null;

        List<SqlParameter> sqlParameters = new ArrayList<SqlParameter>();
        sqlParameters.add(CaptchaDbConst.CaptchaSPParamName.SQL_PARAMETER_CAPTCHA_VALUE_CAPTCHA);


        blogStoredProcedure = new BlogStoredProcedure(dataSource, SELECT_CAPTCHA, sqlParameters);
        logger.info("call " + SELECT_CAPTCHA + " stored procedure");
        //blogStoredProcedure.compile();
        Map<String, Object> contactsMap = blogStoredProcedure.execute(captchaId);
        captchaList = getResultFromSP(contactsMap, captchaList);
        if (captchaList != null && !captchaList.isEmpty() && captchaList.get(0) != null) {
            captcha = captchaList.get(0);
        }
        return captcha;
    }

    @Override
    public List<Captcha> getAllCaptcha() {
        return null;
    }

    @Override
    public Captcha getRandomCaptcha() {
        logger.info(this.getClass().getCanonicalName() + ".getRandomCaptcha()");
        List<Captcha> captchaList = null;
        Captcha captcha = null;
        blogStoredProcedure = new BlogStoredProcedure(dataSource, SELECT_RANDOM_CAPTCHA, null);
        logger.info("call " + SELECT_RANDOM_CAPTCHA + " stored procedure");
        blogStoredProcedure.compile();
        Map<String, Object> contactsMap = blogStoredProcedure.execute();
        captchaList = getResultFromSP(contactsMap, captchaList);
        if (captchaList != null && !captchaList.isEmpty() && captchaList.get(0) != null) {
            captcha = captchaList.get(0);
        }
        logger.info(this.getClass().getCanonicalName() + ".getRandomCaptcha()" + " return captcha object " + captcha);
        return captcha;
    }

    @Override
    public boolean checkCaptcha(String captchaValue) {
        logger.info(this.getClass().getCanonicalName() + ".checkCaptcha()");

        List<Captcha> captchaList = null;
        Captcha captcha = null;

        List<SqlParameter> sqlParameters = new ArrayList<SqlParameter>();
        sqlParameters.add(CaptchaDbConst.CaptchaSPParamName.SQL_PARAMETER_CAPTCHA_VALUE_CAPTCHA);


        blogStoredProcedure = new BlogStoredProcedure(dataSource, CHECK_CAPTCHA, sqlParameters);
        logger.info("call " + CHECK_CAPTCHA + " stored procedure");
        //blogStoredProcedure.compile();
        Map<String, Object> contactsMap = blogStoredProcedure.execute(captchaValue);
        captchaList = getResultFromSP(contactsMap, captchaList);
        if (captchaList != null && !captchaList.isEmpty() && captchaList.get(0) != null) {
            captcha = captchaList.get(0);
        }
        if(captcha != null && StringUtils.isNotBlank(captcha.getValueCaptcha()) && captcha.getValueCaptcha().equals(captchaValue)){
            logger.info("captcha is equal");
            return true;
        }

        return false;
    }

    private List<Captcha> getResultFromSP(Map<String, Object> contactsMap, List<Captcha> list) {
        list = new ArrayList<Captcha>();
        if (!contactsMap.isEmpty()) {
            int i = 0;
            for (String key : contactsMap.keySet()) {
                i++;
                if (key != null && contactsMap.get(key) != null && contactsMap.get(key) instanceof List<?>) {
                    List<?> resultListWithContact = (List<?>) contactsMap.get(key);
                    if (!resultListWithContact.isEmpty()) {
                        for (int j = 0; j < resultListWithContact.size(); j++) {
                            if (resultListWithContact.get(j) instanceof Map) {
                                Map<String, Object> tableFieldMap = (Map<String, Object>) resultListWithContact.get(j);
                                logger.info("get captcha object from result sp");
                                Captcha captcha = new Captcha();
                                captcha.setIdCaptcha(Integer.parseInt(tableFieldMap.get(CAPTCHA_ID).toString()));
                                captcha.setPathToImage(tableFieldMap.get(CAPTCHA_PATH_TO_IMAGE).toString());
                                captcha.setValueCaptcha(tableFieldMap.get(CAPTCHA_VALUE_CAPTCHA).toString());
                                list.add(captcha);
                            }
                        }


                    }
                }
                if (i == 1) {
                    break;
                }
            }
        }
        return list;
    }


}
