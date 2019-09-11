<jsp:include page="index.jsp"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
   <%--  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page import="java.util.List"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
h1{
  color: blue;
  font-size: 300%;
  text-align:center
}
</style>
<body>
<form action="employee">
EmployeeId:<input type="text" name="empId"><br>
<input type="submit" value="view">
</form>
<h1>The Details Are</h1>
<table border="2">
          <tr>
              <th>Employee ID</th>
              <th>Employee Name</th>
              <th>Age</th>
          </tr>
         <tr>
              <td>${emp.empId}</td>
              <td>${emp.empName}</td>
              <td>${emp.age}</td>
         </tr>
</table>
</body>
</html>