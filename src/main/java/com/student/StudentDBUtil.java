package com.student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDBUtil {
	//Create static variables for connection
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static boolean isSuccess = false;
	
	
	
	//Method to Retrieve all student data
	public static List<Student> getStudentAllDetails(){
		ArrayList<Student> stu = new ArrayList<>();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from student";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int sid = rs.getInt(1);
				String sname = rs.getString(2);
				String semail = rs.getString(3);
				String susername = rs.getString(4);
				String spassword = rs.getString(5);
				
				Student s = new Student(sid, sname, semail, susername, spassword);
				
				stu.add(s);
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return stu;
    }
	
	
	
	
	
	
	
	
	//Method to retrieve student details by id
	public static List<Student> getStudentDetails(int sid){
		ArrayList<Student> stu = new ArrayList<>();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from student where sid='"+sid+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int sId = rs.getInt(1);
				String sname = rs.getString(2);
				String semail = rs.getString(3);
				String susername = rs.getString(4);
				String spassword = rs.getString(5);
				
				Student s = new Student(sId, sname, semail, susername, spassword);
				
				stu.add(s);
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return stu;
    }
	
	
	
	
	
	
	
			
			
			
	
	
	
	
	
	
		
		
		

		//Method to insert Student Answers
		public static boolean insertStudentAnswer(int pid, int qid, String sanswer) {
			isSuccess=false;
			
			try {
				con = DBConnect.getConnection();
				
				if (con != null) {
			        System.out.println("Database connection established successfully.");
			    } else {
			        System.err.println("Failed to establish a database connection.");
			        
			    }
				
				stmt = con.createStatement();

				String sql = "insert into studentanswer values ('"+pid+"', '"+qid+"', '"+sanswer+"')";
				System.out.println("SQL Query: " + sql);
				
				int rs = stmt.executeUpdate(sql);
				
				if(rs>0) {
					isSuccess=true;
				}
				else {
					isSuccess=false;
				}

				
			}
			
			catch(Exception e) {
				System.err.println("Error while connecting to the database: " + e.getMessage());
				e.printStackTrace();
			}
			
			
			return isSuccess;
		}
	
}
