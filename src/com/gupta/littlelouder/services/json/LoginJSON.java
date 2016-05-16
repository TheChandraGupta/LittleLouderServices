package com.gupta.littlelouder.services.json;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.gupta.littlelouder.services.bean.User;

public class LoginJSON {
	
	public String constructJSON(User user, boolean status) {
		
		JSONArray array = new JSONArray();
		try {
			
			JSONObject obj = new JSONObject();
			
			obj.put("userId", user.getUserId());
			obj.put("name", user.getName());
			obj.put("email", user.getEmail());
			obj.put("phone", user.getPhone());
			obj.put("password", user.getPassword());
			obj.put("type", user.getType());
			obj.put("doj", user.getDOJ());
			obj.put("remember", user.getRemember());
			obj.put("status", status);

			array.put(obj);
			
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		
		return array.toString();
		
	}

}
