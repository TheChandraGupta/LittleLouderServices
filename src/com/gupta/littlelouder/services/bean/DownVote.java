package com.gupta.littlelouder.services.bean;

public class DownVote {
	
	private int downVoteId;
	private int userId;
	private int postId;
	
	public int getDownVoteId() {
		return downVoteId;
	}
	public void setDownVoteId(int downVoteId) {
		this.downVoteId = downVoteId;
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
	
	public DownVote() {
		super();
	}
	public DownVote(int userId, int postId) {
		super();
		this.userId = userId;
		this.postId = postId;
	}
	
}
