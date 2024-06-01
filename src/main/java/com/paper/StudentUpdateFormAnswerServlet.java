package com.paper;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentUpdateFormAnswerServlet")
public class StudentUpdateFormAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("pid"));
		int sid = Integer.parseInt(request.getParameter("sid"));
		int mid = Integer.parseInt(request.getParameter("mid"));
		
		List<Question> QuestionList = PaperDBUtil.getStudentDoQuestions(pid, mid);
		List<Answer> stuAnswers = PaperDBUtil.getStudentAnswers(pid, sid);
		
		request.setAttribute("QuestionList", QuestionList);
        request.setAttribute("stuAnswers", stuAnswers);
        
        RequestDispatcher dis = request.getRequestDispatcher("studentupdateanswers.jsp");
        dis.forward(request, response);
		
	}

}
