USE myBlog;

CREATE TABLE `mailMessage` (
  `mailMessage_id` int(11) NOT NULL AUTO_INCREMENT,
  `mailMessage_mailTo` varchar(50) DEFAULT NULL,
  `mailMessage_mailFrom` varchar(50) DEFAULT NULL,
  `mailMessage_mailSubject` varchar(50) DEFAULT NULL,
  `mailMessage_personName` varchar(50) DEFAULT NULL,
  `mailMessage_phoneNumber` varchar(25) DEFAULT NULL,
  `mailMessage_mailText` varchar(255) DEFAULT NULL,
  `mailMessage_sendDatePerson` datetime DEFAULT NULL,
  `mailMessage_sendDateServer` datetime DEFAULT NULL,
  `mailMessage_errorOrException` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`mailMessage_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;