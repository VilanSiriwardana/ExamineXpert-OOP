package com.module;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.student.DBConnect;

public class ModuleDBUtil {
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static boolean isSuccess = false;
	
	
	
	
	//Method to Create Module
	public static boolean createModule(String mname, String mdes, String mcode) {
		boolean isSuccess = false;
		try {
			con = DBConnect.getConnection();
			

			if (con != null) {
		        System.out.println("Database connection established successfully.");
		    } else {
		        System.err.println("Failed to establish a database connection.");
		    }
			
			
			stmt = con.createStatement();
			
			String sql = "insert into module values(0, '"+mname+"', '"+mdes+"', '"+mcode+"')";
			System.out.println("SQL Query: " + sql);
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess = true;
			}
			
			else {
				isSuccess = false;
			}
			
			
		}
		
		catch(Exception e) {
			System.err.println("Error while connecting to the database: " + e.getMessage());
			e.printStackTrace();
		}
		
		
		return isSuccess;
	}
	
	
	
	
	
	//Method to Retrieve Module List
	public static List<Module> getModuleList(){
		ArrayList<Module> mods = new ArrayList<>();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "select * from module";
			System.out.println("SQL Query: " + sql);
			rs = stmt.executeQuery(sql);
			
			

			while(rs.next()) {
				int mId = rs.getInt("mid");
				String mName = rs.getString("mname");
				String mDes = rs.getString("mdes");
				String mCode = rs.getString("mcode");
				
				Module m = new Module(mId, mName, mDes, mCode);
				
				mods.add(m);
			}
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return mods;
	}
	
	
	
	
	
	//Method to get Module Details
	public static List<Module> getModuleDetails(int mid){
		ArrayList<Module> mods = new ArrayList<>();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "select * from module where mid='"+mid+"'";
			System.out.println("SQL Query: " + sql);
			rs = stmt.executeQuery(sql);
			
			

			while(rs.next()) {
				int mId = rs.getInt("mid");
				String mName = rs.getString("mname");
				String mDes = rs.getString("mdes");
				String mCode = rs.getString("mcode");
				
				Module m = new Module(mId, mName, mDes, mCode);
				
				mods.add(m);
			}
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return mods;
	}
	
	
	
	
	
	
	
	//Update Module data
	public static boolean teacherUpdateModule(int mid, String mname, String mdes, String mcode) {
		try {
			// Establish a database connection
			con = DBConnect.getConnection();
			
			if (con != null) {
		        System.out.println("Database connection established successfully.");
		    } else {
		        System.err.println("Failed to establish a database connection.");
		        // Handle the connection failure, throw an exception, or provide an error message to the user.
		    }
			
			
			// Create a SQL statement
			stmt = con.createStatement();
			
			// Construct the SQL query
			String sql = "update module set mname='"+mname+"', mdes='"+mdes+"', mcode='"+mcode+"' where mid='"+mid+"'";
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
	
	
	
	
	
	
	
	//Method to Delete Module
	public static boolean teacherDeleteModule(int mid) {
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "delete from module where mid='"+mid+"'";
			System.out.println("SQL Query: " + sql);
			int rs = stmt.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess = true;
			}
			
			else {
				isSuccess = false;
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	
	
	
	
	
	
	
	
}
