<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <html>
<head>
<spring:url
	value="/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css"
	var="bootstrapCss" />
<spring:url value="/resources/js/jquery-1.12.0.min.js" var="jqueryJs" />
<spring:url value="/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js"
	var="bootstrapJs" />
<spring:url value="/resources/less/less_style.less" var="myLess" />
<link href="${bootstrapCss}" rel="stylesheet" type="text/css" />

<script src="${jqueryJs}"></script>
<script src="${bootstrapJs}"></script>

<spring:url value="/resources/less/less.min.js" var="lessJS" />
<script src="${lessJS}"></script>
</head>
<body> --%>



<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="title">
		<spring:message code="page.home.title" />
	</tiles:putAttribute>
	<tiles:putAttribute name="content">
		<div class="body">

			<h1>${message}</h1>



			
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>