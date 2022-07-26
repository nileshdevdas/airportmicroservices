package com.vinsys.airports;

/**
 * 
 * @author Nilesh Devdas
 * Data Model Which going to hold the details
 */
public class Airport {

	private String airportName;
	private String airportType;
	private String country;

	public String getAirportName() {
		return airportName;
	}

	public String getAirportType() {
		return airportType;
	}

	public String getCountry() {
		return country;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public void setAirportType(String airportType) {
		this.airportType = airportType;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
