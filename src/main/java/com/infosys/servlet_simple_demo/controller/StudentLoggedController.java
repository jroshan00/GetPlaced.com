package com.infosys.servlet_simple_demo.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value ="/student-details")
public class StudentLoggedController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);

		if (session == null || session.getAttribute("studentEmail") == null) {
			resp.sendRedirect("login.jsp");
			return;
		}
		String email = (String) session.getAttribute("studentEmail");
		System.out.println("Fetched email: " + email);
		req.setAttribute("studentEmail", email);
		req.getRequestDispatcher("student-details.jsp").forward(req, resp);
	}

}
