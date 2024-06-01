package com.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentAccountServlet")
public class StudentAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sid = Integer.parseInt(request.getParameter("sid"));

		List<Student> stuDetails = StudentDBUtil.getStudentDetails(sid);
        request.setAttribute("stuDetails", stuDetails);
        RequestDispatcher dis = request.getRequestDispatcher("studentaccount.jsp");
        dis.forward(request, response);
	}

}
