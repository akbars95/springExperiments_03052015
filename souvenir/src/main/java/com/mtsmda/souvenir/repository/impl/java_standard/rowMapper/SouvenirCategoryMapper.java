package com.mtsmda.souvenir.repository.impl.java_standard.rowMapper;

import static com.mtsmda.souvenir.model.sp.SouvenirCategorySP.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mtsmda.souvenir.model.Captcha;
import com.mtsmda.souvenir.model.SouvenirCategory;

public class SouvenirCategoryMapper{
	
	public SouvenirCategory mapRow(ResultSet rs) {
		SouvenirCategory souvenirCategory = new SouvenirCategory();
		try {
			souvenirCategory.setSouvenirCategoryId(rs.getInt(columnLabel));
		} catch (SQLException e) {
			captcha.setCaptchaId(null);
		}
		
		try {
			captcha.setCaptchaUrlFile(rs.getString(CAPTCHA_URL_FILE));
		} catch (SQLException e) {
			captcha.setCaptchaId(null);
		}
		
		try {
			captcha.setCaptchaValue(rs.getString(CAPTCHA_VALUE));
		} catch (SQLException e) {
			captcha.setCaptchaValue(null);
		}

		return souvenirCategory;
	}

	
}