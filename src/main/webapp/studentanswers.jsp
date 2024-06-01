<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Answers</title>


    <link href="Styles/feedbackList.css" rel="stylesheet" />
	<%@ include file="HeaderTeacherBeforeLogin.jsp" %>
    
</head>
<body style="background-image: url('Images/back 2.png'); background-size: 40%; background-attachment: fixed;">
	<c:set var="sid" value="${param.sid}" />
	<c:set var="mid" value="${param.mid}" />
	<c:set var="pid" value="${param.pid}" />
	
	<div class="container-layout">
		<table class="table" cellspacing="30" cellpadding="10">
		
		<tr>
				<th>Question Number</th> 
				<th>Answer</th> 
			
			</tr>
			<c:forEach var="ans" items="${stuAnswers}">
		               
			<tr>
				<td><strong>${ans.qid}</strong></td> 
				<td>${ans.sanswer}</td> 
			
			</tr>
			 
	                    
	        </c:forEach>
	        
	        <tr>
                <td>
	                <button class="update-btn"><a style="color: #fff !important;" href="StudentUpdateFormAnswerServlet?sid=${sid}&mid=${mid}&pid=${pid}">Update</a></button>
               	</td>
               
             	<td>
                	<button class="delete-btn"><a style="color: #fff !important;" href="javascript:void(0);" id="delete"" >Reset</a></button>
               </td>
           </tr>
           
           <tr>
           		 <td colspan="2">
	                <button class="update-btn"><a style="color: #fff !important;" href="CalculateResultServlet?sid=${sid}&mid=${mid}&pid=${pid}">Submit Answers</a></button>
               	</td>
           </tr>
	   </table>
	   
	   <a href="StudentUpdateFormAnswerServlet?sid=${sid}&mid=${mid}&pid=${pid}">Update Answers</a> <br>
       <!--  <a href="StudentDeleteAnswersServlet?pid=${pid}" id="delete">Reset Answers</a>
       
       <script>
			// Function to display the confirmation dialog
			function confirmDelete() {
			    if (confirm("Confirm Delete?")) {
			        // If the user clicks "OK" (Yes), perform the delete action here
			        alert("Item deleted.");
			        // You can place your delete logic here
			    } else {
			        // If the user clicks "Cancel" (No), do nothing
			        alert("Item not deleted.");
			    }
			}
			
			// Add a click event listener to the delete button
			document.getElementById("delete").addEventListener("click", confirmDelete);
		</script>
	-->
	
	
	<a href="javascript:void(0);" id="delete">Reset Answers</a>
	<!-- Trigger JavaScript Action -->
	
    <script>
        // Function to display the confirmation dialog
        function confirmDelete() {
            if (confirm("Confirm Reset Answers?")) {
                // If the user clicks "OK" (Yes), perform the delete action here
                alert("Answers Reset");
                window.location.href = "StudentDeleteAnswersServlet?sid=${sid}&mid=${mid}&pid=${pid}";
            } 
            
        }

        // Add a click event listener to the delete button
        document.getElementById("delete").addEventListener("click", confirmDelete);
    </script>
	
	
</body>
</html>