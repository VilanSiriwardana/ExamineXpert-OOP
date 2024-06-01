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

@WebServlet("/TeacherUpdatePaperServlet")
public class TeacherUpdatePaperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tid = Integer.parseInt(request.getParameter("tid"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		int mid = Integer.parseInt(request.getParameter("mid"));
		String pname = request.getParameter("pname");
		
		String[] qids = request.getParameterValues("qid");
		String[] questions = request.getParameterValues("question");
		String[] tanswers = request.getParameterValues("tanswer");
		
		boolean isTrue1 = PaperDBUtil.teacherUpdatePaperDetails(pid, mid, pname); 
		boolean isTrue2 = false;
		
		if(qids!=null && tanswers!=null && qids.length==tanswers.length) {
			for(int i = 0; i < qids.length; i++) {
				int qid = Integer.parseInt(qids[i]);
				String question = questions[i];
				String tanswer = tanswers[i];
				
				isTrue2 = PaperDBUtil.teacherUpdateQuestions(pid, mid, qid, question, tanswer);
			}
		}
		
		if(isTrue2==true) {
			List<Paper> PaperInfo = PaperDBUtil.getPaperInfo(pid);
			List<Question> QuestionList = PaperDBUtil.getStudentDoQuestions(pid,  mid);
			
			request.setAttribute("PaperInfo", PaperInfo);
	        request.setAttribute("QuestionList", QuestionList);
	        RequestDispatcher dis = request.getRequestDispatcher("teacherviewquestions.jsp");
	        dis.forward(request, response);
		}
		
		
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
		
	}

}
