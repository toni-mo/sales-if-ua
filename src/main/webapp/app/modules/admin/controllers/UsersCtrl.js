admin.controller('UsersCtrl', ['$scope', '$http','$routeParams', function ($scope, $http, $routeParams) {
    $scope.id = '';
    $scope.role = '';
    $scope.id = $routeParams.userId;
    $scope.role = $routeParams.role;
    $scope.users = '';
    $http.get('/Practice/user/client').then(function (response) {
        $scope.users = response.data;
        if($scope.users[index].isBlocked == false){
            $scope.users[index].isBlocked = "active";
        }else $scope.users[index].isBlocked = "blocked";
    });
    $scope.deleteAlert = function(index){
        if(confirm('You want to delete user:'+$scope.users[index].firstName+' '+$scope.users[index].lastName)){
            $http.get('/Practice/user/delete/'+$scope.users[index].id);
            $http.get('/Practice/user/client').then(function (response) {
                $scope.users = response.data;})
        }

    };
    $scope.btnBlockName = "block";
    $scope.showMessage = function (status) {
        if (status == false){return "block";}
        if(status == true){return "unblock";}
    };
    $scope.changeButtonName = function (index) {
        if (true == $scope.users[index].isBlocked) {
            $scope.btnBlockName = 'unblock';
            $http.put('/Practice/user/lock/' + $scope.users[index].id).then(function() {
                $http.get('/Practice/user/client').then(function (response) {
                    $scope.users = response.data;
                });});
        }
        else {
            $scope.btnBlockName = 'block';
            $http.put('/Practice/user/lock/' + $scope.users[index].id).then(function() {
                $http.get('/Practice/user/client').then(function (response) {
                    $scope.users = response.data;
                });
            });
        }
    };
    $scope.getClass = function (status) {
        if (status == "blocked")
            return {
                'fa-unlock': true
            }
        else
            return {
                'fa-lock': true
            };
    }
    $scope.getRowStatus = function (status) {
        if (status == true)
            return {
                'adm-PR1': true
            }
        else
            return {
                'adm-PR1': false
            };
    }
}]);