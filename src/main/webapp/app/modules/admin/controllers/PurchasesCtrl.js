admin.controller('PurchasesCtrl', ['$scope', '$http','$routeParams', function ($scope, $http, $routeParams) {
    $scope.id= '';
    $scope.role = '';
    $scope.id = $routeParams.userId;
    $scope.role = $routeParams.role;
    $http.get('app/modules/admin/json/purchases.json').then(function (response) {
        $scope.purch = response.data;
    });
    $scope.deletePurchases = function () {
        $scope.purchases.splice(0, $scope.purchases.length);
    };
}]);
