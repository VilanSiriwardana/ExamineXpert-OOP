<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Paper Result</title>
<link rel="stylesheet" href="Styles/feedbackList.css">
    <%@ include file="HeaderTeacherAfterLogin.jsp" %>
</head>
<body style="background-image: url('Images/back 2.png'); background-size: 40%; background-attachment: fixed;">

<div class="container-layout" style="width: 800px;">
		
		<c:forEach var="mods" items="${ModDetails}">
	
			<h1 style="text-align: center; align-items: center; font-size: 40px;">${mods.mname}</h1>	<br><br>	
            				
	
		</c:forEach>
		
		
		<c:set var="sid" value="${param.sid}" />
		<c:set var="mid" value="${param.mid}" />
		<c:set var="pid" value="${param.pid}" />
		
		
	
		<table class="table">
		
		
		<c:forEach var="paper" items="${PaperDetails}">
			
				<tr>
					<th>
            				${paper.pname}
					</th>
				</tr>
		</c:forEach>
				
				
		<c:forEach var="stu" items="${StuDetails}">
			
				<tr>
					<td>
            				${stu.sname}
					</td>
				</tr>
		</c:forEach>
						
						
		<c:forEach var="result" items="${StuResults}">
			
				<tr>
					<td>Score : ${result.score}</td>
		
				</tr>
				
				
				<tr>
					<td>Grade : ${result.grade}</td>
				</tr>
		</c:forEach>
				
			
		</table>
	</div>


	<object data="footer.php" width="100%" height="475"></object>
	
	
</body>
</html>