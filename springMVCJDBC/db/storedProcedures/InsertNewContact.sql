DELIMITER //
CREATE PROCEDURE InsertNewContact(IN nameIn        varchar(255),
                                  IN emailIn       varchar(255),
                                  IN addressIn     varchar(255),
                                  IN telephoneIn   varchar(255))
   BEGIN
      INSERT INTO contact(name,
                          email,
                          address,
                          telephone)
      VALUES (nameIn,
              emailIn,
              addressIn,
              telephoneIn);
   END
//