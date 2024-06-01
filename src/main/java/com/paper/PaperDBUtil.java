package com.paper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.student.DBConnect;
import com.teacherpaper.Result;


public class PaperDBUtil {
	//Create static variables for connection
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static boolean isSuccess = false;
	private static PreparedStatement  pstmt = null;
	
	
	
	

	//Method to retrieve papers list
			public static List<Paper> getPapersList(int mid){
				ArrayList<Paper> paper = new ArrayList<>();
				
				try {
					con = DBConnect.getConnection();
					stmt = con.createStatement();
					String sql = "select * from paper where mid='"+mid+"'";
					rs = stmt.executeQuery(sql);
					
					while(rs.next()) {
						int pId = rs.getInt(1);
						int mId = rs.getInt(2);
						String pName = rs.getString(3);
						
						Paper p = new Paper(pId, mId, pName);
						
						paper.add(p);
					}
				}
				
				catch(Exception e) {
					e.printStackTrace();
				}
				
				
				return paper;
		    }
			
			
			
			
			
			
			
			

			//Method to retrieve paper questions
				public static List<Question> getStudentDoQuestions(int pid, int mid){
					ArrayList<Question> ques = new ArrayList<>();
					
					try {
						con = DBConnect.getConnection();
						stmt = con.createStatement();
						String sql = "select * from question where pid='"+pid+"' and mid='"+mid+"'";
						rs = stmt.executeQuery(sql);
						
						while(rs.next()) {
							int pId = rs.getInt("pid");
							int mId = rs.getInt("mid");
							int qId = rs.getInt("qid");
							String qUestion = rs.getString("question");
							String tAnswer = rs.getString("tanswer");
						
							
							Question q = new Question(pId, mId, qId, qUestion, tAnswer);
							
							ques.add(q);
						}
					}
					
					catch(Exception e) {
						e.printStackTrace();
					}
					
					
					return ques;
			    }
				
				
			
			
	
	

		
		
		
		
		
		

