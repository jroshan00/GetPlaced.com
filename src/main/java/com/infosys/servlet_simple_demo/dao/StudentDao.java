package com.infosys.servlet_simple_demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

import com.infosys.servlet_simple_demo.connection.StudentConnection;
import com.infosys.servlet_simple_demo.entity.StudentEntity;
import com.infosys.servlet_simple_demo.entity.StudentMessage;

public class StudentDao {

	private static Connection connection = StudentConnection.getStudentConnection();

	public static void setStudentDetailsDao(StudentEntity se) throws SQLException {
		final String insertQuery = "INSERT INTO STUDENT(id,name,email,password,phone,dob,gender) VALUES(?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
		preparedStatement.setInt(1, se.getId());
		preparedStatement.setString(2, se.getName());
		preparedStatement.setString(3, se.getEmail());
		preparedStatement.setString(4, se.getPassword());
		preparedStatement.setLong(5, se.getPhone());
		preparedStatement.setDate(6, Date.valueOf(se.getDate()));
		preparedStatement.setString(7, se.getGender());
		int x = preparedStatement.executeUpdate();
		if (x > 0) {
			System.out.println("Query Executed");
		} else {
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
			preparedStatement.setInt(1, id);
			ResultSet set = preparedStatement.executeQuery();
			while (set.next()) {
				studentEntity.setId(id);
				studentEntity.setName(set.getString("name"));
				studentEntity.setEmail(set.getString("email"));
				studentEntity.setPassword(set.getString("password"));
				studentEntity.setPhone(set.getLong("phone"));
				studentEntity.setDate(set.getDate("dob").toLocalDate());
				studentEntity.setGender(set.getString("gender"));
			}
			return studentEntity;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		}
	}
	
	public static StudentEntity getStudentDetailsByEmailDao(String email) {
		if (connection == null) {
			return null;
		}
		final String GET_BY_ID_QUERY = "SELECT * FROM STUDENT WHERE email=?";
		try {
			StudentEntity studentEntity = new StudentEntity();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID_QUERY);
			email=email.toLowerCase();
			preparedStatement.setString(1, email);
			ResultSet set = preparedStatement.executeQuery();
			while (set.next()) {
				studentEntity.setId(set.getInt("id"));
				studentEntity.setName(set.getString("name"));
				studentEntity.setEmail(email);
				studentEntity.setPassword(set.getString("password"));
				studentEntity.setPhone(set.getLong("phone"));
				studentEntity.setDate(set.getDate("dob").toLocalDate());
				studentEntity.setGender(set.getString("gender"));
			}
			return studentEntity;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		}
	}

	public static void setStudentMessageDao(StudentMessage studentMessage) {

		final String insertQuery = "INSERT INTO messages(name, email, message) VALUES (?, ?, ?)";

		try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);) {
			preparedStatement.setString(1, studentMessage.getName());
			preparedStatement.setString(2, studentMessage.getEmail());
			preparedStatement.setString(3, studentMessage.getMessage());
			int x = preparedStatement.executeUpdate();
			if (x > 0) {
				System.out.println("Query Executed");
			} else {
				System.out.println("Query Not Executed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static boolean isStudentCredentialValidationDao(StudentEntity studentEntity) throws SQLException {
		final String getStudentDataQuery = "SELECT email,password FROM STUDENT";
		try (Statement statement = connection.createStatement();) {
			ResultSet set = statement.executeQuery(getStudentDataQuery);
			System.out.println("Query Executed");
			while (set.next()) {
				if (set.getString("email").equalsIgnoreCase(studentEntity.getEmail())
						&& set.getString("password").equalsIgnoreCase(studentEntity.getPassword()))
					return true;
			}
		}
		return false;
	}

	/*
	 * Not in service
	 */
	public static List<StudentEntity> getListOfStudentDao() {

		List<StudentEntity> l1 = new ArrayList<>();
		if (connection == null) {
			System.out.println("DB Connection is failled !!");
			return null;
		}

		final String GET_TABLE_DATA_QUERY = "SELECT * FROM STUDENT";

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(GET_TABLE_DATA_QUERY);
			while (resultSet.next()) {
				StudentEntity studentEntity = new StudentEntity();
				studentEntity.setId(resultSet.getInt("id"));
				studentEntity.setName(resultSet.getString("name"));
				studentEntity.setEmail(resultSet.getString("email"));
				studentEntity.setGender(resultSet.getString("gender"));
				studentEntity.setPhone(resultSet.getLong("phone"));
				studentEntity.setDate((resultSet.getDate("dob").toLocalDate()));
				studentEntity.setPassword(resultSet.getString("password"));
				l1.add(studentEntity);
			}
			return l1;
		} catch (SQLException e) {
			System.out.println(e.getStackTrace());
			return null;
		}
	}

	/*
	 * Not in service
	 */
	public static boolean deleteStudentDataDao(int id) {
		final String deleteQuery = "DELETE FROM STUDENT WHERE id=?";

		try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);) {
			preparedStatement.setInt(1, id);
			int x = preparedStatement.executeUpdate();
			if (x > 0) {
				return true;
			}
			return false;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	/*
	 * Not in service
	 */
	public static boolean updateStudentDataDao(int id, StudentEntity studentEntity) {
		final String updateQuery = "UPDATE STUDENT SET name=?,email=?,phone=?,dob=?,gender=?,password=? where id=?";

		try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);) {
			preparedStatement.setString(1, studentEntity.getName());
			preparedStatement.setString(2, studentEntity.getEmail());
			preparedStatement.setLong(3, studentEntity.getPhone());
			preparedStatement.setObject(4, studentEntity.getDate());
			preparedStatement.setString(5, studentEntity.getGender());
			preparedStatement.setString(6, studentEntity.getPassword());
			preparedStatement.setInt(7, id);
			int x = preparedStatement.executeUpdate();
			if (x > 0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

}
