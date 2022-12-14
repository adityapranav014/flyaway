package com.flyaway.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flyaway.model.FlightDetails;

public class FlightDetailsDao {

//	SQL Connection
	private Connection conn;

//	Default Constructor
	public FlightDetailsDao() {
		conn = DBConfig.getConnection();
	}

//	Insert flight details into DB	
	public int saveFlightDetails(FlightDetails fd) {

		try {
			PreparedStatement stat = conn.prepareStatement("insert into flight_details_table"
					+ "(flight_number,airline,weekdays,src_airport_code,dest_airport_code,class,fare) values (?,?,?,?,?,?,?)");

			stat.setInt(1, fd.getFlightNo());
			stat.setString(2, fd.getAirline());
			stat.setString(3, fd.getWeekdays());
			stat.setString(4, fd.getSrcAirportCode());
			stat.setString(5, fd.getDestAirportCode());
			stat.setString(6, fd.getClassType());
			stat.setDouble(7, fd.getFare());

			return stat.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}

	}

//	Show all Flight Details from DB
	public List<FlightDetails> selectAllFlightDetails() {

		List<FlightDetails> flightDetails = new ArrayList<>();

		try {

			PreparedStatement stat = conn.prepareStatement("SELECT * FROM flight_details_table");

			ResultSet rs = stat.executeQuery();

			while (rs.next()) {
				int flightId = rs.getInt("flight_id");
				int flightNo = rs.getInt("flight_number");
				String airline = rs.getString("airline");
				String weekdays = rs.getString("weekdays");
				String srcAirportCode = rs.getString("src_airport_code");
				String destAirportCode = rs.getString("dest_airport_code");
				String classType = rs.getString("class");
				double fare = rs.getDouble("fare");
				flightDetails.add(new FlightDetails(flightId, flightNo, airline, weekdays, srcAirportCode,
						destAirportCode, classType, fare));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flightDetails;
	}

//  Searched Flight details O/P	
	public List<FlightDetails> searchFlightDetails(FlightDetails fd) {

		List<FlightDetails> searchedDetails = new ArrayList<>();

		try {
			String week = fd.getWeekdays();
			PreparedStatement stat = conn
					.prepareStatement("SELECT * FROM flight_details_table WHERE src_airport_code = ?"
							+ "And dest_airport_code=?" + "and weekdays LIKE '%" + week + "%';");
			stat.setString(1, fd.getSrcAirportCode());
			stat.setString(2, fd.getDestAirportCode());

			ResultSet rs = stat.executeQuery();

			while (rs.next()) {
				int flightId = rs.getInt("flight_id");
				int flightNo = rs.getInt("flight_number");
				String airline = rs.getString("airline");
				String weekdays = rs.getString("weekdays");
				String srcAirportCode = rs.getString("src_airport_code");
				String destAirportCode = rs.getString("dest_airport_code");
				String classType = rs.getString("class");
				double fare = rs.getDouble("fare");
				searchedDetails.add(new FlightDetails(flightId, flightNo, airline, weekdays, srcAirportCode,
						destAirportCode, classType, fare));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		System.out.println(searchedDetails);
		return searchedDetails;

	}

//	Delete Flight details
	public boolean deleteFlight(int id) {
		boolean rowDeleted = false;

		try {

			PreparedStatement stat = conn.prepareStatement("DELETE FROM flight_details_table WHERE flight_id=?");
			stat.setInt(1, id);
			rowDeleted = stat.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}

//  Select Flight Details by id
	public FlightDetails selectUser(int id) {
		FlightDetails flightDetails = null;
		try {

			PreparedStatement stat = conn.prepareStatement("SELECT * FROM flight_details_table WHERE flight_id = ?");
			stat.setInt(1, id);
			ResultSet rs = stat.executeQuery();

			while (rs.next()) {
				int flightId = rs.getInt("flight_id");
				int flightNo = rs.getInt("flight_number");
				String airline = rs.getString("airline");
				String weekdays = rs.getString("weekdays");
				String srcAirportCode = rs.getString("src_airport_code");
				String destAirportCode = rs.getString("dest_airport_code");
				String classType = rs.getString("class");
				double fare = rs.getDouble("fare");
				flightDetails = new FlightDetails(flightId, flightNo, airline, weekdays, srcAirportCode,
						destAirportCode, classType, fare);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flightDetails;
	}

//  Update Flight Details by id	
	public boolean updateFlightDetails(FlightDetails ufd) {
		boolean rowUpdated = false;
		try {

			PreparedStatement stat = conn.prepareStatement(
					"UPDATE flight_details_table SET flight_number=?, airline=?, weekdays=?, src_airport_code=?, dest_airport_code=?, class=?,fare=? WHERE flight_id=?");

			stat.setInt(1, ufd.getFlightNo());
			stat.setString(2, ufd.getAirline());
			stat.setString(3, ufd.getWeekdays());
			stat.setString(4, ufd.getSrcAirportCode());
			stat.setString(5, ufd.getDestAirportCode());
			stat.setString(6, ufd.getClassType());
			stat.setDouble(7, ufd.getFare());
			stat.setDouble(8, ufd.getflightId());

			rowUpdated = stat.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}
}
