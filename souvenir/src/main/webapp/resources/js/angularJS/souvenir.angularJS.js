/**
 * 
 */
var host = "/souvenir";

var contactUsApp = angular.module('contactUsApp', []);
contactUsApp.controller('contactUsCtrl', function($scope, $http){
	$scope.currentCaptcha = "";
	$scope.updateCaptchaURL = host + "/update_captcha";
	
	
	
	$scope.refreshCaptcha = function(){
		var dataObj = {
				captchaId : $scope.currentCaptcha.captchaId, 
				captchaValue: "",
				captchaUrlFile : ""
		};
		$http.post($scope.updateCaptchaURL, dataObj).success(function(response){
			$scope.currentCaptcha = response;
			$scope.currentCaptcha.captchaUrlFile = host + $scope.currentCaptcha.captchaUrlFile;
		});
	};
	
	$scope.refreshCaptcha();
	
});