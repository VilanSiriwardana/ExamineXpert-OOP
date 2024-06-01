<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Teacher Profile</title>
     <link href="Styles/profileSeller.css" rel="stylesheet" />
     <%@ include file="HeaderTeacherAfterLogin.jsp" %>
</head>
<body style="background-image: url('Images/back 2.png'); background-size: 40%; background-attachment: fixed;">
	<script>
		var successMessage = '<%= request.getAttribute("successMessage") %>';
    	if (successMessage && successMessage !== 'null') {
        	alert(successMessage);
    	}
    
    	var errorMessage = '<%= request.getAttribute("errorMessage") %>';
    	if (errorMessage && errorMessage !== 'null') {
        	alert(errorMessage);
    	}
    	
    	function confirmDelete() {
    		if (confirm("Are you sure you want to delete your profile?")) {
    	        return true;
    	    }
    	    return false;
    	}
	</script>
	
	
	<div class="container">
		<div class="profile-container">
		<c:forEach var="teach" items="${teachDetails}">
			<div class="profile-info">
				<h2>Name</h2>
				<p>${teach.name}</p>
			</div>
			
			<div class="profile-info">
				<h2>Email</h2>
				<p>${teach.email}</p>
			</div>
			
			<div class="profile-info">
				<h2>Contact Number</h2>
				<p>${teach.contactNo}</p>
			</div>
			
			</c:forEach>
			
		</div>
		
		<c:forEach var="teach" items="${teachDetails}">
        <c:set var="id" value="${teach.id}"/>
        <c:set var="name" value="${teach.name}"/>
        <c:set var="email" value="${teach.email}"/>
        <c:set var="contactNo" value="${teach.contactNo}"/>
        <c:set var="username" value="${teach.userName}"/>
        <c:set var="password" value="${teach.password}"/>
    </c:forEach>

    <c:url value="TeacherProfileUpdate.jsp" var="teacherupdate">
        <c:param name="id" value="${id}"/>
        <c:param name="name" value="${name}"/>
        <c:param name="email" value="${email}"/>
        <c:param name="contactNo" value="${contactNo}"/>
        <c:param name="username" value="${username}"/>
        <c:param name="password" value="${password}"/>
    </c:url>
		
		
		<c:url value="TeacherProfileDelete.jsp" var="teacherdelete">
        	<c:param name="id" value="${id}"/>
    	</c:url>
    	
		<div class="profile-actions">
			<a href="${teacherupdate}" class="update" >Update My Details</a>
         	<a href="${teacherdelete}" onclick="return confirmDelete();" class = "delete">Delete My Profile</a>
        </div>
		
	</div>
	<object data="footer.php" width="100%" height="475"></object>
</body>
</html>
