DROP PROCEDURE IF EXISTS myblog.SelectAllArticle;
CREATE PROCEDURE myblog.`SelectAllArticle`()
BEGIN
	
  SELECT ar.article_id, ar.article_name, ar.article_htmltext, ar.article_created_date, ar.article_last_updated_date , 
  CONCAT(au.author_lastname, ' ', au.author_firstname, ' ', au.author_middlename) as authorName,
  sc.subcategory_name, c.category_name
  from article ar INNER JOIN author au ON au.author_id = ar.article_author_id
  INNER JOIN subcategory sc ON sc.subcategory_id = ar.subcategory_id
  INNER JOIN category c ON c.category_id = sc.category_id;
  
END;
