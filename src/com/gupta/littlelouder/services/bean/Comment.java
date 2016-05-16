package com.gupta.littlelouder.services.bean;

public class Comment {
	
	private int commentId;
	private String message;
	private int userId;
	private int postId;
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	
	
	public Comment() {
		super();
	}
	public Comment(String message, int userId, int postId) {
		super();
		this.message = message;
		this.userId = userId;
		this.postId = postId;
	}
		
}
