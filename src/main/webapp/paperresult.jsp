<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    
    <title>Paper Details</title>
    <link rel="stylesheet" href="Styles/feedbackList.css">
    <%@ include file="HeaderTeacherAfterLogin.jsp" %>
    
</head>
<body style="background-image: url('Images/back 2.png'); background-size: 40%; background-attachment: fixed;">

        <div class="container-layout">
        	<div style="text-align: center;">
        		<h1>Paper Details</h1>
			</div>
			
			<div class="paperinfo">
				<h2>Paper Information</h2>
				<h3>Paper ID: ${paper.pid}</h3>
				<h3>Paper Name: ${paper.pname}</h3><br><br><br>
			</div>
			
	
			<h1>Student Results</h1>
			
			<table class="table">
		    	<tr>
		        	<th scope="col">Student ID</th>
		        	<th scope="col">Student Name</th>
		        	<th scope="col">Marks</th>
		        	<th scope="col">Grade</th>
		    	</tr>
	
				<c:forEach var="result" items="${results}">
					<tr>
			            <td>${result.sid}</td>
			            <td>${result.sname}</td>
			            <td>${result.marks}</td>
			            <td>${result.grade}</td>
			            
			        </tr>
	
					<c:set var="totalStudents" value="0" />
				    <c:set var="totalMarks" value="0" />
				    <c:set var="gradeA" value="0" />
				    <c:set var="gradeB" value="0" />
				    <c:set var="gradeC" value="0" />
				    <c:set var="gradeW" value="0" />
				    <c:set var="totalMarks" value="${totalMarks + result.marks}" />
		        	<c:set var="totalStudents" value="${totalStudents + 1}" />
		    
			        <c:choose>
			            <c:when test="${result.grade eq 'A'}">
			                <c:set var="gradeA" value="${gradeA + 1}" />
			            </c:when>
			            
			            <c:when test="${result.grade eq 'B'}">
			                <c:set var="gradeB" value="${gradeB + 1}" />
			            </c:when>
			            
			            <c:when test="${result.grade eq 'C'}">
			                <c:set var="gradeC" value="${gradeC + 1}" />
			            </c:when>
			            
			            <c:when test="${result.grade eq 'W'}">
			                <c:set var="gradeW" value="${gradeW + 1}" />
			            </c:when>
			            
			        </c:choose>
				</c:forEach>
			</table>
			<div class="paperinfo">
				<h2>Summary</h2>
				<h3>Total Students: ${totalStudents}</h3>
				<h3>Grade A: ${gradeA}</h3>
				<h3>Grade B: ${gradeB}</h3>
				<h3>Grade C: ${gradeC}</h3>
				<h3>Grade W: ${gradeW}</h3>
				<h3>Average Mark: <c:if test="${totalStudents > 0}">${totalMarks / totalStudents}</c:if></h3>
			</div>
		</div>
	<object data="footer.php" width="100%" height="475"></object>
</body>
</html>
