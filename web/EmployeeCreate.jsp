<%-- 
    Document   : EmployeeSave
    Created on : Apr 1, 2018, 11:17:25 PM
    Author     : Afsar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular-sanitize.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-animate.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css" rel="stylesheet" />
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="cssFile/ADM-dateTimePicker.css" />
<script src="jsFile/ADM-dateTimePicker.min.js"></script>

</style>
        <title>Employee create</title>
    </head>
    <body>
        
        <br><div class="container">
            <div class="row">
        <div class="col-md-6" style="text-align: center" ng-show="saveloading">
            <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<div>please wait....</div>
<div class="container">
	<div class="row">
		<div id="loader">
    		<div class="dot"></div>
			<div class="dot"></div>
			<div class="dot"></div>
			<div class="dot"></div>
			<div class="dot"></div>
			<div class="dot"></div>
			<div class="dot"></div>
			<div class="dot"></div>
			<div class="lading"></div>
		</div>
	</div>
</div>
<style>
    #loader {
    bottom: 0;
    height: 175px;
    left: 0;
    margin: auto;
    position: absolute;
    right: 0;
    top: 0;
    width: 175px;
}
#loader {
    bottom: 0;
    height: 175px;
    left: 0;
    margin: auto;
    position: absolute;
    right: 0;
    top: 0;
    width: 175px;
}
#loader .dot {
    bottom: 0;
    height: 100%;
    left: 0;
    margin: auto;
    position: absolute;
    right: 0;
    top: 0;
    width: 87.5px;
}
#loader .dot::before {
    border-radius: 100%;
    content: "";
    height: 87.5px;
    left: 0;
    position: absolute;
    right: 0;
    top: 0;
    transform: scale(0);
    width: 87.5px;
}
#loader .dot:nth-child(7n+1) {
    transform: rotate(45deg);
}
#loader .dot:nth-child(7n+1)::before {
    animation: 0.8s linear 0.1s normal none infinite running load;
    background: #00ff80 none repeat scroll 0 0;
}
#loader .dot:nth-child(7n+2) {
    transform: rotate(90deg);
}
#loader .dot:nth-child(7n+2)::before {
    animation: 0.8s linear 0.2s normal none infinite running load;
    background: #00ffea none repeat scroll 0 0;
}
#loader .dot:nth-child(7n+3) {
    transform: rotate(135deg);
}
#loader .dot:nth-child(7n+3)::before {
    animation: 0.8s linear 0.3s normal none infinite running load;
    background: #00aaff none repeat scroll 0 0;
}
#loader .dot:nth-child(7n+4) {
    transform: rotate(180deg);
}
#loader .dot:nth-child(7n+4)::before {
    animation: 0.8s linear 0.4s normal none infinite running load;
    background: #0040ff none repeat scroll 0 0;
}
#loader .dot:nth-child(7n+5) {
    transform: rotate(225deg);
}
#loader .dot:nth-child(7n+5)::before {
    animation: 0.8s linear 0.5s normal none infinite running load;
    background: #2a00ff none repeat scroll 0 0;
}
#loader .dot:nth-child(7n+6) {
    transform: rotate(270deg);
}
#loader .dot:nth-child(7n+6)::before {
    animation: 0.8s linear 0.6s normal none infinite running load;
    background: #9500ff none repeat scroll 0 0;
}
#loader .dot:nth-child(7n+7) {
    transform: rotate(315deg);
}
#loader .dot:nth-child(7n+7)::before {
    animation: 0.8s linear 0.7s normal none infinite running load;
    background: magenta none repeat scroll 0 0;
}
#loader .dot:nth-child(7n+8) {
    transform: rotate(360deg);
}
#loader .dot:nth-child(7n+8)::before {
    animation: 0.8s linear 0.8s normal none infinite running load;
    background: #ff0095 none repeat scroll 0 0;
}
#loader .lading {
    background-image: url("../images/loading.gif");
    background-position: 50% 50%;
    background-repeat: no-repeat;
    bottom: -40px;
    height: 20px;
    left: 0;
    position: absolute;
    right: 0;
    width: 180px;
}
@keyframes load {
100% {
    opacity: 0;
    transform: scale(1);
}
}
@keyframes load {
100% {
    opacity: 0;
    transform: scale(1);
}
}

</style>
        </div>
            </div>
        </div>
        <div class="container" ng-show="!saveloading">
