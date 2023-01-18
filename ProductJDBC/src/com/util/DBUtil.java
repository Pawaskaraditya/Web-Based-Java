package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static Connection con;
	
	public static void openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");// optional
		System.out.println("Driver Loaded....");
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3307/Product","root" , "root123");
		System.out.println("Connected to DB....");
	}
	
	public static Connection getCon() {
		return con;
	}
	
	public static void closeConnection() throws SQLException {
		
		if(con!=null) {
			con.close();
		}
		
	}
	
	
	
	

}
