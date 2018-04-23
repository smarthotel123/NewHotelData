<%-- 
    Document   : EmployeeView
    Created on : Apr 2, 2018, 12:24:01 PM
    Author     : Afsar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" />
<link href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css" rel="stylesheet" />
<script>
$(document).ready(function() {
    $('#example').DataTable();
} );
</script>
        <title>Employee View</title>
    </head>
    <body>
        <h1>Employee</h1>
        
        <table id="example" class="table table-striped table-bordered" style="width:100%">
        <thead>
            <tr>
                <th>Employee Name</th>
                <th>empNo</th>
                <th>System empID</th>
                <th>empPhone</th>
                <th>Status</th>
                <th>pincode</th>
            </tr>
        </thead>
        <tbody>
            <tr ng-repeat="x in employee">
                <td>{{x.empName}}</td>
                <td>{{x.empNo}}</td>
                <td>{{x.empID}}</td>
                <td>{{x.empPhone}}</td>
                <td>{{x.status}}</td>
                <td>{{x.pincode}}</td>
            </tr>

        </tbody>
        <tfoot>
            <tr>
                <th>Employee Name</th>
                <th>empNo</th>
                <th>System empID</th>
                <th>empPhone</th>
                <th>Status</th>
                <th>pincode</th>
            </tr>
        </tfoot>
    </table>
    </body>
</html>
