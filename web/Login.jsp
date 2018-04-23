
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>

        <script type="text/javascript" src="jsFile/LoginController.js"></script>
        <title>Login</title>
    </head>
    <body ng-app="myApp" ng-controller="loginctrl">
        <% 
            String status=(String)session.getAttribute("LoginStatus");
            //session.getAttribute("LoginStatus");
            if(status=="success"){
                
                response.sendRedirect("Main.jsp");
            
            }
           // else{response.sendRedirect("Login.jsp");}
        
        
        %>
        
    <div class="container">    
        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
            <div class="panel panel-info" >
                    <div class="panel-heading">
                        <div class="panel-title">Sign In </div>
                        <div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#">Forgot password?</a></div>
                    </div>     

                    <div style="padding-top:30px" class="panel-body" >

                        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
                            
                        <form  name="loginForm" class="form-horizontal" ng-submit="login1()">
                                    
                            <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                        <input id="login-username" type="text" ng-model="loginData.username" class="form-control" name="username" value="" placeholder="username or email" required>                                        
                                        <span  style="color: red" ng-show="loginForm.username.$touched && loginForm.username.$invalid">Password is required.</span>
                                    </div>
                                
                            <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                        <input id="login-password" type="password" ng-model="loginData.password" class="form-control" name="password" placeholder="password" required>
                                        <span  style="color: red" ng-show="loginForm.password.$touched && loginForm.password.$invalid">Password is required.</span>
                                    
                                    </div>
                                    

                                
                            <div class="input-group">
                                      <div class="checkbox">
                                        <label>
                                          <input id="login-remember" type="checkbox" name="remember" value="1"> Remember me
                                        </label>
                                      </div>
                                    </div>


                                <div style="margin-top:10px" class="form-group">
                                    <!-- Button -->

                                    <div class="col-sm-12 controls">
                                        <span><button id="btn-login" ng-click="login()" class="btn btn-success">Login  </button>
                                        
                                            <span style="color: red">{{message}}</span>
                                            
                                                
                                        </span>
                                      

                                    </div>
                                </div>


                                <div class="form-group">
                                    <div class="col-md-12 control">
                                        <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                            Don't have an account! 
                                            <a href="Registration.html">
                                            Registration free for 30 day Here
                                        </a>
                                        </div>
                                    </div>
                                </div>    
                            </form>     
<form name="myForm">

</form>




                        </div>                     
                    </div>  
        </div>
         
    </div>
    
</html>
