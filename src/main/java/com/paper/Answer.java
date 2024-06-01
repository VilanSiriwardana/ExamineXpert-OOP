package com.paper;

public class Answer {
	private int pid;
	private int mid;
	private int qid;
	private int sid;
    private String sanswer;
    
	public Answer(int pid, int mid, int qid, int sid, String sanswer) {
		super();
		this.pid = pid;
		this.mid = mid;
		this.qid = qid;
		this.sid = sid;
		this.sanswer = sanswer;
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

	public int getSid() {
		return sid;
	}

	public String getSanswer() {
		return sanswer;
	}
    
	
	
    
    
    
}
