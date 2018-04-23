 var app = angular.module('myApp', []);
app.controller('loginctrl', function($scope, $http,$window) {
    $scope.loginData={};
    $scope.login1 = function (){
        $http({
            url : 'Login',
            method : "POST",
            headers: {'Content-Type': 'application/json'},
            data : {
                'loginData' : $scope.loginData
            }
        }).then(function(response) {
            console.log(response.data);
            //alert("SUCCESS! Data: " + data);
            $scope.message = response.data;
            
            if($scope.message=="success"){
                $window.location.href = "Main.jsp"
                
            }
        }, function(response) {
            //fail case
            console.log(response);
            $scope.message = response;
        });
    };
});

