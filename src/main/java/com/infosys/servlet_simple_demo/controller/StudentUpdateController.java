package com.infosys.servlet_simple_demo.controller;

import java.io.IOException;
import java.time.LocalDate;

import com.infosys.servlet_simple_demo.dao.StudentDao;
import com.infosys.servlet_simple_demo.entity.StudentEntity;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/updateStudent")
public class StudentUpdateController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentEntity studentEntity=new StudentEntity();
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		long phoneNo=Long.parseLong(req.getParameter("phone"));
		LocalDate date=LocalDate.parse(req.getParameter("date"));
		String gender=req.getParameter("gender");
		
		studentEntity.setId(id);
		studentEntity.setName(name);
		studentEntity.setEmail(email);
		studentEntity.setPassword(password);
		studentEntity.setPhone(phoneNo);
		studentEntity.setDate(date);
		studentEntity.setGender(gender);
		System.out.println(studentEntity.toString());
		System.out.println(StudentDao.updateStudentDataDao(id, studentEntity)?"Query Executed" : "Query Not Executed");
		resp.sendRedirect("student-edit-delete.jsp");
		System.out.println("================================================================");
	}
	

}
