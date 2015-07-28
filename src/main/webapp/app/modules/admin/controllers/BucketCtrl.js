admin.controller( 'BucketCtrl', ['$scope','$http', function ( $scope,$http) {
	$http.get('modules/admin/json/bucket.json').then(function(response){
          	$scope.products = response.data;
            	});
            	$scope.deleteProduct = function(index){
            	$scope.products.splice(index,1);
            	}
            	}])