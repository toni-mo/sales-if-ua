home.controller('ProductsCtrl', ['$scope', '$http', function($scope, $http){
	$scope.goods=[];
	// Fetching data from server
	$http.get('http://localhost:8080/Practice/goods/').then(function(response){
		$scope.goods = response.data;
	});
}]);