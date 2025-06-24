package com.infosys.servlet_simple_demo.services;

import java.sql.SQLException;

import com.infosys.servlet_simple_demo.dao.StudentDao;
import com.infosys.servlet_simple_demo.entity.StudentEntity;
import com.infosys.servlet_simple_demo.entity.StudentMessage;
import com.infosys.servlet_simple_demo.exception.StudentException;

public class StudentServices {
	
	/*
	 * @Author : Roshan Pandey
	 * 
	 * <> setStudentDetailsServices(StudentEntity studentMessage) <> 
	 * return 0  : when condition satisfied
	 * throws custom exception named StudentException in case condition is not satisfied
	 */
	public static int setStudentDetailsServices(StudentEntity studentEntity) throws StudentException, SQLException{
		if(!(studentEntity.getName().isEmpty()) && 
			!(studentEntity.getPassword().isEmpty()) && 
			!(studentEntity.getEmail().isEmpty()) && 
			!(studentEntity.getGender().isEmpty()) && 
			(studentEntity.getPhone()+"").length()==10 && 
			(studentEntity.getId()+"").length()>2 && 
			(studentEntity.getId()+"").length()<5){
			
			StudentDao.setStudentDetailsDao(studentEntity);
			return 0;
		}else {
			throw new StudentException("Invalid StudentEntity");
		}
	}
	
	/*
	 * 
	 * <> getStudentDetailsByIdServices(int id) throws StudentException <> 
	 * if condition is true return instanceOf StudentEntity
	 * else return null
	 * 
	 */
	public static StudentEntity getStudentDetailsByIdServices(int id) throws StudentException{
		if(id>100 && id<=9999) {
			return StudentDao.getStudentDetailsByIdDao(id);
		}else {
			throw new StudentException("Inavlid Id");
		}
	}
	
	/*
	 * <> setStudentMessageService(StudentMessage studentMessage) throws StudentException <>
	 * return 0  : when condition satisfied
	 * throws custom exception named StudentException in case condition is not satisfied
	 */
	
	public static int setStudentMessageService(StudentMessage studentMessage) throws StudentException {
		if(!(studentMessage.getName().isEmpty()) && !(studentMessage.getMessage().isEmpty()) && !(studentMessage.getEmail().isEmpty())){
			StudentDao.setStudentMessageDao(studentMessage);
			return 0;
		}else {
			throw new StudentException("Inavlid StudentMessage");
		}
		
	}
	
	/*
	 * <> isStudentCredentialValidationService(StudentEntity studentEntity) throws SQLException <>
	 * return 0  : when condition satisfied
	 * throws custom exception named StudentException in case condition is not satisfied
	 */
	public static boolean isStudentCredentialValidationService(StudentEntity studentEntity) throws SQLException{
		if(studentEntity.getEmail()==null || studentEntity.getPassword()==null) {
			System.out.println("Query Not Executed");
			return false;
		}else if(studentEntity.getEmail().isEmpty()|| studentEntity.getPassword().isEmpty()) {
			System.out.println("Query Not Executed");
			return false;
		}else if(studentEntity.getEmail().isBlank()|| studentEntity.getPassword().isBlank()) {
			System.out.println("Query Not Executed");
			return false;
		}
		return StudentDao.isStudentCredentialValidationDao(studentEntity);
	}

}
