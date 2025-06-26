package com.infosys.servlet_simple_demo.controller;

import java.io.IOException;

import com.infosys.servlet_simple_demo.dao.StudentDao;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet(value = "/deleteStudent")
public class StudentDeleteController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		System.out.println("Id fetched is : "+id);
		System.out.println(StudentDao.deleteStudentDataDao(id)?"Query Executed":"Query Not Executed");
		resp.sendRedirect("deleteStudent.jsp");
	}
}
