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
    <title>Add Product</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <div class="product">
                <h1>Add New Product</h1>
                <a href="<c:url value="/j_spring_security_logout"/>">Log out</a>
                <form:form modelAttribute="newProduct" enctype="multipart/form-data">
                    <table>
                        <tr>
                            <td><label><spring:message
                                    code="addProduct.labelProductID"/></label></td>
                            <td><form:input path="productId" id="productId"/></td>
                        </tr>
                        <tr>
                            <td><label>Product name</label></td>
                            <td><form:input path="name" id="productName"/></td>
                        </tr>
                        <tr>
                            <td><label>Product price</label></td>
                            <td><form:input path="unitPrice" id="unitPrice"/></td>
                        </tr>
                        <tr>
                            <td><label>Description</label></td>
                            <td><form:textarea path="description" rows="2"/></td>
                        </tr>
                        <tr>
                            <td><label>Product category</label></td>
                            <td><form:input path="category" id="category"/></td>
                        </tr>
                        <tr>
                            <td><label>Product manufacturer</label></td>
                            <td><form:input path="manufacturer" id="manufacturer"/></td>
                        </tr>
                        <tr>
                            <td><label>Product units In Stock</label></td>
                            <td><form:input path="unitsInStock" id="unitsInStock"/></td>
                        </tr>
                        <tr>
                            <td><label>Product discontinued</label></td>
                            <td><form:checkbox path="discontinued" id="discontinued"/>
                            </td>
                        </tr>
                        <tr>
                            <td><label>Product condition</label></td>
                            <td><form:radiobutton path="condition" value="New"/>New <form:radiobutton
                                    path="condition" value="Old"/>Old <form:radiobutton
                                    path="condition" value="Refurbished"/>Refurbished
                            </td>
                        </tr>
                        <tr>
                            <td><label>Product image</label></td>
                            <td><form:input type="file" path="productImage" id="discontinued"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" value="Add"></td>
                        </tr>
                    </table>
                </form:form>


            </div>

        </div>
    </div>
</section>
</body>
</html>
