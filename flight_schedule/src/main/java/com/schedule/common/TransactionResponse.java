package com.schedule.common;

import com.schedule.entity.Schedule;

public class TransactionResponse {

	private Schedule schedule;

	private int scheduleId;// order id -- random
	
	private String source;
	
	private String destination;

	private String message;

	public TransactionResponse(Schedule schedule, int scheduleId, String source, String destination, String message) {
		super();
		this.schedule = schedule;
		this.scheduleId = scheduleId;
		this.source = source;
		this.destination = destination;
		this.message = message;
	}

	public TransactionResponse() {
		super();
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
