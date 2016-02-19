<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="title">
		<spring:message code="page.home.title" />
	</tiles:putAttribute>
	<tiles:putAttribute name="content">
		<ng-view />
	</tiles:putAttribute>
</tiles:insertDefinition>