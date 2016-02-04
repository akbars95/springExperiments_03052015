DELIMITER $$
CREATE PROCEDURE getCaptchaById (IN captcha_idIN int(11))
BEGIN
	SELECT * FROM captcha WHERE captcha_id = captcha_idIN;
END$$
DELIMITER ;