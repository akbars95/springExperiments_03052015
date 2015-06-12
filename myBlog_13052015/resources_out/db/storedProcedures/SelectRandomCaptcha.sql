DROP PROCEDURE IF EXISTS myblog.SelectRandomCaptcha;
CREATE PROCEDURE myblog.`SelectRandomCaptcha`()
BEGIN
	DECLARE maxID INT;
  DECLARE constrainst int;
  SELECT MAX(c.captcha_id) INTO maxID FROM captcha c;
  
  SET constrainst = maxID * Rand();
  
  IF constrainst <= 0 THEN
  WHILE constrainst <= 0 DO
    SET constrainst = maxID * Rand();
  END WHILE;
  /*SELECT constrainst;*/
  SELECT * FROM captcha c WHERE c.captcha_id = constrainst;
  ELSE SELECT * FROM captcha c WHERE c.captcha_id = constrainst;
  END IF;
  /*SELECT constrainst;*/
--   SELECT IF(constrainst > 0,constrainst,'-');
  /*IF (constrainst > 0, SELECT * FROM captcha c WHERE c.captcha_id = constrainst;,'')  */
  
END;