		//Method to insert Student Answers
		public static boolean insertStudentAnswer(int pid, int mid, int qid, int sid, String sanswer) {
			isSuccess=false;
			
			try {
				con = DBConnect.getConnection();
				
				if (con != null) {
			        System.out.println("Database connection established successfully.");
			    } else {
			        System.err.println("Failed to establish a database connection.");
			        
			    }
				
				stmt = con.createStatement();

				String sql = "insert into studentanswer values ('"+pid+"', '"+mid+"', '"+qid+"', '"+sid+"','"+sanswer+"')";
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
	
		
		
			
			
			
		
			
			//Method to retrieve student answer
			public static List<Answer> getStudentAnswers(int pid, int sid){
				ArrayList<Answer> ans = new ArrayList<>();
					
				try {
					con = DBConnect.getConnection();
					stmt = con.createStatement();
					String sql = "select * from studentanswer where pid='"+pid+"' and sid='"+sid+"'";
					rs = stmt.executeQuery(sql);
						
					while(rs.next()) {
						int pId = rs.getInt("pid");
						int mId = rs.getInt("mid");
						int qId = rs.getInt("qid");
						int sId = rs.getInt("sid");
						String sAnswer = rs.getString("sanswer");
						
							
						Answer a = new Answer(pId, mId, qId, sId, sAnswer);
							
						ans.add(a);
					}
				}
					
				catch(Exception e) {
					e.printStackTrace();
				}
					
				
				return ans;
				
			}
			
			
			
			
			
			//Update Student Answers
			public static boolean updateStudentAnswers(int pid, int qid, String sanswer) {
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
					String sql = "update studentanswer set sanswer='"+sanswer+"' where pid='"+pid+"' and qid='"+qid+"'";
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
			
			
			
			
			

			//Delete Student Answers
			public static boolean deleteStudentAnswers(int pid, int sid) {
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
					String sql = "delete from studentanswer where pid='"+pid+"' and sid='"+sid+"'";
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
			
			
			
			
			
			
			
			//Method to Insert Paper 
			public static int teacherInsertPaper(int mid, String pname) {
				isSuccess=false;
				 int pid = -1; 
				 
				try {
					con = DBConnect.getConnection();
					
					if (con != null) {
				        System.out.println("Database connection established successfully.");
				    } else {
				        System.err.println("Failed to establish a database connection.");
				        
				    }
					
					
					String sql = "insert into paper values (0, '"+mid+"', '"+pname+"')";
					
					//retrieve any auto-generated keys after executing the query.
			        pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			        
			        int rs1 = pstmt.executeUpdate();

			        rs = pstmt.getGeneratedKeys();
			        
			        if (rs.next()) {
			            pid = rs.getInt(1); // Get the generated pid
			        }
			        
			        if(rs1>0) {
						isSuccess=true;
					}
					else {
						isSuccess=false;
					}
					
					
					/*
					stmt = con.createStatement();
					
					String sql1 = "insert into paper values (0, '"+mid+"', "+pname+"')";
					System.out.println("SQL Query: " + sql1);

					
					int rs1 = stmt.executeUpdate(sql1);
					
					
					if(rs1>0) {
						isSuccess=true;
					}
					else {
						isSuccess=false;
					}
					*/
					
				}
				
				catch(Exception e) {
					System.err.println("Error while connecting to the database: " + e.getMessage());
					e.printStackTrace();
				}
				
				
				return pid;
				
			
			}
			
			
			
			
			
			
			
			
			
			//Method to Insert Questions 
			public static boolean teacherInsertQuestions(int pid, int mid, int qid, String question, String tanswer) {
				isSuccess=false;
				
				try {
					con = DBConnect.getConnection();
					
					if (con != null) {
				        System.out.println("Database connection established successfully.");
				    } else {
				        System.err.println("Failed to establish a database connection.");
				        
				    }
					
					stmt = con.createStatement();
					

					String sql = "insert into question values('"+pid+"', '"+mid+"', '"+qid+"', '"+question+"', '"+tanswer+"')";
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
			
			
			
			
			

			//Method to retrieve paper Info
				public static List<Paper> getPaperInfo(int pid){
					ArrayList<Paper> paper = new ArrayList<>();
					
					try {
						con = DBConnect.getConnection();
						stmt = con.createStatement();
						String sql = "select * from paper where pid='"+pid+"'";
						rs = stmt.executeQuery(sql);
						
						while(rs.next()) {
							int pId = rs.getInt("pid");
							int qId = rs.getInt("mid");
							String pName = rs.getString("pname");
						
							
							Paper p = new Paper(pId, qId, pName);
							
							paper.add(p);
						}
					}
					
					catch(Exception e) {
						e.printStackTrace();
					}
					
					
					return paper;
			    }
				
				
				
				
				
				
				
				
				//Method to Update Paper Details
				public static boolean teacherUpdatePaperDetails(int pid, int mid, String pname) {
					
					try {
						con = DBConnect.getConnection();
						stmt = con.createStatement();
						
						String sql = "update paper set pid="+pid+", mid="+mid+", pname='"+pname+"' where pid="+pid+"";
						
						int rs = stmt.executeUpdate(sql);
						
						if(rs>0) {
							isSuccess=true;
						}
						
						else {
							isSuccess=false;
						}
						
					}
					
					catch(Exception e) {
						e.printStackTrace();
					}
					return isSuccess;
				}
				
				
				
				//Method to Update Questions
				public static boolean teacherUpdateQuestions(int pid, int mid, int qid, String question, String tanswer) {
					
					try {
						con = DBConnect.getConnection();
						stmt = con.createStatement();
						
						String sql = "update question set pid="+pid+", mid="+mid+", qid="+qid+", question='"+question+"', tanswer='"+tanswer+"' where pid="+pid+" and mid="+mid+" and qid="+qid+"";
						int rs = stmt.executeUpdate(sql);
						
						if(rs>0) {
							isSuccess=true;
						}
						
						else {
							isSuccess=false;
						}
						
					}
					
					catch(Exception e) {
						e.printStackTrace();
					}
					
					return isSuccess;
				}
				
			
			
				
				
				//Method to Delete Paper
				public static boolean teacherDeletePaper(int pid, int mid) {
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
						String sql = "delete from paper where pid='"+pid+"' and mid='"+mid+"'";
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
				
				
				
				
				
				//Method to Delete Questions
				public static boolean teacherDeleteQuestions(int pid, int mid) {
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
						String sql = "delete from question where pid='"+pid+"' and mid='"+mid+"'";
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
			
			
			
				
				
				
				
				//Calcualte Results
				public static boolean calculateResults(int pid, int mid, int sid){
					// Create an ArrayList to hold student objects
					ArrayList<Result> res = new ArrayList<>();
					int mark = 0;
					
					//Validate
					try {
						
						// Establish a database connection
						con = DBConnect.getConnection();
						
						// Create a SQL statement
						Statement stmt1 = con.createStatement();
						Statement stmt2 = con.createStatement();
						
						// Construct the SQL query
						String sql1 = "select tanswer from question where pid="+pid+" and mid="+mid+"";
						System.out.println("SQL Query 1: " + sql1);
						
						String sql2 = "select sanswer from studentanswer where pid="+pid+" and mid="+mid+" and sid="+sid+"";
						System.out.println("SQL Query 2: " + sql2);
						
						
						ResultSet rs1 = null;
						ResultSet rs2 = null;

						rs1 = stmt1.executeQuery(sql1);
						rs2 = stmt2.executeQuery(sql2);
						
					
						while (rs1.next() && rs2.next()) {
						    String tanswer = rs1.getString("tanswer");
						    String sanswer = rs2.getString("sanswer");
						    
						    System.out.println("Tanswer: "+ tanswer + " == Sanswer: "+ sanswer + "??");

						    // Compare tanswer and sanswer and take appropriate action
						    if (sanswer != null && sanswer.equals(tanswer)) {
						        mark+=1;
						        System.out.println("Marks = "+ mark);
						    }
						}
						
						
						//Calculate Score 
						int count = 0;

						try {
							Statement stmt3 = con.createStatement();
							String sql3 = "select count(qid) from question where pid="+pid+" and mid="+mid+""; 
						    ResultSet rs3 = stmt3.executeQuery(sql3);

						    if (rs3.next()) {
						        count = rs3.getInt(1); // Assuming the count is in the first column (column index 1)
						    }
						    
						    // Close the ResultSet and Statement when done
						    rs3.close();
						    stmt3.close();
						} catch (SQLException e) {
						    e.printStackTrace();
						}
						
						
						System.out.println("No. of Questions = "+ count);
						
						float score = ((float)mark/count)*100;
						System.out.println("("+mark+"/"+count+")*100");
						System.out.println("score = "+ score);
						
						
						
						//Determine Grade
						String grade;
						
						if(score>75) 
							grade = "A";
						
						else if(score>65) 
							grade = "B";
						
							else if(score>55) 
								grade = "C";
							
						
								else if(score>35) 
									grade = "S";
								
									else
										grade = "F";
						
						
						System.out.println("Grade = "+ grade);
						
						
						
						
						//Insert Results
						
						Statement stmt4 = con.createStatement();
						String sql4 = "insert into result values("+pid+", "+mid+", "+sid+", "+score+", '"+grade+"')";
						
						int rs4 = stmt4.executeUpdate(sql4);
						
						if(rs4>0) {
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
				
				
				
				
				
				
				
				
				
				//Mehtod to get Results
				public static List<Result> getStudentResults(int pid, int mid, int sid){
					ArrayList<Result> results = new ArrayList<>();
	
					try {
						con = DBConnect.getConnection();
						stmt = con.createStatement();
						String sql = "select * from result where pid="+pid+" and mid="+mid+" and sid="+sid+"";
						rs = stmt.executeQuery(sql);
							
						while(rs.next()) {
							int pId = rs.getInt("pid");
							int mId = rs.getInt("mid");
							int sId = rs.getInt("sid");
							int sCore = rs.getInt("score");
							String Grade = rs.getString("grade");
							
								
							Result r = new Result(pId, mId, sId, sCore, Grade);
								
							results.add(r);
						}
					}
						
					catch(Exception e) {
						e.printStackTrace();
					}
						
					
					return results;
					
				}
				
				
				
				
				

						
			
}
