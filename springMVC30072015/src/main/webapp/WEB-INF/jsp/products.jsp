<%--
  Created by IntelliJ IDEA.
  User: c-DMITMINZ
  Date: 31.07.2015
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Welcome</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <div class="product">
                <c:forEach items="${products}" var="product">
                    <h1><a href="/spMVC/product?id=${product.productId}"> Product name ${product.name} </a></h1>

                    <p><a href="<spring:url value="/product?id=${product.productId}" htmlEscape="true"/>">Price ${product.unitPrice} </a></p>

                    <p>Description ${product.description} </p>

                    <p>Category ${product.category} </p>
                </c:forEach>
            </div>

        </div>
    </div>
</section>
</body>
</html>
