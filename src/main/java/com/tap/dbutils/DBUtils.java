package com.tap.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;

final public class DBUtils {
	
	private static String url = "jdbc:mysql://localhost:3306/online_food_delivery"; // Added '//' after 'mysql:'
	private static String username = "root";
	private static String password = "12345";
	private static Connection connection = null;

	public static Connection myConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection=DriverManager.getConnection(url,username,password);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

}