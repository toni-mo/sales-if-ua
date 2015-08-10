admin.controller('ShopsCtrl', ['$scope', '$http', function ($scope, $http) {
    $http.get('/Practice/user/shop').then(function (response) {
        $scope.shops = response.data;
    });
    $scope.changeStatusBlocked = function (index) {
        $scope.shops[index].status = "blocked";
    };
    $scope.changeStatusActive = function (index) {
        $scope.shops[index].status = "active";
    };
    //$scope.deleteShop = function (index) {
    //    $scope.shops.splice(index, 1);
    //}
    $scope.deleteAlert = function(index){
        if(confirm('You want to delete shop: '+$scope.shops[index].firstName)){
            $http.get('/Practice/user/delete/'+$scope.shops[index].id);
            $http.get('/Practice/user/shop').then(function (response) {
                $scope.shops = response.data;})
        }

    };
    $scope.btnBlockName = "block";
    $scope.showMessage = function (status) {
        if (status == false)
            return "block"
        else
            return "unblock";
    }
    $scope.changeButtonName = function (index) {
        if ($scope.shops[index].status == 'blocked') {
            $scope.btnBlockName = 'unblock';
            $scope.shops[index].status = "active";
        }
        else {
            $scope.btnBlockName = 'block';
            $scope.shops[index].status = "blocked";
        }
    }
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
        if (status == "blocked")
            return {
                'adm-PR1': true
            }
        else
            return {
                'adm-PR1': false
            };
    }
}])
