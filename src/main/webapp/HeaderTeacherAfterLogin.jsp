<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Header</title>
    <link rel="stylesheet" href="Styles/header.css">
    <link rel="icon" href="Images/ShopZilla Logo.png" type="image/x-icon">
</head>

<body>
<header>
		<c:choose>
		    <c:when test="${not empty param.tid}">
		        <c:set var="tid" value="${param.tid}" />
		    </c:when>
		    
		    <c:otherwise>
		        <c:set var="tid" value="${requestScope.tid}" />
		    </c:otherwise>
		</c:choose>
		
    <div class="head-container">
        <div class="logo">
            <a href=""> <img style="top: 5px; height: 90px; width: auto; margin-top: 5px; border: 2px solid #000000; border-radius: 10px;" src="Images/ShopZilla Logo.png" > </a>
        </div>
        
        <div class="nav-btns" style="margin-left:250px">
                <ul>
                    <a href="TeacherDashboard.jsp?tid=${tid}"> <li>Dashboard</li> </a>           
                </ul>
            </div>

        <div style="width:10px">
            <label class="name" style="font-family: Georgia, serif; font-size: 50px; color:#ffffff; margin-left:-60px">ExamineXpert</label>
        </div>
        
        <div class="nav-btns" style="margin-left:250px">
                <ul>
                    <a href="TeacherModuleListServlet?tid=${tid}"> <li>Modules</li> </a>                 
                </ul>
            </div>


        <div class="sign-btn-container">
          
           <div class="login" style=""><a href="TeacherLogin.jsp" > Logout </a></div> 
        </div>
    </div>
</header>
</body>

</html>
