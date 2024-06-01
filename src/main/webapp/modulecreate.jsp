<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Module</title>
	<link href="Styles/loginSeller.css" rel="stylesheet" />
	<%@ include file="HeaderTeacherAfterLogin.jsp" %>
	
	<script>
		document.addEventListener('DOMContentLoaded', function() {
		    var form = document.querySelector('form');
		    var mcodeInput = document.getElementById('mcode');
		    var errorSpan = document.querySelector('.error');
		
		    form.addEventListener('submit', function(event) {
		        if (!mcodeInput.checkValidity()) {
		            errorSpan.style.display = 'block';
		            event.preventDefault(); // Prevent form submission
		        } else {
		            errorSpan.style.display = 'none';
		        }
		    });
		});
	</script>
	
	
</head>
<body style="background-image: url('Images/back 2.png'); background-size: 40%; background-attachment: fixed;">

	<div class="container">
		<h2>Create Module</h2>
		
		<c:choose>
		    <c:when test="${not empty param.tid}">
		        <c:set var="tid" value="${param.tid}" />
		    </c:when>
		    
		    <c:otherwise>
		        <c:set var="tid" value="${requestScope.tid}" />
		    </c:otherwise>
		</c:choose>
		
		<form action="ModuleCreateServlet" method="post">
		
		<input type="hidden" id="tid" name="tid" value="${tid}">
	
		
		<div class="form-group">
			<label class="label" for="mname" style="font-size: 140%; text-align: left; align-items: left;">Module Name:</label>
			<input type="text" id="mname" name="mname" placeholder="Enter Module Name">
		</div>
		<br>
		<div class="form-group">
			<label class="label" for="mname" style="font-size: 140%; text-align: left; align-items: left;">Module Description:</label> 
			<input type="text" id="mdes" name="mdes" placeholder="Enter Module Description"> 
		</div>
		<br>
		<div class="form-group">
			<label class="label" for="mname" style="font-size: 140%; text-align: left; align-items: left;">Module Code:</label> 
			<input type="text" id="mcode" name="mcode" placeholder="Enter Module Code" pattern="[A-Z]{2}\d{4}"><br>
			<span class="error">Module code must start with 2 capital letters and followed by 4 digits.</span>
		</div>

		<br>
		<center>
		<button name="submit" type="submit" value="Create Module" style="text-align: center; margin: 0 auto;">Create Module</button>
		</center>
		</form>
	</div>
	<object data="footer.php" width="100%" height="475"></object>
</body>
</html>
