package com.gupta.littlelouder.services.json;

import java.util.ArrayList;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.gupta.littlelouder.services.bean.Comment;

public class CommentJSON {
	
	public String constructJSON(ArrayList<Comment> cmt) {
		
		JSONArray array = new JSONArray();
		
		int i = 0;
		
		try {
			
			
			for(i= 0; i < cmt.size(); i++) {
				
				JSONObject obj = new JSONObject();
				
				Comment comment = cmt.get(i);
				
				obj.put("commentid", comment.getCommentId());
				obj.put("message", comment.getMessage());
				obj.put("userid", comment.getUserId());
				obj.put("postid", comment.getPostId());
				
				array.put(obj);
				/*
				
				System.out.print("commentid" + comment.getCommentId());
				System.out.print("message" + comment.getMessage());
				System.out.print("userid" + comment.getUserId());
				System.out.println("postid" + comment.getPostId());
				System.out.println("OBJ:"+obj);
				System.out.println("ARRAY:"+array);
				*/
			}
			/*
			for(i= 0; i < cmt.size(); i++) {
			
				Comment comment = cmt.get(i);
				
				System.out.println("commentid" + comment.getCommentId());
				System.out.println("message" + comment.getMessage());
				System.out.println("userid" + comment.getUserId());
				System.out.println("postid" + comment.getPostId());
			
				//array.put(obj);
			
			}*/
						
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		
		return array.toString();
		
	}

}
