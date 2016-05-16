package com.gupta.littlelouder.services.bean;

public class UpVote {
	
	private int upVoteId;
	private int userId;
	private int postId;
	
	public int getUpVoteId() {
		return upVoteId;
	}
	public void setUpVoteId(int upVoteId) {
		this.upVoteId = upVoteId;
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
	
	public UpVote() {
		super();
	}
	public UpVote(int userId, int postId) {
		super();
		this.userId = userId;
		this.postId = postId;
	}
		

}
