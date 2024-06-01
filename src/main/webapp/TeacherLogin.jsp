<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Teacher Login</title>
	<link href="Styles/loginSeller.css" rel="stylesheet" />
	<%@ include file="HeaderTeacherBeforeLogin.jsp" %>
	
</head>
<body style="background-image: url('Images/back 2.png'); background-size: 40%; background-attachment: fixed;">

<script>
    // Check if a success message is present in the request attributes and is not null
    var successMessage = '<%= request.getAttribute("successMessage") %>';
    if (successMessage && successMessage !== 'null') {
        alert(successMessage);
    }
    
    // Check if an error message is present in the request attributes and is not null
    var errorMessage = '<%= request.getAttribute("errorMessage") %>';
    if (errorMessage && errorMessage !== 'null') {
        alert(errorMessage);
    }
</script>

    <div class="container">
		<h2>Login</h2>

		<form action=TeacherLoginServlet method = "post">
		
		<div class="form-group">
    		<label class="label" for="C_Username" style="font-size: 140%; text-align: left; align-items: left;">Username:</label> <br>
    		<input type="text" id="C_Username" name="tusername" placeholder="Enter Username">
    	</div>
		
		<div class="form-group">
    		<label class="label" for="C_Password" style="font-size: 140%; text-align: left; align-items: left;">Password:</label> <br>
    		<input type="password" id="C_Password" name="tpassword" placeholder="Enter Password">
    	</div>
		
		<div style="text-align: center; margin: 0 auto;">
   			<p><br>New Here? <a href="TeacherRegister.jsp">Register</a> </p><br>
    		<button name="submit" type="submit" value="login" style="text-align: center; margin: 0 auto;">Login</button>
		</div>
		
		</form>
		
	</div>
	<object data="footer.php" width="100%" height="475"></object>
</body>
</html>