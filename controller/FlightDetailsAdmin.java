package com.flyaway.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.dao.FlightDetailsDao;
import com.flyaway.model.FlightDetails;

@WebServlet("/FlightDetailsAdmin")
public class FlightDetailsAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	FlightDetailsDao dao = new FlightDetailsDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			List<FlightDetails> ListFlightDetails = dao.selectAllFlightDetails();
			request.setAttribute("ListFlightDetails", ListFlightDetails);
			RequestDispatcher dispatcher = request.getRequestDispatcher("all-flight-details-admin.jsp");
			dispatcher.forward(request, response);
	

		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
}
