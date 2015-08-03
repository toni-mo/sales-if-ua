goods
	.controller('OrderCtrl', ['$scope', '$http', function($scope, $http){
		// fields for future JSON
		$scope.goodId = "";
		$scope.firstName = "";
		$scope.lastName = "";
		$scope.email = "";
		// card field
		$scope.card = {
			number: "",
			type: "",
			expireMonth: "",
			expireYear: "",
			cvv2: ""
		};

		$scope.makeOrder = function(){
			// alert("Hello");
			var order = {
				goodsId: $scope.goodId,
				firstName: $scope.firstName,
				lastName: $scope.lastName,
				email: $scope.email,
				card: $scope.card
			};
			console.log("User has sent an order:", order);
		};

		

		$scope.getClass = function(fieldStatus, pristine){
			if(!pristine){
				return{
					'has-success': fieldStatus,
					'has-error': !fieldStatus
				};
			}
		};

		$scope.getIconClass = function(fieldStatus, pristine){
			if(!pristine){
				return{
					'glyphicon-ok': fieldStatus,
					'glyphicon-remove': !fieldStatus
				};
			};
		};


	}]);