<div class="row">
<div class="col-sm-8 col-sm-offset-2">

<div class="panel panel-default">
<div class="panel-heading">
    <div class="panel-title">Employee Create <span style="color: green">{{datasaveornot}}</span></div>
</div>
<div class="panel-body">
         <form name="employeeForm" id="employeeForm" method="post" class="form-horizontal" >
<div class="form-group">
<label class="col-sm-4 control-label" for="firstName">Employee First name</label>
<div class="col-sm-5">
    <input type="text" class="form-control" id="firstName" ng-model="employee.firstName" name="firstName" placeholder="Employee First name" ng-blur="formref()" required />
</div>
<span ng-if="showerror" style="color: red" ng-show="employeeForm.firstName.$touched && employeeForm.firstName.$invalid">The name is required.</span>

</div>
<div class="form-group">
<label class="col-sm-4 control-label" for="lastName">Employee Last name</label>
<div class="col-sm-5">
<input type="text" class="form-control"  id="lastName" name="lastName" ng-model="employee.lastName" placeholder="Employee Last name" required/>
</div>
<span ng-if="showerror" style="color: red" ng-show="employeeForm.lastName.$touched && employeeForm.lastName.$invalid">The name is required.</span>
</div>
             <div class="form-group">
<label class="col-sm-4 control-label" for="lastName">Employee Code</label>
<div class="col-sm-5">
<input type="text" class="form-control"  id="empNo" name="empNo" ng-model="employee.empNo" placeholder="Employee Code"/>
</div>
</div>
<div class="form-group">
<label class="col-sm-4 control-label" for="empPhone">Employee Phone Number</label>
<div class="col-sm-5">
<input type="text" class="form-control" id="empPhone" name="empPhone" ng-pattern="phoneNumbr" ng-model="employee.empPhone" placeholder="Employee Phone Number" ng-minlength="10" ng-maxlength="10" required/>
<span id="spnPhoneStatus"></span>
</div>
<span class="error" style="color: red" ng-show="employeeForm.empPhone.$touched &&employeeForm.empPhone.$error.required">Required!</span>
      
      
      <span class="error" style="color: red" ng-show="employeeForm.empPhone.$error.maxlength || employeeForm.empPhone.$error.minlength || employeeForm.empPhone.$error.pattern">Please enter correct mobile number</span>

</div>
<div class="form-group">
<label class="col-sm-4 control-label" for="oPhone">Create Web Login</label>
<div class="col-sm-5">
    <input class="form-check-input" type="checkbox" ng-model="employee.loginaccess" id="gridCheck">

</div>
</div>
             

             <div class="form-group" ng-show="employee.loginaccess">
            <label class="col-sm-4 control-label" for="empEmail">Email</label>
<div class="col-sm-5">
    <input type="text" class="form-control" id="empEmail" name="empEmail" placeholder="Email" ng-model="employee.empEmail" ng-blur="checkemail()" ng-pattern="eml_add" required/>

</div>

<span ng-if="showerror"  style="color: red" ng-show="employeeForm.empEmail.$touched && employeeForm.empEmail.$invalid">This field is required.</span>

<p ng-if="showerror" style="color: red">{{message1}}</p>


</div>
             
             <div class="form-group">
              <label for="hState" class="col-sm-4 control-label">Role</label>
              <div class="col-sm-5">
                  <select class="form-control fontsize" name="role" id="repeatSelect" ng-model="employee.role" required>
                        <option ng-repeat="role in RoleData" value="{{role.roleId}}">{{role.roleName}}</option>
                    </select>
                  <span ng-if="showerror" style="color: red" ng-show="employeeForm.role.$touched && employeeForm.role.$invalid">The roe is required.</span>

              </div>
            </div>
              <div class="form-group">
              <label for="hState" class="col-sm-4 control-label">Joining Date</label>
              <div class="col-sm-5">
                  <adm-dtp ng-model='employee.joindate' options='{calType: "gregorian", format: "YYYY/MM/DD hh:mm", default: "today" }'></adm-dtp>
              </div>
            </div>
             
<div class="form-group">
<label class="col-sm-4 control-label" for="indainornot">Employee Indian or not</label>
<div class="col-sm-5">
    <input class="form-check-input" type="checkbox" ng-model="employee.indainornot" id="gridCheck">

</div>


</div>            
             
         <div class="form-group">
