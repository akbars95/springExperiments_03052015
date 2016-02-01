<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<body>
	<h1>${message}</h1>

	<spring:message code="language.label" />
	:
	<a href="?lang=en"><spring:message code="language.english" /></a>|
	<a href="?lang=md"><spring:message code="language.moldavian" /></a>|
	<a href="?lang=ru"><spring:message code="language.russian" /></a>

</body>
</html>