angular.module('forCustomCtrlApp', [])
	.controller('firstCustCtrl', ['$scope',function($scope){
		$scope.hello = "Hello Anton";
		$scope.newVar = "new VAr";
	}]);