CREATE TABLE `article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `subcategory_id` int(11) NOT NULL,
  `article_name` varchar(50) DEFAULT NULL,
  `article_htmltext` text CHARACTER SET latin1,
  `article_author_id` int(11) NOT NULL,
  `article_created_date` datetime NOT NULL,
  `article_last_updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
