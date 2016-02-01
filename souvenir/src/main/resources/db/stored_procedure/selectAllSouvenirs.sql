DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `selectAllSouvenirs`()
BEGIN
	SELECT * FROM fullselectsouvenirs;
END$$
DELIMITER ;
