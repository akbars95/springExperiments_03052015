DELIMITER $$
CREATE PROCEDURE `getAllCategories`()
BEGIN
select * from souvenir_categories;
END$$
DELIMITER ;
