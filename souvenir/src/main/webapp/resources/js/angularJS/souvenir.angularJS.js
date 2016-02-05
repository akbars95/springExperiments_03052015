/**
 * 
 */
var host = "/souvenir";

var contactUsApp = angular.module('contactUsApp', []);
contactUsApp
		.controller(
				'contactUsCtrl',
				function($scope, $http) {
					$scope.currentCaptcha = "";
					$scope.updateCaptchaURL = host + "/update_captcha";
					$scope.sendEmailURLURL = host + "/sendemail";

					$scope.refreshCaptcha = function() {
						var dataObj = {
							captchaId : $scope.currentCaptcha.captchaId,
							captchaValue : "",
							captchaUrlFile : ""
						};
						$http
								.post($scope.updateCaptchaURL, dataObj)
								.success(
										function(response) {
											$scope.currentCaptcha = response;
											$scope.currentCaptcha.captchaUrlFile = host
													+ $scope.currentCaptcha.captchaUrlFile;
										});
					};
					$scope.refreshCaptcha();

					$scope.formDataSendEmail = {
						messageId : 0,
						messageName : "",
						messageEmail : "",
						messageText : "",
						messageCaptcha : ""
					};
					$scope.responseFormSuccess = false;
					$scope.responseFormError = false;

					$scope.sendFormToServer = function() {
						$scope.formDataSendEmail.messageCaptcha = $scope.currentCaptcha.captchaId;
						$http.post($scope.sendEmailURLURL,
								$scope.formDataSendEmail).success(
								function(response) {
									console.log(response);
									$scope.responseFormSuccess = true;
									$scope.responseFormError = false;
								}).error(function(response) {
							$scope.responseFormSuccess = false;
							$scope.responseFormError = true;
						});
					}

				});