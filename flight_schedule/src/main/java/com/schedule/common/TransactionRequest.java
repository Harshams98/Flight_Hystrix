package com.schedule.common;

import com.schedule.entity.Schedule;

public class TransactionRequest {

	private Airport airport;
	
	private Schedule schedule;

	public TransactionRequest(Airport airport, Schedule schedule) {
		super();
		this.airport = airport;
		this.schedule = schedule;
	}

	public TransactionRequest() {
		super();
	}

	public Airport getAirport() {
		return airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	
}
