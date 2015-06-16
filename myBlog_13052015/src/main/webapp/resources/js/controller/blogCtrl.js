/**
 * Created by c-DMITMINZ on 6/3/2015.
 */

var myBlog = "/myBlog/";
var validationSuccessClass = "validationSuccess";
var validationErrorClass = "validationError";

contactUsApp.controller('contactUsCtrl', function($scope, $http, $location){

    $scope.hostNameSite = myBlog;
    $scope.updateCaptchaURL = $scope.hostNameSite + "updateCaptcha/";

    $scope.init = function(){
        var response = $http.get($scope.updateCaptchaURL);

        response.success(function(data, status, headers, config){
            data.pathToImage = $scope.hostNameSite + data.pathToImage;
            $scope.responseCaptcha = data;
        });

        response.error(function(data, status, headers, config){
            alert("Error")
        });

    };

    $scope.namePerson = "";

    $scope.submitDate = function(){

    };



    $scope.loadOtherImg = function(){
        $scope.init();
    }


    /////email form
    $scope.emailForm = {};


    $scope.emailForm.namePerson = "";
    $scope.emailForm.namePersonMinLength = 5;
    $scope.emailForm.namePersonMaxLength = 50;
    $scope.emailForm.namePersonValidationClass = validationErrorClass;


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

    /*reset*/
    $scope.emailForm.reset = function(){
        $scope.emailForm.namePerson = "";
        $scope.emailForm.emailPerson = "";
        $scope.emailForm.phoneNumberPerson = "";
        $scope.emailForm.subjectMessagePerson = "";
        $scope.emailForm.textMessagePerson = "";
        $scope.emailForm.captcha = "";
    };

    /*submit email*/
    $scope.emailForm.submitEmail = function(){

    };

    $scope.namePersonChange = function(){
        if($scope.emailForm.namePerson.length >= $scope.emailForm.namePersonMinLength && $scope.emailForm.namePerson.length <= $scope.emailForm.namePersonMaxLength){
            $scope.emailForm.namePersonValidationClass = validationSuccessClass;
        }else{
            $scope.emailForm.namePersonValidationClass = validationErrorClass;
        }
    };


});


/*directives*/
contactUsApp.directive('numbersOnly', function(){
    return {
        require: 'ngModel',
        link: function(scope, element, attrs, modelCtrl){
            modelCtrl.$parsers.push(function(inputValue){
                if(inputValue == undefined) return '';
                var transformInput = inputValue.replace(/[^0-9]/g, '');
                if(transformInput != inputValue){
                    modelCtrl.$setViewValue(transformInput);
                    modelCtrl.$render();
                }
                return transformInput;
            });
        }
    }

});