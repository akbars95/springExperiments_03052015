/**
 *
 */
var host = "/souvenir";

var contactUsApp = angular.module('contactUsApp', []);
contactUsApp
    .controller(
    'contactUsCtrl',
    function ($scope, $http) {
        $scope.currentCaptcha = "";
        $scope.updateCaptchaURL = host + "/update_captcha";
        $scope.sendEmailURLURL = host + "/sendemail";
        $scope.sendemailWithFileURL = host + "/sendemailWithFile";

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

        $scope.formDataSendEmail = {
            messageId: 0,
            messageName: "",
            messageEmail: "",
            messageText: "",
            messageCaptcha: ""
        };
        $scope.responseFormSuccess = false;
        $scope.responseFormError = false;

        $scope.sendFormToServer = function () {
            if ($scope.showFileUpload) {
                var data = 'messageName=' + $scope.formDataSendEmail.messageName +
                            '&messageEmail=' + $scope.formDataSendEmail.messageEmail +
                    '&messageText=' + $scope.formDataSendEmail.messageText +
                    '&messageCaptcha=' + $scope.formDataSendEmail.messageCaptcha;

                /*var data = $.param({
                    messageName: $scope.formDataSendEmail.messageName,
                    messageEmail: $scope.formDataSendEmail.messageEmail,
                    messageText: $scope.formDataSendEmail.messageText,
                    messageCaptcha: $scope.formDataSendEmail.messageCaptcha
                });*/

                /*var data = "messageName=fvz&messageEmail=zdfz&messageText=dfzfd&messageCaptcha=zdfdf";*/

                var config = {
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
                    }
                };

                $http.post($scope.sendemailWithFileURL, data, config).success(
                    function (response) {
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
                    }).error(function (response) {
                        $scope.responseFormSuccess = false;
                        $scope.responseFormError = true;
                    });
            }
        }

        $scope.showFileUpload = false;
        $scope.fileUpload = function () {
            $scope.showFileUpload = !$scope.showFileUpload;
        };

    });