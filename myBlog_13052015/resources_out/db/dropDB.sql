REVOKE ALL PRIVILEGES ON `myblog`.* FROM 'myBlog199'@'localhost';
REVOKE GRANT OPTION ON *.* FROM `myBlog199`@`localhost`;
DROP USER `myBlog199`@`localhost`;

DROP DATABASE myblog;