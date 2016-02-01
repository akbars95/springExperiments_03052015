<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>

<spring:url
	value="/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css"
	var="bootstrapCss" />
<spring:url value="/resources/js/jquery-1.12.0.min.js" var="jqueryJs" />
<spring:url value="/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js"
	var="bootstrapJs" />
<spring:url value="/resources/less/less_style.less" var="myLess" />
<spring:url value="/resources/less/less.min.js" var="lessJS" />


<link href="${bootstrapCss}" rel="stylesheet" type="text/css" />
<link href="${myLess}" rel="stylesheet/less" type="text/css" />
<script src="${jqueryJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="${lessJS}"></script>



</head>
<body>



	<h1>${message}</h1>

	<spring:message code="language.label" />
	:
	<a href="?lang=en"><spring:message code="language.english" /></a>|
	<a href="?lang=md"><spring:message code="language.moldavian" /></a>|
	<a href="?lang=ru"><spring:message code="language.russian" /></a>

</body>
</html>