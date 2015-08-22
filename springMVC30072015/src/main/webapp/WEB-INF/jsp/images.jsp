<%--
  Created by IntelliJ IDEA.
  User: c-DMITMINZ
  Date: 31.07.2015
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>Images</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/styles/style.css"/>">
</head>
<body>
	
	<ul>
		<c:forEach items="${images}" var="image">
			<h1><a href="<spring:url value="/images/image${image}"/>">Image name is - ${image}</a></h1>
			<p>
				<img alt="" src="<spring:url value="${image}"/>">
			</p>
		</c:forEach>
	</ul>

</body>
</html>