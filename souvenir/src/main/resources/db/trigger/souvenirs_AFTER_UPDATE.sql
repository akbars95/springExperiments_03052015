USE `souvenir`;

DELIMITER $$

DROP TRIGGER IF EXISTS souvenir.souvenirs_AFTER_UPDATE$$
USE `souvenir`$$
CREATE DEFINER = CURRENT_USER TRIGGER `souvenir`.`souvenirs_AFTER_UPDATE` AFTER UPDATE ON `souvenirs` FOR EACH ROW
BEGIN
	update souvenirs_audit set last_update_datetime = now() where souvenir_id = OLD.souvenir_id;
END$$
DELIMITER ;
