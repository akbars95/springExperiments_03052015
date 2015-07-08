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
    <link href="<c:url value="/resources/style/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.11.3.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <link href="<c:url value="/resources/style/style.css" />" rel="stylesheet">
    <%--angular--%>
    <script src="<c:url value="/resources/js/angular.min.js" />"></script>
    <script src="<c:url value="/resources/js/angular-route.min.js" />"></script>
    <script src="<c:url value="/resources/js/application/blogApp.js" />"></script>
    <script src="<c:url value="/resources/js/controller/blogCtrl.js" />"></script>
</head>
<body ng-controller="tutorialCtrl" ng-init="init();">
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <div class="content">
            <table>
                <tr>
                    <td>
                        <a href="" ng-click="order('articleName')"><spring:message
                                code="tutorial.allTutorials.sort.byName"/></a>
                        <span class="sortorder" ng-show="predicate === 'articleName'"
                              ng-class="{reverse:reverse}"></span>
                    </td>
                    <td><a href="" ng-click="order('subCategory.subcategoryName')"><spring:message
                            code="tutorial.allTutorials.sort.byCategory"/></a>
                <span class="sortorder" ng-show="predicate === 'subCategory.subcategoryName'"
                      ng-class="{reverse:reverse}"></span>
                    </td>
                    <td><a href="" ng-click="order('author.authorFirstname')"><spring:message
                            code="tutorial.allTutorials.sort.byAuthor"/></a>
            <span class="sortorder" ng-show="predicate === 'author.authorFirstname'"
                  ng-class="{reverse:reverse}"></span>
                    </td>
                    <td><a href="" ng-click="order('articleCreatedDate')"><spring:message
                            code="tutorial.allTutorials.sort.byСreatedDate"/></a>
            <span class="sortorder" ng-show="predicate === 'articleCreatedDate'"
                  ng-class="{reverse:reverse}"></span>
                    </td>
                    <td><a href="" ng-click="order('articleLastUpdatedDate')"><spring:message
                            code="tutorial.allTutorials.sort.byUpdatedDate"/></a>
            <span class="sortorder" ng-show="predicate === 'articleLastUpdatedDate'"
                  ng-class="{reverse:reverse}"></span>
                    </td>
                </tr>
            </table>

            <div ng-repeat="tutorial in tutorials | orderBy:predicate:reverse " class="oneTutorial">
                <a href="get_tutorial/{{tutorial.idArticle}}" ><h2>{{tutorial.articleName}}</h2></a>

                <p>
                <span class="subcategoryName"><spring:message
                        code="tutorial.allTutorials.сategory"/> - <a
                        href="">{{tutorial.subCategory.subcategoryName}}</a></span><span class="delimiter"> | </span>
                <span class="authorName"><spring:message
                        code="tutorial.allTutorials.authorName"/> - <a
                        href="">{{tutorial.author.authorFirstname}}</a></span>
                </p>

                <p>
                    <span class="articleCreatedDate"><spring:message code="tutorial.allTutorials.articleCreatedDate"/> - {{tutorial.articleCreatedDate}}</span><span
                        class="delimiter"> | </span>
                <span class="articleLastUpdatedDate"><spring:message
                        code="tutorial.allTutorials.articleLastUpdatedDate"/> - {{tutorial.articleLastUpdatedDate}}</span>
                </p>
            </div>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>

</body>
</html>