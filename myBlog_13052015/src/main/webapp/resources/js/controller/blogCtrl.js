/**
 * Created by c-DMITMINZ on 6/3/2015.
 */

var myBlog = "/myBlog/";
var validationSuccessClass = "validationSuccess";
var validationErrorClass = "validationError";

function dateAddFirstNull(dateTime) {
    if(dateTime >= 0 && dateTime < 10){
        return "0" + dateTime;
    }
    return dateTime;
}

function getNormalDate(dateInMilliSeconds){
    var dateIn = null;
    if(dateInMilliSeconds == 0){
        dateIn = new Date();
    }else{
        dateIn = new Date(dateInMilliSeconds);
    }

    var dateRequest = dateAddFirstNull(dateIn.getDate()) + "." + dateAddFirstNull(dateIn.getMonth() + 1) + "." + dateIn.getFullYear();
    dateRequest += " " + dateAddFirstNull(dateIn.getHours()) + ":" + dateAddFirstNull(dateIn.getMinutes()) + ":"
        + dateAddFirstNull(dateIn.getSeconds()) + "." + dateAddFirstNull(dateIn.getMilliseconds());
    return dateRequest;
}

contactUsApp.controller('contactUsCtrl', function ($scope, $http, $location, $timeout) {

    $scope.hostNameSite = myBlog;
    $scope.updateCaptchaURL = $scope.hostNameSite + "updateCaptcha/";
    $scope.sendEmail = $scope.hostNameSite + "sendEmail";

    $scope.init = function () {
        var response = $http.get($scope.updateCaptchaURL);

        response.success(function (data, status, headers, config) {
            data.pathToImage = $scope.hostNameSite + data.pathToImage;
            $scope.responseCaptcha = data;
        });

        response.error(function (data, status, headers, config) {
            alert("Error")
        });

    };

    $scope.loadOtherImg = function () {
        $scope.init();
    };


    /////email form
    $scope.emailForm = {};

    $scope.emailForm.emailSendNow = false;
    $scope.emailForm.emailSendNowTextProcessing = "";

    $scope.emailForm.namePerson = "";
    $scope.emailForm.namePersonMinLength = 5;
    $scope.emailForm.namePersonMaxLength = 50;

    $scope.emailForm.emailPerson = "";
    $scope.emailForm.emailPersonMinLength = $scope.emailForm.namePersonMinLength;
    $scope.emailForm.emailPersonMaxLength = $scope.emailForm.namePersonMaxLength;

    $scope.emailForm.phoneNumberPerson = "";
    $scope.emailForm.phoneNumberPersonMinLength = 6;
    $scope.emailForm.phoneNumberPersonMaxLength = 15;

    $scope.emailForm.subjectMessagePerson = "";
    $scope.emailForm.subjectMessagePersonMinLength = 2;
    $scope.emailForm.subjectMessagePersonMaxLength = $scope.emailForm.namePersonMaxLength;

    $scope.emailForm.textMessagePerson = "";
    $scope.emailForm.textMessagePersonMinLength = 2;
    $scope.emailForm.textMessagePersonMaxLength = 1000;

    $scope.emailForm.captcha = "";
    $scope.emailForm.captchaMinLength = 11;
    $scope.emailForm.captchaMaxLength = 11;
    $scope.emailForm.captchaNotEquals = false;
    $scope.emailForm.captchaNotLength11 = false;

    /*init style validation*/
    $scope.emailForm.initStyleValidation = function () {
        $scope.emailForm.namePersonValidationClass = "";
        $scope.emailForm.emailPersonValidationClass = "";
        $scope.emailForm.phoneNumberPersonValidationClass = "";
        $scope.emailForm.subjectMessagePersonValidationClass = "";
        $scope.emailForm.textMessagePersonValidationClass = "";
        $scope.emailForm.captchaValidationClass = "";
    };
    $scope.emailForm.initStyleValidation();

    /*reset*/
    $scope.emailForm.reset = function () {
        $scope.emailForm.namePerson = "";
        $scope.emailForm.emailPerson = "";
        $scope.emailForm.phoneNumberPerson = "";
        $scope.emailForm.subjectMessagePerson = "";
        $scope.emailForm.textMessagePerson = "";
        $scope.emailForm.captcha = "";
        $scope.emailForm.initStyleValidation();
    };

    $scope.emailForm.responseFromServer = function () {
        $scope.emailForm.emailSendNow = false;
    };

    /*submit email*/
    $scope.emailForm.submitEmail = function () {
        $scope.emailForm.checkAllField();
        if ($scope.emailForm.namePersonValidationClass == validationSuccessClass
            && $scope.emailForm.phoneNumberPersonValidationClass == validationSuccessClass
            && $scope.emailForm.phoneNumberPersonValidationClass == validationSuccessClass
            && $scope.emailForm.subjectMessagePersonValidationClass == validationSuccessClass
            && $scope.emailForm.textMessagePersonValidationClass == validationSuccessClass
            && $scope.emailForm.captchaValidationClass == validationSuccessClass) {

            var dateRequest = getNormalDate(0);

            var responseEmailSend = $http({
                method: 'POST',
                url: $scope.sendEmail,
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                data: $.param({
                    namePerson: $scope.emailForm.namePerson,
                    emailPerson: $scope.emailForm.emailPerson,
                    phoneNumberPerson: $scope.emailForm.phoneNumberPerson,
                    subjectMessagePerson: $scope.emailForm.subjectMessagePerson,
                    textMessagePerson: $scope.emailForm.textMessagePerson,
                    currentTimeByUser: dateRequest,
                    captcha: $scope.emailForm.captcha,
                    imageID: $scope.responseCaptcha.idCaptcha
                })
            });

            $scope.emailForm.emailSendNow = true;
            $scope.emailForm.emailSendNowTextProcessing = "Email sending...";

            responseEmailSend.success(function (dataFromServer, status, headers, config) {
                if (dataFromServer.errorOrException) {
                    if (dataFromServer.errorOrExceptionDescription == "captchaNotEquals") {
                        $scope.loadOtherImg();
                        $scope.emailForm.captchaNotEquals = true;
                        $scope.emailForm.captchaNotLength11 = false;
                        $scope.emailForm.emailSendNow = false;
                        $scope.emailForm.captchaValidationClass = "";
                        return;
                    } else if (dataFromServer.errorOrExceptionDescription == "captchaNotLength11") {
                        $scope.loadOtherImg();
                        $scope.emailForm.captchaNotEquals = false;
                        $scope.emailForm.captchaNotLength11 = true;
                        $scope.emailForm.emailSendNow = false;
                        $scope.emailForm.captchaValidationClass = "";
                        return;
                    } else if (dataFromServer.errorOrExceptionDescription.indexOf("Exception") >= 0) {
                        $scope.emailForm.emailSendNowTextProcessing = dataFromServer.errorOrExceptionDescription;
                    }
                    else {
                        $scope.emailForm.emailSendNowTextProcessing = "Email send is success!";
                    }
                }
                $scope.emailForm.captchaNotEquals = false;
                $scope.emailForm.captchaNotLength11 = false;
                $scope.emailForm.reset();
                $scope.loadOtherImg();
                $timeout(function () {
                    $scope.emailForm.responseFromServer();
                }, 2500);
            });

            responseEmailSend.error(function (data, status, headers, config) {
                if (!dataFromServer.errorOrException) {
                    $scope.emailForm.emailSendNowTextProcessing = "Error sending email! " + dataFromServer.errorOrExceptionDescription;
                }
                $scope.emailForm.captchaNotEquals = false;
                $scope.emailForm.captchaNotLength11 = false;
                $scope.emailForm.reset();
                $scope.loadOtherImg();
                $timeout(function () {
                    $scope.emailForm.responseFromServer();
                }, 2500);
            });

        }
    };

    $scope.emailForm.checkAllField = function () {
        if ($scope.emailForm.namePerson.length >= $scope.emailForm.namePersonMinLength && $scope.emailForm.namePerson.length <= $scope.emailForm.namePersonMaxLength) {
            $scope.emailForm.namePersonValidationClass = validationSuccessClass;
        } else {
            $scope.emailForm.namePersonValidationClass = validationErrorClass;
        }

        if ($scope.emailForm.emailPerson.length >= $scope.emailForm.emailPersonMinLength && $scope.emailForm.emailPerson.length <= $scope.emailForm.emailPersonMaxLength) {
            $scope.emailForm.emailPersonValidationClass = validationSuccessClass;
        } else {
            $scope.emailForm.emailPersonValidationClass = validationErrorClass;
        }

        if ($scope.emailForm.phoneNumberPerson.length > 0) {
            if ($scope.emailForm.phoneNumberPerson.length >= $scope.emailForm.phoneNumberPersonMinLength && $scope.emailForm.phoneNumberPerson.length <= $scope.emailForm.phoneNumberPersonMaxLength) {
                $scope.emailForm.phoneNumberPersonValidationClass = validationSuccessClass;
            } else {
                $scope.emailForm.phoneNumberPersonValidationClass = validationErrorClass;
            }
        } else {
            $scope.emailForm.phoneNumberPersonValidationClass = validationSuccessClass;
        }

        if ($scope.emailForm.subjectMessagePerson.length >= $scope.emailForm.subjectMessagePersonMinLength && $scope.emailForm.subjectMessagePerson.length <= $scope.emailForm.subjectMessagePersonMaxLength) {
            $scope.emailForm.subjectMessagePersonValidationClass = validationSuccessClass;
        } else {
            $scope.emailForm.subjectMessagePersonValidationClass = validationErrorClass;
        }

        if ($scope.emailForm.textMessagePerson.length >= $scope.emailForm.textMessagePersonMinLength && $scope.emailForm.textMessagePerson.length <= $scope.emailForm.textMessagePersonMaxLength) {
            $scope.emailForm.textMessagePersonValidationClass = validationSuccessClass;
        } else {
            $scope.emailForm.textMessagePersonValidationClass = validationErrorClass;
        }

        if ($scope.emailForm.captcha.length >= $scope.emailForm.captchaMinLength && $scope.emailForm.captcha.length <= $scope.emailForm.captchaMaxLength) {
            $scope.emailForm.captchaValidationClass = validationSuccessClass;
        } else {
            $scope.emailForm.captchaValidationClass = validationErrorClass;
        }

    };

    $scope.namePersonChange = function () {
        if ($scope.emailForm.namePerson.length >= $scope.emailForm.namePersonMinLength && $scope.emailForm.namePerson.length <= $scope.emailForm.namePersonMaxLength) {
            $scope.emailForm.namePersonValidationClass = validationSuccessClass;
        } else {
            $scope.emailForm.namePersonValidationClass = validationErrorClass;
        }
    };


});


