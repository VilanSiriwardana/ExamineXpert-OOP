package com.module;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ModulePageServlet")
public class ModulePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mid = Integer.parseInt(request.getParameter("mid"));
		
		List<Module> modDetails = ModuleDBUtil.getModuleDetails(mid);
		request.setAttribute("modDetails", modDetails);
		
		String sid = request.getParameter("sid");
		String tid = request.getParameter("tid");

		if (sid != null && !sid.isEmpty()) {
		    int sidInt = Integer.parseInt(sid);
		    // Forward to the studentmodulepage.jsp
		    request.setAttribute("modList", modDetails);
		    RequestDispatcher dis = request.getRequestDispatcher("studentmodulepage.jsp");
		    dis.forward(request, response);
		} 
		
		else if (tid != null && !tid.isEmpty()) {
		    int tidInt = Integer.parseInt(tid);
		    // Forward to the teachermodulepage.jsp
			request.setAttribute("tid", tid);
		    request.setAttribute("modList", modDetails);
		    RequestDispatcher dis = request.getRequestDispatcher("teachermodulepage.jsp");
		    dis.forward(request, response);
		} else {
		    // Handle cases where neither sid nor tid is present
		}
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mid = Integer.parseInt(request.getParameter("mid"));
		
		List<Module> modDetails = ModuleDBUtil.getModuleDetails(mid);
		request.setAttribute("modDetails", modDetails);
		
		String sid = request.getParameter("sid");
		String tid = request.getParameter("tid");

		if (sid != null && !sid.isEmpty()) {
		    int sidInt = Integer.parseInt(sid);
		    // Forward to the studentmodulepage.jsp
		    request.setAttribute("modList", modDetails);
		    RequestDispatcher dis = request.getRequestDispatcher("studentmodulepage?tid="+sidInt+".jsp");
		    dis.forward(request, response);
		} 
		
		else if (tid != null && !tid.isEmpty()) {
		    int tidInt = Integer.parseInt(tid);
		    // Forward to the teachermodulepage.jsp
		    request.setAttribute("modList", modDetails);
		    RequestDispatcher dis = request.getRequestDispatcher("teachermodulepage?tid="+tidInt+".jsp");
		    dis.forward(request, response);
		} else {
		    // Handle cases where neither sid nor tid is present
		}
	}

}
