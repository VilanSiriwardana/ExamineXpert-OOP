package com.paper;

public class Question {
	private int pid;
	private int mid;
	private int qid;
    private String question;
    private String tanswer;
    
    
    public Question(int pid, int mid, int qid, String question, String tanswer) {
		super();
		this.pid = pid;
		this.mid = mid;
		this.qid = qid;
		this.question = question;
		this.tanswer = tanswer;
	}
    
   

	public int getPid() {
		return pid;
	}
	
	public int getMid() {
		return mid;
	}
	
	public int getQid() {
		return qid;
	}

	public String getQuestion() {
		return question;
	}
	
	public String getTanswer() {
		return tanswer;
	}

}
