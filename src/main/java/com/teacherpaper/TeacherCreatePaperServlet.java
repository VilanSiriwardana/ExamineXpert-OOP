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


@WebServlet("/TeacherCreatePaperServlet")
public class TeacherCreatePaperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//CreatePaperServlet Method 1
		
				String[] qids = request.getParameterValues("qid");
				String[] questions = request.getParameterValues("question");
		        String[] tanswers = request.getParameterValues("tanswer");
		        
		        int mid = Integer.parseInt(request.getParameter("mid"));
		        String pname = request.getParameter("pname");
		        
		     // Insert each Questions into the database
		        int pid = PaperDBUtil.teacherInsertPaper(mid, pname);
		        boolean isTrue = false;
		        
		        if (qids != null && tanswers != null && qids.length == tanswers.length) {
		            for (int i = 0; i < qids.length; i++) {
		                int qid = Integer.parseInt(qids[i]);
		                String question = questions[i];
		                String tanswer = tanswers[i];
		                
		                // Insert each Questions into the database
						isTrue = PaperDBUtil.teacherInsertQuestions(pid, mid, qid, question, tanswer);
						
						
		            }
		        }
		        
		        else {
		        	System.out.println("Null Values");
		        }
		        
		        if(isTrue==true) {
		    		List<Paper> paperList = PaperDBUtil.getPapersList(mid);	
		    		request.setAttribute("paperList", paperList);
					RequestDispatcher dis = request.getRequestDispatcher("teacherpaperslist.jsp");
					dis.forward(request, response);
				}
				
				else {
					RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
					dis2.forward(request, response);
				}
		    
		
		
		
		
		
		
		/*
		//CreatePaperServlet Method 2
		//int mid = Integer.parseInt(request.getParameter("mid"));
		String mid = request.getParameter("mid");
        String pname = request.getParameter("pname");
        int numQuestions = Integer.parseInt(request.getParameter("numQuestions"));

        System.out.println(mid + pname);
        
        if (mid != null && !mid.isEmpty()) {
            int midInt = Integer.parseInt(mid);

        }
        
        else {
        	System.out.println("Null MID");
        }

        //int pid = PaperDBUtil.teacherInsertPaper(mid, pname);
        
        boolean isTrue = false;

        try {
            for (int i = 1; i <= numQuestions; i++) {
            	//int qid = Integer.parseInt(request.getParameter("qid" + i));
            	String qid = request.getParameter("qid" + i);
                String question = request.getParameter("question" + i);
                String tanswer = request.getParameter("tanswer" + i);

                if (qid != null && !qid.isEmpty()) {
                    int qidInt = Integer.parseInt(qid);

                    // Insert each question and answer into the database
                    //isTrue = PaperDBUtil.teacherInsertQuestions(pid, qidInt, question, tanswer);
                }
                
                else {
                	System.out.println("Null String QID");
                }
            }
        }
        
        catch (Exception e) {
        	
        }
            if (isTrue == true) {
            
            response.sendRedirect("success.jsp");
        } 
            
            else {
            // Handle the case where the paper insertion failed
            response.sendRedirect("unsuccess.jsp");
        }
		
		*/
		
		
		
		
		
		
        
	}
	


}
