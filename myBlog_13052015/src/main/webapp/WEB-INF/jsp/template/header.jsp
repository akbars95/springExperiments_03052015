<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container-fluid">

    <div class="header">
        <div>
            <spring:message code="i18n.language.text" /> :
            <ul>
                <li><a href="?language=en"><spring:message code="i18n.en" text="English"/></a></li>
                <li><a href="?language=ru"><spring:message code="i18n.ru" text="Russian"/></a></li>
            </ul>
        </div>
        <div>
            <span><spring:message code="registration.name" /></span>
            <span><spring:message code="logIn" /></span>
            <span><spring:message code="logOut" /></span>
        </div>
        <div>

        </div>
    </div>
