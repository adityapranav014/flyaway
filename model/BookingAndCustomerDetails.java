package com.flyaway.model;

public class BookingAndCustomerDetails {

	private int customerId;
	private String firstName;
	private String lastName;
	private String mobileNo;
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

	// Default Constructor
	public BookingAndCustomerDetails() {
		// TODO Auto-generated constructor stub
	}

	// Constructor using fields
	public BookingAndCustomerDetails(int customerId, String firstName, String lastName, String mobileNo, int bookingId,
			int flightId, int flightNo, String email, String travelClass, int noOfPassenger, double totalFare,
			String airline, String date, String source, String destination) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
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

	//	Getter and Setter
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public int getBookingId() {
		return bookingId;
	}

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
