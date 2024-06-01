package com.paper;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.module.ModuleDBUtil;
import com.module.Module;


@WebServlet("/PapersListServlet")
public class PapersListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mid = Integer.parseInt(request.getParameter("mid"));
		
		List<Module> modDetails = ModuleDBUtil.getModuleDetails(mid);
		List<Paper> paperList = PaperDBUtil.getPapersList(mid);
		
		String sid = request.getParameter("sid");
		String tid = request.getParameter("tid");
		
		if (sid != null && !sid.isEmpty()) {
		    int sidInt = Integer.parseInt(sid);
		    // Forward to the studentviewpapers.jsp
		    request.setAttribute("modDetails", modDetails);
	        request.setAttribute("paperList", paperList);
		    RequestDispatcher dis = request.getRequestDispatcher("studentpaperslist.jsp");
		    dis.forward(request, response);
		} 
		
		else if (tid != null && !tid.isEmpty()) {
		    int tidInt = Integer.parseInt(tid);
		    // Forward to the teacherviewpapers.jsp
		    request.setAttribute("modDetails", modDetails);
	        request.setAttribute("paperList", paperList);
		    RequestDispatcher dis = request.getRequestDispatcher("teacherpaperslist.jsp");
		    dis.forward(request, response);
		} else {
		    // Handle cases where neither sid nor tid is present
		}
		
		
	}

}
