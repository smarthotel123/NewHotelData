<%-- 
    Document   : navmenu
    Created on : Apr 1, 2018, 9:57:31 PM
    Author     : Afsar
--%>
<html ng-app="clock">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css" rel="stylesheet" />
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>
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
<!DOCTYPE html>
<body onload="startTime()">
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
            <%= (new java.util.Date()).toLocaleString()%>
</h2>
    </div>
  </div>

<div class="col-lg-6" style="text-align: left">
      <div class="input-group" >
        <h2 style="color: blue" >
           <div id="txt"></div>
</h2>
    </div>
  </div>
</div>
</body>
</html>            