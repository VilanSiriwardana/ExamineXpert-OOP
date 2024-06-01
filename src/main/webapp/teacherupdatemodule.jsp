<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Module</title>
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
	<%
		String tid = request.getParameter("tid");
		String mid = request.getParameter("mid");
		String mname = request.getParameter("mname");
		String mdes = request.getParameter("mdes");
		String mcode = request.getParameter("mcode");
	%>
	
	<div class="container"> 
		<h2>Update Module</h2>
		<form action="TeacherUpdateModuleServlet" method="post">
		
				<input type="hidden" id="tid" name="tid" value="<%=tid%>" readonly><br>
		
			<div class="form-group">
				<label class="label" for="mname" style="font-size: 140%; text-align: left; align-items: left;">Module ID:</label>
				<input type="text" id="mid" name="mid" value="<%=mid%>" readonly><br>
			</div>
			<br>
			<div class="form-group">	
				<label class="label" for="mname" style="font-size: 140%; text-align: left; align-items: left;">Module Name:</label> 
				<input type="text" id="mname" name="mname" value="<%=mname%>"><br>
			</div>
			<br>
			<div class="form-group">	
				<label class="label" for="mname" style="font-size: 140%; text-align: left; align-items: left;">Module Description:</label>
				<input type="text" id="mdes" name="mdes" value="<%=mdes%>"><br>
			</div>
			<br>
			<div class="form-group">	
				<label class="label" for="mname" style="font-size: 140%; text-align: left; align-items: left;">Module Code:</label> 
				<input type="text" id="mcode" name="mcode" value="<%=mcode%>" pattern="[A-Z]{2}\d{4}"><br>
				<span class="error">Module code must start with 2 capital letters and followed by 4 digits.</span>
			</div>	
			<br>
			<div class="form-group">	
				<button name="submit" type="submit" value="Update Module" style="text-align: center; margin: 0 auto;">Update Module</button>
			</div>
		</form>
	</div>
	
	<object data="footer.php" width="100%" height="475"></object>
	
</body>
</html>