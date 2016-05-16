package com.gupta.littlelouder.services.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.gupta.littlelouder.services.bean.Post;
import com.gupta.littlelouder.services.database.DBManager;

public class PostData {
	
	public void addPost(Post post) {
		
		String query = "insert into post "
				+ "(status, upvote, downvote, userid, date) "
				+ "values ("
				+ "'"+post.getStatus()+"',"
						+ post.getUpVote() + ","
								+ post.getDownVote() + ","
										+ post.getUserId() + ","
												+ "'" + post.getDate() + "')";
		
		DBManager db = new DBManager();
		
		try {

			System.out.println(query);
			
			db.getSt().executeUpdate(query);
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		db.close();
		
	}
	
	public Post latestPost() {
		
		Post post = new Post();
		
		String query = "select * from post order by postid desc limit 1";
		
		DBManager db = new DBManager();
		ResultSet rs;
		
		try {
			System.out.println(query);
			
			rs = db.getSt().executeQuery(query);
			
			while(rs.next()) {
				
				post.setPostId(rs.getInt("postid"));
				post.setStatus(rs.getString("status"));
				post.setUpVote(rs.getInt("upvote"));
				post.setDownVote(rs.getInt("downvote"));
				post.setUserId(rs.getInt("userid"));
				post.setDate(rs.getString("date"));
				
			}
			
			rs.close();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		db.close();
		
		return post;
		
	}
	
	public int like(int postId, int userId) {
		
		int upVote = 0;
		String query1 = "update post set upvote = upvote + 1 where postid = " + postId;
		String query2 = "insert into upvote "
				+ "(userid, postid) values "
				+ "(" + userId + ", " + postId + ")";
		String query3 = "select * from post where postid=" + postId;
		
		DBManager db = new DBManager();
		ResultSet rs;
		
		try {
			
			System.out.println(query1);
			db.getSt().executeUpdate(query1);
			
			System.out.println(query2);
			db.getSt().executeUpdate(query2);
			
			System.out.println(query3);
			rs = db.getSt().executeQuery(query3);
			
			while(rs.next()) {
				
				upVote = rs.getInt("upvote");
				
			}
			
			rs.close();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		db.close();
		
		return upVote;
		
	}
	
	public int disLike(int postId, int userId) {
		
		int upVote = 0;
		String query1 = "update post set upvote = upvote - 1 where postid = " + postId;
		String query2 = "delete from upvote where userid=" + userId + " and postid=" + postId;
		String query3 = "select * from post where postid=" + postId;
		
		DBManager db = new DBManager();
		ResultSet rs;
		
		try {
			
			System.out.println(query1);
			db.getSt().executeUpdate(query1);
			
			System.out.println(query2);
			db.getSt().executeUpdate(query2);
			
			System.out.println(query3);
			rs = db.getSt().executeQuery(query3);
			
			while(rs.next()) {
				
				upVote = rs.getInt("upvote");
				
			}
			
			rs.close();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		db.close();
		
		return upVote;
		
	}
	
	public boolean checkVote(int postId, int userId) {
		boolean check = false;
		
		DBManager db = new DBManager();
		ResultSet rs;
		
		String query = "select * from upvote where userid=" + userId + " and postid=" + postId;
		
		try {
			
			System.out.println(query);
			rs = db.getSt().executeQuery(query);
			
			while(rs.next()) {
				check = true;
			}
			
			rs.close();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		db.close();
		
		return check;
	}

}
