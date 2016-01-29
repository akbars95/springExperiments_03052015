DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertCategory`(IN souvenir_categoryIN varchar(50))
BEGIN
INSERT INTO souvenir_categories(souvenir_category) values(souvenir_categoryIN);
END$$
DELIMITER ;
