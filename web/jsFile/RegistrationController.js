var helloAjaxApp = angular.module("myApp", []);
 
helloAjaxApp.controller("myCtrl", [ '$scope', '$http', function($scope, $http) {
        $scope.hotel={};
        $scope.eml_add = /^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/;

    $http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8";
     
    $scope.getAddress = function() {
        if($scope.hotel.pincode == null){
            $scope.message2 ="Please enter valid  pincode";
        }
        else{
            $scope.message2=null;
            $http({
            url : 'Test1',
            method : "POST",
            data : {
                'name' : $scope.hotel.pincode
            }
        }).then(function(response) {
            console.log(response.data);
            $scope.message = response.data;
        }, function(response) {
            //fail case
            console.log(response);
            $scope.message = response;
        });
           
        }
        
        
 
    };
    $scope.checkemail = function() {
        if($scope.hotel.hemail == null){
        $scope.message1="Pleses Valid enter email ID."
        
    }
    else{
        $http({
            url : 'EmailChecker',
            method : "POST",
            data : {
                'name' : $scope.hotel.hemail
            }
        }).then(function(response) {
            console.log(response.data);
            $scope.message1 = response.data;
        }, function(response) {
            //fail case
            console.log(response);
            $scope.message1 = response;
        });
    }
        
 
    };
    $scope.signup1 = function (){
        
            $http({
            url : 'Registration',
            method : "POST",
            datatype : 'JSON',
            data : {
                loadProds: 1,
               // hName : $scope.hotel,
                'hotelData' : $scope.hotel
            }
        }).then(function(response) {
            console.log(response.data);
            $scope.message = response.data;
        }, function(response) {
            //fail case
            console.log(response);
            $scope.message = response;
        });
    };
   $scope.$watch(function (){
       $('.fontsize').selectpicker('refresh');
   });
}]);