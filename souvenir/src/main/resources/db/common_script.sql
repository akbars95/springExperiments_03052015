
		/*drop and create database*/
DROP DATABASE IF EXISTS souvenir;
DROP USER IF EXISTS 'souvenir'@'localhost';

CREATE DATABASE IF NOT EXISTS souvenir CHARACTER SET utf8 COLLATE utf8_bin;

CREATE USER 'souvenir'@'localhost' IDENTIFIED BY 'souvenir12345';
GRANT ALL PRIVILEGES ON souvenir. * TO 'souvenir'@'localhost';


		/*tables*/
use souvenir;

CREATE TABLE `souvenir_categories` (
  `souvenir_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `souvenir_category` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`souvenir_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


CREATE TABLE `souvenirs` (
  `souvenir_id` int(11) NOT NULL AUTO_INCREMENT,
  `souvenir_name` varchar(50) NOT NULL,
  `souvenir_description` varchar(255) DEFAULT NULL,
  `souvenir_show` tinyint(1) NOT NULL DEFAULT '1',
  `souvenir_path` varchar(300) NOT NULL,
  `souvenir_category_id` int(11) DEFAULT NULL,
  `souvenir_price` decimal(8,2) DEFAULT NULL,
  `souvenir_count_of_days_for_order` int(11) DEFAULT NULL,
  PRIMARY KEY (`souvenir_id`),
  KEY `souvenir_category_id_souvenir_id_idx` (`souvenir_category_id`),
  CONSTRAINT `souvenir_category_id_souvenir_id` FOREIGN KEY (`souvenir_category_id`) REFERENCES `souvenir_categories` (`souvenir_category_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `souvenirs_audit` (
  `souvenir_id` int(11) NOT NULL,
  `created_datetime` datetime DEFAULT NULL,
  `last_update_datetime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


		/*views*/
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `fullselectsouvenirs` AS
select `s`.`souvenir_id` AS `souvenir_id`,`s`.`souvenir_name` AS `souvenir_name`,`s`.`souvenir_description` AS `souvenir_description`,`s`.`souvenir_show` AS `souvenir_show`,`s`.`souvenir_path` AS `souvenir_path`,`s`.`souvenir_category_id` AS `souvenir_category_id`,`s`.`souvenir_price` AS `souvenir_price`,`s`.`souvenir_count_of_days_for_order` AS `souvenir_count_of_days_for_order`,`sc`.`souvenir_category` AS `souvenir_category`
from (`souvenirs` `s` join `souvenir_categories` `sc` on((`s`.`souvenir_category_id` = `sc`.`souvenir_category_id`)));


		/*triggers*/
USE `souvenir`;

DELIMITER $$

DROP TRIGGER IF EXISTS souvenir.souvenirs_AFTER_INSERT$$
USE `souvenir`$$
CREATE DEFINER = CURRENT_USER TRIGGER `souvenir`.`souvenirs_AFTER_INSERT` AFTER INSERT ON `souvenirs` FOR EACH ROW
BEGIN
SET @lastID = 0;

CALL `souvenir`.`getLastAddedSouvenirId`(@lastID);

insert into souvenirs_audit(souvenir_id, created_datetime, last_update_datetime) values(NEW.souvenir_id , current_timestamp(), now());/*@lastID instead of NEW.souvenir_id */
END$$
DELIMITER ;

USE `souvenir`;

DELIMITER $$

DROP TRIGGER IF EXISTS souvenir.souvenirs_AFTER_UPDATE$$
USE `souvenir`$$
CREATE DEFINER = CURRENT_USER TRIGGER `souvenir`.`souvenirs_AFTER_UPDATE` AFTER UPDATE ON `souvenirs` FOR EACH ROW
BEGIN
	update souvenirs_audit set last_update_datetime = now() where souvenir_id = OLD.souvenir_id;
END$$
DELIMITER ;


		/*stored_procedures*/
DELIMITER $$
CREATE PROCEDURE `getAllCategories`()
BEGIN
select * from souvenir_categories;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `getCategoryById` (IN souvenir_category_idIN INT(11))
BEGIN
SELECT * from souvenir_categories sc
where sc.souvenir_category_id = souvenir_category_idIN;
END$$

DELIMITER ;


DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `getCategoryByNameLike`(IN souvenir_categoryIN VARCHAR(50))
BEGIN
select *
from souvenir_categories sc
where sc.souvenir_category like souvenir_categoryIN;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `getLastAddedCategoryIdgetLastAddedCategoryId`()
BEGIN
select MAX(souvenir_category_id)
    from souvenir_categories;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `getLastAddedSouvenirId`(INOUT lastID INT)
BEGIN
	select MAX(souvenir_id) into lastID
    from souvenirs;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `insertCategory`(IN souvenir_categoryIN varchar(50))
BEGIN
INSERT INTO souvenir_categories(souvenir_category) values(souvenir_categoryIN);
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `insertsouvenirs`(IN souvenir_nameIN VARCHAR(50), IN souvenir_descriptionIN VARCHAR(255), IN souvenir_showIN TINYINT(1), IN souvenir_pathIN VARCHAR(300),
									IN souvenir_category_idIN INT(11), IN souvenir_priceIN DECIMAL(8,2), IN souvenir_count_of_days_for_orderIN INT(11))
BEGIN
	insert into souvenirs(souvenir_name, souvenir_description, souvenir_show, souvenir_path, souvenir_category_id, souvenir_price, souvenir_count_of_days_for_order)
    values(souvenir_nameIN, souvenir_descriptionIN, souvenir_showIN, souvenir_pathIN, souvenir_category_idIN, souvenir_priceIN, souvenir_count_of_days_for_orderIN);
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `selectAllSouvenirs`()
BEGIN
	SELECT * FROM fullselectsouvenirs;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `selectSouvenir`(IN souvenirIdIN int(11))
BEGIN
	SELECT * FROM fullselectsouvenirs WHERE souvenir_id = souvenirIdIN;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `updateCategory`(IN souvenir_categoryIN varchar(50), IN souvenir_category_idIN int(11))
BEGIN
UPDATE souvenir_categories SET souvenir_category = souvenir_categoryIN
WHERE souvenir_category_id = souvenir_category_idIN;
END$$
DELIMITER ;

