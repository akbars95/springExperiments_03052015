<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Default tiles template</title>
    <tiles:insertAttribute name="jsCss" />
</head>
<body>
<div class="page">
    <tiles:insertAttribute name="header" />
    <div class="content">
        <tiles:insertAttribute name="menu" />
        <tiles:insertAttribute name="body" />
    </div>
    <tiles:insertAttribute name="footer" />
</div>
</body>
</html>