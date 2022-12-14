package com.flyaway.model;

public class FlightDetails {

	private int flightId;
	private int flightNo;
	private String airline;
	private String weekdays;
	private String srcAirportCode;
	private String destAirportCode;
	private String classType;
	private double fare;

//  Default Constructor
	public FlightDetails() {
	}

//	Generated Constructor using fields
	public FlightDetails(int flightId, int flightNo, String airline, String weekdays, String srcAirportCode,
			String destAirportCode, String classType, double fare) {
		super();
		this.flightId = flightId;
		this.flightNo = flightNo;
		this.airline = airline;
		this.weekdays = weekdays;
		this.srcAirportCode = srcAirportCode;
		this.destAirportCode = destAirportCode;
		this.classType = classType;
		this.fare = fare;
	}


//	Getters and Setters 
	public int getflightId() {
		return flightId;
	}

	public void setId(int flightId) {
		this.flightId = flightId;
	}

	public int getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getWeekdays() {
		return weekdays;
	}

	public void setWeekdays(String weekdays) {
		this.weekdays = weekdays;
	}

	public String getSrcAirportCode() {
		return srcAirportCode;
	}

	public void setSrcAirportCode(String srcAirportCode) {
		this.srcAirportCode = srcAirportCode;
	}

	public String getDestAirportCode() {
		return destAirportCode;
	}

	public void setDestAirportCode(String destAirportCode) {
		this.destAirportCode = destAirportCode;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

}
