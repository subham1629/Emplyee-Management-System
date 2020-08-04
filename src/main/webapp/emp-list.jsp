<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Employee Management Application</title>
</head>
<body>
	<center>
		<h1>Employee Management</h1>
        <h2>
        	<a href="new">Add New Employee</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Employees</a>
        	
        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Employees</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="Employee" items="${listEmployee}">
                <tr>
                    <td><c:out value="${Employee.id}" /></td>
                    <td><c:out value="${Employee.name}" /></td>
                    <td><c:out value="${Employee.email}" /></td>
                    <td><c:out value="${Employee.country}" /></td>
                    <td>
                    	<a href="edit?id=<c:out value='${Employee.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${Employee.id}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>
