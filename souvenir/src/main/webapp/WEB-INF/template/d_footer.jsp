<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="footer">
    <p class="text-left"><spring:url value="/home" var="homeUrl"
                   htmlEscape="true"/> <a href="${homeUrl}"><spring:message
            code="menu.home.title"/></a></p>
    <p class="text-right">    &copy; <spring:message code="footer.siteName.text"/> -
        <script type="text/javascript">
            window.document.write(new Date().getFullYear());
        </script>
    </p>
</div>