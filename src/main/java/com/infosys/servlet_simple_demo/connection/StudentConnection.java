package com.infosys.servlet_simple_demo.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class StudentConnection {
	
	public static Connection getStudentConnection() {
		
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			String url="jdbc:mysql://localhost:3306/jdbc-a7-weekdays";
			String userName="root";
			String password="B2pandit18@";
		
			Connection connection=DriverManager.getConnection(url, userName, password);
			return connection;
		
		}
		 catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				return null;
			}
			
		
	}

}
