CREATE TABLE `souvenir` (
  `souvenir_id` int(11) NOT NULL AUTO_INCREMENT,
  `souvenir_name` varchar(50) NOT NULL,
  `souvenir_description` varchar(255) DEFAULT NULL,
  `souvenir_show` tinyint(1) NOT NULL DEFAULT '1',
  `souvenir_path` varchar(300) NOT NULL,
  PRIMARY KEY (`souvenir_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;