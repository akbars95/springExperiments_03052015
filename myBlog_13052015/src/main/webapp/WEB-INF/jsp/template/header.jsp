<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid">

    <div class="row headerS">
        <div class="col-md-6">
            <p>
                <spring:message code="i18n.language.text"/> :
                <a href="?language=en" title="<spring:message code="i18n.en"/>"><img class="languageImage"
                        src="<c:url value="/resources/images/languages/en.png"/>"></a> |
                <a href="?language=ru" title="<spring:message code="i18n.ru"/>"><img class="languageImage"
                        src="<c:url value="/resources/images/languages/ru.png"/>"></a>
            </p>
        </div>
        <div class="col-md-6">
            <p style="text-align: right;">
                <span><spring:message code="registration.name"/></span>
                <span><spring:message code="logIn"/></span>
                <span><spring:message code="logOut"/></span>
            </p>
        </div>
        <div>

        </div>
    </div>
