admin.controller('OrdersCtrl', ['$scope', '$http','$routeParams', function ($scope, $http, $routeParams) {
    $scope.id = '';
    $scope.role = '';
    $scope.id = $routeParams.userId;
    $scope.role = $routeParams.role;
    $http.get('app/modules/admin/json/orders.json').then(function (response) {
        $scope.orders = response.data;
    })
}]);