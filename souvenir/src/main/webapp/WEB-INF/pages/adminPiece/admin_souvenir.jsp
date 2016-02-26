<%--
  Created by IntelliJ IDEA.
  User: MTSMDA
  Date: 03.02.2016
  Time: 7:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertDefinition name="defaultAdminTemplate">
	<tiles:putAttribute name="title">
		<spring:message code="page.about_us.title" />
	</tiles:putAttribute>
	<tiles:putAttribute name="content">
		<div class="" ng-controller="adminSouvenirCtrl">
			<div id="allSouvenirs">
				<div class="row">
					<div
						ng-class-odd="'col-xs-10 col-xs-offset-1 col-sm-10 col-sm-offset-1 col-md-5 col-lg-5'"
						ng-class-even="'col-md-5 col-md-offset-1 col-lg-5 col-lg-offset-1'"
						ng-repeat="souvenirCurrent in souvenirs">
						<a href="#/{{souvenirCurrent.souvenirId}}"><h1
								class="text-center">{{souvenirCurrent.souvenirName}}</h1></a>
					</div>
					<div class="text-center">
						<span class="glyphicon insertNewSouvenir"
							ng-class="styleClassesForInsertNewSouvenir"
							ng-mouseenter="eventMouseEnterNew()"
							ng-mouseleave="eventMouseLeaveNew()"></span>
					</div>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>