DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllCategories`()
BEGIN
select * from souvenir_categories;
END$$
DELIMITER ;
