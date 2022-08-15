package com.scheduleflight.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

//Mapping to db
@Entity
public class ScheduledFlight {

	// primary key
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sfid;
	// foreign key
	@OneToOne
	private Flight flight;

	private int availableseats;

	// foreign key
	@OneToOne
	private Schedule schedule;

	// default constructor
	public ScheduledFlight() {
		super();
	}

	// parameterized constructor
	public ScheduledFlight(int sfid, Flight flight, int availableseats, Schedule schedule) {
		super();
		this.sfid = sfid;
		this.flight = flight;
		this.availableseats = availableseats;
		this.schedule = schedule;
	}

	// Getters and setters
	public int getSfid() {
		return sfid;
	}

	public void setSfid(int sfid) {
		this.sfid = sfid;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public int getAvailableseats() {
		return availableseats;
	}

	public void setAvailableseats(int availableseats) {
		this.availableseats = availableseats;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "ScheduledFlight [sfid=" + sfid + ", flight=" + flight + ", availableseats=" + availableseats
				+ ", schedule=" + schedule + "]";
	}

}