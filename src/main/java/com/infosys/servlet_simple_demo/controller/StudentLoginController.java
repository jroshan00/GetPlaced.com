package com.infosys.servlet_simple_demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.infosys.servlet_simple_demo.dao.StudentDao;
import com.infosys.servlet_simple_demo.entity.StudentEntity;
import com.infosys.servlet_simple_demo.services.StudentServices;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class StudentLoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter=resp.getWriter();
		RequestDispatcher requestDispenser;
		String mail=req.getParameter("email");
		HttpSession session= req.getSession();
		StudentEntity studentEntity=new StudentEntity();
		studentEntity.setEmail(req.getParameter("email"));
		studentEntity.setPassword(req.getParameter("password"));
		try {
			if(StudentServices.isStudentCredentialValidationService(studentEntity) && session !=null) {
				session.setAttribute("studentEmail",mail);
				session.setMaxInactiveInterval(10);
				resp.sendRedirect("dashboard.jsp");
//				String[] str=StudentDao.getStudentDetailsByEmailDao(mail).getName().trim().split("\s+");
//				printWriter.write("Welcome Dear "+str[0]+"!");
//				requestDispenser=req.getRequestDispatcher("dashboard.jsp");
//				requestDispenser.include(req, resp);
				System.out.println("Login Success");
				return;
			}
			else {
				printWriter.write("Invalid Credential !!");
				requestDispenser=req.getRequestDispatcher("login.jsp");
				System.out.println(requestDispenser.toString());
				requestDispenser.include(req, resp);
				System.out.println("Invalid Credential !!");
				System.out.println("Login Failed");
			}
		} catch(SQLException e) {
			printWriter.write("Something Went Wrong !!");
			System.out.println("Something Went Wrong !!");
			requestDispenser=req.getRequestDispatcher("login.jsp");
			System.out.println(requestDispenser.toString());
			requestDispenser.include(req, resp);
			e.printStackTrace();
		}
	}

}
