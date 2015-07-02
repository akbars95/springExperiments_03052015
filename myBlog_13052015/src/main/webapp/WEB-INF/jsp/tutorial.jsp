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
<html ng-app="tutorialApp">
<head>
    <title><spring:message code="page.title.tutorials"/></title>
    <link href="<c:url value="/resources/style/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/style/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.11.3.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <%--angular--%>
    <script src="<c:url value="/resources/js/angular.min.js" />"></script>
    <script src="<c:url value="/resources/js/application/blogApp.js" />"></script>
    <script src="<c:url value="/resources/js/controller/blogCtrl.js" />"></script>
</head>
<body  ng-controller="tutorialCtrl">
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        Simple text

    </tiles:putAttribute>
</tiles:insertDefinition>

</body>
</html>
