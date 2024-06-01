<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

    <link href="Styles/feedbackList.css" rel="stylesheet" />
	<%@ include file="HeaderTeacherAfterLogin.jsp" %>
    
<meta charset="ISO-8859-1">
<title>Teacher Papers List</title>
</head>
<body style="background-image: url('Images/back 2.png'); background-size: 40%; background-attachment: fixed;">

<div class="container-layout">

<c:forEach var="mod" items="${modDetails}">
	
</c:forEach>
<table class="table" cellspacing="30" cellpadding="10">
		<c:forEach var="module" items="${modDetails}">
			<tr>
				<th colspan="3">
					${module.mname}
				</th>
			</tr>
		</c:forEach>
		
		
		<c:set var="tid" value="${param.tid}" />
		<c:set var="mid" value="${param.mid}" />
		
        <c:forEach var="paper" items="${paperList}">
      	
            <tr>
                <td>${paper.pid}</td>
                <td>${paper.pname}</td>
                
                 <td>
                	<button class="update-btn"><a style="color: #fff !important;" href="ViewQuestionsServlet?tid=${tid}&mid=${mid}&pid=${paper.pid}">View Paper</a></button>
                </td>
          
            </tr>
        </c:forEach>
        
        <tr>
        	<td colspan="3">
        		<button class="update-btn"><a style="color: #fff !important;" href="teachercreatepaper.jsp?tid=${tid}&mid=${mid}">Create Paper</a></button>
        	</td>
        </tr>
    </table>
    </div>
    <object data="footer.php" width="100%" height="475"></object>		
</body>
</html>