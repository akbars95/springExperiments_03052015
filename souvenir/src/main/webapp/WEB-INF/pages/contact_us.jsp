<%--
  Created by IntelliJ IDEA.
  User: MTSMDA
  Date: 03.02.2016
  Time: 7:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertDefinition name="contactUsTemplate">
	<tiles:putAttribute name="title">
		<spring:message code="page.contact_us.title" />
	</tiles:putAttribute>
	<tiles:putAttribute name="content">
		<div ng-app="contactUsApp" ng-controller="contactUsCtrl">
			<!-- ng-init="" -->
			<div class="row">
				<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
					<p>
						<label class=""> <spring:message
								code="page.contactus.address.address.label" /> :
						</label> <span><spring:message
								code="page.contactus.address.address.text" /></span>
					</p>
					<p>
						<label> <spring:message
								code="page.contactus.address.email.label" /></label> : <span><a
							href="mailto:ivanov.ivan1862@gmail.com">ivanov.ivan1862@gmail.com</a></span>
					</p>
					<p>
						<label> <spring:message
								code="page.contactus.address.map_images.label" />
						</label> <span><spring:message
								code="page.contactus.address.map_images.description.label" /></span><span
							class="numbers" id="number1">1</span> <img alt=""
							class="contact_img"
							src="<spring:url value="/resources/images/address_map_small.png" htmlEscape="true"/>" />

						<span class="numbers" id="number2">2</span> <img alt=""
							class="contact_img"
							src="<spring:url value="/resources/images/address_map_middle.png" htmlEscape="true"/>" />
						<span class="numbers" id="number3">3</span> <img alt=""
							class="contact_img"
							src="<spring:url value="/resources/images/address_map_big.png" htmlEscape="true"/>" />
					</p>
				</div>
				<div class="col-lg-5 col-md-7 col-sm-7 col-xs-7">
					<div class="alert alert-success" role="alert"
						ng-show="responseFormSuccess">
						<spring:message code="page.contactus.form.response.success" />
					</div>
					<div class="alert alert-danger" role="alert"
						ng-show="responseFormError">
						<spring:message code="page.contactus.form.response.error" />
					</div>
					<form class="form-horizontal" action="/sendemail" method="post"
						enctype="application/x-www-form-urlencoded"
						novalidate="novalidate">
						<div class="form-group">
							<label for="person_name"
								class="col-sm-2 control-label contact_us_form_item"> <spring:message
									code="page.contactus.form.name.label" />
							</label>
							<div class="col-sm-10">
								<input type="text" name="person_name" class="form-control"
									id="person_name" ng-model="formDataSendEmail.messageName"
									placeholder="<spring:message code="page.contactus.form.common.label"/> <spring:message code="page.contactus.form.name.label"/>">
							</div>
						</div>
						<div class="form-group">
							<label for="person_email"
								class="col-sm-2 control-label contact_us_form_item"><spring:message
									code="page.contactus.form.email.label" /></label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="person_email"
									name="person_email" ng-model="formDataSendEmail.messageEmail"
									placeholder="<spring:message code="page.contactus.form.common.label"/> <spring:message code="page.contactus.form.email.label"/>">
							</div>
						</div>
						<div class="form-group">
							<label for="person_message"
								class="col-sm-2 control-label contact_us_form_item"><spring:message
									code="page.contactus.form.message.label" /></label>

							<div class="col-sm-10">
								<textarea class="form-control" rows="5" id="person_message"
									name="person_message" ng-model="formDataSendEmail.messageText"
									placeholder="<spring:message code="page.contactus.form.common.label"/> <spring:message code="page.contactus.form.message.label"/>"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label for="person_сaptcha"
								class="col-sm-2 control-label contact_us_form_item"><spring:message
									code="page.contactus.form.сaptcha.label" /></label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="person_сaptcha"
									name="person_сaptcha"
									ng-model="formDataSendEmail.messageCaptcha"
									placeholder="<spring:message code="page.contactus.form.common.label"/> <spring:message code="page.contactus.form.сaptcha.label"/>">
								<img ng-src="{{currentCaptcha.captchaUrlFile}}" /> <img
									id="refreshCaptchaBtn" ng-click="refreshCaptcha()"
									src="<spring:url value="/resources/images/arrow_refresh.png" htmlEscape="true"/>" />
							</div>
						</div>
						<%-- <div class="form-group">
							<label for="person_file"
								class="col-sm-2 control-label contact_us_form_item"><spring:message
									code="page.contactus.form.message.label" /></label>

							<div class="col-sm-10">
								<input type="file" name="person_file" id="person_file">
							</div>
						</div> --%>
						<div class="form-group">
							<div class="col-sm-5 col-xs-5 text-center">
								<button type="reset" class="btn btn-danger" name="reset">
									<spring:message code="page.contactus.form.reset.btn" />
								</button>
							</div>
							<div
								class="col-sm-offset-2 col-sm-5 col-xm-offset-2 col-xs-5 text-center">
								<button type="button" class="btn btn-success"
									ng-click="sendFormToServer()">
									<spring:message code="page.contactus.form.send.btn" />
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div id="googleMapP">
						<label> <spring:message
								code="page.contactus.address.map.label" />
						</label>
						<button class="btn btn-info" id="button_show_hide_map">
							<span id="span_show"><spring:message
									code="page.contactus.address.show_map.label" /></span> <span
								id="span_hide"><spring:message
									code="page.contactus.address.hide_map.label" /></span>
						</button>
					</div>
					<div id="googleMap"></div>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>