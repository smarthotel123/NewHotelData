<%-- 
    Document   : Main
    Created on : Apr 1, 2018, 3:27:55 PM
    Author     : Afsar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css" rel="stylesheet" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
        <title>DashBoard</title>
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
        <nav class="navbar navbar-inverse">
             <div class="row" >
  <div class="col-lg-2">
    <div class="input-group">
      
    <h2 style="color: blue" ><%= session.getAttribute("empName") %>
            </h2>

    </div>
  </div>
            
  <div class="col-lg-4" style="text-align: left">
      <div class="input-group" >
        <h2 style="color: blue" >
            here clock
</h2>
    </div>
  </div>


             </div>
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="Main.jsp">Smart Hotel</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="Main.jsp">Home</a></li>
      <li><a href="Employee.jsp">Employee</a></li>
      <li><a href="Room.jsp">Room</a></li>
      <li><a href="#">Page 2</a></li>
      <li><a href="#">Page 3</a></li>
      
    </ul>
    <ul class="nav navbar-nav navbar-right">
        <li>
            <div class="navbar-header">
                <p class="navbar-text"><%= session.getAttribute("empName") %></p>
            </div>
        </li>
        <li></li>
        <li><a href="#"><span class="glyphicon glyphicon-cog"></span>Setting</a></li>
        <li><form action="Logout" method="post" class="form-inline">
                <button class="btn btn-danger navbar-btn" type="submit" value="Logout">Logout</button>
            </form></li>
            
      </ul>
  </div>
</nav>
    </div>
    </body>
</html>
