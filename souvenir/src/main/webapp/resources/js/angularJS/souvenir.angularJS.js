/**
 *
 */

/*app*/
var souvenirApp = angular.module('souvenirApp', ['ngRoute']);

/*constants*/
souvenirApp.constant("hostConst", "/souvenir");

/*Ctrl*/
/*index page*/
souvenirApp.controller('indexCtrl', function ($scope, $http, $timeout, hostConst) {

});

/*catalog page*/
souvenirApp.controller('catalogCtrl', function ($scope, $http, $timeout, hostConst) {
    var get_all_souvenirsURL = "/get_all_souvenirs";
    $http.get(hostConst + get_all_souvenirsURL).
        success(function (data, status, headers, config) {
            $scope.souvenirs = data;
        }).
        error(function (data, status, headers, config) {
            // log error
        });
});

/*souvenirById page*/
souvenirApp.controller('souvenirByIdCtrl', function ($scope, $http, $timeout, hostConst) {
    var get_all_souvenirsURL = "/get_all_souvenirs";
    $http.get(hostConst + get_all_souvenirsURL).
        success(function (data, status, headers, config) {
            $scope.souvenirs = data;
        }).
        error(function (data, status, headers, config) {
            // log error
        });
});

/*advanced_search page*/
souvenirApp.controller('advancedSearchCtrl', function ($scope, $http, $timeout, hostConst) {

});

/*about_us page*/
souvenirApp.controller('aboutUsCtrl', function ($scope, $http, $timeout, hostConst) {

});

souvenirApp
    .controller(
    'contactUsCtrl',
    function ($scope, $http, $timeout, hostConst) {
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
        $scope.updateCaptchaURL = hostConst + "/update_captcha";
        $scope.sendEmailURLURL = hostConst + "/sendemail";
        $scope.sendemailWithFileURL = hostConst + "/sendemailWithFile";
        $scope.check_captchaURL = hostConst + "/check_captcha";

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
                    $scope.currentCaptcha.captchaUrlFile = hostConst
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