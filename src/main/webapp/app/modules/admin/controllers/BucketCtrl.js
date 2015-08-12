admin.controller('BucketCtrl', ['$scope', '$http','$routeParams', function ($scope, $http, $routeParams) {
    $scope.products = '';
    $scope.id = '';
    $scope.role= '';
    $scope.id = $routeParams.userId;
    $scope.role = $routeParams.role;
    $scope.addChart = function(id){
        //alert('product id :'+id);
        $http.get('/Practice/goods?id=1').then(function (response) {
            $scope.prod = response.data;
            $scope.products[$scope.products.length+1]=$scope.prod;
        });
    };
    $scope.deleteProduct = function (index) {
        $scope.products.splice(index, 1);
    }
}]);