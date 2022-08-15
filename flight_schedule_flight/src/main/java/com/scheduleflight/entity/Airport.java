package com.scheduleflight.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//DB Mapping
@Entity
@Table(name = "airport")
public class Airport {
//primary key
	@Id
	@Column(name = "airportcode")
	private String airportcode;

	@Column(name = "airportname", nullable = false)
	private String airportname;

	@Column(name = "airportlocation")
	private String airportlocation;

	// parameterized constructor
	public Airport(String airportcode, String airportname, String airportLocation) {
		super();
		this.airportcode = airportcode;
		this.airportname = airportname;
		this.airportlocation = airportLocation;
	}

	// default constructor
	public Airport() {
		super();
	}

	// Getters and setters
	public String getAirportcode() {
		return airportcode;
	}

	public void setAirportcode(String airportcode) {
		this.airportcode = airportcode;
	}

	public String getAirportname() {
		return airportname;
	}

	public void setAirportname(String airportname) {
		this.airportname = airportname;
	}

	public String getAirportLocation() {
		return airportlocation;
	}

	public void setAirportLocation(String airportLocation) {
		this.airportlocation = airportLocation;
	}

	@Override
	public String toString() {
		return "Airport [airportcode=" + airportcode + ", airportname=" + airportname + ", airportLocation="
				+ airportlocation + "]";
	}
}
