<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Dashboard</title>
    <link rel="stylesheet" href="Styles/formCustomer.css">
    <%@ include file="HeaderTeacherAfterLogin.jsp" %>
    
</head>

<body style="background-image: url('Images/back 2.png'); background-size: 40%; background-attachment: fixed;">
		<c:choose>
		    <c:when test="${not empty param.tid}">
		        <c:set var="tid" value="${param.tid}" />
		    </c:when>
		    
		    <c:otherwise>
		        <c:set var="tid" value="${requestScope.tid}" />
		    </c:otherwise>
		</c:choose>
		
	
	<div class="container">
		
		<h1> Dashboard</h1>
		
		<div class="form-group">
			<label class="label" for="C_Username" style="font-size: 140%; text-align: left; align-items: left;">
				<a href="TeacherModuleListServlet?tid=${tid}" style="text-decoration: none;">Manage Modules</a> <br>
			</label> <br>
		
		
		
		
    		<label class="label" for="C_Username" style="font-size: 140%; text-align: left; align-items: left;">
				<a href="TeacherProfileServlet?tid=${tid}" style="text-decoration: none;">Go to Profile</a>
			</label> <br>
		</div>
	</div>

	<object data="footer.php" width="100%" height="475"></object>
	
	
</body>
</html>
