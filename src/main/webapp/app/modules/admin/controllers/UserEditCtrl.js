admin.controller('UserEditCtrl', ['$scope', '$http','$routeParams', function ($scope, $http, $routeParams) {
    $scope.id= '';
    $scope.role = '';
    $scope.user ='';
    $http.get('/Practice/user/client/'+ $routeParams.userId).then(function (response) {
        $scope.user = response.data;
        $scope.id = $routeParams.userId;
        $scope.role = $routeParams.role;
    })
}])