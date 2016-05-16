package com.gupta.littlelouder.services.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Post {
	
	private int postId;
	private String status;
	private int upVote = 0;
	private int downVote = 0;
	private int userId;
	private String date;
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getUpVote() {
		return upVote;
	}
	public void setUpVote(int upVote) {
		this.upVote = upVote;
	}
	public int getDownVote() {
		return downVote;
	}
	public void setDownVote(int downVote) {
		this.downVote = downVote;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public Post() {
		super();
	}
	
	public Post(String status, int userId) {
		super();
		
		this.status = status;
		this.userId = userId;
		this.date = new SimpleDateFormat("dd-mm-yyyy").format(new Date());
	}
		
}
