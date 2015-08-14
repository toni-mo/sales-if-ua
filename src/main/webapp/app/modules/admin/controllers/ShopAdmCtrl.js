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
    });
    $scope.getShopDefault = function () {
        $scope.getShop = '/Practice/analytics/sales/shop/'+ $scope.id+'/after/'+  (new Date().getTime() - 86400000*30);
        return $scope.getShop;
    };
    $scope.getShopD = function () {
        var dateR = $scope.date2.getTime()+ 86400000;
        $scope.getShop = '/Practice/analytics/sales/shop/'+$scope.id+'/range?from=' + $scope.date1.getTime() + '&to=' + dateR;
        console.log('get link',$scope.getShop);
        return $scope.getShop;
    };
    $scope.buildProductsChart = function (shopsData ) {
        $http.get(shopsData).then(function (response) {
            $scope.data = [];
            $scope.date = [];
            $scope.time = [];
            $scope.month = [];
            $scope.profit = [];
            $scope.soldProducts = [];
            $scope.data = response.data;
            for (var i = 0; i < $scope.data.length; i++) {
                var time = $scope.data[i].date;
                var date = new Date(time);
                var month = date.getMonth() + 1;
                $scope.date[i] = date.getDate() + "/" + month + "/" + date.getFullYear();
                $scope.soldProducts[i] = $scope.data[i].soldProducts;
                $scope.profit[i] = $scope.data[i].profit;
            }
            $(function () {
                $('#Products').highcharts({
                    chart: {
                        type: 'area',
                        zoomType: 'x'
                    },
                    title: {
                        text: 'Products/money'
                    },
                    legend: {
                        layout: 'vertical',
                        align: 'left',
                        verticalAlign: 'top',
                        x: 150,
                        y: 100,
                        floating: true,
                        borderWidth: 1,
                        backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
                    },
                    xAxis: {
                        categories: $scope.date
                    },
                    yAxis: {
                        title: {
                            text: 'products sold'
                        }
                    },
                    tooltip: {
                        shared: true,
                        valueSuffix: ''
                    },
                    credits: {
                        enabled: false
                    },
                    plotOptions: {
                        areaspline: {
                            fillOpacity: 0.5
                        }
                    },
                    series: [{
                        name: 'Products sold',
                        data: $scope.soldProducts,
                        //Chart line width
                        lineWidth: 1,
                        //Points selection
                        allowPointSelect: true
                    }
                    ]
                });
            });
            //Profit chart
            $(function () {
                $('#Profit').highcharts({
                    chart: {
                        type: 'area',
                        zoomType: 'x'
                    },
                    title: {
                        text: 'Profit'
                    },
                    legend: {
                        layout: 'vertical',
                        align: 'left',
                        verticalAlign: 'top',
                        x: 150,
                        y: 100,
                        floating: true,
                        borderWidth: 1,
                        backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
                    },
                    xAxis: {
                        categories: $scope.date
                    },
                    yAxis: {
                        title: {
                            text: 'money received'
                        }
                    },
                    tooltip: {
                        shared: true,
                        valueSuffix: ''
                    },
                    credits: {
                        enabled: false
                    },
                    plotOptions: {
                        areaspline: {
                            fillOpacity: 0.5
                        }
                    },
                    series: [{
                        name: 'Money received',
                        data: $scope.profit,
                        //Chart line width
                        lineWidth: 1,
                        //Points selection
                        allowPointSelect: true
                    }
                    ]
                });
            });

        })
    };
}]);