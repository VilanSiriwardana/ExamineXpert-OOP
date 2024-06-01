package com.module;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TeacherDeleteModuleServlet")
public class TeacherDeleteModuleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tid = request.getParameter("tid");
		int mid = Integer.parseInt(request.getParameter("mid"));
		
		boolean isTrue;
		isTrue = ModuleDBUtil.teacherDeleteModule(mid);
		
		if(isTrue == true) {
			List<Module> modList = ModuleDBUtil.getModuleList();
			request.setAttribute("modList", modList);
			RequestDispatcher dis = request.getRequestDispatcher("teachermodulelist.jsp");
			dis.forward(request, response);
		}
		
		else {
			List<Module> modList = ModuleDBUtil.getModuleList();
			request.setAttribute("modList", modList);
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
	}

}
