package com.scheduleflight.service;

import java.util.List;

import com.scheduleflight.entity.ScheduledFlight;



public interface ScheduledFlightServices {

	//insert
		ScheduledFlight saveScheduledFlight (ScheduledFlight schedule);

		//get all
		List<ScheduledFlight> getAllScheduledFlight();
		
		//get by id
		ScheduledFlight getById (int scheduledflightid);
		
		//update
		ScheduledFlight updateScheduledflight(ScheduledFlight Sscheduledflight,int scheduleid);
		
		//delete
		void deleteScheduledflight(int scheduleid);
	
}