/*directives*/
contactUsApp.directive('numbersOnly', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, attrs, modelCtrl) {
            modelCtrl.$parsers.push(function (inputValue) {
                if (inputValue == undefined) return '';
                var transformInput = inputValue.replace(/[^0-9]/g, '');
                if (transformInput != inputValue) {
                    modelCtrl.$setViewValue(transformInput);
                    modelCtrl.$render();
                }
                return transformInput;
            });
        }
    }

});

tutorialApp.controller('tutorialCtrl',function ($scope, $http, $location, $timeout) {

    $scope.hostNameSite = myBlog;
    $scope.get_all_tutorialsURL = $scope.hostNameSite + "get_all_tutorials/";
    $scope.get_tutorial = $scope.hostNameSite + "get_tutorial/";
    $scope.tutorials = {};

    $scope.init = function(){

        var response = $http.get($scope.get_all_tutorialsURL);

        response.success(function (data, status, headers, config) {
            for(i = 0; i < data.length; i++){
                data[i].articleCreatedDate = getNormalDate(data[i].articleCreatedDate);
                data[i].articleLastUpdatedDate = getNormalDate(data[i].articleLastUpdatedDate);
            }
            $scope.tutorials = data;
        });

        response.error(function (data, status, headers, config) {
            alert("Error")
        });

    };

    $scope.predicate = 'articleCreatedDate';
    $scope.reverse = true;
    $scope.order = function(predicate) {
        $scope.reverse = ($scope.predicate === predicate) ? !$scope.reverse : false;
        $scope.predicate = predicate;
    };

    $scope.submitGetTutorial = function(idArticle){
        var responseEmailSend = $http({
            method: 'GET',
            url: $scope.get_tutorial,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            data: $.param({
                articleId: idArticle
            })
        });
    };

});

/*tutorialApp.config(['$routeProvider'], function($routeProvider){
    $routeProvider.when('/tutorial', {
        templateUrl: 'tutorial',
        controller: 'tutorialCtrl'
    }).when('/tutorial/:tutorialId', {
        templateUrl: 'tutorial-detail',
        controller: 'tutorialCtrl'
    }).otherwise({
        redirectTo: '/tutorial'
    });
});*/