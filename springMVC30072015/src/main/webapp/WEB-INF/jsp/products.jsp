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
            <div class="product">
                <c:forEach items="${products}" var="product">
                    <h1>Product name ${product.name} </h1>

                    <p>Price ${product.unitPrice} </p>

                    <p>Description ${product.description} </p>

                    <p>Category ${product.category} </p>
                </c:forEach>
            </div>

        </div>
    </div>
</section>
</body>
</html>
