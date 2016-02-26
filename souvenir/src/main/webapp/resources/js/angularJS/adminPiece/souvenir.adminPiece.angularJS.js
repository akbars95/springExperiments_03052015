/**
 * 
 */

/* apps */
var souvenirAdminPieceApp = angular.module('souvenirAdminPieceApp', []);

/* constants */
souvenirAdminPieceApp.constant("hostConst", "/souvenir");

/* controllers */
souvenirAdminPieceApp.controller('insertSouvenirCtrl', function($scope, $http,
		hostConst) {
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
		$http.post(hostConst + "/souvenirInsert", fd, {
			transformRequest : angular.identity,
			headers : {
				'Content-Type' : undefined
			}
		}).success(function(data) {
			console.log(data)
		});
	};

});

souvenirAdminPieceApp.controller('adminSouvenirCtrl', function($scope, $http,
		hostConst) {
	$scope.getAllSOuvenirs = function() {
		var get_all_souvenirsURL = "/get_all_souvenirs";

		$scope.souvenirs = [];

		$http.get(hostConst + get_all_souvenirsURL).success(
				function(data, status, headers, config) {
					$scope.souvenirs = data;
				}).error(function(data, status, headers, config) {
			// log error
		});
		
		$scope.styleClassesForInsertNewSouvenir = "glyphicon-plus";
		
		$scope.eventMouseEnterNew = function(){
			$scope.styleClassesForInsertNewSouvenir = "glyphicon-plus-sign";
		};
		
		$scope.eventMouseLeaveNew = function(){
			$scope.styleClassesForInsertNewSouvenir = "glyphicon-plus";
		};
		
	};

	$scope.getAllSOuvenirs();

});

/* directives */
souvenirAdminPieceApp.directive('fileInput', [ '$parse', function($parse) {
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