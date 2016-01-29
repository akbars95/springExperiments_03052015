DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getLastAddedSouvenirId`(INOUT lastID INT)
BEGIN
	select MAX(souvenir_id) into lastID
    from souvenirs;
END$$
DELIMITER ;
