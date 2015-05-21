<%--
  Created by IntelliJ IDEA.
  User: c-DMITMINZ
  Date: 5/15/2015
  Time: 6:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
    <title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>

<tiles:insertAttribute name="header" />
<tiles:insertAttribute name="body" />
<tiles:insertAttribute name="footer" />

</body>
</html>
