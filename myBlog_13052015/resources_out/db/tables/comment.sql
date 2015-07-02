CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_author_id` int(11) DEFAULT NULL,
  `comment_created_date` datetime NOT NULL,
  `comment_text` varchar(255) NOT NULL,
  PRIMARY KEY (`comment_id`),
  CONSTRAINT comment_author_id_fk FOREIGN KEY (comment_author_id) REFERENCES myblog.author (author_id) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
