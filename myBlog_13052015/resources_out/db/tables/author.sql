CREATE TABLE `author` (
  `author_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `author_lastname` varchar(50) NOT NULL,
  `author_firstname` varchar(50) NOT NULL,
  `author_middlename` varchar(100) DEFAULT NULL,
  `author_email` varchar(100) NOT NULL,
  `author_sex` varchar(1) NOT NULL,
  `author_dateOfBirth` date NOT NULL,
  PRIMARY KEY (`author_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
