DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSouvenirs`()
BEGIN
	SELECT * FROM SOUVENIRS;
END$$
DELIMITER ;
