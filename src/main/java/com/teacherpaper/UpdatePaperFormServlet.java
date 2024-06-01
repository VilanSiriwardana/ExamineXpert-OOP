package com.teacherpaper;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.paper.Paper;
import com.paper.PaperDBUtil;
import com.paper.Question;

@WebServlet("/UpdatePaperFormServlet")
public class UpdatePaperFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tid = Integer.parseInt(request.getParameter("tid"));
		int mid = Integer.parseInt(request.getParameter("mid"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		List<Paper> PaperInfo = PaperDBUtil.getPaperInfo(pid); 
		List<Question> QuestionList = PaperDBUtil.getStudentDoQuestions(pid, mid);
		
		request.setAttribute("PaperInfo", PaperInfo);
		request.setAttribute("QuestionList", QuestionList);
		
		RequestDispatcher dis = request.getRequestDispatcher("teacherupdatepaperform.jsp");
		dis.forward(request, response);
		
	}

}
