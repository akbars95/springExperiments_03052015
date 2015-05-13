CREATE DATABASE `myBlog` CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE USER 'myBlog'@'localhost' IDENTIFIED BY 'myBlog';
GRANT ALL PRIVILEGES ON * . * TO 'myBlog'@'localhost';