<%--
  Created by IntelliJ IDEA.
  User: c-DMITMINZ
  Date: 31.07.2015
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1> ${greeting} </h1>

            <p> ${tagline} </p>
        </div>
    </div>
</section>

<a href="/spMVC/order/P15025/5">P15025</a>
<a href="/spMVC/products/Smart Phone">Smart Phone</a>
<a href="/spMVC/products/PC">PC</a>

</body>
</html>
