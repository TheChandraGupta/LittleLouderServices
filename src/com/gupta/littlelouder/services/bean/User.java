package com.gupta.littlelouder.services.bean;

import java.text.SimpleDateFormat;
import java.util.Date;


public class User {
	
	private int userId;
	private String name;
	private String email;
	private String phone;
	private String password;
	private String type = "USER";
	private String DOJ;
	private String remember = "false";
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRemember() {
		return remember;
	}
	public void setRemember(String remember) {
		this.remember = remember;
	}
	public String getDOJ() {
		return DOJ;
	}
	public void setDOJ(String dOJ) {
		DOJ = dOJ;
	}
	
	public User() {
		super();
	}
	
	public User(String name, String email, String phone, String password) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.DOJ = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	}
	
	

}
