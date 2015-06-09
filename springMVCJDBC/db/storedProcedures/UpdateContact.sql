DELIMITER //

CREATE PROCEDURE UpdateContact(IN contact_nameIn        varchar(255),
                               IN contact_emailIn       varchar(255),
                               IN contact_addressIn     varchar(255),
                               IN contact_telephoneIn   varchar(255),
                               IN contact_idIn          int)
   BEGIN
      UPDATE contact
         SET contact_name = contact_nameIn,
             contact_email = contact_emailIn,
             contact_address = contact_addressIn,
             contact_telephone = contact_telephoneIn
       WHERE contact_id = contact_idIn;
       END
//