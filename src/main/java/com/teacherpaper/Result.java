package com.teacherpaper;

public class Result {

	private int pid;
	private int mid;
	private int sid;
    private int score;
    private String grade;
    
	public Result(int pid, int mid, int sid, int score, String grade) {
		super();
		this.pid = pid;
		this.mid = mid;
		this.sid = sid;
		this.score = score;
		this.grade = grade;
	}

	public int getPid() {
		return pid;
	}

	public int getMid() {
		return mid;
	}

	public int getSid() {
		return sid;
	}

	public int getScore() {
		return score;
	}

	public String getGrade() {
		return grade;
	}
    
    
	
	
	
    
}
