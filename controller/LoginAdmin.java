package com.flyaway.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyaway.dao.AdminDao;

@WebServlet("/LoginAdmin")
public class LoginAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		AdminDao dao = new AdminDao();

		String email = request.getParameter("email");
		String password = request.getParameter("pass");

		if (dao.checkadmin(email, password)) {

//			Session Management using HttpSession
			HttpSession session = request.getSession();
			session.setAttribute("adminEmail", email);
			response.sendRedirect("home-admin.jsp");

		} else {
			response.setContentType("text/html");
			request.getRequestDispatcher("login-admin.jsp").include(request, response);
			out.println("<h4 style='color:red;text-align:center;background-color:black; margin-top:5%'>Invalid Admin<h4>");
		}

	}

}
