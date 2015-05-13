<%--
  Created by IntelliJ IDEA.
  User: dmitriim
  Date: 5/13/2015
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<html>
<head>
    <title></title>
  <%@include file="WEB-INF/piece/jsCss.jsp"%>
</head>
<body>
<%--Language : <a href="?language=en">EN</a>|<a href="?language=ru">RU</a>--%>
<%@include file="WEB-INF/piece/header.jsp"%>
<%@include file="WEB-INF/piece/menu_main.jsp"%>
<%--<spring:message code="page.title.index"  />--%>
<a href="welcome">welcome</a>

<%@include file="WEB-INF/piece/footer.jsp"%>
</body>
</html>
