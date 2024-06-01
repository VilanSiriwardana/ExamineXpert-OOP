package com.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateTeacherServlet")
public class TeacherProfileUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String contactNo = request.getParameter("contactNo");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean isTrue ;
		
		isTrue = TeacherDBUtill.TeacherProfileUpdateValidate(id, name, email, contactNo, username, password);
		
		if(isTrue == true) {
			List <Teacher> teachDetails = TeacherDBUtill.getTeacherDetails(id);
			request.setAttribute("teachDetails", teachDetails);
			
			request.setAttribute("successMessage", "Profile Updated Successfully");
			
			RequestDispatcher dis = request.getRequestDispatcher("TeacherProfile.jsp");
			dis.forward(request, response);
			
			

			
		} else {
			
			List <Teacher> teachDetails = TeacherDBUtill.getTeacherDetails(id);
			request.setAttribute("teachDetails", teachDetails);
			request.setAttribute("errorMessage", "Profile Update Unsuccessful");
			
			RequestDispatcher dis2 = request.getRequestDispatcher("TeacherProfile.jsp");
			dis2.forward(request, response);
		}
	}

}
