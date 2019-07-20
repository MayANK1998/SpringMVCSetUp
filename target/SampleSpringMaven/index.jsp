<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <style>
        table, td, th {
            border: 1px solid black;
        }

        table {
            border-collapse: collapse;
            width: 50%;
        }

        th {
            text-align: left;
        }

    </style>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<a href="#data" class="btn btn-info" data-toggle="collapse" onclick="putEmployeeData()">Simple collapsible</a>
<div id="data" class="collapse"></div>
<a href="#employeedetails" class="btn btn-info" data-toggle="collapse" >Get Employee detail</a>
<div id="employeedetails" class="collapse">
    <p>put employee id</p>
    <input type="number" name="empid" ><br>
    <input type="submit" value="Submit" onclick="getEmployeeDetail()">


</div>
<div id="data1" class="collapse"></div>
</body>
<script>
    function createTable(data, divloc) {
        var col = [];
        for (var i = 0; i < data.length; i++) {
            for (var key in data[i]) {
                if (col.indexOf(key) === -1) {
                    col.push(key);
                }
            }
        }
        var table = document.createElement("table");

        // CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.

        var tr = table.insertRow(-1);                   // TABLE ROW.

        for (var i = 0; i < col.length; i++) {
            var th = document.createElement("th");      // TABLE HEADER.
            th.innerHTML = col[i];
            tr.appendChild(th);
        }

        // ADD JSON DATA TO THE TABLE AS ROWS.
        for (var i = 0; i < data.length; i++) {

            tr = table.insertRow(-1);

            for (var j = 0; j < col.length; j++) {
                var tabCell = tr.insertCell(-1);
                tabCell.innerHTML = data[i][col[j]];
            }
        }

        // FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
        var divContainer = document.getElementById(divloc);
        divContainer.innerHTML = "";
        divContainer.appendChild(table);
    }

    function putEmployeeData() {
        fetch("http://localhost:9080/springmvcexample_war_exploded/employee-module/getAllEmployees").then(function (response) {


            return response.json();

        }).then(function (data) {

            createTable(data, "data");

        }).catch(function () {
            console.log("Booo");
        });
    }
    function getEmployeeDetail() {

        var empid = document.getElementsByName("empid");
        empid=1;
        fetch("http://localhost:9080/springmvcexample_war_exploded/employee-module/getEmployees?empid="+empid.toString()).then(function (response) {

            console.log("ffd","http://localhost:9080/springmvcexample_war_exploded/employee-module/getAllEmployees?empid="+empid);
            return response.json();

        }).then(function (data) {

            document.getElementById("employeedetails").innerText=JSON.stringify(data);

        }).catch(function () {
            console.log("Booo");
        });
    }
</script>
</html>
