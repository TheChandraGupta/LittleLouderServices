package com.gupta.littlelouder.services.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	
	private String DRIVER = "com.mysql.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost:3306/louder";
	private String USER = "root";
	private String PASS = "root";
	
	private Connection con;
	private Statement st;
	
	public DBManager() {
		
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASS);
			st = con.createStatement();
		}
		catch(ClassNotFoundException e) {
			con = null;
			e.printStackTrace();
		}
		catch(SQLException e) {
			con = null;
			e.printStackTrace();
		}
		
	}
	
	public Connection getCon() {
		return con;
	}

	public Statement getSt() {
		return st;
	}
	
	public void closeCon() {
		
		try {
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void closeSt() {
		
		try {
			st.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void close() {
	
	try {
		con.close();
		st.close();
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	
}
	
}
