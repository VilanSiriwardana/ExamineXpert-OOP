package com.paper;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewQuestionsServlet")
public class ViewQuestionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String siD = request.getParameter("sid");
		String tiD = request.getParameter("tid");
		
		int mid = Integer.parseInt(request.getParameter("mid"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		if (siD != null && !siD.isEmpty()) {
			List<Question> QuestionList = PaperDBUtil.getStudentDoQuestions(pid, mid);
	        request.setAttribute("QuestionList", QuestionList);
	        request.setAttribute("siD", siD);
	        RequestDispatcher dis = request.getRequestDispatcher("studentdoquestions.jsp");
	        dis.forward(request, response);
		}
		
		else if(tiD != null && !tiD.isEmpty()) {
			List<Paper> PaperInfo = PaperDBUtil.getPaperInfo(pid);
			List<Question> QuestionList = PaperDBUtil.getStudentDoQuestions(pid, mid);
			
			request.setAttribute("PaperInfo", PaperInfo);
	        request.setAttribute("QuestionList", QuestionList);
	        request.setAttribute("tiD", tiD);
	        RequestDispatcher dis = request.getRequestDispatcher("teacherviewquestions.jsp");
	        dis.forward(request, response);
		}
	        
		
		
        
	}

}
