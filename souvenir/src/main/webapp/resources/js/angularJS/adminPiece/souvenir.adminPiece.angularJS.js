/**
 * 
 */
var host = "/souvenir";

var contactUsApp = angular.module('insertSouvenirApp', []);
contactUsApp.controller('insertSouvenirCtrl', function($scope, $http) {
	/* objects */

	/* paths */

	/* variables */

	/* functions */
	$scope.save = function() {
		var fd = new FormData();
		angular.forEach($scope.files, function(file) {
			fd.append('souvenirPath', file);
		});
		fd.append('souvenirName', $scope.souvenirName);
		fd.append('souvenirDescription', $scope.souvenirDescription);
		fd.append('souvenirShow', $scope.souvenirShow);
		fd.append('souvenirCategoryId', $scope.souvenirCategoryId);
		fd.append('souvenirPrice', $scope.souvenirPrice);
		$http.post("/souvenir/souvenirInsert", fd, {
			transformRequest : angular.identity,
			headers : {
				'Content-Type' : undefined
			}
		}).success(function(data) {
			console.log(data)
		});
	};

});

contactUsApp.directive('fileInput', [ '$parse', function($parse) {
	return {
		restrict : 'A',
		link : function(scope, elm, attrs) {
			elm.bind('change', function() {
				$parse(attrs.fileInput).assign(scope, elm[0].files);
				scope.$apply();
			})
		}
	};
} ]);