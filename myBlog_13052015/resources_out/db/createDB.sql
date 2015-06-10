CREATE DATABASE IF NOT EXISTS `myBlog` CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE USER 'myBlog199'@'localhost' IDENTIFIED BY 'my!Blog@19#';
GRANT ALL PRIVILEGES ON myBlog. * TO 'myBlog199'@'localhost';

SELECT * FROM mysql.user;