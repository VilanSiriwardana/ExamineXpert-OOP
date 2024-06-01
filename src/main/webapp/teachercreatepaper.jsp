<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Paper</title>

	<link href="Styles/loginSeller.css" rel="stylesheet" />
	<%@ include file="HeaderTeacherAfterLogin.jsp" %>
	

	<script>
        function addQuestions() {
            const numQuestions = parseInt(document.getElementById('numQuestions').value);
            const questionsDiv = document.getElementById('questions');
            questionsDiv.innerHTML = ''; // Clear previous content

            for (let i = 1; i <= numQuestions; i++) {
                questionsDiv.innerHTML += `
                

            	 	<fieldset>
            	 	<legend>Question \${i} :</legend>
	                	<div class="form-group">
	                		
		                    <input type="hidden" name="qid" value="\${i}" readonly>
	                	</div>
	                    <div class="form-group">
	                        <label class="label" for="question">Question \${i}:</label>
	                        <input type="text" name="question" placeholder="Enter Question" required>
	                    </div>
	                    <div class="form-group">
	                        <label class="label" for="tanswer">Answer \${i}:</label>
	                        <input type="text" name="tanswer" placeholder="Enter Answer" required>
	                    </div>
	                    <br><br>
	                </fieldset>
	                    <br><br>
	                    
                `;
            }
        }
    </script>
     
     
</head>

<body style="background-image: url('Images/back 2.png'); background-size: 40%; background-attachment: fixed;">
	    <c:set var="tid" value="${param.tid}" />
		<c:set var="mid" value="${param.mid}" />
		
	<div class="container">		
	 <form action="TeacherCreatePaperServlet" method="post">
	 	
	 	<input type="hidden" name="tid" value="${tid}">
	 	
	 	<fieldset>
	 	<legend>  Paper Details</legend>
	 	<div class="form-group">
	        <label class="label" for="mid">ModuleID:</label>
	        <input type="text" name="mid" value="${mid}" readonly>
		</div>

		<br>
		
		<div class="form-group">
	        <label class="label" for="pname">Paper Name:</label>
	        <input type="text" name="pname" placeholder="Enter Paper Name" required>
		</div>
		<br>
		
		<div class="form-group">
	        <label class="label" for="numQuestions">Number of Questions:</label>
	        <input type="number" id="numQuestions" name="numQuestions" placeholder="Enter No. of Questions" min="1" max="10" required>
       
        <button name="submit" type="submit" value="Add Questions" onclick="addQuestions()" style="text-align: center; margin: 0 auto;">Add Questions</button>
		</div>
		<br><br>
		
		</fieldset>	
		
		<br><br><br><br>
	 	<fieldset>
	 	<legend>Questions</legend>
        <div id="questions">
            
        </div>

        </fieldset>
        
		<br><br>
		<center>
			<button name="submit" type="submit" value="Create Paper" style="text-align: center; margin: 0 auto;">Create Paper</button>
		</center>
		
    </form>
     
    
    </div>
	<object data="footer.php" width="100%" height="475"></object>

    
</body>

</html>