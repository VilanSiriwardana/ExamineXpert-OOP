package com.module;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ModuleListServlet")
public class ModuleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Module> modList = ModuleDBUtil.getModuleList();
		request.setAttribute("modList", modList);
		
		String tid = (String) request.getAttribute("tid");
		System.out.println("Teacher ID (tid): " + tid);
		
		String sid = request.getParameter("sid");

		if (sid != null && !sid.isEmpty()) {
		    int sidInt = Integer.parseInt(sid);
		    // Forward to the studentmodulelist.jsp
		    RequestDispatcher dis = request.getRequestDispatcher("studentmodulelist.jsp");
		    dis.forward(request, response);
		    
		    
		} else if (tid != null && !tid.isEmpty()) {
		    // Forward to the teachermodulelist.jsp
		    request.setAttribute("tid", tid);
		    RequestDispatcher dis = request.getRequestDispatcher("teachermodulelist.jsp");
		    dis.forward(request, response);
		} else {
		    // Handle cases where neither sid nor tid is present
		}
		
		
	}
	
	
	
	
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Module> modList = ModuleDBUtil.getModuleList();
		request.setAttribute("modList", modList);
		
		String tid = (String) request.getAttribute("tid");
		System.out.println("Teacher ID (tid): " + tid);
		
		String sid = request.getParameter("sid");

		if (sid != null && !sid.isEmpty()) {
		    int sidInt = Integer.parseInt(sid);
		    // Forward to the studentmodulelist.jsp
		    RequestDispatcher dis = request.getRequestDispatcher("studentmodulelist.jsp");
		    dis.forward(request, response);
		    
		    
		} else if (tid != null && !tid.isEmpty()) {
		    // Forward to the teachermodulelist.jsp
		    request.setAttribute("tid", tid);
		    RequestDispatcher dis = request.getRequestDispatcher("teachermodulelist.jsp");
		    dis.forward(request, response);
		} else {
		    // Handle cases where neither sid nor tid is present
		}
		
		
	}

}
