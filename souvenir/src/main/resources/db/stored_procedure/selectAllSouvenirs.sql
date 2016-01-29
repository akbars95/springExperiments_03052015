DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `selectAllSouvenirs`()
BEGIN
	SELECT * FROM fullselectsouvenirs;
END$$
DELIMITER ;
