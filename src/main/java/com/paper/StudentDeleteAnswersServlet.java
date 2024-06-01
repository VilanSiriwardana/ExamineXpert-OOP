package com.paper;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentDeleteAnswersServlet")
public class StudentDeleteAnswersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the student's answers for each question and delete them from the database.
				int pid = Integer.parseInt(request.getParameter("pid"));
				int sid = Integer.parseInt(request.getParameter("sid"));
				int mid = Integer.parseInt(request.getParameter("mid"));
	
		        boolean isTrue = false;
                
                // Insert each answer into the database
				isTrue = PaperDBUtil.deleteStudentAnswers(pid, sid);
		        

		        if(isTrue==true) {
		        	request.setAttribute("pid", pid);
		        	request.setAttribute("sid", sid);
					RequestDispatcher dis = request.getRequestDispatcher("/ViewQuestionsServlet");
					dis.forward(request, response);
				}
				
				else {
					RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
					dis2.forward(request, response);
				}
			
	}

}
