<%--
  Created by IntelliJ IDEA.
  User: dmitriim
  Date: 5/13/2015
  Time: 6:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title><spring:message code="page.title.contact_us"/></title>
    <link href="<c:url value="/resources/style/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/style/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.11.3.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <%--angular--%>
    <script src="<c:url value="/resources/js/angular.min.js" />"></script>
    <script src="<c:url value="/resources/js/application/contactUsApp.js" />"></script>
    <script src="<c:url value="/resources/js/controller/" />"></script>
</head>
<body>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <form method="post" action="/myBlog/sendEmail">
            <table>
                <tr>
                    <td><label for="namePerson"><spring:message code="contact_us.form.namePerson"/></label><span
                            class="required_field"></span></td>
                    <td><input type="text" id="namePerson" name="namePerson"
                               placeholder="<spring:message code="contact_us.form.namePerson"/>" size="20"
                               maxlength="50"><span
                            class="required_field hide"></span></td>
                </tr>
                <tr>
                    <td><label for="emailPerson"><spring:message code="contact_us.form.emailPerson"/></label><span
                            class="required_field"></span></td>
                    <td><input type="email" id="emailPerson" name="emailPerson"
                               placeholder="<spring:message code="contact_us.form.emailPerson"/>" size="20"
                               maxlength="50"><span
                            class="required_field hide"></span></td>
                </tr>
                <tr>
                    <td><label for="phoneNumberPerson"><spring:message
                            code="contact_us.form.phoneNumberPerson"/></label>
                    </td>
                    <td><input type="text" id="phoneNumberPerson" name="phoneNumberPerson"
                               placeholder="<spring:message code="contact_us.form.phoneNumberPerson"/>" size="20"
                               maxlength="50">
                    </td>
                </tr>
                <tr>
                    <td><label for="subjectMessagePerson"><spring:message
                            code="contact_us.form.subjectMessagePerson"/></label><span class="required_field"></span>
                    </td>
                    <td><input type="text" id="subjectMessagePerson" name="subjectMessagePerson"
                               placeholder="<spring:message code="contact_us.form.subjectMessagePerson"/>" size="20"
                               maxlength="50"><span class="required_field hide"></span>
                    </td>
                </tr>
                    <%--<tr>
                        <td><label for="attachFileInMessagePerson"><spring:message
                                code="contact_us.form.attachFileInMessagePerson"/></label>
                        </td>
                        <td><input type="file" id="attachFileInMessagePerson" multiple="multiple" name="attachFileInMessagePerson" placeholder="<spring:message code="contact_us.form.attachFileInMessagePerson"/>" size="20"></span>
                        </td>
                    </tr>--%>
                <tr>
                    <td><label for="textMessagePerson"><spring:message
                            code="contact_us.form.textMessagePerson"/></label><span class="required_field"></span>
                    </td>
                    <td>
                    <textarea id="textMessagePerson" name="textMessagePerson" maxlength="1000" cols="100" rows="15"
                              placeholder="<spring:message code="contact_us.form.textMessagePerson"/>"></textarea><span
                            class="required_field hide"></span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <button type="button" class="btn btn-warning" id="resetBtn" name="resetBtn"><spring:message
                                code="contact_us.form.reset.btn"/></button>
                    </td>
                    <td>
                        <button type="submit" class="btn btn-default" id="sendBtn" name="sendBtn"><spring:message
                                code="contact_us.form.send.btn"/></button>
                    </td>
                </tr>
            </table>
        </form>
    </tiles:putAttribute>
</tiles:insertDefinition>

</body>
</html>
