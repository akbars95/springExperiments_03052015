CREATE PROCEDURE selectSouvenir (IN souvenirIdIN int(11))
BEGIN
	SELECT * FROM souvenir WHERE souvenir_id = souvenirIdIN;
END;