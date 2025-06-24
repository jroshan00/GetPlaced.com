package com.infosys.servlet_simple_demo.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import com.infosys.servlet_simple_demo.entity.StudentMessage;
import com.infosys.servlet_simple_demo.exception.StudentException;
import com.infosys.servlet_simple_demo.services.StudentServices;

public class StudentMessageController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter printWriter=resp.getWriter();
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String message=req.getParameter("message");
		
		StudentMessage studentMessage=new StudentMessage();
		studentMessage.setName(name);
		studentMessage.setEmail(email);
		studentMessage.setMessage(message);
		try {
			StudentServices.setStudentMessageService(studentMessage);
		} catch (StudentException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		printWriter.write("<html><body>");
		printWriter.write("<h1 style='color:green'>"+"Thank you for reaching out to us!!!");
		printWriter.write("</h1>");
		printWriter.write("</body></html>");
		
	}

}
