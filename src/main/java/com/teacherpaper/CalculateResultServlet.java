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
import com.student.Student;
import com.student.StudentDBUtil;

@WebServlet("/CalculateResultServlet")
public class CalculateResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sid = Integer.parseInt(request.getParameter("sid"));
		int mid = Integer.parseInt(request.getParameter("mid"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		boolean isTrue1 = PaperDBUtil.calculateResults(pid, mid, sid);
		
		List<Result> StuResults = PaperDBUtil.getStudentResults(pid, mid, sid);
		List<Student> StuDetails = StudentDBUtil.getStudentDetails(sid);
		List<Paper> PaperDetails = PaperDBUtil.getPaperInfo(pid);
		List<Module> ModDetails = ModuleDBUtil.getModuleDetails(mid);
		
		

        request.setAttribute("StuResults", StuResults);
        request.setAttribute("StuDetails", StuDetails);
        request.setAttribute("PaperDetails", PaperDetails);
        request.setAttribute("ModDetails", ModDetails);
        RequestDispatcher dis = request.getRequestDispatcher("studentpaperresult.jsp");
        dis.forward(request, response);
	}

}
