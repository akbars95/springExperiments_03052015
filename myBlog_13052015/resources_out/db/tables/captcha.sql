USE myBlog;

CREATE TABLE `captcha` (
  `captcha_id` int(11) NOT NULL AUTO_INCREMENT,
  `captcha_pathToImage` varchar(255) NOT NULL,
  `captcha_valueCaptcha` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`captcha_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `captcha`(`captcha_id`,`captcha_pathToImage`,`captcha_valueCaptcha`) values (1,'/resources/images/captcha/45634bfg4.png','Cth0HspF5Bg');
insert into `captcha`(`captcha_id`,`captcha_pathToImage`,`captcha_valueCaptcha`) values (2,'/resources/images/captcha/asdfskhds15ds.png','GY5dfdk43rV');
insert into `captcha`(`captcha_id`,`captcha_pathToImage`,`captcha_valueCaptcha`) values (3,'/resources/images/captcha/dfgre45fg.png','5Yydfdk43Vr');
insert into `captcha`(`captcha_id`,`captcha_pathToImage`,`captcha_valueCaptcha`) values (4,'/resources/images/captcha/dfsg69werth.png','5YydfD97Ngg');
insert into `captcha`(`captcha_id`,`captcha_pathToImage`,`captcha_valueCaptcha`) values (5,'/resources/images/captcha/eyte6yeh76iu64.png','M95GTGh10Bg');
