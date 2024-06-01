<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Student Account</title>
</head>
<body>
 <h1>Student Details</h1>
    <table border="1">
        <tr>
            <th>Student ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>UserName</th>
            <th>Password</th>
        </tr>
        <c:forEach var="stu" items="${stuDetails}">
            <tr>
                <td>${stu.sid}</td>
                <td>${stu.sname}</td>
                <td>${stu.semail}</td>
                <td>${stu.susername}</td>
                <td>${stu.spassword}</td>
                 
            </tr>
        </c:forEach>
        
        <c:set var="sid" value="${param.sid}" />
        
    </table>
    <a href="StudentAllDetailsServlett"><button type="submit">Back to Student List</button></a>
    
    <a href="ModuleListServlet?sid=${sid}"><button type="submit">View Module List</button></a>
</body>
</html>