DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSouvenirs`()
BEGIN
	SELECT * FROM souvenir;
END$$
DELIMITER ;
