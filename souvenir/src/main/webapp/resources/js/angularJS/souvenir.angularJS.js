/**
 *
 */
var host = "/souvenir";

var contactUsApp = angular.module('contactUsApp', []);
contactUsApp
    .controller(
    'contactUsCtrl',
    function ($scope, $http, $timeout) {
        /* objects */
        $scope.currentCaptcha = "";
        $scope.formDataSendEmail = {
            messageId: 0,
            messageName: "",
            messageEmail: "",
            messageText: "",
            messageCaptcha: ""
        };

        /* paths */
        $scope.updateCaptchaURL = host + "/update_captcha";
        $scope.sendEmailURLURL = host + "/sendemail";
        $scope.sendemailWithFileURL = host + "/sendemailWithFile";
        $scope.check_captchaURL = host + "/check_captcha";

        /* variables */
        $scope.responseFormSuccess = false;
        $scope.responseFormError = false;
        $scope.showFileUpload = false;

        /* functions */
        $scope.refreshCaptcha = function () {
            var dataObj = {
                captchaId: $scope.currentCaptcha.captchaId,
                captchaValue: "",
                captchaUrlFile: ""
            };
            $http
                .post($scope.updateCaptchaURL, dataObj)
                .success(
                function (response) {
                    $scope.currentCaptcha = response;
                    $scope.currentCaptcha.captchaUrlFile = host
                        + $scope.currentCaptcha.captchaUrlFile;
                });
        };
        $scope.refreshCaptcha();

        $scope.sendFormToServer = function () {
            if ($scope.showFileUpload) {
                var data = 'messageName='
                    + $scope.formDataSendEmail.messageName
                    + '&messageEmail='
                    + $scope.formDataSendEmail.messageEmail
                    + '&messageText='
                    + $scope.formDataSendEmail.messageText
                    + '&messageCaptcha='
                    + $scope.formDataSendEmail.messageCaptcha;

                /*
                 * var data = $.param({ messageName:
                 * $scope.formDataSendEmail.messageName,
                 * messageEmail:
                 * $scope.formDataSendEmail.messageEmail,
                 * messageText:
                 * $scope.formDataSendEmail.messageText,
                 * messageCaptcha:
                 * $scope.formDataSendEmail.messageCaptcha });
                 */
                var config = {
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
                    }
                };

                $http.post($scope.sendemailWithFileURL, data,
                    config).success(function (response) {
                        console.log(response);
                        $scope.responseFormSuccess = true;
                        $scope.responseFormError = false;
                    }).error(function (response) {
                        $scope.responseFormSuccess = false;
                        $scope.responseFormError = true;
                    });
            } else {
                $scope.formDataSendEmail.messageCaptcha = $scope.currentCaptcha.captchaId;
                $http.post($scope.sendEmailURLURL,
                    $scope.formDataSendEmail).success(
                    function (response) {
                        console.log(response);
                        $scope.responseFormSuccess = true;
                        $scope.responseFormError = false;
                        $timeout(callAtTimeout, 3000);
                    }).error(function (response) {
                        $scope.responseFormSuccess = false;
                        $scope.responseFormError = true;
                        $timeout(callAtTimeout, 3000);
                    });
            }
        }

        $scope.checkCaptcha = function () {
            if ($scope.formDataSendEmail.messageCaptcha) {
                var dataObj = {
                    captchaId: $scope.currentCaptcha.captchaId,
                    captchaValue: $scope.formDataSendEmail.messageCaptcha,
                    captchaUrlFile: ""
                };
                $http.post($scope.check_captchaURL, dataObj)
                    .success(function (response) {
                        $scope.currentCaptcha = response;
                        alert(response);
                    });
            }
        }

        function callAtTimeout() {
            $scope.responseFormSuccess = false;
            $scope.responseFormError = false;
        }

        $scope.fileUpload = function () {
            $scope.showFileUpload = !$scope.showFileUpload;
        };

    });


var catalogApp = angular.module('catalogApp', []);
catalogApp.controller('catalogCtrl',function ($scope, $http, $timeout) {

});