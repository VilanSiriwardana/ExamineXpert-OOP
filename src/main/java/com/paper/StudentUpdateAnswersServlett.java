package com.paper;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/StudentUpdateAnswersServlett")
public class StudentUpdateAnswersServlett extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the student's answers for each question and update them into the database.
		
	 	String[] qids = request.getParameterValues("qid");
        String[] sanswers = request.getParameterValues("sanswer");
        int pid = Integer.parseInt(request.getParameter("pid"));
        boolean isTrue = false;
        if (qids != null && sanswers != null && qids.length == sanswers.length) {
            for (int i = 0; i < qids.length; i++) {
                int qid = Integer.parseInt(qids[i]);
                String sanswer = sanswers[i];
                
                // Insert each answer into the database
				isTrue = PaperDBUtil.updateStudentAnswers(pid, qid, sanswer);

				
            }
        }
        
        if(isTrue==true) {
        	request.setAttribute("pid", pid);
			RequestDispatcher dis = request.getRequestDispatcher("/StudentViewAnswersServlet");
			dis.forward(request, response);
		}
		
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
	}

}
