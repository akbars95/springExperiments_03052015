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

    $scope.namePersonChange = function(){
        if($scope.emailForm.namePerson.length >= $scope.emailForm.namePersonMinLength && $scope.emailForm.namePerson.length <= $scope.emailForm.namePersonMaxLength){
            $scope.emailForm.namePersonValidationClass = validationSuccessClass;
        }else{
            $scope.emailForm.namePersonValidationClass = validationErrorClass;
        }
    };


});