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
import com.flyaway.model.Customer;

@WebServlet("/RegisterCustomer")
public class RegisterCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		CustomerDao dao = new CustomerDao();

		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		String mobileNo = request.getParameter("mobileno");

		Customer cust = new Customer(firstName, lastName, email, password, mobileNo);

		if (dao.saveCustomer(cust) > 0 && !firstName.isEmpty() && !lastName.isEmpty() && !password.isEmpty()
				&& !mobileNo.isEmpty()) {

			HttpSession session = request.getSession();
			session.setAttribute("user", cust);
			response.sendRedirect("login-customer.jsp");
		} else {

			response.setContentType("text/html");
			request.getRequestDispatcher("registration-customer.jsp").include(request, response);
			out.println("<h4 style='color:red;text-align:center;background-color:black'>Invalid Input<h4>");
		}

	}

	

}
