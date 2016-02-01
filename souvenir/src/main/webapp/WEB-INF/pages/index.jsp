<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%-- <html>
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
<body> --%>

	

	<tiles:insertDefinition name="defaultTemplate">
		<tiles:putAttribute name="content">



			<div class="body">
				<h1>Home page !</h1>

				<h1>${message}</h1>

				<spring:message code="language.label" />
				: <a href="?lang=en"><spring:message code="language.english" /></a>|
				<a href="?lang=md"><spring:message code="language.moldavian" /></a>|
				<a href="?lang=ru"><spring:message code="language.russian" /></a>

				<p>The time on the server is ${serverTime}.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
					enim ad minim veniam, quis nostrud exercitation ullamco laboris
					nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
					reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
					pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
					culpa qui officia deserunt mollit anim id est laborum.</P>
			</div>



		</tiles:putAttribute>
	</tiles:insertDefinition>
<!-- 
</body>
</html> -->