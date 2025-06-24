package com.infosys.servlet_simple_demo.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

import com.infosys.servlet_simple_demo.connection.StudentConnection;
import com.infosys.servlet_simple_demo.entity.StudentEntity;
import com.infosys.servlet_simple_demo.entity.StudentMessage;

public class StudentDao {
	
	private static Connection connection=StudentConnection.getStudentConnection();
	
	public static  void setStudentDetailsDao(StudentEntity se)throws SQLException{
		final String insertQuery="INSERT INTO STUDENT(id,name,email,password,phone,dob,gender) VALUES(?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement=connection.prepareStatement(insertQuery);
		preparedStatement.setInt(1,se.getId());
		preparedStatement.setString(2,se.getName());
		preparedStatement.setString(3,se.getEmail());
		preparedStatement.setString(4,se.getPassword());
		preparedStatement.setLong(5,se.getPhone());
		preparedStatement.setDate(6,Date.valueOf(se.getDate()));
		preparedStatement.setString(7,se.getGender());
		int x=preparedStatement.executeUpdate();
		if(x>0) {
			System.out.println("Query Executed");
		}else {
			System.out.println("Query Not Executed");
		}
	}
	
	
	public static StudentEntity getStudentDetailsByIdDao(int id) {
		if (connection == null) {
			return null;
		}
		final String GET_BY_ID_QUERY = "SELECT * FROM STUDENT WHERE id=?";
		try {
			StudentEntity studentEntity = new StudentEntity();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID_QUERY);
			preparedStatement.setInt(1,id);
			ResultSet set = preparedStatement.executeQuery();
			while(set.next()){
				studentEntity.setId(id);
				studentEntity.setName(set.getString("name"));
				studentEntity.setEmail(set.getString("email"));
				studentEntity.setPassword(set.getString("password"));
				studentEntity.setPhone(set.getLong("phone"));
				studentEntity.setDate(set.getDate("dob").toLocalDate());
				studentEntity.setPassword(set.getString("gender"));
			}
			return studentEntity;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		}
	}
	
	public static void setStudentMessageDao(StudentMessage studentMessage) {
		
		final String insertQuery="INSERT INTO messages(name, email, message) VALUES (?, ?, ?)";
		
		try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);){
			preparedStatement.setString(1,studentMessage.getName());
			preparedStatement.setString(2,studentMessage.getEmail());
			preparedStatement.setString(3,studentMessage.getMessage());
			int x=preparedStatement.executeUpdate();
			if(x>0) {
				System.out.println("Query Executed");
			}else {
				System.out.println("Query Not Executed");
			}
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	
	public static boolean isStudentCredentialValidationDao(StudentEntity studentEntity) throws SQLException{
		final String getStudentDataQuery="SELECT email,password FROM STUDENT";
		try(Statement statement=connection.createStatement();){
			ResultSet set=statement.executeQuery(getStudentDataQuery);
			System.out.println("Query Executed");
			while(set.next()) {
				if(set.getString("email").equalsIgnoreCase(studentEntity.getEmail()) && set.getString("password").equalsIgnoreCase(studentEntity.getPassword()))
					return true;
			}
		}
		return false;
	}

}
