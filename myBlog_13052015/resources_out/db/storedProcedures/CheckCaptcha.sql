DROP PROCEDURE IF EXISTS myblog.CheckCaptcha;
CREATE PROCEDURE myblog.`CheckCaptcha`(IN captcha_valueCaptchaIN varchar(11))
BEGIN
	
  select *
  from captcha c
  where c.captcha_valueCaptcha = binary captcha_valueCaptchaIN;
  
END;
