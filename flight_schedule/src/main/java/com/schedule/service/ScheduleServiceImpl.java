package com.schedule.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.schedule.common.Airport;
import com.schedule.entity.Schedule;
import com.schedule.repository.ScheduleRepo;
import com.schedule.common.TransactionRequest;
import com.schedule.common.TransactionResponse;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	

	//DI
	@Autowired
	private ScheduleRepo scheduleRepo;
	
	@Autowired
	private RestTemplate restTemplate;

	// constructor
	public ScheduleServiceImpl(ScheduleRepo scheduleRepo) {
		super();
		this.scheduleRepo = scheduleRepo;
	}
	//default constructor
	public ScheduleServiceImpl() {
		super();
	}

	
//	//fake Schedule list
//	Airport sid =new Airport();
//    List<Schedule> list = List.of(
//            new Schedule(7, null,null,"21:11","16:20"),
//            new Schedule(9,null,null,"21:11","16:20")
//            
//    );
//	
//	
//	//static data from the code
//	
//	public Schedule getfakeStaticValue(int sid) {
//		// TODO Auto-generated method stub
//		return list.stream().filter(schedule ->
//		schedule.getScheduleId()==sid).findAny().orElse(null);
//	}
	
// return list.stream().filter(user -> user.getUserId().equals(id)).findAny().orElse(null);	
	@Override
	public TransactionResponse saverestschedule(TransactionRequest request) {

		String response="";
		Airport airport=request.getAirport();
		
		Airport airportdestination=request.getAirport();
		Schedule schedule=request.getSchedule();
		
		schedule.setSourceAirport(airport);
	
		schedule.setDestination(airportdestination);
		
		//rest call
		Airport airportResponse=restTemplate.postForObject("http://localhost:1001/api/airport/doAirportSource",airport,Airport.class);
		response=airportResponse.getAirportLocation().equals("Goa India")?
				"Schedule Flight Successful":"there is a failure in schedule";
		airportdestination=restTemplate.postForObject("http://localhost:1001/api/airport/doAirportDestination",airportdestination,Airport.class);
		String responsedestination=airportdestination.getAirportLocation().equals("Banglore India")?
				"Banglore":"there is a failure in schedule";
		
		
		airport.setAirportcode(airportResponse.getAirportcode()+1);
		airport.setAirportname(airportResponse.getAirportname());
		airport.setAirportLocation(airportResponse.getAirportLocation());
		
		
	
		
		scheduleRepo.save(schedule);
		return new TransactionResponse(schedule,schedule.getScheduleId(),airportResponse.getAirportLocation(),
				airportdestination.getAirportLocation()
			,response);
		
	}
	
	
	//insert
	@Override
	public Schedule saveSchedule(Schedule schedule) {

		return scheduleRepo.save(schedule);
	}

	//display all
	@Override
	public List<Schedule> getAllSchedule() {
		return scheduleRepo.findAll();
	}

	//display specific id
	@Override
	public Schedule getById(int scheduleid) {
		Optional<Schedule> aircode = scheduleRepo.findById(scheduleid);

		return scheduleRepo.findById(scheduleid).orElseThrow(() -> // USING LAMBDA
		new com.schedule.exception.ResourceNotFoundException("scheduleid", "scheduleidid", aircode));
	}
	
	//update 
	@Override
	public Schedule updateSchedule(Schedule schedule, int scheduleid) {

		Schedule sid = scheduleRepo.findById(scheduleid).orElseThrow(() ->

		new com.schedule.exception.ResourceNotFoundException("Airport", "code", scheduleid));
		sid.setArrivalTime(schedule.getArrivalTime());
		
		sid.setDepartureTime(schedule.getDepartureTime());

		// saving existion employee in db
		scheduleRepo.save(sid);

		return sid;
	}

	//delete
	@Override
	public void deleteSchedule(int scheduleid) {
		// TODO Auto-generated method stub
		scheduleRepo.findById(scheduleid).orElseThrow( ()->
		new com.schedule.exception.ResourceNotFoundException("schedule","id",scheduleid));
		scheduleRepo.deleteById(scheduleid);
	}


}
