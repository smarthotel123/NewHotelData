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
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css" rel="stylesheet" />
<script type="text/javascript" src="jsFile/RoomController.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular-sanitize.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css" rel="stylesheet" />
<link rel="stylesheet" href="cssFile/ADM-dateTimePicker.css" />
<script src="jsFile/ADM-dateTimePicker.min.js"></script>
        <title>Room</title>
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
                <a href="#!RoomView" class="btn btn-warning" role="button">View all Rooms</a>
                <a href="#!RoomAdd" class="btn btn-warning" role="button">Add Room</a>
                <button type="button" class="btn btn-warning">Import Rooms</button>
            </div>
            <div>
            

        <div ng-view></div>
            </div>
             </div>
        
        
        
    </body>
</html>
