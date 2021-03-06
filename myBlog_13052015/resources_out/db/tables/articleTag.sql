CREATE TABLE `articletag` (
  `articletag_id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  PRIMARY KEY (`articletag_id`),
  CONSTRAINT article_id_fk FOREIGN KEY (article_id) REFERENCES myblog.article (article_id) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT tag_id_fk FOREIGN KEY (tag_id) REFERENCES myblog.tag (tag_id) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
