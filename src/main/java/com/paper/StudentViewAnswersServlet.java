package com.paper;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/StudentViewAnswersServlet")
public class StudentViewAnswersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("pid"));
		int sid = Integer.parseInt(request.getParameter("sid"));
		
		List<Answer> stuAnswers = PaperDBUtil.getStudentAnswers(pid, sid);
        request.setAttribute("stuAnswers", stuAnswers);
        RequestDispatcher dis = request.getRequestDispatcher("studentanswers.jsp");
        dis.forward(request, response);
		
	}

}
