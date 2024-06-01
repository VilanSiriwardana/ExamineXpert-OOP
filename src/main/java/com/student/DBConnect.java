package com.student;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	//Create Database Connection
	private static String url = "jdbc:mysql://localhost:3306/examinexpert";
	private static String user = "root";
	private static String pass = "oop1234";
	private static Connection con;
	
	public static Connection getConnection() {
		try {
			// Load the MySQL JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// Establish a database connection
			con = DriverManager.getConnection(url, user, pass);
		}
		
		catch (Exception e) {
			System.out.println("Database COnnection Unsuccessful!!");
		}
		
		return con;
	}
	
}
