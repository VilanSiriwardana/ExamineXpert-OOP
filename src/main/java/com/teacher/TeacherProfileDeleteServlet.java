package com.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TeacherProfileDelete")
public class TeacherProfileDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		
		
boolean isTrue ;
		
		isTrue = TeacherDBUtill.TeacherProfileDeleteValidate(id);
		
		if(isTrue == true) {
			request.setAttribute("successMessage", "Profile Deleted Successfully");
			
			RequestDispatcher dis = request.getRequestDispatcher("TeacherLogin.jsp");
			dis.forward(request, response);
			
			

			
		} else {
			List <Teacher> teachDetails = TeacherDBUtill.getTeacherDetails(id);
			request.setAttribute("teachDetails", teachDetails);
			
			request.setAttribute("errorMessage", "Profile Delete Unsuccessful");
			
			RequestDispatcher dis2 = request.getRequestDispatcher("TeacherProfile.jsp");
			dis2.forward(request, response);
		}
		
		
	}

}
