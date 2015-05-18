<%--
  Created by IntelliJ IDEA.
  User: dmitriim
  Date: 5/13/2015
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<html>
<head>
    <title>Index</title>
    <link href="<c:url value="/resources/style/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/style/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.11.3.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>

<div class="container-fluid">


    <div class="header">
        <div></div>
        <div></div>
    </div>
    <div class="mainMenu">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.jsp">Home</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="#">Tutorials<span class="sr-only">(current)</span></a></li>
                        <%--class="active"--%>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-expanded="false">Categories<span
                                    class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">JAVA SE</a></li>
                                <li><a href="#">JAVA EE</a></li>
                                <li><a href="#">Hibernate</a></li>
                                <li><a href="#">Spring</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Database</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Javascript</a></li>
                                <li><a href="#">Javascript/jQuery</a></li>
                            </ul>
                        </li>
                        <li><a href="#">About site</a></li>
                        <li><a href="#">Contact Us</a></li>
                    </ul>


                    <form class="navbar-form navbar-right" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Site search">
                        </div>
                        <button type="submit" class="btn btn-default">Search</button>
                    </form>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container-fluid -->
        </nav>
    </div>

    <div class="footer">
        Copyright &copy; 2015 mtsmdaTutorials.com, all rights reserved.
    </div>

</div>

</body>
</html>
