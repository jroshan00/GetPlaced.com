package com.infosys.servlet_simple_demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;

import com.infosys.servlet_simple_demo.entity.StudentEntity;
import com.infosys.servlet_simple_demo.exception.StudentException;
import com.infosys.servlet_simple_demo.services.StudentServices;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertStudentController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("---------doPost()------------");
		resp.setContentType("text/html");
		PrintWriter printWriter =resp.getWriter();
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		long phoneNo=Long.parseLong(req.getParameter("phone"));
		LocalDate date=LocalDate.parse(req.getParameter("date"));
		String gender=req.getParameter("gender");
		
		StudentEntity studentEntity=new StudentEntity();
		studentEntity.setId(id);
		studentEntity.setName(name);
		studentEntity.setEmail(email);
		studentEntity.setPassword(password);
		studentEntity.setPhone(phoneNo);
		studentEntity.setDate(date);
		studentEntity.setGender(gender);
		try {
			StudentServices.setStudentDetailsServices(studentEntity);
			printWriter.write("<html><body>");
			printWriter.write("<h1 style='color:green'>"+"Mr. "+name+" Thank You!! you have successfully completed the registration process");
			printWriter.write("</h1>");
			printWriter.write("</body></html>");
			RequestDispatcher requestDispacher=req.getRequestDispatcher("login.jsp");
			//requestDispacher.forward(req, resp);
			requestDispacher.include(req, resp);
			System.out.println(StudentServices.getStudentDetailsByIdServices(Integer.parseInt(req.getParameter("id"))).toString());
		} catch (StudentException | SQLException e) {
			printWriter.write("<html><body>");
			printWriter.write("<h1 style='color:red'>"+"Somethimg Went Wrong");
			printWriter.write("</h1>");
			printWriter.write("</body></html>");
			RequestDispatcher requestDispacher=req.getRequestDispatcher("login.jsp");
			//requestDispacher.forward(req, resp);
			requestDispacher.include(req, resp);
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		

	}

}
