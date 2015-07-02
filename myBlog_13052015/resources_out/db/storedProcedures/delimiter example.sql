DELIMITER //
CREATE PROCEDURE SelectArticle (IN article_idIn int(11))
BEGIN
	select * from article;
END
//