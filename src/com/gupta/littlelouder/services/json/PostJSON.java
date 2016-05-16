package com.gupta.littlelouder.services.json;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.gupta.littlelouder.services.bean.Post;

public class PostJSON {
	
	public String constructJSON(Post post, boolean status, boolean like) {
		
		JSONArray array = new JSONArray();
		try {
			
			JSONObject obj = new JSONObject();

			obj.put("postid", post.getPostId());
			obj.put("post", post.getStatus());
			obj.put("upvote", post.getUpVote());
			obj.put("downvote", post.getDownVote());
			obj.put("userid", post.getUserId());
			obj.put("date", post.getDate());
			obj.put("like", like);
			obj.put("status", status);
			
			array.put(obj);
			
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		
		return array.toString();
		
	}
	

}
