var app = angular.module("myApp", ["ngRoute","ADM-dateTimePicker", "ngSanitize", "ui.bootstrap"]);
app.config(function($routeProvider) {
    
    $routeProvider
    .when("/", {
        templateUrl : "EmployeeView.jsp",
        controller : "EmployeeViewCtrl"
    })
    .when("/EmployeeView", {
        templateUrl : "EmployeeView.jsp",
        controller : "EmployeeViewCtrl"
    })
    .when("/emplyeecreate", {
        templateUrl : "EmployeeCreate.jsp",
        controller : "EmployeeCreateCtrl"
    }).when("/emplyeeimport", {
        templateUrl : "importemployee.jsp",
        controller : "EmployeeImportCtrl"
    });
});
app.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            
            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);
app.service('fileUpload', ['$http', function ($http) {
    this.uploadFileToUrl = function(file, uploadUrl){
        var fd = new FormData();
        fd.append('file', file);
        return $http.post(uploadUrl, fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        });
    };
}]);
app.controller('EmployeeImportCtrl',function($scope,$http,fileUpload){
    $scope.testdate="Employee?action=demodownload";
$scope.uploadFile = function(){
            var file = $scope.fileupload;
          
            var uploadUrl = "DownloadServlet";
            fileUpload.uploadFileToUrl(file, uploadUrl)
            .then(function(response) {
                console.log(response) ;
                $scope.fileData= response.data;
                })
            
         };
});
app.controller("EmployeeImportCtrl1",[ '$scope', '$http','$window', function($scope, $http,$window,fileUpload){
        $scope.msg="Please read the import note befor upload file";
        $scope.uploadFile = function(){
            var file = $scope.fileupload;
          
            var uploadUrl = "Employee?action=import";
            fileUpload.uploadFileToUrl(file, uploadUrl)
            .then(function(response) {
                console.log(response) ;
                $scope.fileData= response.data;
                });
            
         };
        
}]);
app.controller("EmployeeViewCtrl",[ '$scope', '$http','$window', function($scope, $http,$window) {
    $scope.msg = "I love London";
    $scope.employee=[];
    $http({
            url : 'Employee?action=all',
            method : "POST",
        }).then(function(response) {
            console.log(response.data);
            $scope.employee = response.data;
        }, function(response) {
            //fail case
            console.log(response);
            $scope.employeeerror = response;
        });
     $scope.$watch(function() {
    $('.fontsize').selectpicker('refresh');
});
}]);
app.controller("EmployeeCreateCtrl",[ '$scope', '$http','$window', function($scope, $http,$window) {
          
        $scope.phoneNumbr = /^\+?\d{2}?\d{3}?\d{5}$/;
        $scope.pinNumbrpattern= /^\+?\d{2}?\d{4}$/;
        $scope.showerror=true;
        //$scope.employee.loginaccess=false;
        $scope.$watch(function() {
    $('.fontsize').selectpicker('refresh');
});
        $scope.datavalidate=true;
         $http({
            url : 'EmployeeRoleControler',
            method : "POST",
        }).then(function(response) {
            console.log(response.data);
            $scope.RoleData = response.data;
        }, function(response) {
            //fail case
            console.log(response);
            $scope.ROleDataError = response;
        });
        
    $scope.msg = "I love My app";
    $scope.employee={};
    
    $scope.employee.loginaccess=false;
     $scope.$watch(function() {
    $('.fontsize').selectpicker('refresh');
});
    $scope.eml_add = /^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/;
    $scope.formref = function (){
        $scope.showerror=true;
    };
    $scope.checkemail = function() {
        if($scope.employee.empEmail == null){
        $scope.message1="Pleses Valid enter email ID.";
        
    }
    else{
        $scope.sava1desabel=true;
        $scope.message1="";
        $http({
            url : 'EmailChecker',
            method : "POST",
            data : {
                'name' : $scope.employee.empEmail
            }
        }).then(function(response) {
            console.log(response.data);
            $scope.message1 = response.data;
            if($scope.message1==="Fine"){
                $scope.sava1desabel=false;
            }
            
        }, function(response) {
            //fail case
            console.log(response);
            $scope.message1 = response;
        });
    }
        
 
    };
    
    $scope.getAddress = function (){
        if($scope.employee.indainornot==true){
            $scope.pindata=$scope.employee.pincode;
            $scope.msgggg="Hello";
            $http({
            url : 'Test1',
            method : "POST",
            data : {
                'name' : $scope.employee.pincode
            }
        }).then(function(response) {
            console.log(response.data);
            $scope.addaressdata = response.data;
            $scope.stateautodata = $scope.addaressdata.state;
            $scope.districtautodata = $scope.addaressdata.district;
            $scope.cityautodata = $scope.addaressdata.city;
            $scope.areaNameautodata = $scope.addaressdata.areaName;
        }, function(response) {
            //fail case
            console.log(response);
            $scope.addaressdata = response;
        });
        }
        
    };
     
        $scope.checkdata=function (){
             if($scope[form.firstName].$valid){
                 
            $scope.datavalidate=false;
        }
        else{
            $scope.validatemasage="please enter first name";
        }
        };
       
     $scope.addemp = function (){
            //$scope.pindata=$scope.employee.pincode;
            //$scope.msgggg="Hello";
            $scope.data=$scope.employee;
            $scope.employee={};
            $scope.showerror=false;
            $scope.saveloading=true;
            $http({
            url : 'Employee?action=save',
            method : "POST",
            data : {
                'employeesavedata' : $scope.data
            }
        }).then(function(response) {
            console.log(response.data);
            $scope.saveloading=false;
            $scope.datasaveornot = response.data;
            
            if($scope.datasaveornot=="Status1"){
                $window.location.href = "Employee.jsp"
                
            }
         
            
        }, function(response) {
            //fail case
            console.log(response);
            $scope.datasaveornot = response;
        });
       
        
    };

    
}]);
