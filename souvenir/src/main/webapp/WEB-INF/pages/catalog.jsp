<%--
  Created by IntelliJ IDEA.
  User: MTSMDA
  Date: 02.02.2016
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="title">
		<spring:message code="page.catalog.title" />
	</tiles:putAttribute>
	<tiles:putAttribute name="content">
		<div class="" ng-controller="catalogCtrl">

			<div class="row">
				<div class="col-lg-6">

				</div>
				<div class="col-lg-6">
					<select name="countPerPage">
						<option value="10">10</option>
						<option value="25">25</option>
						<option value="50">50</option>
						<option value="100">100</option>
						<option value="all">all</option>
					</select>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 text-center" ng-repeat="souvenir in souvenirs">
					<h1><spring:url value="/get/souvenir/" var="homeUrl"
									htmlEscape="true"/><a href="${homeUrl}{{souvenir.souvenirId}}">{{souvenir.souvenirName}}</a></h1>
					<p>{{souvenir.souvenirDescription}}</p>
				</div>
			</div>

		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>