goods.controller('LoginController', ['$scope', '$http', function($scope, $http){
	$scope.user = {
		username: "",
		password: ""	
	};


	$scope.submit = function() {
		console.log('User clicked submit with ', $scope.user);
	};
}]);