DELIMITER //
CREATE PROCEDURE DeleteContact (IN idIn int)
BEGIN
	DELETE FROM contact WHERE contact_id = idIn;
END//
