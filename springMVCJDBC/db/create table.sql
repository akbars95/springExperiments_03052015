USE contactdb;
CREATE TABLE `contact` (
  `contact_id` int(11) NOT NULL AUTO_INCREMENT,
  `contact_name` varchar(255) DEFAULT NULL,
  `contact_email` varchar(255) DEFAULT NULL,
  `contact_address` varchar(255) DEFAULT NULL,
  `contact_telephone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`contact_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


insert into `contact`(`contact_id`,`contact_name`,`contact_email`,`contact_address`,`contact_telephone`) values (2,'Ivanov Ivan','ivanov.ivan@mail.ru','Kishinev','069 258 954');
insert into `contact`(`contact_id`,`contact_name`,`contact_email`,`contact_address`,`contact_telephone`) values (3,'Petrov Petr','petrov.petr@gmail.com','Kiev','079 359 962');
insert into `contact`(`contact_id`,`contact_name`,`contact_email`,`contact_address`,`contact_telephone`) values (4,'Petrov Petr Ptrovic','petrov.petr@yahoo.com','Kiev drugoi rayon','079 389 982');
insert into `contact`(`contact_id`,`contact_name`,`contact_email`,`contact_address`,`contact_telephone`) values (5,'Petrov Petr','petrov.petr@gmail.com','Kiev','079 359 962');
insert into `contact`(`contact_id`,`contact_name`,`contact_email`,`contact_address`,`contact_telephone`) values (6,'Petrov Petr','petrov.petr@gmail.com','Kiev','079 359 962');
insert into `contact`(`contact_id`,`contact_name`,`contact_email`,`contact_address`,`contact_telephone`) values (7,'Petrov Petr','petrov.petr@gmail.com','Kiev','079 359 962');

