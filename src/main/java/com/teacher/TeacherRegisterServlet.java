package com.teacher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TeacherInsert")
public class TeacherRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String contactNo = request.getParameter("contactNo");
		String username = request.getParameter("uid");
		String password = request.getParameter("psw");
		
		boolean isTrue ;
		
		isTrue = TeacherDBUtill.TeacherRegisterValidate(name, email, contactNo, username, password);
		
		if(isTrue == true) {
			
			request.setAttribute("successMessage", "Profile Created Successfully");
			
			RequestDispatcher dis = request.getRequestDispatcher("TeacherLogin.jsp");
			dis.forward(request, response);
			
		} else {
			
			request.setAttribute("errorMessage", "Profile Creation Unsuccessful");
			
			RequestDispatcher dis2 = request.getRequestDispatcher("TeacherRegister.jsp");
			dis2.forward(request, response);
		}
		
		
		
	}

}
