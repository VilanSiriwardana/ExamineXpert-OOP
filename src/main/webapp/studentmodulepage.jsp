<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Module Page</title>
<link rel="stylesheet" href="Styles/feedbackList.css">
    <%@ include file="HeaderTeacherAfterLogin.jsp" %>
</head>
<body style="background-image: url('Images/back 2.png'); background-size: 40%; background-attachment: fixed;">

<div class="container-layout" style="width: 800px;">
		
		<h1 style="text-align: center; align-items: center; font-size: 40px;">Module</h1>	<br><br>	
		
		<c:set var="sid" value="${param.sid}" />
		<c:set var="mid" value="${param.mid}" />
		
		
	
		<table class="table">
		<c:forEach var="mods" items="${modDetails}">
			
				<tr>
					<th>
						<a Style="text-align: right;" href="TeacherCreateView.jsp?mid=${mods.mid}&sid=${sid}">
            				${mods.mname}
        				</a>
					</th>
				</tr>
				
				<tr>
					<td>
						<a Style="text-align: right;" >
            				${mods.mdes}
        				</a>
					</td>
				</tr>
				
				
				<tr>
					<td>
						<a Style="text-align: right;" >
            				${mods.mcode}
        				</a>
					</td>
				</tr>
				
				<tr>
					<td>
					
		                  <button class="update-btn"><a style="color: #fff !important;" href="PapersListServlet?sid=${sid}&mid=${mid}">View Papers</a></button>
	               	</td>
	             </tr>  
	               
	              
			</c:forEach>
		</table>
	</div>


<object data="footer.php" width="100%" height="475"></object>










<!-- 
 <c:forEach var="mods" items="${modDetails}">
 
    <h1>${mods.mid}</h1>
    <h1>${mods.mname}</h1>
    <h3>${mods.mdes}</h3>
    <h3>${mods.mcode}</h3>
</c:forEach>
	
	<c:set var="sid" value="${param.sid}" />
	<c:set var="mid" value="${param.mid}" />

<a href="PapersListServlet?sid=${sid}&mid=${mid}"><button type="submit">View Papers</button></a>
 -->
</body>
</html>