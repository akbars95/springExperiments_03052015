
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

CREATE TABLE `captcha` (
  `captcha_id` int(11) NOT NULL AUTO_INCREMENT,
  `captcha_value` varchar(10) CHARACTER SET utf8 NOT NULL,
  `captcha_url_file` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`captcha_id`)
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
CREATE PROCEDURE deleteCaptcha (IN captcha_idIN int(11))
BEGIN
	DELETE FROM captcha WHERE captcha_id = captcha_idIN;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE deleteCategoryById (IN souvenir_category_idIN int(11))
BEGIN
	DELETE FROM souvenir_categories WHERE souvenir_category_id = souvenir_category_idIN;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE getAllCaptcha ()
BEGIN
	SELECT * FROM captcha;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `getAllCategories`()
BEGIN
select * from souvenir_categories;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE getCaptchaById (IN captcha_idIN int(11))
BEGIN
	SELECT * FROM captcha WHERE captcha_id = captcha_idIN;
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
CREATE PROCEDURE insertCaptcha (IN captcha_valueIN varchar(10), IN captcha_url_fileIN varchar(255))
BEGIN
	INSERT INTO captcha(captcha_value, captcha_url_file) VALUES(captcha_valueIN, captcha_url_fileIN);
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
CREATE PROCEDURE updateCaptcha (IN captcha_idIN int(11), IN captcha_valueIN varchar(10), IN captcha_url_fileIN varchar(255))
BEGIN
	UPDATE captcha SET captcha_value = captcha_valueIN, captcha_url_file = captcha_url_fileIN WHERE captcha_id = captcha_idIN;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `updateCategory`(IN souvenir_categoryIN varchar(50), IN souvenir_category_idIN int(11))
BEGIN
UPDATE souvenir_categories SET souvenir_category = souvenir_categoryIN
WHERE souvenir_category_id = souvenir_category_idIN;
END$$
DELIMITER ;

CALL `souvenir`.`insertCategory`('Category 1');
CALL `souvenir`.`insertCategory`('Category 2');
CALL `souvenir`.`insertCategory`('Category 3');
CALL `souvenir`.`insertCategory`('Category 4');
CALL `souvenir`.`insertCategory`('Category 5');

CALL `souvenir`.`insertCategory`('Category 6');
CALL `souvenir`.`updateCategory`('Category 999', 6);
CALL `souvenir`.`deleteCategoryById`(6);




CALL `souvenir`.`insertCaptcha`('192frt$', '/resources/images/captcha/i1.png');
CALL `souvenir`.`insertCaptcha`('1e345t$', '/resources/images/captcha/i2.png');
CALL `souvenir`.`insertCaptcha`('ifhn846', '/resources/images/captcha/i3.png');
CALL `souvenir`.`insertCaptcha`('85235jj', '/resources/images/captcha/i4.png');
CALL `souvenir`.`insertCaptcha`('kjfiptd', '/resources/images/captcha/i5.png');
CALL `souvenir`.`insertCaptcha`('of4965j', '/resources/images/captcha/i6.png');
CALL `souvenir`.`insertCaptcha`('FJ40J4I', '/resources/images/captcha/i7.png');
CALL `souvenir`.`insertCaptcha`('jkJK98i', '/resources/images/captcha/i8.png');
CALL `souvenir`.`insertCaptcha`('orkj403', '/resources/images/captcha/i9.png');
CALL `souvenir`.`insertCaptcha`('93535Ip', '/resources/images/captcha/i10.png');
CALL `souvenir`.`insertCaptcha`('12345', '/resources/images/captcha/i11.png');
CALL `souvenir`.`insertCaptcha`('83f46', '/resources/images/captcha/i12.png');
CALL `souvenir`.`insertCaptcha`('82f4T', '/resources/images/captcha/i13.png');
CALL `souvenir`.`insertCaptcha`('0.5834', '/resources/images/captcha/i14.png');
CALL `souvenir`.`insertCaptcha`('52659', '/resources/images/captcha/i15.png');
CALL `souvenir`.`insertCaptcha`('ifhvno', '/resources/images/captcha/i16.png');
CALL `souvenir`.`insertCaptcha`('ifhO', '/resources/images/captcha/i17.png');
CALL `souvenir`.`insertCaptcha`('po,djr3', '/resources/images/captcha/i18.png');
CALL `souvenir`.`insertCaptcha`('0..692P', '/resources/images/captcha/i19.png');


		/*functions*/
DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION `getMaxIdCaptcha`() RETURNS int(11)
BEGIN
	DECLARE maxIdCaptcha int;
	Select Max(c.captcha_id) into maxIdCaptcha from captcha c;
RETURN maxIdCaptcha;
END$$
DELIMITER ;

DROP FUNCTION IF EXISTS souvenir.souvenirIsUpdated;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION `souvenirIsUpdated`(souvenir_idIN int(11)) RETURNS varchar(5) CHARSET utf8
BEGIN

DECLARE isUpdated VARCHAR(5);
  DECLARE created_datetimeL datetime;
  DECLARE last_update_datetimeL datetime;

  select created_datetime, last_update_datetime into created_datetimeL, last_update_datetimeL
  FROM souvenirs_audit sa
  where sa.souvenir_id = souvenir_idIN;

  IF created_datetimeL = last_update_datetimeL
  THEN SET isUpdated = 'false';
  ELSE SET isUpdated = 'true';
  END IF;

	RETURN isUpdated;

END$$
DELIMITER ;


DROP FUNCTION IF EXISTS souvenir.souvenirIsUpdatedV2;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION souvenir.`souvenirIsUpdatedV2`(souvenir_idIN int(11)) RETURNS VARCHAR(5) CHARSET utf8
BEGIN
  DECLARE isUpdated VARCHAR(5);
  DECLARE created_datetimeL datetime;
  
  select created_datetime into created_datetimeL
  FROM souvenirs_audit sa
  where sa.created_datetime = sa.last_update_datetime and sa.souvenir_id = souvenir_idIN;
  
  IF created_datetimeL is null
  THEN SET isUpdated = 'true';
  ELSE SET isUpdated = 'false';
  END IF;
  
	RETURN isUpdated;
END$$
DELIMITER ;

delete from souvenirs_audit;

insert into souvenirs_audit values(1, now(), now());
insert into souvenirs_audit values(2, now(), now() + 1);

select souvenirIsUpdated(1);
select souvenirIsUpdatedV2(1);

