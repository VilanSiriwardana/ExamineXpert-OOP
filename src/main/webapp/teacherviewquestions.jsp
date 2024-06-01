<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

    <link href="Styles/feedbackList.css" rel="stylesheet" />
	<%@ include file="HeaderTeacherBeforeLogin.jsp" %>
    
<meta charset="ISO-8859-1">
<title>Teacher Papers List</title>
</head>
<body style="background-image: url('Images/back 2.png'); background-size: 40%; background-attachment: fixed;">

<div class="container-layout">
<table class="table" cellspacing="30" cellpadding="10">
		<c:set var="tid" value="${param.tid}" />
		<c:set var="pid" value="${param.pid}" />
		<c:set var="mid" value="${param.mid}" />
		
		<tr>
			<c:forEach var="paper" items="${PaperInfo}">
				<th colspan="3">${paper.pname}</th>
			</c:forEach>
		</tr>
		
		<tr>
             	<th>Question No.</th>
                <th>Question</th>
                <th>Answer</th>
               
            </tr>
            
		
        <c:forEach var="ques" items="${QuestionList}">
      	
            <tr>
             	<td>${ques.qid}</td>
                <td>${ques.question}</td>
                <td>${ques.tanswer}</td>
               
            </tr>
            
           
        </c:forEach>

         <tr>
                 <td colspan ="3">
                	<button class="update-btn"><a style="color: #fff !important;" href="UpdatePaperFormServlet?tid=${tid}&mid=${mid}&pid=${pid}">Update Paper</a></button>
                </td>
            </tr>
            
             <tr>
	               <td colspan ="3">
	                	<button class="delete-btn"><a style="color: #fff !important;" href="javascript:void(0);" class="delete" data-mid="${mods.mid}" >Delete Paper</a></button>
	               </td>
			</tr>

    </table>
    </div>
    
   				 <script>
				        // Add a click event listener to the delete buttons
				        const deleteButtons = document.querySelectorAll('.delete');
				        deleteButtons.forEach(button => {
				            button.addEventListener('click', function() {
				                const mid = this.getAttribute('data-mid');
				                if (confirm("Confirm Delete Module")) {
				                    // If the user clicks "OK" (Yes), perform the delete action here
				                    alert("Module Deleted");
				                    window.location.href = "TeacherDeletePaperServlet?tid=${tid}&mid=${mid}&pid=${pid}";
				                }
				            });
				        });
				    </script>
				    
    <object data="footer.php" width="100%" height="475"></object>		
</body>
</html>