<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Paper</title>
     
	<link href="Styles/loginSeller.css" rel="stylesheet" />
	<%@ include file="HeaderTeacherAfterLogin.jsp" %>
	
     
</head>

<body style="background-image: url('Images/back 2.png'); background-size: 40%; background-attachment: fixed;">

	<c:set var="tid" value="${param.tid}" />
	    
	 <div class="container">	
	 <form action="TeacherUpdatePaperServlet" method="post">
	 
	 <c:forEach var="paper" items="${PaperInfo}">
	 
	 	<input type="hidden" name="tid" value="${tid}">
	 	
	 	<input type="hidden" name="pid" value="${paper.pid}">
	 	
		<fieldset>
	 	<legend>  Paper Details</legend>
	 	
		<div class="form-group">
	        <label for="mid">ModuleID:</label>
	        <input type="text" name="mid" value="${paper.mid}" readonly>
		</div>
		
		<div class="form-group">
	        <label for="pname">Paper Name:</label>
	        <input type="text" name="pname" value="${paper.pname}" required>
        </div>
		<br><br>
		
		</fieldset>	
		
	</c:forEach>
	
	<br><br><br><br>
		<fieldset>
		<legend>Questions</legend>
 	
     <div id="questions">
	
	<c:forEach var="ques" items="${QuestionList}">

            <fieldset style="margin: 15px;">
           	<legend>Question ${ques.qid} :</legend>
           	
					<div class="form-group">
	                    <input type="hidden" name="qid" value="${ques.qid}" readonly>
                	</div>
                	
                    <div class="form-group">
                        <label for="question">Question ${i}:</label>
                        <input type="text" name="question" value="${ques.question}" required>
                        
                    </div>
                    
                    
                    <div class="form-group">
                        <label for="tanswer">Answer ${i}:</label>
                        <input type="text" name="tanswer" value="${ques.tanswer}" required>
                    </div>

        
        
	               <br><br>
	      	</fieldset>
	             	<br><br>
        

	</c:forEach>
	</div>

        </fieldset>
        
        <br><br>
        <center>
			<button name="submit" type="submit" value="Update Paper" style="text-align: center; margin: 0 auto;">Update Paper</button>
		</center>
    </form>
     
    
    
     </div>
    

    <object data="footer.php" width="100%" height="475"></object>
    
</body>

</html>