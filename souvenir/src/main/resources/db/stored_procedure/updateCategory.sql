DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateCategory`(IN souvenir_categoryIN varchar(50), IN souvenir_category_idIN int(11))
BEGIN
UPDATE souvenir_categories SET souvenir_category = souvenir_categoryIN
WHERE souvenir_category_id = souvenir_category_idIN;
END$$
DELIMITER ;
