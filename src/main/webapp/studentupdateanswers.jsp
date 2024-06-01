<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Answers</title>


    <link href="Styles/feedbackList.css" rel="stylesheet" />
	<%@ include file="HeaderTeacherBeforeLogin.jsp" %>
    
</head>
<body style="background-image: url('Images/back 2.png'); background-size: 40%; background-attachment: fixed;">
	<c:set var="sid" value="${param.sid}" />
	<c:set var="mid" value="${param.mid}" />
	
	<div class="container-layout">
	<form action=StudentUpdateAnswersServlett method="post">
	        
		<table class="table"  cellspacing="30" cellpadding="10">
		
        <tr>
            <th>QID</th>
            <th>Question</th>
            <th>Answer</th>
        </tr>
        <c:forEach var="ques" items="${QuestionList}">
        	<input type="hidden" name="pid" value="${ques.pid}">
        	<input type="hidden" name="mid" value="${mid}">
        	<input type="hidden" name="sid" value="${sid}">
        	
            <input type="hidden" name="question" value="${ques.question}">
            <tr>

                <td>${ques.qid}</td>
                <td>${ques.question}</td>
                <td>
                    <c:forEach var="ans" items="${stuAnswers}">
                        <c:if test="${ans.qid eq ques.qid}">
                        	<input type="hidden" name="qid" value="${ans.qid}">
                        	
                        	<div class="form-group">
                            <input type="text" id="sanswer" name="sanswer" value="${ans.sanswer}">
                            </div>
                        </c:if>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table>
	   
	   <center>
		<button name="submit" type="submit" value="Update" style="text-align: center; margin: 0 auto;">Submit</button>
		</center>

	</form>	
	</div>
	
	<object data="footer.php" width="100%" height="475"></object>	
</body>
</html>