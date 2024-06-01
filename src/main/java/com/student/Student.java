package com.student;

public class Student {
	private int sid;
	private String sname;
    private String semail;
    private String susername;
    private String spassword;
    
    
    public Student(int sid, String sname, String semail, String susername, String spassword) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.semail = semail;
		this.susername = susername;
		this.spassword = spassword;
	}

    
    public int getSid() {
		return sid;
	}


	public String getSname() {
		return sname;
	}


	public String getSemail() {
		return semail;
	}


	public String getSusername() {
		return susername;
	}


	public String getSpassword() {
		return spassword;
	}
	
	
	

}
