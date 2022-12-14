package com.flyaway.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flyaway.model.Booking;
import com.flyaway.model.BookingAndCustomerDetails;

public class BookingDao {

	// SQL Connection
	private Connection conn;

	// default constructor
	public BookingDao() {
		conn = DBConfig.getConnection();
	}

//	Insert flight details into DB
	public int bookingDetails(Booking bookingDetails, int customerId) {

		try {
			PreparedStatement stat = conn.prepareStatement("insert into booking_table"
					+ "(flight_id, flight_no, email, travel_class, no_of_passengers, total_fare, airline, date, src, dest, customer_id) values (?,?,?,?,?,?,?,?,?,?,?)");

			stat.setInt(1, bookingDetails.getFlightId());
			System.out.println("from dao" + bookingDetails.getFlightId());
			stat.setInt(2, bookingDetails.getFlightNo());
			stat.setString(3, bookingDetails.getEmail());
			stat.setString(4, bookingDetails.getTravelClass());
			stat.setInt(5, bookingDetails.getNoOfPassenger());
			stat.setDouble(6, bookingDetails.getTotalFare());
			stat.setString(7, bookingDetails.getAirline());
			stat.setString(8, bookingDetails.getDate());
			stat.setString(9, bookingDetails.getSource());
			stat.setString(10, bookingDetails.getDestination());
			stat.setInt(11, customerId);

			return stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

//	For Ticket Getting all details from customer table and booking table with the help of join
	public List<BookingAndCustomerDetails> ticketDetails(int customerId, int flightId2, String date) {

		List<BookingAndCustomerDetails> bookingAndCustomerDetails = new ArrayList<>();

		try {
			PreparedStatement stat = conn.prepareStatement(
					"select * from customer_table left join booking_table on customer_table.customer_id = booking_table.customer_id where customer_table.customer_id=? and booking_table.flight_id=? and date=?");

			stat.setInt(1, customerId);
			stat.setInt(2, flightId2);
			stat.setString(3, date);

			ResultSet rs = stat.executeQuery();

			while (rs.next()) {
				String source = rs.getString("src");
				String destination = rs.getString("dest");
				String date2 = rs.getString("date");
				int flightNo = rs.getInt("flight_no");
				String airline = rs.getString("airline");
				String travelClass = rs.getString("travel_class");
				double totalFare = rs.getDouble("total_fare");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String email = rs.getString("email");
				String mobileNo = rs.getString("phone_no");
				int noOfPassenger = rs.getInt("no_of_passengers"); // add

				bookingAndCustomerDetails.add(new BookingAndCustomerDetails(0, firstName, lastName, mobileNo, 0, 0,
						flightNo, email, travelClass, noOfPassenger, totalFare, airline, date2, source, destination));
			}
		} catch (SQLException e) {
			System.out.println("Sql exception occured");
			e.printStackTrace();

		}
		return bookingAndCustomerDetails;
	}

//	For Customer Dashboard all booking details, Getting all details from customer table and booking table with the help of join
	public List<BookingAndCustomerDetails> selectAllBookingDetails(int customerId) {
		List<BookingAndCustomerDetails> bookingAndCustomerDetails = new ArrayList<>();
		try {
			PreparedStatement stat = conn.prepareStatement(
					"select * from customer_table left join booking_table on customer_table.customer_id = booking_table.customer_id where customer_table.customer_id=?");
			stat.setInt(1, customerId);
			ResultSet rs = stat.executeQuery();

			while (rs.next()) {
				int customerId1 = rs.getInt("customer_id");
				int bookingId = rs.getInt("booking_id");
				String source = rs.getString("src");
				String destination = rs.getString("dest");
				String date = rs.getString("date");
				int flightNo = rs.getInt("flight_no");
				String airline = rs.getString("airline");
				String travelClass = rs.getString("travel_class");
				double totalFare = rs.getDouble("total_fare");
				int noOfPassenger = rs.getInt("no_of_passengers");

				bookingAndCustomerDetails.add(new BookingAndCustomerDetails(customerId1, null, null, null, bookingId, 0,
						flightNo, null, travelClass, noOfPassenger, totalFare, airline, date, source, destination));
			}
		} catch (SQLException e) {
			System.out.println("Sql exception occured");
			e.printStackTrace();
		}
		return bookingAndCustomerDetails;
	}

}
