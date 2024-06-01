<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
        <tr>
            <th>Student ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>UserName</th>
            <th>Password</th>
        </tr>
        <c:forEach var="teach" items="${teacherList}">


               <!-- 
                    <c:set var="sid" value="${stu.sid}"/>
                    <c:set var="sname" value="${stu.sname}"/>
                    <c:set var="semail" value="${stu.semail}"/>
                    <c:set var="username" value="${stu.susername}"/>
                    <c:set var="password" value="${stu.spassword}"/>
                -->
                            
            <tr>
                <td>${teach.tid}</td>
                <td>${teach.tname}</td>
                <td>${teach.temail}</td>
                <td>${teach.tconno}</td>
                <td>${teach.tusername}</td>
                <td>${teach.tpassword}</td>
                
                <td>
                    <a href="TeacherDashboard.jsp?tid=${teach.tid}"><button >Dashboard</button></a>

                    <!-- 
                    <form action="StudentDetailsServlet" method="post">
                        <input type="hidden" name="studentId" value="${stu.sid}">
                        <button type="submit">View Details</button>
                    </form> 
                    -->
                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>