<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

    <link href="Styles/feedbackList.css" rel="stylesheet" />
	<%@ include file="HeaderTeacherBeforeLogin.jsp" %>
    
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-image: url('Images/back 2.png'); background-size: 40%; background-attachment: fixed;">

<div class="container-layout">
<table class="table" cellspacing="30" cellpadding="10">
		<c:set var="sid" value="${param.sid}" />
		<c:set var="mid" value="${param.mid}" />
		
        <c:forEach var="paper" items="${paperList}">
      	
            <tr>
                <td>${paper.pid}</td>
                <td>${paper.pname}</td>
                
                 <td>
                	<button class="update-btn"><a style="color: #fff !important;" href="ViewQuestionsServlet?sid=${sid}&mid=${mid}&pid=${paper.pid}">Do Paper</a></button>
                </td>
          
            </tr>
        </c:forEach>
    </table>
    </div>
    <object data="footer.php" width="100%" height="475"></object>		
</body>
</html>