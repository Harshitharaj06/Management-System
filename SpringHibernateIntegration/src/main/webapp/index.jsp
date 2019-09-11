<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<title>Employee Management System</title>
</head>
<style>

.navigation-bar {
 height: 70px;
 width: 100%
 text-align:center;
}

ul {
 list-style-type: none;
 margin: 0;
 padding: 0;
 overflow: hidden;
 background-color: grey;
}

li {
 float:Left;
}

li a {
 display: block;
 color: Blue
 text-align: center;
 padding: 14px 16px;
 text-decoration: none;
}

li a:hover {
 background-color:Grey;
}

</style>
<body>
	 <div class="navigation-bar">
       <ul>
        <li><a href="addemp.jsp">Add Employees</a></li>
        <li><a href="getall.jsp">View All Employees</a></li>
        <li><a href="getemp.jsp">Get Employee</a></li>
        <li><a href="delete.jsp">Delete Employee</a></li>
        <li><a href="update.jsp">Update Employee</a></li>
      </ul>
    </div>
</body>
</html>