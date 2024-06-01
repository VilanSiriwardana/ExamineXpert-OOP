package com.teacher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.student.DBConnect;
import com.student.Student;

public class TeacherDBUtill {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static boolean isSuccess = false;

	public static List<Teacher> TeacherLoginValidate(String tusername, String tpassword){
		
		ArrayList<Teacher> teach = new ArrayList<>();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "SELECT * "
					   + "FROM teacher "
					   + "WHERE tusername='"+tusername+"' "
					   + "AND tpassword='"+tpassword+"'";
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				int tid = rs.getInt(1);
				String tname = rs.getString(2);
				String temail = rs.getString(3);
				String tconno = rs.getString(4);
				String tuser = rs.getString(5);
				String tpass = rs.getString(6);
				
				Teacher t = new Teacher(tid, tname, temail, tconno, tuser, tpass);
				teach.add(t);
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return teach;
	}
	
	
	
	
	public static List<Teacher> TeacherProfile(String tid) {
	    ArrayList<Teacher> teach = new ArrayList<>();
	    
	    try {
	        con = DBConnect.getConnection();
	        stmt = con.createStatement();
	        
	        String sql = "SELECT * FROM teacher WHERE tid='"+tid+"'";
	        rs = stmt.executeQuery(sql);
	        
	        if (rs.next()) {
	            int tiD = rs.getInt(1);
	            String name = rs.getString(2);
	            String email = rs.getString(3);
	            String contactNo = rs.getString(4);
	            String userT = rs.getString(5);
	            String passT = rs.getString(6);
	            
	            Teacher t = new Teacher(tiD, name, email, contactNo, userT, passT);
	            teach.add(t);
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return teach;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static boolean TeacherRegisterValidate(String tname, String temail, String tconno, String tusername, String tpassword) {
		
		isSuccess = false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "INSERT INTO teacher "
					   + "VALUES (0, '"+tname+"', '"+temail+"', '"+tconno+"', '"+tusername+"', '"+tpassword+"')";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
    			isSuccess = true;
    		} else {
    			isSuccess = false;
    		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	
	
	public static boolean TeacherProfileUpdateValidate(String tid,String tname, String temail, String tconno, String tusername, String tpassword) {
		
		isSuccess = false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "UPDATE teacher "
					   + "SET tname='"+tname+"', temail='"+temail+"', tconno='"+tconno+"', tusername='"+tusername+"', tpassword='"+tpassword+"' "
					   + "WHERE tid='"+tid+"'";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
    			isSuccess = true;
    		} else {
    			isSuccess = false;
    		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	
	public static List<Teacher> getTeacherDetails(String tid){
		
		int covertID = Integer.parseInt(tid);
		
		ArrayList<Teacher> tArray = new ArrayList<>();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "SELECT * "
					   + "FROM teacher "
					   + "WHERE tid = '"+covertID+"'";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getNString(2);
				String email = rs.getNString(3);
				String contactNo = rs.getNString(4);
				String username = rs.getNString(5);
				String password = rs.getNString(6);
				
				Teacher t = new Teacher(id, name, email, contactNo, username, password);
				
				tArray.add(t);
			}
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
		
		return tArray;
	}
	
	
	
	public static boolean TeacherProfileDeleteValidate(String id) {
		
		int tid = Integer.parseInt(id);
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "DELETE FROM teacher "
					   + "WHERE tid = '"+tid+"'";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
    			isSuccess = true;
    		} else {
    			isSuccess = false;
    		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	
	
	
	
	
	
	//Method to retrieve all teachers
	public static List<Teacher> getTeacherList(){
		ArrayList<Teacher> teach = new ArrayList<>();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from teacher";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int tid = rs.getInt("tid");
				String tname = rs.getString("tname");
				String temail = rs.getString("temail");
				String tconno = rs.getString("tconno");
				String tusername = rs.getString("tusername");
				String tpassword = rs.getString("tpassword");
				
				Teacher t = new Teacher(tid, tname, temail, tconno, tusername, tpassword);
				
				teach.add(t);
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return teach;
    }
}
