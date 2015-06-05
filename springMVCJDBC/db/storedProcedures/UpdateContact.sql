DELIMITER //

CREATE PROCEDURE UpdateContact(IN nameIn        varchar(255),
                               IN emailIn       varchar(255),
                               IN addressIn     varchar(255),
                               IN telephoneIn   varchar(255),
                               IN idIn          int)
   BEGIN
      UPDATE contact
         SET name = nameIn,
             email = emailIn,
             address = addressIn,
             telephone = telephoneIn
       WHERE contact_id = idIn;
       END
//