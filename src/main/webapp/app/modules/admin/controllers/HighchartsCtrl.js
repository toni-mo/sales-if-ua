admin.controller('HighchartsCtrl', ['$scope', '$http','$routeParams', function ($scope, $http, $routeParams) {
    $scope.id = $routeParams.userId;
    $scope.role = $routeParams.role;
    $scope.checkbox1 = '';
    $scope.checkbox2 = '';
    $scope.checkbox3 = '';
    $scope.checkbox4 = '';
    $scope.date1 = '';
    $scope.date2 = '';
    $scope.getClientDate = '';
    $scope.getShopDate = '';
    $scope.getClientsDefault = function () {
        $scope.getClientDate = '/Practice/analytics/clients/after/' + (new Date().getTime() - 86400000*30);
        return $scope.getClientDate;
    };
    $scope.getShopsDefault = function () {
        $scope.getShopDate = '/Practice/analytics/shops/after/'+ + (new Date().getTime() - 86400000*30);
        return $scope.getShopDate;
    };
    $scope.getProfitDefault = function () {
        $scope.getProfitDate = '/Practice/analytics/profit/site/after/' + (new Date().getTime() - 86400000*30*6);
        return $scope.getProfitDate;
    };
    $scope.getClients = function () {
        var dateR = $scope.date2.getTime()+ 86400000;
        $scope.getClient = '/Practice/analytics/clients/range?from=' + $scope.date1.getTime() + '&to=' + dateR;
        return $scope.getClient;
    };
    $scope.getShops = function () {
        var dateR = $scope.date2.getTime()+ 86400000;
        $scope.getShop = '/Practice/analytics/shops/range?from=' + $scope.date1.getTime() + '&to=' + dateR;
        return $scope.getShop;
    };
    $scope.getProfit = function () {
        var dateR = $scope.date2.getTime()+ 86400000;
        $scope.getProfit = '/Practice/analytics/profit/site/range?from=' + $scope.date1.getTime() + '&to=' + dateR;
        return $scope.getProfit;
    };
    $scope.buildClientsChart = function (Clients ) {
        $http.get(Clients).then(function (response) {
            $scope.data = [];
            $scope.date = [];
            $scope.time = [];
            $scope.month = [];
            $scope.users = [];
            $scope.data = response.data;
            for (var i = 0; i < $scope.data.length; i++) {
                var time = $scope.data[i].date;
                var date = new Date(time);
                var month = date.getMonth() + 1;
                $scope.date[i] = date.getDate() + "/" + month + "/" + date.getFullYear();
                $scope.users[i] = $scope.data[i].userAmount;
            }
            $(function () {
                $('#Clients').highcharts({
                    chart: {
                        type: 'area',
                        zoomType: 'x'
                    },
                    title: {
                        text: 'Users statistics'
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
                            text: 'new members'
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
                        name: 'New Users',
                        data: $scope.users,
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
    $scope.buildShopsChart = function (Shops ) {
        $http.get(Shops).then(function (response) {
            $scope.data = [];
            $scope.date = [];
            $scope.time = [];
            $scope.month = [];
            $scope.users = [];
            $scope.data = response.data;
            for (var i = 0; i < $scope.data.length; i++) {
                var time = $scope.data[i].date;
                var date = new Date(time);
                var month = date.getMonth() + 1;
                $scope.date[i] = date.getDate() + "/" + month + "/" + date.getFullYear();
                $scope.users[i] = $scope.data[i].shopsAmount;
            }
            $(function () {
                $('#Shops').highcharts({
                    chart: {
                        type: 'area',
                        zoomType: 'x'
                    },
                    title: {
                        text: 'Shops statistics'
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
                            text: 'new members'
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
                        name: 'New Shops',
                        data: $scope.users,
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
    $scope.buildProfitChart = function (Profit ) {
        $http.get(Profit).then(function (response) {
            $scope.data = [];
            $scope.date = [];
            $scope.time = [];
            $scope.month = [];
            $scope.profit = [];
            $scope.data = response.data;
            for (var i = 0; i < $scope.data.length; i++) {
                var time = $scope.data[i].date;
                var date = new Date(time);
                var month = date.getMonth() + 1;
                $scope.date[i] = date.getDate() + "/" + month + "/" + date.getFullYear();
                $scope.profit[i] = $scope.data[i].profit;
            }
            $(function () {
                $('#Profit').highcharts({
                    chart: {
                        type: 'area',
                        zoomType: 'x'
                    },
                    title: {
                        text: 'Profit statistics'
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
            //Second chart witch shows money transactions
            //$(function () {
            //    $('#money-transactions').highcharts({
            //        chart: {
            //            zoomType: 'x'
            //        },
            //        title: {
            //            text: 'Money transactions'
            //        },
            //        subtitle: {
            //            text: document.ontouchstart === undefined ?
            //                'Click and drag in the plot area to zoom in' : 'Pinch the chart to zoom in'
            //        },
            //        xAxis: {
            //            categories: $scope.date
            //        },
            //        yAxis: {
            //            title: {
            //                text: 'Transactions rate'
            //            }
            //        },
            //        legend: {
            //            enabled: false
            //        },
            //        credits: {
            //            enabled: false
            //        },
            //        plotOptions: {
            //            area: {
            //                fillColor: {
            //                    linearGradient: {
            //                        x1: 0,
            //                        y1: 0,
            //                        x2: 0,
            //                        y2: 1
            //                    },
            //                    stops: [
            //                        [0, Highcharts.getOptions().colors[0]],
            //                        [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
            //                    ]
            //                },
            //                marker: {
            //                    radius: 2
            //                },
            //                lineWidth: 1,
            //                states: {
            //                    hover: {
            //                        lineWidth: 1
            //                    }
            //                },
            //                threshold: null
            //            }
            //        },
            //
            //        series: [{
            //            type: 'area',
            //            name: 'Summary amount',
            //            data: $scope.cost
            //        }]
            //    });
            //});
            //third hichchart
            //$(function () {
            //    $('#products').highcharts({
            //        chart: {
            //            zoomType: 'x'
            //        },
            //        title: {
            //            text: 'Products sold'
            //        },
            //        subtitle: {
            //            text: document.ontouchstart === undefined ?
            //                'Click and drag in the plot area to zoom in' : 'Pinch the chart to zoom in'
            //        },
            //        xAxis: {
            //            categories: $scope.date
            //        },
            //        yAxis: {
            //            title: {
            //                text: 'Sales rate'
            //            }
            //        },
            //        legend: {
            //            enabled: false
            //        },
            //        credits: {
            //            enabled: false
            //        },
            //        plotOptions: {
            //            area: {
            //                fillColor: {
            //                    linearGradient: {
            //                        x1: 0,
            //                        y1: 0,
            //                        x2: 0,
            //                        y2: 1
            //                    },
            //                    stops: [
            //                        [0, Highcharts.getOptions().colors[0]],
            //                        [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
            //                    ]
            //                },
            //                marker: {
            //                    radius: 2
            //                },
            //                lineWidth: 1,
            //                states: {
            //                    hover: {
            //                        lineWidth: 1
            //                    }
            //                },
            //                threshold: null
            //            }
            //        },
            //
            //        series: [{
            //            type: 'area',
            //            name: 'Summary amount',
            //            data: $scope.products
            //        }]
            //    });
            //});
        })

    };


}]);