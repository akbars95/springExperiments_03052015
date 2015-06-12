DELIMITER //
CREATE PROCEDURE SelectCaptcha (IN captcha_idIn int)
BEGIN
  	SELECT * FROM captcha c WHERE c.captcha_id = captcha_idIn;
END
//