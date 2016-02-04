DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION `getMaxIdCaptcha`() RETURNS int(11)
BEGIN
	DECLARE maxIdCaptcha int;
	Select Max(c.captcha_id) into maxIdCaptcha from captcha c;
RETURN maxIdCaptcha;
END$$
DELIMITER ;
