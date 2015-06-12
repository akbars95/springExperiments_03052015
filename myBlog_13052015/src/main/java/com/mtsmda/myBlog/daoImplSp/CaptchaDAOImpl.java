package com.mtsmda.myBlog.daoImplSp;

import com.mtsmda.myBlog.SP.CaptchaSP;
import com.mtsmda.myBlog.dao.CaptchaDAO;
import com.mtsmda.myBlog.model.Captcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.mtsmda.myBlog.model.dbConst.CaptchaDbConst.CaptchaFieldName.*;
import static com.mtsmda.myBlog.model.dbConst.CaptchaDbConst.CaptchaSPName.*;
import static com.mtsmda.myBlog.model.dbConst.CaptchaDbConst.CaptchaSPParamName.*;

/**
 * Created by c-DMITMINZ on 6/11/2015.
 */
public class CaptchaDAOImpl implements CaptchaDAO {

    private JdbcTemplate jdbcTemplate;

    private DataSource dataSource;

    private CaptchaSP captchaSP;

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
        return null;
    }

    @Override
    public List<Captcha> getAllCaptcha() {
        return null;
    }

    @Override
    public Captcha getRandomCaptcha() {
        List<Captcha> captchaList = null;
        Captcha captcha = null;
        captchaSP = new CaptchaSP(dataSource, SELECT_RANDOM_CAPTCHA, null);
        Map<String, Object> contactsMap = captchaSP.execute();
        captchaList = getResultFromSP(contactsMap, captchaList);
        if (captchaList != null && !captchaList.isEmpty() && captchaList.get(0) != null) {
            captcha = captchaList.get(0);
        }
        return captcha;
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
