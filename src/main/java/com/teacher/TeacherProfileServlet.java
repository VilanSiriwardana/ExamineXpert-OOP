package com.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TeacherProfileServlet")
public class TeacherProfileServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	String tid = request.getParameter("tid");
        
        try {
            List<Teacher> teachDetails = TeacherDBUtill.TeacherProfile(tid);
            
            if (teachDetails != null && !teachDetails.isEmpty()) {
                int teacherId = teachDetails.get(0).getTid();
                request.setAttribute("tid", tid);
            }
            
            request.setAttribute("teachDetails", teachDetails);
            RequestDispatcher dis = request.getRequestDispatcher("TeacherProfile.jsp");
            dis.forward(request, response);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
