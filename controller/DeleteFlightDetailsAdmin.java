package com.flyaway.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.dao.FlightDetailsDao;

@WebServlet("/DeleteFlightDetailsAdmin")
public class DeleteFlightDetailsAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

//	created new instance    
    FlightDetailsDao dao = new FlightDetailsDao();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		dao.deleteFlight(id);
		response.sendRedirect("FlightDetailsAdmin");	
	}

}
