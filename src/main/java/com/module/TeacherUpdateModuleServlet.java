package com.module;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/TeacherUpdateModuleServlet")
public class TeacherUpdateModuleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mid = Integer.parseInt(request.getParameter("mid"));
		int tid = Integer.parseInt(request.getParameter("tid"));
		String mname = request.getParameter("mname");
		String mdes = request.getParameter("mdes");
		String mcode = request.getParameter("mcode");
		
		boolean isTrue;
		
		isTrue = ModuleDBUtil.teacherUpdateModule(mid, mname, mdes, mcode);
		
		
		//This segment is done after the DBUtil
		if(isTrue==true) {
			List<Module> modDetails = ModuleDBUtil.getModuleDetails(mid);
			request.setAttribute("tid", tid);
			request.setAttribute("modDetails", modDetails);
			RequestDispatcher dis = request.getRequestDispatcher("teachermodulepage.jsp");
			dis.forward(request, response);
		}
		
		else {
			RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");
			dis.forward(request, response);
		}
		
	}
	

}
