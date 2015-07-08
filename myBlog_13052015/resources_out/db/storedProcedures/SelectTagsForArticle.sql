DROP PROCEDURE IF EXISTS myblog.SelectTagsForArticle;
CREATE PROCEDURE myblog.`SelectTagsForArticle`(IN article_idIn int(11))
BEGIN
	SELECT ar.article_id, t.tag_name
  from article ar INNER JOIN articletag at ON ar.article_id = at.article_id
  INNER JOIN tag t ON t.tag_id = at.tag_id
  where ar.article_id = article_idIn;
END;