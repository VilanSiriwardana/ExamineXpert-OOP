package com.teacherpaper;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.module.Module;
import com.module.ModuleDBUtil;
import com.paper.Paper;
import com.paper.PaperDBUtil;

@WebServlet("/TeacherDeletePaperServlet")
public class TeacherDeletePaperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tid = Integer.parseInt(request.getParameter("tid"));
		int mid = Integer.parseInt(request.getParameter("mid"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		boolean isTrue1 = PaperDBUtil.teacherDeletePaper(pid, mid);
		boolean isTrue2 = PaperDBUtil.teacherDeleteQuestions(pid, mid);
		
		if(isTrue1==true&&isTrue2==true) {

			List<Module> modDetails = ModuleDBUtil.getModuleDetails(mid);
			List<Paper> paperList = PaperDBUtil.getPapersList(mid);

		    request.setAttribute("modDetails", modDetails);
	        request.setAttribute("paperList", paperList);
		    RequestDispatcher dis = request.getRequestDispatcher("teacherpaperslist.jsp");
		    dis.forward(request, response);
		}
	}

}
