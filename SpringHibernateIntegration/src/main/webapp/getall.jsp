
<jsp:include page="index.jsp"/>
<%@page import="com.hbspring.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<style>
h1{
  color: blue;
  font-size: 300%;
  text-align:center
}
</style>
<h1>List Of Employees</h1><br><br><br>
<body>
<form action="employees">
<input type="Submit" value="submit">
</form>
<table border="2">
          <tr>
              <th>Employee ID</th>
              <th>Employee Name</th>
              <th>Age</th>
          </tr>
<c:forEach items="${emplist}" var="Employee">
<tr>
<td>${Employee.empId}</td>
<td>${Employee.empName}</td>
<td>${Employee.age}</td>
</tr>
</c:forEach>
</table>
</body>