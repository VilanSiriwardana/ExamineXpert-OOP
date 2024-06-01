package com.module;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ModuleCreateServlet")
public class ModuleCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tid = request.getParameter("tid");
		String mname = request.getParameter("mname");
		String mdes = request.getParameter("mdes");
		String mcode = request.getParameter("mcode");
		
		System.out.println("TID: " + tid);
		
		boolean isTrue;
		
		isTrue = ModuleDBUtil.createModule(mname, mdes, mcode);
		
		
		if(isTrue == true) {
			request.setAttribute("tid", tid);
			RequestDispatcher dis = request.getRequestDispatcher("/ModuleListServlet");
			dis.forward(request, response);
		}
		
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
		
		
		
	}

}
