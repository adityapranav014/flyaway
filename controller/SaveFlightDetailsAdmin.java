package com.flyaway.controller;

import java.io.IOException;
import com.flyaway.dao.FlightDetailsDao;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyaway.model.FlightDetails;

@WebServlet("/SaveFlightDetails")
public class SaveFlightDetailsAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		FlightDetailsDao dao = new FlightDetailsDao();

		int flightNo = Integer.parseInt(request.getParameter("fno"));
		String airline = request.getParameter("airline");
		String[] weekdaysjsp = request.getParameterValues("weekdays");
		String weekdays = Arrays.toString(weekdaysjsp);
		String srcAirportCode = request.getParameter("src");
		String destAirportCode = request.getParameter("dest");
		String classType = request.getParameter("class");
		double fare = Double.parseDouble(request.getParameter("fare"));

		FlightDetails fd = new FlightDetails(0, flightNo, airline, weekdays, srcAirportCode, destAirportCode, classType,
				fare);

		if (dao.saveFlightDetails(fd) > 0 && !airline.isEmpty()) {

			HttpSession session = request.getSession();
			session.setAttribute("fd", fd);

			response.sendRedirect("FlightDetailsAdmin");

		} else {
			request.getRequestDispatcher("save-flightdetails-admin.jsp").include(request, response);
			response.setContentType("text/html");
			out.println("<h4 style='color:red;text-align:center;background-color:black'>Invalid Input<h4>");
		}
	}

}
