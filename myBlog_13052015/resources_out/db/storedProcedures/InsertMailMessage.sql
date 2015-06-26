DROP PROCEDURE IF EXISTS myblog.InsertMailMessage;
CREATE PROCEDURE myblog.`InsertMailMessage`(IN mailMessage_mailToIn varchar(50), IN mailMessage_mailFromIn varchar(50),
mailMessage_mailSubjectIn varchar(50), IN mailMessage_personNameIn varchar(50), IN mailMessage_phoneNumberIn varchar(25),
IN mailMessage_mailTextIn varchar(255), IN mailMessage_sendDatePersonIn datetime, IN mailMessage_sendDateServerIn datetime, 
IN mailMessage_errorOrExceptionIn varchar(255)
)
BEGIN
	INSERT INTO mailmessage(mailMessage_mailTo, mailMessage_mailFrom, mailMessage_mailSubject, mailMessage_personName, mailMessage_phoneNumber, mailMessage_mailText, mailMessage_sendDatePerson, mailMessage_sendDateServer, mailMessage_errorOrException )
      VALUES (mailMessage_mailToIn, mailMessage_mailFromIn, mailMessage_mailSubjectIn, mailMessage_personNameIn, mailMessage_phoneNumberIn,
      mailMessage_mailTextIn, mailMessage_sendDatePersonIn, mailMessage_sendDateServerIn, /*mailMessage_sendDatePersonIn, mailMessage_sendDateServerIn, */mailMessage_errorOrExceptionIn);
      /* STR_TO_DATE(mailMessage_sendDatePersonIn,'%d.%m.%Y %H:%i:%s'), STR_TO_DATE(mailMessage_sendDateServerIn,'%d.%m.%Y %H:%i:%s') */
END;
