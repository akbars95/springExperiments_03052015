CREATE TABLE `article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `subcategory_id` int(11) NOT NULL,
  `article_name` varchar(50) DEFAULT NULL,
  `article_htmltext` text CHARACTER SET latin1,
  `article_author_id` int(11) NOT NULL,
  `article_created_date` datetime NOT NULL,
  `article_last_updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`article_id`),
  CONSTRAINT subcategory_id_fk FOREIGN KEY (subcategory_id) REFERENCES myblog.subcategory (subcategory_id) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT article_author_id_fk FOREIGN KEY (article_author_id) REFERENCES myblog.author (author_id) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
