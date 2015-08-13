home.controller('ProductsCtrl', ['$scope', '$http', '$location', 'CategoryService', function($scope, $http, $location, CategoryService){
	$scope.goods=[];
	console.log(CategoryService.categories);
	// Fetching data from server
	// $http.get('http://localhost:8080/Practice/goods/search?name=Sony').then(function(response){
	// 	$scope.goods = response.data;
	// });

	// $http.get('http://');

	$scope.inputData = $location.search().name;

	$http.get('http://localhost:8080/Practice/goods/search?name='+$location.search().name).then(function(response){
		$scope.goods = response.data;
	});
}]);