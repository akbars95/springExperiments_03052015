DELIMITER //
CREATE PROCEDURE SelectContact(IN contact_idIn int)
   BEGIN
      SELECT * FROM contact WHERE contact_id = contact_idIn;
   END
//