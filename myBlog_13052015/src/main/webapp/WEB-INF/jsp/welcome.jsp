<%--
  Created by IntelliJ IDEA.
  User: dmitriim
  Date: 5/13/2015
  Time: 6:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<html>
<head>
    <title><spring:message code="page.title.welcome"/></title>
</head>
<body>--%>
<tiles:insertDefinition name="defaultTemplate">
  <tiles:putAttribute name="body">

    <div class="body">

      Language : <a href="?language=en"><spring:message code="i18n.en" text="English"/></a>|<a href="?language=ru"><spring:message code="i18n.ru"/></a>
      |<a href="?language=de"><spring:message code="i18n.ru"/></a>

      <spring:message code="page.title.index"/>

      Current Locale : ${pageContext.response.locale}


      <h1>Home page !</h1>

      <p>The time on the server is ${serverTime}.</p>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore
        magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
        consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
        Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</P>
    </div>



  </tiles:putAttribute>
</tiles:insertDefinition>

<%--</body>
</html>--%>
