package com.teacher;

public class Teacher {

	private int tid;
	private String tname;
	private String temail;
	private String tconno;
	private String tusername;
	private String tpassword;
	
	
	public Teacher(int tid, String tname, String temail, String tconno, String tusername, String tpassword) {
		this.tid = tid;
		this.tname = tname;
		this.temail = temail;
		this.tconno = tconno;
		this.tusername = tusername;
		this.tpassword = tpassword;
	}


	public int getTid() {
		return tid;
	}

	public String getTname() {
		return tname;
	}

	public String getTemail() {
		return temail;
	}
	
	public String getTconno() {
		return tconno;
	}

	public String getTusername() {
		return tusername;
	}

	public String getTpassword() {
		return tpassword;
	}
	
}
