CREATE PROCEDURE deleteCategoryById (IN souvenir_category_idIN int(11))
BEGIN
	DELETE FROM souvenir_categories WHERE souvenir_category_id = souvenir_category_idIN;
END;
