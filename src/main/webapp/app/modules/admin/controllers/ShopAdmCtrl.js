admin.controller('ShopAdmCtrl', ['$scope', '$http','$routeParams', function ($scope, $http, $routeParams) {
    $scope.id = '';
    $scope.role = '';
    $scope.id = $routeParams.userId;
    $scope.role = $routeParams.role;
    $http.get('app/modules/admin/json/products.json').then(function (response) {
        $scope.products = response.data;
    });
    $http.get('app/modules/admin/json/product_1.json').then(function (response) {
        $scope.pr = response.data;
    })
}]);