<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Do Questions</title>

	<link href="Styles/loginSeller.css" rel="stylesheet" />
	<%@ include file="HeaderTeacherBeforeLogin.jsp" %>
</head>
<body style="background-image: url('Images/back 2.png'); background-size: 40%; background-attachment: fixed;">
	<c:set var="sid" value="${param.sid}" />
	<c:set var="mid" value="${param.mid}" />
	<c:set var="pid" value="${param.pid}" />
	
	<div class="container">
	<h2>Do Paper</h2>
	<form action=StudentAnswersInsertServlet method="post">
	
			<c:forEach var="ques" items="${QuestionList}">
			
		    <input type="hidden" name="pid" value="${ques.pid}"> 
		    <input type="hidden" name="mid" value="${mid}">     
		    <input type="hidden" name="qid" value="${ques.qid}">
		    <input type="hidden" name="sid" value="${sid}">
		    

			<div class="form-group">
				<strong>${ques.qid}</strong><label class="label" for="question" style="font-size: 140%; text-align: left; align-items: left;">${ques.question} :</label>
				<input type="text" id="sanswer" name="sanswer" placeholder="Enter Answer">
			</div>		               
			
			
	                    
	        </c:forEach>
	
	   <center>
		<button name="submit" type="submit" value="Submit" style="text-align: center; margin: 0 auto;">Submit</button>
		</center>
	
	</form>
	</div>
	<object data="footer.php" width="100%" height="475"></object>
</body>

</html>