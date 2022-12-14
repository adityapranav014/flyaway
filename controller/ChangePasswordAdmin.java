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

@WebServlet("/ChangePasswordAdmin")
public class ChangePasswordAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ChangePasswordAdmin() {
        super();
      
    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		AdminDao dao = new AdminDao();

		String email = request.getParameter("email");
		String newpassword = request.getParameter("newpass");

		if (dao.newpasswordadmin(email, newpassword)) {

//			Session Management
			HttpSession session = request.getSession();
			session.removeAttribute("adminEmail");
			session.invalidate();
			response.sendRedirect("login-admin.jsp");

		} else {
			response.setContentType("text/html");
			request.getRequestDispatcher("change-password-admin.jsp").include(request, response);
			out.println("<h4 style='color:red;text-align:center;background-color:black'>Invalid Admin<h4>");
		}

	}

}
