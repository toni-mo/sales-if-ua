home
	.controller('TestCtrl', ['$scope', '$http', '$routeParams', 'CategoryService', function($scope, $http, $routeParams, CategoryService){
		$scope.testVar = "We're using a Test controller";

		$scope.category = CategoryService.get({categoryId: $routeParams.categoryId});

		// $http.get('modules/home/json/categories.json',{categoryId: $routeParams.categoryId}).then(function(response){
		// 	$scope.category = response.data;
		// });

		// $scope.routeVar = $routeParams.categoryId;
		// $http.get({
		// 	method: 'GET',
		// 	url: 'modules/home/json/:categoryId.json',
		// 	params: {
		// 		categoryId: $routeParams.categoryId
		// 	}
		// }).then(function(response){
		// 	$scope.category = response.data;
		// });

		// $http.get('modules/home/json/categories.json').then(function(response){
		// 	$scope.itemArray = response.data;
		// });
	}]);