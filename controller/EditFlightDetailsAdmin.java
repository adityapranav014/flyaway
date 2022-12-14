package com.flyaway.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.dao.FlightDetailsDao;
import com.flyaway.model.FlightDetails;


@WebServlet("/EditFlightDetailsAdmin")
public class EditFlightDetailsAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//	created new instance    
    FlightDetailsDao dao = new FlightDetailsDao();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		FlightDetails existingFD = dao.selectUser(id);
		RequestDispatcher rd = request.getRequestDispatcher("edit-flight-details-form-admin.jsp");
		request.setAttribute("efd", existingFD);
		rd.forward(request, response);
	}

}
