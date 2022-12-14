package com.flyaway.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.dao.FlightDetailsDao;
import com.flyaway.model.FlightDetails;

@WebServlet("/UpdateFlightDetailsAdmin")
public class UpdateFlightDetailsAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		FlightDetailsDao dao = new FlightDetailsDao();

		int flightId = Integer.parseInt(request.getParameter("id"));
		int flightNo = Integer.parseInt(request.getParameter("fno"));
		String airline = request.getParameter("airline");
		String[] weekdaysjsp = request.getParameterValues("weekdays");
		String weekdays = Arrays.toString(weekdaysjsp);
		String srcAirportCode = request.getParameter("src");
		String destAirportCode = request.getParameter("dest");
		String classType = request.getParameter("class");
		double fare = Double.parseDouble(request.getParameter("fare"));

		FlightDetails ufd = new FlightDetails(flightId, flightNo, airline, weekdays, srcAirportCode, destAirportCode, classType,
				fare);
		dao.updateFlightDetails(ufd);
		response.sendRedirect("FlightDetailsAdmin");	
	}

}
