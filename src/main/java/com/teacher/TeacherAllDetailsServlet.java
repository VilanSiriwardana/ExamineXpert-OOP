package com.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TeacherAllDetailsServlet")
public class TeacherAllDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Teacher> teacherList = TeacherDBUtill.getTeacherList();
        request.setAttribute("teacherList", teacherList);
        RequestDispatcher dis = request.getRequestDispatcher("teacherall.jsp");
        dis.forward(request, response);
	}

}
