DELIMITER //
CREATE PROCEDURE InsertContact(IN contact_nameIn        varchar(255),
                                  IN contact_emailIn       varchar(255),
                                  IN contact_addressIn     varchar(255),
                                  IN contact_telephoneIn   varchar(255))
   BEGIN
      INSERT INTO contact(contact_name,
                          contact_email,
                          contact_address,
                          contact_telephone)
      VALUES (contact_nameIn,
              contact_emailIn,
              contact_addressIn,
              contact_telephoneIn);
   END
//