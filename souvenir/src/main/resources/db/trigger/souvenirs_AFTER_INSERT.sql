USE `souvenir`;

DELIMITER $$

DROP TRIGGER IF EXISTS souvenir.souvenirs_AFTER_INSERT$$
USE `souvenir`$$
CREATE DEFINER = CURRENT_USER TRIGGER `souvenir`.`souvenirs_AFTER_INSERT` AFTER INSERT ON `souvenirs` FOR EACH ROW
BEGIN
SET @lastID = 0;

CALL `souvenir`.`getLastAddedSouvenirId`(@lastID);

insert into souvenirs_audit(souvenir_id, created_datetime, last_update_datetime) values(NEW.souvenir_id , current_timestamp(), now());/*@lastID instead of NEW.souvenir_id */
END$$
DELIMITER ;