<label class="col-sm-4 control-label" for="lastName">Pincode or Zipcode</label>
<div class="col-sm-5">
    <input type="text" class="form-control"  id="pincode" ng-pattern="pinNumbrpattern" name="pincode" ng-blur="getAddress()" ng-model="employee.pincode" placeholder="Pincode or Zipcode" required/>
</div>
<span ng-if="showerror"  style="color: red" ng-show="employeeForm.pincode.$touched && employeeForm.pincode.$invalid">Please enter valid pincode.</span>
</div>  
 
             <div class="form-group">
<label class="col-sm-4 control-label" for="lastName">Country</label>
<div class="col-sm-5">
<input type="text" class="form-control"  id="country" name="country" ng-model="employee.country" placeholder="country" required/>
</div>
<span ng-if="showerror"  style="color: red" ng-show="employeeForm.country.$touched && employeeForm.country.$invalid">This field is required.</span>
</div> 
             
         
             
             
             
       
             <div class="form-group">
<label class="col-sm-4 control-label" for="lastName">State</label>
<div class="col-sm-5">
  <input type="text" name="state" id="state" ng-model="employee.state" 
         uib-typeahead="stateautodata1 for stateautodata1 in stateautodata | filter:$viewValue | limitTo:8" class="form-control" />
            </div>
</div> 
             
    <div class="form-group">
    
    <label class="col-sm-4 control-label" for="lastName">district</label>
        <div class="col-sm-5">
            <input type="text" name="district" id="district" ng-model="employee.district" uib-typeahead="districtautodata1 for districtautodata1 in districtautodata | filter:$viewValue | limitTo:8" class="form-control" />
    </div>
    </div> 
       <div class="form-group">
    
    <label class="col-sm-4 control-label" for="lastName">city</label>
        <div class="col-sm-5">
            <input type="text" name="city" id="city" ng-model="employee.city" uib-typeahead="cityautodata1 for cityautodata1 in cityautodata | filter:$viewValue | limitTo:8" class="form-control" />
            
    </div>
    
</div> 
             
             
          <div class="form-group">
<label class="col-sm-4 control-label" for="lastName">AreaName or Village</label>
<div class="col-sm-5">
  <input type="text" name="areaName" id="areaName" ng-model="employee.areaName" uib-typeahead="areaNameautodata1 for areaNameautodata1 in areaNameautodata | filter:$viewValue | limitTo:8" class="form-control" required />
            </div><span ng-if="showerror"  style="color: red" ng-show="employeeForm.areaName.$touched && employeeForm.areaName.$invalid">This field is required.</span>

<span ng-if="showerror"  style="color: red" ng-show="employeeForm.areaName.$touched && employeeForm.areaName.$invalid">This field is required.</span>
</div>    
            


             <div class="form-group">
<label class="col-sm-4 control-label" for="lastName">Address</label>
<div class="col-sm-5">
<input type="text" class="form-control"  id="address" name="address" ng-model="employee.address" placeholder="Address"/>
</div>
</div>



             
            
             
<div class="form-group">
<div class="col-sm-9 col-sm-offset-4">
    <button type="submit"  ng-show="employee.loginaccess" class="btn btn-primary" 
            ng-disabled="employeeForm.areaName.$invalid ||
                employeeForm.country.$invalid ||
                employeeForm.empPhone.$invalid &&  employeeForm.empPhone.$dirty  ||
                employeeForm.firstName.$invalid ||
                employeeForm.lastName.$invalid ||
                employeeForm.role.$invalid ||
                employeeForm.pincode.$invalid ||
                 employeeForm.empEmail.$invalid ||
                  sava1desabel
                
            "  
            name="signup1" ng-click="addemp()" value="Sign up">Save</button>
    
    
    <button type="submit" ng-show="!employee.loginaccess" class="btn btn-primary"   
            name="signup1" ng-click="addemp()" 
            ng-disabled="employeeForm.areaName.$invalid ||
                employeeForm.country.$invalid ||
                employeeForm.empPhone.$invalid &&  employeeForm.empPhone.$dirty  ||
                employeeForm.firstName.$invalid ||
                employeeForm.lastName.$invalid ||
                employeeForm.role.$invalid ||
                employeeForm.pincode.$invalid 
                
            " 
            value="Sign up">Save</button>
    
    
</div>
</div>
            
</form>
</div>
</div>
</div>
</div>
</div>
</body>
</html>
