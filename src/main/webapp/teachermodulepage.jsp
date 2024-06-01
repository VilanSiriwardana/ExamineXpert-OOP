<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Module Page</title>

    <link rel="stylesheet" href="Styles/feedbackList.css">
    <%@ include file="HeaderTeacherAfterLogin.jsp" %>
</head>
<body style="background-image: url('Images/back 2.png'); background-size: 40%; background-attachment: fixed;">
	
	<div class="container-layout" style="width: 800px;">
		
		<h1 style="text-align: center; align-items: center; font-size: 40px;">Module</h1>	<br><br>	
		
		<c:choose>
		    <c:when test="${not empty param.tid}">
		        <c:set var="tid" value="${param.tid}" />
		    </c:when>
		    
		    <c:otherwise>
		        <c:set var="tid" value="${requestScope.tid}" />
		    </c:otherwise>
		</c:choose>

		<c:set var="mid" value="${param.mid}" />
		
		
	
		<table class="table">
		
			<c:forEach var="mods" items="${modDetails}">
			
			<c:url value="teacherupdatemodule.jsp" var="moduleupdate">
						<c:param name="tid" value="${tid}"/>		
                        <c:param name="mid" value="${mods.mid}"/>
                        <c:param name="mname" value="${mods.mname}"/>
                        <c:param name="mdes" value="${mods.mdes}"/>
                        <c:param name="mcode" value="${mods.mcode}"/>
                        
             </c:url>
				<tr>
					<th>
						<a Style="text-align: right;" href="TeacherCreateView.jsp?tid=${tid}&mid=${mid}">
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
		                  <button class="update-btn"><a style="color: #fff !important;" href="${moduleupdate}">Update</a></button>
	               	</td>
	             </tr>  
	               
	              <tr>
	               <td>
	                	<button class="delete-btn"><a style="color: #fff !important;" href="javascript:void(0);" class="delete" data-mid="${mods.mid}" >Delete</a></button>
	               </td>
				</tr>
				
				<tr>
					<td>
					
		                  <button class="update-btn"><a style="color: #fff !important;" href="PapersListServlet?tid=${tid}&mid=${mid}">View Papers</a></button>
	               	</td>
	             </tr>  
			</c:forEach>
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
				                    window.location.href = "TeacherDeleteModuleServlet?tid=${tid}&mid=${mid}";
				                }
				            });
				        });
				    </script>
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
	
    <p>
        <a href="StudentViewPapersServlet">View Paper List</a> <br>
        <a href="teachercreatepaper.jsp">Create Paper</a> <br>
        <a href="modulecreate.jsp">View Results</a> <br>
    </p>
	-->
	
	
</body>
</html>