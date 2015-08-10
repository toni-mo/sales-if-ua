goods.controller('OverviewCtrl', ['$scope', '$http', '$routeParams', function($scope, $http, $routeParams){
	$scope.id = $routeParams.goodId;
	// fetching data for 1 good
	// $http.get()
}]);