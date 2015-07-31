admin.controller('ShopAdmCtrl', ['$scope', '$http', function ($scope, $http) {
    $http.get('app/modules/admin/json/products.json').then(function (response) {
        $scope.products = response.data;
    });
    $http.get('app/modules/admin/json/product_1.json').then(function (response) {
        $scope.pr = response.data;
    })
}])