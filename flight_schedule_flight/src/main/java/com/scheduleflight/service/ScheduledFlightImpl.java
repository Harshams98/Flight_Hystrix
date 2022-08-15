package com.scheduleflight.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scheduleflight.entity.ScheduledFlight;
import com.scheduleflight.repository.ScheduledFlightRepo;


@Service
public class ScheduledFlightImpl implements ScheduledFlightServices{

	//DI
	@Autowired
	private ScheduledFlightRepo scheduledFlightRepo;

	// constructor
	public ScheduledFlightImpl(ScheduledFlightRepo scheduledFlightRepo) {
		super();
		this.scheduledFlightRepo = scheduledFlightRepo;
	}
	
	//default constructor
	public ScheduledFlightImpl() {
		super();
	}

	//insert
	@Override
	public ScheduledFlight saveScheduledFlight(ScheduledFlight schedule) {
		// TODO Auto-generated method stub
		return scheduledFlightRepo.save(schedule);
	}

	//display all
	@Override
	public List<ScheduledFlight> getAllScheduledFlight() {
		// TODO Auto-generated method stub
		return scheduledFlightRepo.findAll();
	}

	//display specifically
	@Override
	public ScheduledFlight getById(int scheduledflightid) {
		Optional<ScheduledFlight> scheduleflightid = scheduledFlightRepo.findById(scheduledflightid);

		return scheduledFlightRepo.findById(scheduledflightid).orElseThrow(() -> // USING LAMBDA
		new  com.scheduleflight.exception.ResourceNotFoundException("scheduleid", "scheduleidid", scheduleflightid));
	}

	//update
	@Override
	public ScheduledFlight updateScheduledflight(ScheduledFlight Sscheduledflight, int scheduleid) {
		ScheduledFlight sfid = scheduledFlightRepo.findById(scheduleid).orElseThrow(() ->

		new  com.scheduleflight.exception.ResourceNotFoundException("scheduled flight", "id", scheduleid));
		sfid.setAvailableseats(Sscheduledflight.getAvailableseats());
		sfid.setSchedule(Sscheduledflight.getSchedule());

		// saving existion employee in db
		scheduledFlightRepo.save(sfid);

		return sfid;
	}

	//delete
	@Override
	public void deleteScheduledflight(int scheduleid) {
		scheduledFlightRepo.findById(scheduleid).orElseThrow( ()->
		new  com.scheduleflight.exception.ResourceNotFoundException("schedule","id",scheduleid));
		scheduledFlightRepo.deleteById(scheduleid);	
	}

	

}
