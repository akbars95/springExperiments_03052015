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
				<div>
					<c:if test="${not empty error}">
						<spring:message
							code="AbstractUserDetailsAuthenticationProvider.badCredentials" />
						<br>
					</c:if>
				</div>

				<form action="/j_spring_security_check" method="post">
					<table>
						<tr>
							<td><label>User name</label></td>
							<td><input placeholder="User name" name="j_username"
								type="text"></td>
						</tr>
						<tr>
							<td><label>User password</label></td>
							<td><input placeholder="User password" name="j_password"
								type="text" value=""></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="Login">
							</td>
						</tr>
					</table>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>

			</div>
		</div>
	</section>
</body>
</html>
