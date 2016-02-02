DROP FUNCTION IF EXISTS souvenir.souvenirIsUpdatedV2;
CREATE FUNCTION souvenir.`souvenirIsUpdatedV2`(souvenir_idIN int(11)) RETURNS tinyint(4)
BEGIN
	DECLARE isUpdated TINYINT;
  DECLARE created_datetimeL datetime;
  
  select created_datetime into created_datetimeL
  FROM souvenirs_audit sa
  where sa.created_datetime = sa.last_update_datetime and sa.souvenir_id = souvenir_idIN;
  
  IF created_datetimeL is null
  THEN SET isUpdated = 1;
  ELSE SET isUpdated = 0;
  END IF;
  
	RETURN isUpdated;
END;
