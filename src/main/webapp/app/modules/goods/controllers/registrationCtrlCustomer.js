goods.controller('registrationCtrlCustomer', ['$scope', '$http', function($scope, $http){
	$scope.user = {
		firstName: "",
		surName: "",
		gender: "",
		dob: "",
		eMail: "",	
		phoneNumber: "",
		password: "",
		repeatPasswd: ""
	};


	$scope.submit = function() {
		console.log('User clicked submit with ', $scope.user);
	};
}]);