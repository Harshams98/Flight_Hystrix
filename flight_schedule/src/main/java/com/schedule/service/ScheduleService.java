package com.schedule.service;

import java.util.List;

import com.schedule.common.TransactionRequest;
import com.schedule.common.TransactionResponse;
import com.schedule.entity.Schedule;



public interface ScheduleService {

	//insert
	Schedule saveSchedule (Schedule schedule);

	//get all
	List<Schedule> getAllSchedule();
	
	
//	//get all
//	Schedule getfakeStaticValue(int sid);
	
	//get by id
	Schedule getById (int scheduleid);
	
	//update
	Schedule updateSchedule(Schedule Sschedule,int scheduleid);
	
	//delete
	void deleteSchedule(int scheduleid);

	TransactionResponse saverestschedule(TransactionRequest request);
	
	
}
