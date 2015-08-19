<%--
  Created by IntelliJ IDEA.
  User: c-DMITMINZ
  Date: 31.07.2015
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>Product</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<div class="product">
					<h1>
						<a href="<spring:url value="/products"/>">Products</a>
					</h1>
					<h2>Product name ${product.name}</h2>

					<p>Price ${product.unitPrice}</p>

					<p>Description ${product.description}</p>

					<p>Category ${product.category}</p>
					<p>Description ${product.description}</p>
					<p>Manufacturer ${product.manufacturer}</p>
					<p>Units In Stock ${product.unitsInStock}</p>
					<p>Units In Order ${product.unitsInOrder}</p>
					<p>Discontinued ${product.discontinued}</p>
					<p>Condition ${product.condition}</p>

				</div>

			</div>
		</div>
	</section>
</body>
</html>
