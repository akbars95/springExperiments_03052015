DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `getLastAddedCategoryIdgetLastAddedCategoryId`()
BEGIN
select MAX(souvenir_category_id)
    from souvenir_categories;
END$$
DELIMITER ;
