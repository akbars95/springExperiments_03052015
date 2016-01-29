DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `selectSouvenir`(IN souvenirIdIN int(11))
BEGIN
	SELECT * FROM fullselectsouvenirs WHERE souvenir_id = souvenirIdIN;
END$$
DELIMITER ;
