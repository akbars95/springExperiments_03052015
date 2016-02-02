DROP FUNCTION IF EXISTS souvenir.souvenirIsUpdated;
CREATE FUNCTION souvenir.`souvenirIsUpdated`(souvenir_idIN int(11)) RETURNS tinyint(4)
BEGIN
	DECLARE isUpdated TINYINT;
  DECLARE created_datetimeL datetime;
  DECLARE last_update_datetimeL datetime;
  
  select created_datetime, last_update_datetime into created_datetimeL, last_update_datetimeL
  FROM souvenirs_audit sa
  where /*sa.created_datetime = sa.last_update_datetime and */ sa.souvenir_id = souvenir_idIN;
  
  IF created_datetimeL = last_update_datetimeL
  THEN SET isUpdated = 0;
  ELSE SET isUpdated = 1;
  END IF;
  
	RETURN isUpdated;
END;
