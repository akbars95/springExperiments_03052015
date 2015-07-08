CREATE TABLE `article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `subcategory_id` int(11) NOT NULL,
  `article_name` varchar(50) DEFAULT NULL,
  `article_htmltext` text CHARACTER SET latin1,
  `article_author_id` int(11) NOT NULL,
  `article_created_date` datetime NOT NULL,
  `article_last_updated_date` datetime DEFAULT NULL,
  `articleCount_rewiew` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`article_id`),
  KEY `article_author_id_fk` (`article_author_id`),
  KEY `subcategory_id_fk` (`subcategory_id`),
  CONSTRAINT `article_author_id_fk` FOREIGN KEY (`article_author_id`) REFERENCES `author` (`author_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `subcategory_id_fk` FOREIGN KEY (`subcategory_id`) REFERENCES `subcategory` (`subcategory_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;