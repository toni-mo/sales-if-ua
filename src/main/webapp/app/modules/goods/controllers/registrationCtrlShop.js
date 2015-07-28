goods.controller('registrationCtrlShop', ['$scope', '$http', function($scope, $http){
	$scope.user = {
		shopName: "",
		country: "",
		region: "",
		city: "",
		street: "",	
		building: "",
		eMail: "",
		shopPhone: "",
		shopPasswd: "",
		repPasswd: ""
	};

	$scope.submit = function() {
		console.log('User clicked submit with ', $scope.user);
	};
}]);