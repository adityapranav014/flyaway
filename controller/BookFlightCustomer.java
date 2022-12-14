package com.flyaway.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyaway.dao.BookingDao;
import com.flyaway.model.Booking;
import com.flyaway.model.BookingAndCustomerDetails;
import com.flyaway.model.FlightDetails;

@WebServlet("/BookFlightCustomer")
public class BookFlightCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BookingDao dao = new BookingDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		// Session Management
		int id = Integer.parseInt(request.getParameter("fid"));

		HttpSession session = request.getSession();
		session.setAttribute("Flight_id", id);
		String email = (String) session.getAttribute("email");
		String date = (String) session.getAttribute("date");
		int noOfTravelers = (int) session.getAttribute("noOfTravelers");

		if (session.getAttribute("customerId") != null) {
			int customerId = (int) session.getAttribute("customerId");

			// initialize variable
			int flightId = 0;
			int flightNo = 0;
			String airline = null;
			String weekdays = null;
			String srcAirportCode = null;
			String destAirportCode = null;
			String classType = null;
			double fare = 0.00;

			List<FlightDetails> lft = (List<FlightDetails>) session.getAttribute("ListFlightDetails");

			for (FlightDetails values : lft) {
				flightId = values.getflightId();

				if (flightId == id) {
					flightNo = values.getFlightNo();
					airline = values.getAirline();
					weekdays = values.getWeekdays();
					srcAirportCode = values.getSrcAirportCode();
					destAirportCode = values.getDestAirportCode();
					classType = values.getClassType();
					fare = values.getFare();
				}
			}
			double totalFare = fare * noOfTravelers;
			Booking bookingDetails = new Booking(0, id, flightNo, email, classType, noOfTravelers, totalFare, airline,
					date, srcAirportCode, destAirportCode);

			if (dao.bookingDetails(bookingDetails, customerId) != 0) {
				doPost(request, response);
			} else {
				request.getRequestDispatcher("avilable-flights-customer.jsp").include(request, response);
				response.setContentType("text/html");
				out.println(
						"<h4 style='color:red;text-align:center;background-color:black'>Error in booking ticket<h4>");
			}
		} else {
			request.getRequestDispatcher("login-customer.jsp").include(request, response);
			response.setContentType("text/html");
			out.println(
					"<h4 style='color:black;text-align:center;background-color:white; margin-top:2%'>Please Login To Book Ticket<h4>");
		}
	}

	// getting booking data for ticket
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int customerId = (int) session.getAttribute("customerId");
		int flightId = (int) session.getAttribute("Flight_id");
		String date = (String) session.getAttribute("date");

		try {
			List<BookingAndCustomerDetails> ListTicketDetails = dao.ticketDetails(customerId, flightId, date);
			request.setAttribute("ListTicketDetails", ListTicketDetails);
			RequestDispatcher dispatcher = request.getRequestDispatcher("payment-ticket-details-customer.jsp");
			dispatcher.forward(request, response);

		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
}
