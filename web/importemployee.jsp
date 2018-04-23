<%-- 
    Document   : importemployee
    Created on : Apr 15, 2018, 4:17:05 PM
    Author     : Afsar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
                <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular-sanitize.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-animate.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css" rel="stylesheet" />
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="cssFile/ADM-dateTimePicker.css" />
<script src="jsFile/ADM-dateTimePicker.min.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Import Employee</title>
    </head>
    <body>
        <h3>Import Employee</h3>
        <h6>{{msg}}</h6>
        <hr>
        <P>Please download sample file and upload...<a href="{{testdate}}">click here for download the file</a> </P>
        <form>
            <p>
                <input name="fileupload" type="file" class="btn btn-primary" file-model="fileupload"><br>
                <button ng-click="uploadFile()" class="btn btn-primary">Upload File</button>
            </p> 


        
        <br>
          
        {{fileData}}
        </form>
    </body>
</html>
