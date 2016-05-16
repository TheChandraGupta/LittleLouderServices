package com.gupta.littlelouder.services.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gupta.littlelouder.services.bean.Comment;
import com.gupta.littlelouder.services.database.DBManager;

public class CommentData {
	
	public void addComment(Comment comment) {
		
		DBManager db = new DBManager();
		
		String query = "insert into comment "
				+ "(message, userid, postid) values"
				+ "('" + comment.getMessage() + "', "
						+ comment.getUserId() + ", "
								+ comment.getPostId() + ")";
		
		try {
			
			System.out.println(query);
			db.getSt().executeUpdate(query);
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		db.close();
		
	}
	
	public ArrayList<Comment> allComment(int postId) {

		//Comment[] comment = new Comment[];
		ArrayList<Comment> comment = new ArrayList<Comment>();
		
		DBManager db = new DBManager();
		ResultSet rs;
		
		int i = 0;
		String query = "select * from comment where postid=" + postId + " order by commentid desc";
		try {

			System.out.println(query);
			rs = db.getSt().executeQuery(query);
			
			//rs.last();
			//System.out.println(rs.getRow());
			//comment = new Comment[rs.getRow()];
						
			//rs.beforeFirst();
					
			i = 0;
			
			while(rs.next()) {
				Comment cmt = new Comment();
				cmt.setCommentId(rs.getInt("commentid"));
				cmt.setMessage(rs.getString("message"));
				cmt.setUserId(rs.getInt("userid"));
				cmt.setPostId(rs.getInt("postid"));
				comment.add(i, cmt);
				i++;
			}
			
			rs.close();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		db.close();

		//System.out.println(comment);
		
		return comment;
		
	}

}
