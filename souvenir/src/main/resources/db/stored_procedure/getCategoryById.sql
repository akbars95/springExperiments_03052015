DELIMITER $$
CREATE PROCEDURE `getCategoryById` (IN souvenir_category_idIN INT(11))
BEGIN
SELECT * from souvenir_categories sc
where sc.souvenir_category_id = souvenir_category_idIN;
END$$

DELIMITER ;

