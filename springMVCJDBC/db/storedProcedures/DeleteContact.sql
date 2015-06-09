DELIMITER //
CREATE PROCEDURE DeleteContact (IN contact_idIn int)
BEGIN
	DELETE FROM contact WHERE contact_id = contact_idIn;
END//
