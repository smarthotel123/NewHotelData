<%-- 
    Document   : RoomAdd
    Created on : Apr 8, 2018, 7:01:09 PM
    Author     : Afsar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="myApp">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="input-group">
                        <h2>Room Add</h2>
                        <h4 style="color: {{datacolor}}">{{datasaveornot}}</h4>
                        </div>
        
    <div>
        <form name="roomForm">
        <table cellpadding="0" cellspacing="0" class="table table-hover">
            <tr class="info">
               
                <th class="text-center">Room Number</th>
                <th class="text-center">Room Type</th>
                <th class="text-center">Room Price</th>
                <th class="text-center">Bad count</th>
                <th class="text-center"></th>
            </tr>
            <tbody ng-repeat="m in Rooms">
                <tr >
                    
                    <td class="text-center">{{m.rNumber}}</td>
                    <td class="text-center">{{m.rType}}</td>
                    <td class="text-center">{{m.rPrice}}</td>
                    <td class="text-center">{{m.badCount}}</td>
                    <td class="text-center"><input class="btn btn-danger" type="button"  ng-click="Remove($index)" value="Remove" /></td>
                </tr>
            </tbody>
            <tfoot>
                <tr>
                    <td><input class="form-control" type="text" name="rNumber" ng-model="rNumber" ng-blur="rNumberCheck()" required/>
                  
                    <td><select  class="form-control"  ng-model="rType" name="rType" required>
                            <option>Delux</option>
                            <option>Simple</option>
                            <option>Hall</option>
                     </select></td>
                    <td class="input-group">

                        <span class="input-group-addon">$</span>
                        <input class="form-control" type="number"  placeholder="amount in rupees" name="rPrice" ng-model="rPrice" required />
                    </td>
                    <td >
                        <div class="input-group">
                        <span class="input-group-addon">Capacity</span>
                        <input class="form-control" placeholder="in number" type="number" min="0" name="badCount" ng-model="badCount" required />
                        </div>
            </td>
                    <td><input class="btn btn-info" type="button" ng-click="Add()" value="Add" ng-show="!error1" ng-disabled="roomForm.rNumber.$error.required || roomForm.rType.$error.required || roomForm.rPrice.$error.required || roomForm.badCount.$error.required"/></td>
                </tr>
                <tr ng-if="error1" class="text-center" >
                    <td colspan="5"> <p  style="color:red" >This <mark> {{Rooms[RoomsLength-1].rNumber}} </mark> room number is duplicate,Please remove any one room details for room number <mark>{{Rooms[RoomsLength-1].rNumber}}</mark> </p></td>
                </tr>
                <tr ng-if="roomerror" class="text-center">
                    <td colspan="5"> <p  style="color:red" >Please add atleast one room detilas</p></td>
                </tr>
                <tr ng-if="!error1">
                <td>
                    <span style="color:red" ng-show="roomForm.rNumber.$touched && roomForm.rNumber.$invalid">
<span ng-show="roomForm.rNumber.$error.required">Room Number is required.</span>
</span>
                </td>
                <td>
                    <span style="color:red" ng-show="roomForm.rType.$touched && roomForm.rType.$invalid">
<span ng-show="roomForm.rType.$error.required">Room Type is required.</span>
</span>
                </td>
                <td>
                    <span style="color:red" ng-show="roomForm.rPrice.$touched && roomForm.rPrice.$invalid">
<span ng-show="roomForm.rPrice.$error.required">Room Price is required.</span>
</span>
                </td>
                <td>
                    <span style="color:red" ng-show="roomForm.badCount.$touched && roomForm.badCount.$invalid">
<span ng-show="roomForm.badCount.$error.required">Bad Count is required.</span>
</span>
                </td>
               
                </tr>
                
            </tfoot>
        </table>
        </form>

<table ><tr ><td colspan="5"></td></tr></table>
<div class="text-center"><input class="btn btn-primary" ng-show="!error1" ng-click="saveRoom()" type="button" value="Save Room" /></div>
    </div>
        

    </body>
</html>
