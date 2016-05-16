package com.gupta.littlelouder.services.json;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class VoteJSON {
	
	public String constructJSON(int upVote, boolean like, boolean status) {
		
		JSONArray array = new JSONArray();
		try {
			
			JSONObject obj = new JSONObject();

			obj.put("upvote", upVote);
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
