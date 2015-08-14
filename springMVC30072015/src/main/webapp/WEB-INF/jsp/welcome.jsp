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
            <h1> ${greeting} </h1>

            <p> ${tagline} </p>
        </div>
    </div>
</section>

<a href="/spMVC/order/P15025/5">P15025</a>
<a href="/spMVC/products/Smart Phone">Smart Phone</a>
<a href="/spMVC/products/PC">PC</a>

<hr>
Matrix variables
<a href="/spMVC/filter/ByCriteria;brand=Everest;">Only Everest</a>
<a href="/spMVC/filter/ByCriteria;brand=Everest,Lenovo;">Everest and Lenovo</a>
<a href="/spMVC/filter/ByCriteria;brand=Everest;category=Smart Phone;">All</a>

<a href="/spMVC/filter/ByCriteria;brand=Everest;category=Smart Phone;/Price;price=500">All and price > 500</a>

<a href="/spMVC/productByIdAndCategory?id=15023&category=Smart Phone">Smart Phone - 15023</a>

<a href="<spring:url value="/products/PC/Price;low=7060;high=9500?manufacturer=Samsung"/>">Path variable, matrix variable, GET param</a>
<a href="<spring:url value="/products/PC/Price;low=7050;high=9500?manufacturer=Samsung"/>">Path variable, matrix variable, GET param 2 </a>
<br>
<a href="<spring:url value="/add"/>">Add Product</a>

</body>
</html>
