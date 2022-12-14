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


@WebServlet("/ChangePasswordCustomer")
public class ChangePasswordCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		CustomerDao dao = new CustomerDao();

		String email = request.getParameter("email");
		String newpassword = request.getParameter("newpass");

		if (dao.newpasswordCustomer(email, newpassword)) {

//			Session Management
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			response.sendRedirect("login-customer.jsp");

		} else {
			response.setContentType("text/html");
			request.getRequestDispatcher("change-password-customer.jsp").include(request, response);
			out.println("<h4 style='color:red;text-align:center;background-color:black'>Invalid Customer<h4>");
		}
	}

}
