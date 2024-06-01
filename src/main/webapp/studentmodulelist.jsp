<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Module List</title>

    <link href="Styles/feedbackList.css" rel="stylesheet" />
	<%@ include file="HeaderTeacherBeforeLogin.jsp" %>
    
</head>
<body style="background-image: url('Images/back 2.png'); background-size: 40%; background-attachment: fixed;">

<div class="container-layout">
 <table class="table" cellspacing="30" cellpadding="10">
        
        <c:forEach var="mods" items="${modList}">
       
            <tr>
                <td style="display: none;">${mods.mid}</td>
                <td>${mods.mname}</td>
                
                <c:set var="sid" value="${param.sid}" />
                
                <td>
                	<button class="update-btn"><a style="color: #fff !important;" href="ModulePageServlet?mid=${mods.mid}&sid=${sid}">View</a></button>
                </td>

				
            </tr>
        </c:forEach>
    </table>
    </div>
    <object data="footer.php" width="100%" height="475"></object>
</body>
</html>