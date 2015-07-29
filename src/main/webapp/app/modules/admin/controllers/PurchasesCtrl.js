admin.controller( 'PurchasesCtrl', ['$scope','$http',function ( $scope,$http) {
      $http.get('modules/admin/json/purchases.json').then(function(response){
      $scope.purch = response.data;
      });
      $scope.deletePurchases = function(){
      $scope.purchases.splice(0,$scope.purchases.length);
      };
      }])
      // disable zoom
      // $(document).ready(function () {
      // $(document).keydown(function (event) {
      //       if (event.ctrlKey == true && (event.which == '107' || event.which == '109' || event.which == '187' || event.which == '189'))
      //       {
      //       event.preventDefault();
      //       }
      //       });
      //       $(window).bind('mousewheel DOMMouseScroll', function (event) {
      //       if (event.ctrlKey == true) {
      //       event.preventDefault();
      //       }
      //  });
// })