<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Teacher Module List</title>
    
     <link rel="stylesheet" href="Styles/feedbackList.css">
    <%@ include file="HeaderTeacherAfterLogin.jsp" %>
</head>
<body style="background-image: url('Images/back 2.png'); background-size: 40%; background-attachment: fixed;">

<c:set var="tid" value="${param.tid}"/>


<div class="container-layout">
    <table class="table" cellspacing="30" cellpadding="40">
    
    <c:choose>
		    <c:when test="${not empty param.tid}">
		        <c:set var="tid" value="${param.tid}" />
		    </c:when>
		    
		    <c:otherwise>
		        <c:set var="tid" value="${requestScope.tid}" />
		    </c:otherwise>
		</c:choose>
        
        <c:forEach var="mods" items="${modList}">
            
                <tr>
					<th>
						<a Style="text-align: right;" href="ModulePageServlet?tid=${tid}&mid=${mods.mid}">
            				${mods.mname}<br>
            				${mods.mcode}
        				</a>
					</th>
				</tr>
  
                    <c:url value="teacherupdatemodule.jsp" var="moduleupdate">
                    	<c:param name="tid" value="${tid}"/>	
                        <c:param name="mid" value="${mods.mid}"/>
                        <c:param name="mname" value="${mods.mname}"/>
                        <c:param name="mdes" value="${mods.mdes}"/>
                        <c:param name="mcode" value="${mods.mcode}"/>
                        
                    </c:url>
                  
               
            
            
            
        </c:forEach>
        <tr>
            	<td colspan="5">
            		<button class="update-btn"><a style="color: #fff !important;" href="modulecreate.jsp?tid=${tid}">Create Module</a></button>
            	</td>
            </tr>
        
    </table>
    </div>
    
    <br>
                    
    
					
					<script>
				        // Add a click event listener to the delete buttons
				        const deleteButtons = document.querySelectorAll('.delete');
				        deleteButtons.forEach(button => {
				            button.addEventListener('click', function() {
				                const mid = this.getAttribute('data-mid');
				                if (confirm("Confirm Delete Module")) {
				                    // If the user clicks "OK" (Yes), perform the delete action here
				                    alert("Module Deleted");
				                    window.location.href = "TeacherDeleteModuleServlet?mid=" + mid;
				                }
				            });
				        });
				    </script>
					
					
					
		<object data="footer.php" width="100%" height="475"></object>			
</body>
</html>
