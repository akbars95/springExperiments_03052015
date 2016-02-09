package com.mtsmda.souvenir.repository.impl.java_standard;

import com.mtsmda.souvenir.exception.SouvenirException;
import com.mtsmda.souvenir.helper.ListHelper;
import com.mtsmda.souvenir.helper.MapHelper;
import com.mtsmda.souvenir.helper.SouvenirStandardSP;
import com.mtsmda.souvenir.model.Captcha;
import com.mtsmda.souvenir.repository.CaptchaRepository;
import com.mtsmda.souvenir.repository.impl.java_standard.rowMapper.CaptchaMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.mtsmda.souvenir.model.sp.CaptchaSP.*;

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
		Captcha captcha = null;
		try {
			CaptchaMapper captchaMapper = new CaptchaMapper();
			Map<String, Object> mapParam = new LinkedHashMap<>();
			mapParam.put(CAPTCHA_ID_IN_SP_PARAM_NAME, idCaptcha);

			CallableStatement callableStatement = SouvenirStandardSP.execute(this.dataSource, GET_CAPTCHA_BY_ID_SP_NAME,
					mapParam, false);
			ResultSet rs = callableStatement.executeQuery();
			while (rs.next()) {
				captcha = captchaMapper.mapRow(rs);
			}
		} catch (SQLException e) {
			throw new SouvenirException("getCaptchaById - " + e.getMessage());
		}
		return captcha;
	}

	@Override
	public List<Captcha> getAllCaptcha() {
		return null;
	}

	@Override
	public Captcha getRandomCaptcha(Captcha captchaUser) {
		Captcha captcha = null;
		try {
			CaptchaMapper captchaMapper = new CaptchaMapper();
			Map<String, Object> mapParam = new LinkedHashMap<>();
			mapParam.put(CAPTCHA_ID_IN_SP_PARAM_NAME, captchaUser.getCaptchaId());

			CallableStatement callableStatement = SouvenirStandardSP.execute(this.dataSource,
					GET_RANDOM_CAPTCHA_SP_NAME, mapParam, false);
			ResultSet rs = callableStatement.executeQuery();
			while (rs.next()) {
				captcha = captchaMapper.mapRow(rs);
			}
		} catch (SQLException e) {
			throw new SouvenirException("getRandomCaptcha - " + e.getMessage());
		}
		return captcha;
	}

	@Override
	public Integer getMaxIdCaptcha() {
		Integer maxId = null;
		try {
			CallableStatement callableStatement = SouvenirStandardSP.execute(this.dataSource,
					GET_MAX_ID_CAPTCHA_FN_NAME, null, true);
			callableStatement.registerOutParameter(1, Types.INTEGER);
			callableStatement.execute();
			maxId = callableStatement.getInt(1);
		} catch (SQLException e) {
			throw new SouvenirException("getMaxIdCaptcha - " + e.getMessage());
		}
		return maxId;
	}

	@Override
	public boolean checkCaptcha(Captcha captcha) {
		try {
			CaptchaMapper captchaMapper = new CaptchaMapper();
			List<String> keysList = new ArrayList<>();
			ListHelper.getList(keysList, CAPTCHA_ID_IN_SP_PARAM_NAME, CAPTCHA_VALUE_IN_SP_PARAM_NAME);
			HashMap<String, Object> mapParam = new HashMap<>();
			MapHelper.getMap(mapParam, keysList, captcha.getCaptchaId(), captcha.getCaptchaValue());

			CallableStatement callableStatement = SouvenirStandardSP.execute(this.dataSource, checkCaptcha, mapParam,
					false);
			ResultSet rs = callableStatement.executeQuery();
			while (rs.next()) {
				Captcha mapRow = captchaMapper.mapRow(rs);
				if (mapRow != null && mapRow.getCaptchaId() != null) {
					return true;
				}
			}
		} catch (SQLException e) {
			throw new SouvenirException("getRandomCaptcha - " + e.getMessage());
		}
		return false;
	}
}