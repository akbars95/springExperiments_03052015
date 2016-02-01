DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `getCategoryByNameLike`(IN souvenir_categoryIN VARCHAR(50))
BEGIN
select *
from souvenir_categories sc
where sc.souvenir_category like souvenir_categoryIN;
END$$
DELIMITER ;
