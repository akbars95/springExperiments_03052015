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
<html ng-app="contactUsApp">
<head>
    <title><spring:message code="page.title.contact_us"/></title>
    <link href="<c:url value="/resources/style/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/style/style.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.11.3.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <%--angular--%>
    <script src="<c:url value="/resources/js/angular.min.js" />"></script>
    <script src="<c:url value="/resources/js/application/blogApp.js" />"></script>
    <script src="<c:url value="/resources/js/controller/blogCtrl.js" />"></script>
</head>
<body ng-controller="contactUsCtrl">
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <form name="emailSendForm" novalidate="novalidate" ng-submit="emailForm.submitEmail()"> <%-- method="post" action="/myBlog/sendEmail"--%>
            <table ng-init="init()">
                <tr>
                        <%--namePerson--%>
                    <td><label for="namePerson"><spring:message code="contact_us.form.namePerson"/></label><span
                            class="required_field"></span></td>
                    <td>
                        <input type="text" id="namePerson" name="namePerson"
                               placeholder="<spring:message code="contact_us.form.namePerson"/>" size="20"
                            <%--maxlength="{{emailForm.namePersonMaxLength}}"--%>
                               ng-class="validationError"
                               ng-model="emailForm.namePerson" ng-minlength="emailForm.namePersonMinLength"
                               ng-maxlength="emailForm.namePersonMaxLength"
                               required>
                        <small class="error" ng-show="emailSendForm.namePerson.$error.required">
                            <spring:message code="contact_us.form.validation.required"/>
                        </small>
                        <small class="error" ng-show="emailSendForm.namePerson.$error.minlength">
                            <spring:message code="contact_us.form.validation.minLength"/>
                            {{emailForm.namePersonMinLength}}
                        </small>
                        <small class="error" ng-show="emailSendForm.namePerson.$error.maxlength"><spring:message
                                code="contact_us.form.validation.maxLength"/> {{emailForm.namePersonMaxLength}}
                        </small>
                        <p ng-if="!emailSendForm.namePerson.$error.maxlength && !emailSendForm.namePerson.$error.minlength && !emailSendForm.namePerson.$error.required"
                           class="lostChars" ng-class="lostChars"><spring:message
                                code="contact_us.form.validation.lostChars"/>{{emailForm.namePersonMaxLength
                            - emailForm.namePerson.length}} <spring:message
                                    code="contact_us.form.validation.lostChars.from"/>
                            {{emailForm.namePersonMaxLength}}</p>
                    </td>
                </tr>
                <tr>
                        <%--emailPerson--%>
                    <td><label for="emailPerson"><spring:message code="contact_us.form.emailPerson"/></label><span
                            class="required_field"></span></td>
                    <td><input type="email" id="emailPerson" name="emailPerson"
                               placeholder="<spring:message code="contact_us.form.emailPerson"/>" size="20"
                               ng-class="validationError"
                               ng-model="emailForm.emailPerson" ng-minlength="emailForm.emailPersonMinLength"
                               ng-maxlength="emailForm.emailPersonMaxLength"
                               required>
                        <small class="error" ng-show="emailSendForm.emailPerson.$error.required">
                            <spring:message code="contact_us.form.validation.required"/>
                        </small>
                        <small class="error" ng-show="emailSendForm.emailPerson.$error.minlength">
                            <spring:message code="contact_us.form.validation.minLength"/>
                            {{emailForm.emailPersonMinLength}}
                        </small>
                        <small class="error" ng-show="emailSendForm.emailPerson.$error.maxlength"><spring:message
                                code="contact_us.form.validation.maxLength"/> {{emailForm.emailPersonMaxLength}}
                        </small>
                        <p ng-if="!emailSendForm.emailPerson.$error.maxlength && !emailSendForm.emailPerson.$error.minlength && !emailSendForm.emailPerson.$error.required"
                           class="lostChars" ng-class="lostChars">
                            <spring:message code="contact_us.form.validation.lostChars"/>
                            {{emailForm.emailPersonMaxLength - emailForm.emailPerson.length}}
                            <spring:message code="contact_us.form.validation.lostChars.from"/>
                            {{emailForm.emailPersonMaxLength}}
                        </p>
                    </td>
                </tr>
                <tr>
                    <%--phoneNumberPerson--%>
                    <td><label for="phoneNumberPerson"><spring:message
                            code="contact_us.form.phoneNumberPerson"/></label>
                    </td>
                    <td><input type="text" id="phoneNumberPerson" name="phoneNumberPerson"
                               placeholder="<spring:message code="contact_us.form.phoneNumberPerson"/>" size="20"
                               ng-class="validationError" numbers-only="numbers-only"
                               ng-model="emailForm.phoneNumberPerson" ng-minlength="emailForm.phoneNumberPersonMinLength"
                               ng-maxlength="emailForm.phoneNumberPersonMaxLength">
                        <small class="error" ng-show="emailSendForm.phoneNumberPerson.$error.minlength">
                            <spring:message code="contact_us.form.validation.minLength"/>
                            {{emailForm.phoneNumberPersonMinLength}}
                        </small>
                        <small class="error" ng-show="emailSendForm.phoneNumberPerson.$error.maxlength"><spring:message
                                code="contact_us.form.validation.maxLength"/> {{emailForm.phoneNumberPersonMaxLength}}
                        </small>
                        <p ng-if="!emailSendForm.phoneNumberPerson.$error.maxlength && !emailSendForm.phoneNumberPerson.$error.minlength"
                           class="lostChars" ng-class="lostChars">
                                <spring:message code="contact_us.form.validation.lostChars"/>
                            {{emailForm.phoneNumberPersonMaxLength - emailForm.phoneNumberPerson.length}}
                                <spring:message code="contact_us.form.validation.lostChars.from"/>
                            {{emailForm.phoneNumberPersonMaxLength}}
                        </p>
                    </td>
                </tr>
                <tr>
                    <%--subjectMessagePerson--%>
                    <td><label for="subjectMessagePerson"><spring:message
                            code="contact_us.form.subjectMessagePerson"/></label><span class="required_field"></span>
                    </td>
                    <td>
                        <input type="text" id="subjectMessagePerson" name="subjectMessagePerson"
                               placeholder="<spring:message code="contact_us.form.subjectMessagePerson"/>" size="20"
                               ng-class="validationError"
                               ng-model="emailForm.subjectMessagePerson" ng-minlength="emailForm.subjectMessagePersonMinLength"
                               ng-maxlength="emailForm.subjectMessagePersonMaxLength"
                               required>
                        <small class="error" ng-show="emailSendForm.subjectMessagePerson.$error.required">
                            <spring:message code="contact_us.form.validation.required"/>
                        </small>
                        <small class="error" ng-show="emailSendForm.subjectMessagePerson.$error.minlength">
                            <spring:message code="contact_us.form.validation.minLength"/>
                            {{emailForm.namePersonMinLength}}
                        </small>
                        <small class="error" ng-show="emailSendForm.subjectMessagePerson.$error.maxlength"><spring:message
                                code="contact_us.form.validation.maxLength"/> {{emailForm.namePersonMaxLength}}
                        </small>
                        <p ng-if="!emailSendForm.subjectMessagePerson.$error.maxlength && !emailSendForm.subjectMessagePerson.$error.minlength && !emailSendForm.subjectMessagePerson.$error.required"
                           class="lostChars" ng-class="lostChars"><spring:message
                                code="contact_us.form.validation.lostChars"/>
                            {{emailForm.subjectMessagePersonMaxLength - emailForm.subjectMessagePerson.length}}
                            <spring:message code="contact_us.form.validation.lostChars.from"/>
                            {{emailForm.subjectMessagePersonMaxLength}}</p>

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
                    <textarea id="textMessagePerson" name="textMessagePerson" cols="100" rows="15"
                              placeholder="<spring:message code="contact_us.form.textMessagePerson"/>"
                              ng-model="emailForm.textMessagePerson" ng-minlength="emailForm.textMessagePersonMinLength"
                              ng-maxlength="emailForm.textMessagePersonMaxLength"
                              required></textarea>

                        <small class="error" ng-show="emailSendForm.textMessagePerson.$error.required">
                            <spring:message code="contact_us.form.validation.required"/>
                        </small>
                        <small class="error" ng-show="emailSendForm.textMessagePerson.$error.minlength">
                            <spring:message code="contact_us.form.validation.minLength"/>
                            {{emailForm.textMessagePersonMinLength}}
                        </small>
                        <small class="error" ng-show="emailSendForm.textMessagePerson.$error.maxlength"><spring:message
                                code="contact_us.form.validation.maxLength"/> {{emailForm.textMessagePersonMaxLength}}
                        </small>
                        <p ng-if="!emailSendForm.textMessagePerson.$error.maxlength && !emailSendForm.textMessagePerson.$error.minlength && !emailSendForm.textMessagePerson.$error.required"
                           class="lostChars" ng-class="lostChars">
                            <spring:message code="contact_us.form.validation.lostChars"/>
                            {{emailForm.textMessagePersonMaxLength - emailForm.textMessagePerson.length}}
                            <spring:message code="contact_us.form.validation.lostChars.from"/>
                            {{emailForm.textMessagePersonMaxLength}}</p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="captcha"><spring:message
                                code="contact_us.form.captcha"/></label><span class="required_field"></span>
                        <input type="hidden" name="currentTimeByUser" id="currentTimeByUser"/>
                    </td>
                    <td>
                        <input type="text" id="captcha" name="captcha"
                               placeholder="<spring:message code="contact_us.form.captcha"/>" size="11"
                               ng-model="emailForm.captcha" ng-minlength="emailForm.captchaMinLength"
                               ng-maxlength="emailForm.captchaMaxLength"
                               required>

                        <small class="error" ng-show="emailSendForm.captcha.$error.required">
                            <spring:message code="contact_us.form.validation.required"/>
                        </small>
                        <small class="error" ng-show="emailSendForm.captcha.$error.minlength">
                            <spring:message code="contact_us.form.validation.minLength"/>
                            {{emailForm.captchaMinLength}}
                        </small>
                        <small class="error" ng-show="emailSendForm.captcha.$error.maxlength"><spring:message
                                code="contact_us.form.validation.maxLength"/> {{emailForm.captchaMaxLength}}
                        </small>
                        <%--<p ng-if="!emailSendForm.captcha.$error.maxlength && !emailSendForm.captcha.$error.minlength && !emailSendForm.captcha.$error.required"
                           class="lostChars" ng-class="lostChars">
                            <spring:message code="contact_us.form.validation.lostChars"/>
                            {{emailForm.textMessagePersonMaxLength - emailForm.textMessagePerson.length}}
                            <spring:message code="contact_us.form.validation.lostChars.from"/>
                            {{emailForm.textMessagePersonMaxLength}}</p>--%>

                        <img ng-src="<c:url value="{{responseCaptcha.pathToImage}}"/>" class="captchaImg"/>
                        <img ng-click="loadOtherImg()" style="cursor: pointer"
                             src="<c:url value="/resources/images/update.png"/>"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <button type="button" class="btn btn-warning" ng-click="emailForm.reset()" id="resetBtn" name="resetBtn"><spring:message
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
