package com.mtsmda.souvenir.repository.impl.java_standard;

import com.mtsmda.souvenir.exception.SouvenirException;
import com.mtsmda.souvenir.model.Captcha;
import com.mtsmda.souvenir.repository.CaptchaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by MTSMDA on 08.02.2016.
 */
@Repository("captchaRepositoryImplSPJavaStandard")
public class CaptchaRepositoryImplSPJavaStandard implements CaptchaRepository {

    @Autowired
    @Qualifier(value = "mySqlDataSource")
    private DataSource dataSource;

    @Override
    public boolean insertCaptcha(Captcha captcha) {
        return false;
    }

    @Override
    public boolean updateCaptcha(Captcha captcha) {
        return false;
    }

    @Override
    public boolean deleteCaptcha(Captcha captcha) {
        return false;
    }

    @Override
    public Captcha getCaptchaById(Integer idCaptcha) {
        return null;
    }

    @Override
    public List<Captcha> getAllCaptcha() {
        return null;
    }

    @Override
    public Captcha getRandomCaptcha(Captcha captchaUser) {
        Captcha captcha = new Captcha();
        try {
            Connection connection = this.dataSource.getConnection();
            CallableStatement callableStatement = connection.prepareCall("{call getRandomCaptcha(?)}");
            callableStatement.setInt("captcha_idIN", captchaUser.getCaptchaId());
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                captcha.setCaptchaId(rs.getInt(1));
                captcha.setCaptchaUrlFile(rs.getString(2));
            }
        } catch (SQLException e) {
            throw new SouvenirException("getRandomCaptcha - " + e.getMessage());
        }
        return captcha;
    }
}