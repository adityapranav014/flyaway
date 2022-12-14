package com.flyaway.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyaway.dao.CustomerDao;

@WebServlet("/LoginCustomer")
public class LoginCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		CustomerDao dao = new CustomerDao();

		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		
		

		if (dao.check(email,password) != 0) {
			int customerId = dao.check(email,password);
//			Session Management
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			session.setAttribute("customerId", customerId);
			response.sendRedirect("home-customer.jsp");
		} else {
			response.setContentType("text/html");
			request.getRequestDispatcher("login-customer.jsp").include(request, response);
			out.println("<h4 style='color:red;text-align:center;background-color:black;margin-top:3rem'>Invalid User<h4>");
		}

	}

}
