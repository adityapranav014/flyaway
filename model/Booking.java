package com.flyaway.model;

public class Booking {

	private int bookingId;
	private int flightId;
	private int flightNo;
	private String email;
	private String travelClass;
	private int noOfPassenger;
	private double totalFare;
	private String airline;
	private String date;
	private String source;
	private String destination;

	//	Default Constructor
	public int getBookingId() {
		return bookingId;
	}

    //	Generated Constructor using fields
	public Booking(int bookingId, int flightId, int flightNo, String email, String travelClass, int noOfPassenger,
			double totalFare, String airline, String date, String source, String destination) {
		super();
		this.bookingId = bookingId;
		this.flightId = flightId;
		this.flightNo = flightNo;
		this.email = email;
		this.travelClass = travelClass;
		this.noOfPassenger = noOfPassenger;
		this.totalFare = totalFare;
		this.airline = airline;
		this.date = date;
		this.source = source;
		this.destination = destination;
	}

	//	Getters and Setters
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public int getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTravelClass() {
		return travelClass;
	}

	public void setTravelClass(String travelClass) {
		this.travelClass = travelClass;
	}

	public int getNoOfPassenger() {
		return noOfPassenger;
	}

	public void setNoOfPassenger(int noOfPassenger) {
		this.noOfPassenger = noOfPassenger;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

}
