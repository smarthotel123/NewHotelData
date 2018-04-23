<%-- 
    Document   : Employee
    Created on : Apr 1, 2018, 5:11:43 PM
    Author     : Afsar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="myApp">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular-route.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-animate.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular.js"></script>
        <script type="text/javascript" src="jsFile/EmployeeController.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular-sanitize.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css" rel="stylesheet" />
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-animate.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-sanitize.js"></script>
    <script src="jsFile/ui-bootstrap-tpls-2.5.0.min.js"></script>
    
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="cssFile/ADM-dateTimePicker.css" />
<script src="jsFile/ADM-dateTimePicker.min.js"></script>
<script>
function startTime() {
    var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('txt').innerHTML =
    h + ":" + m + ":" + s;
    var t = setTimeout(startTime, 500);
}
function checkTime(i) {
    if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
    return i;
}
</script>
        <title>Employee</title>
    </head>
    <body>
           <% 
            String status=(String)session.getAttribute("LoginStatus");
            //int empID=(int)session.getAttribute("empID");
            //session.getAttribute("LoginStatus");
            if(status==null){
                
                response.sendRedirect("Login.jsp");
            
            }
           // else{response.sendRedirect("Login.jsp");}
        
        
        %>
        <div>
            
            <div ng-include="'Main.jsp'"></div>
            
            <div style="text-align: right">
                <a href="#!EmployeeView" class="btn btn-warning" role="button">View all Employee</a>
                <a href="#!emplyeecreate" class="btn btn-warning" role="button">Create Employee</a>
                <a href="#!emplyeeimport" class="btn btn-warning" role="button">Import Employee</a>
                
            </div>
            <div>
            

        <div ng-view></div>
            </div>
             </div>
        
        
        
    </body>
</html>
