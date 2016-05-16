package com.gupta.littlelouder.services.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.gupta.littlelouder.services.bean.User;
import com.gupta.littlelouder.services.database.DBManager;

public class UserData {

	public User checkLogin(String email, String password) {
		
		//boolean status = false;
		String query = ""; 
		
		DBManager db = new DBManager();
		ResultSet rs = null;
		
		User user = null;
		
		try {
			query = "select * from user where email='"+email+"' and password='"+password+"'";
			
			System.out.println(query);
			
			rs = db.getSt().executeQuery(query);
			
			while(rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("userid"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setPassword(rs.getString("password"));
				user.setType(rs.getString("type"));
				user.setDOJ(rs.getString("doj"));
				user.setRemember(rs.getString("remember"));
				//status = true;
			}
			
			rs.close();
						
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
			
		db.close();
		
		return user;
	}
	
	public int validateUser(String email) {
		
		String query = "";
		int userId = 0;
		
		DBManager db = new DBManager();
		ResultSet rs = null;
			
		try {
			query = "select * from user where email='"+email+"'";
					
			System.out.println(query);
					
			rs = db.getSt().executeQuery(query);
					
			while(rs.next()) {
				userId = rs.getInt("userid");
			}
				
			rs.close();
							
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
					
		db.close();
				
		return userId;
		
	}

	public String validatePassword(int userId) {
		
		String query = "";
		String password = "";
		
		DBManager db = new DBManager();
		ResultSet rs = null;
		
		try {
			query = "select * from user where userid='"+userId+"'";
				
			System.out.println(query);
				
			rs = db.getSt().executeQuery(query);
				
			while(rs.next()) {
				password = rs.getString("password");
			}
			
			rs.close();
						
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
				
		db.close();
			
		return password;
	
	}
	
	public void changeOldPassword(int userId, String password) {
		
		String query = "";
		
		DBManager db = new DBManager();
		
		try {
			query = "update user "
					+ "set password='"+password+"' "
							+ "where userid="+userId;
				
			System.out.println(query);
				
			db.getSt().executeUpdate(query);
										
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
				
		db.close();
		
	}
	
	public void newUser(User user) {
		
		String query = "";
		
		DBManager db = new DBManager();
		//ResultSet rs = null;
		
		try {
			query = "insert into user "
					+ "(name, email, phone, password, type, doj, remember) "
					+ "values "
					+ "('"+user.getName()+"', '"+user.getEmail()+"', '"+user.getPhone()+"', "
							+ "'"+user.getPassword()+"', '"+user.getType()+"', '"+user.getDOJ()+"', '"+user.getRemember()+"')";
			
			System.out.println(query);
			
			db.getSt().executeUpdate(query);
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		db.close();
		
	}
	
}
