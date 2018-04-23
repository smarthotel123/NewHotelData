var app = angular.module("myApp", ["ngRoute","ADM-dateTimePicker","ngSanitize"]);
app.config(function($routeProvider) {
    
    $routeProvider
    .when("/", {
        templateUrl : "RoomView.jsp",
        controller : "RoomViewCtrl"
    })
    .when("/RoomView", {
        templateUrl : "RoomView.jsp",
        controller : "RoomViewCtrl"
    })
    .when("/RoomAdd", {
        templateUrl : "RoomAdd.jsp",
        controller : "RoomAddCtrl"
    });
});
app.controller("RoomViewCtrl",[ '$scope', '$http','$window', function($scope, $http,$window) {
    $scope.msg = "I love London";
    
}]);
app.controller('RoomAddCtrl',[ '$scope', '$http','$window', function($scope, $http,$window) {
            $scope.Rooms = [
          
                ];
                
   
                 $scope.rNumberCheck = function(){
    
    //$scope.error1=true;
    var i=$scope.Rooms.length;
    
    $scope.l=i;
    for(j=1;j<=i;j++){
      
        $scope.re=$scope.Rooms[j-1].rNumber;
      
        }
        for(j=1;j<i;j++){
            if($scope.Rooms[j-1].rNumber==$scope.re){
                
                $scope.error1=true;
                $scope.ll=j;
              
              
            }
    }
    
  };
            $scope.saveRoom = function (){
                if($scope.Rooms.length<1){
                        $scope.roomerror=true;
                  }
                else{
                 $scope.roomerror=false;  
                 var i=$scope.Rooms.length;
    
                        $scope.l=i;
                        for(j=1;j<=i;j++){
      
                         $scope.re=$scope.Rooms[j-1].rNumber;
      
                         }
                         for(j=1;j<i;j++){
                          if($scope.Rooms[j-1].rNumber==$scope.re){
                
                        $scope.error1=true;
                        $scope.ll=j;
                          }
                      }
                }
                if(!$scope.error1==true && $scope.roomerror==false){
                    $scope.checktest="hhhhhhhhhhh";
                    console.log($scope.Rooms);
                    $http({
                            url : 'Rooms?action=save',
                            method : "POST",
                            data : {
                                'roomsavedata' : $scope.Rooms
                            }
                        }).then(function(response) {
                            console.log(response.data);
                            $scope.saveloading=false;
                            $scope.datasaveornot = response.data;
                            if($scope.datasaveornot=="Saved"){
                                $scope.Rooms=[];
                                $scope.datacolor="green";
                            }
                            else{
                                $scope.datacolor="red";
                            }

                        }, function(response) {
                            //fail case
                            console.log(response);
                            $scope.datasaveornot = response;
                        });
                }
        
            };
            $scope.Add = function () {

                $scope.roomerror=false;
                //Add the new item to the Array.
                var customer = {};
                customer.rNumber = $scope.rNumber;
                customer.rType = $scope.rType;
                customer.rPrice = $scope.rPrice;
                customer.badCount = $scope.badCount;
               
                $scope.Rooms.push(customer);
 
                //Clear the TextBoxes.
                $scope.rNumber = "";
                $scope.rType = "";
                $scope.rPrice = "";
                $scope.badCount = "";
                $scope.RoomsLength=$scope.Rooms.length;
                //$scope.countroom=$scope.Rooms.length;
            };
            
 
            $scope.Remove = function (index) {
                $scope.error1=false;
                //Find the record using Index from Array.
                var rNumber1 = $scope.Rooms[index].rNumber;
                if ($window.confirm("Do you want to delete: " + rNumber1)) {
                    //Remove the item from Array using Index.
                    $scope.Rooms.splice(index, 1);
                     $scope.RoomsLength=$scope.Rooms.length;
                }
            }
        }]);