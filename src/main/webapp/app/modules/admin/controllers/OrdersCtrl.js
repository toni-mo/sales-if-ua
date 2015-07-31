admin.controller('OrdersCtrl', ['$scope', '$http', function ($scope, $http) {
    $http.get('app/modules/admin/json/orders.json').then(function (response) {
        $scope.orders = response.data;
    })
}])