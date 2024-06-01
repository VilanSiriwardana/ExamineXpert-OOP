package com.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TeacherLoginServlet")
public class TeacherLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String tusername = request.getParameter("tusername");
	    String tpassword = request.getParameter("tpassword");
	    String errorMessage = "Invalid username or password! Enter again."; 
	    
	    
	    try {
	        List<Teacher> teachDetails = TeacherDBUtill.TeacherLoginValidate(tusername, tpassword);
	        
	        if (teachDetails.isEmpty()) {
	            request.setAttribute("errorMessage", errorMessage);
	            
	        } else {
	        	
	            int tid = teachDetails.get(0).getTid();
	            request.setAttribute("tid", tid);
	            request.setAttribute("teachDetails", teachDetails);
	            RequestDispatcher dis = request.getRequestDispatcher("TeacherDashboard.jsp");
	            dis.forward(request, response);
	            
	            return; 
	        }
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    
	    request.setAttribute("errorMessage", errorMessage);
	    RequestDispatcher dis = request.getRequestDispatcher("TeacherLogin.jsp");
	    dis.forward(request, response);
	}


}
