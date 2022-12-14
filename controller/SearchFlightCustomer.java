package com.flyaway.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyaway.dao.FlightDetailsDao;
import com.flyaway.model.FlightDetails;

@WebServlet("/SearchFlightCustomer")
public class SearchFlightCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	FlightDetails fd = null;
	FlightDetailsDao dao = new FlightDetailsDao();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String srcAirportCode = request.getParameter("src");
		String destAirportCode = request.getParameter("dest");
		String date = request.getParameter("date");
		int noOfTravelers = Integer.parseInt(request.getParameter("noOfTravelers"));

		// Session Management
		HttpSession session = request.getSession();
		session.setAttribute("date", date);
		session.setAttribute("noOfTravelers", noOfTravelers);

		// Date Format Conversion
		String weekdays = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", java.util.Locale.ENGLISH);
		try {
			Date myDate = sdf.parse(date);
			sdf.applyPattern("EEE");
			weekdays = sdf.format(myDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		fd = new FlightDetails(0, 0, null, weekdays, srcAirportCode, destAirportCode, null, 0.0);

		if (dao.searchFlightDetails(fd).size() > 0) {
			doGet(request, response);
		} else {
			request.getRequestDispatcher("booking-customer.jsp").include(request, response);
			response.setContentType("text/html");
			out.println("<h4 style='color:red;text-align:center;background-color:black;margin-top:3rem'>Flights Not Available<h4>");
		}
	}

	// For Table output
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			List<FlightDetails> ListFlightDetails = dao.searchFlightDetails(fd);
			request.setAttribute("ListFlightDetails", ListFlightDetails);
			RequestDispatcher dispatcher = request.getRequestDispatcher("avilable-flights-customer.jsp");
			dispatcher.forward(request, response);
			
			// Session Management
			HttpSession session = request.getSession();
			session.setAttribute("ListFlightDetails", ListFlightDetails);

		} catch (ServletException e) {
			e.printStackTrace();
		}

	}
}
