package com.flyaway.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyaway.dao.BookingDao;
import com.flyaway.model.BookingAndCustomerDetails;

@WebServlet("/DashboardAllBookingCustomer")
public class DashboardAllBookingCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BookingDao dao = new BookingDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// HTTP Session Management
		HttpSession session = request.getSession();
		int customerId = (int) session.getAttribute("customerId");
		try {
			List<BookingAndCustomerDetails> ListAllBookingDetails = dao.selectAllBookingDetails(customerId);
			request.setAttribute("ListAllBookingDetails", ListAllBookingDetails);
			RequestDispatcher dispatcher = request.getRequestDispatcher("all-booking-details-customer.jsp");
			dispatcher.forward(request, response);

		} catch (ServletException e) {
			e.printStackTrace();
		}

	}
}
