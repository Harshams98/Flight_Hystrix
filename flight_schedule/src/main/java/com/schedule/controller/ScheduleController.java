package com.schedule.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schedule.common.TransactionRequest;
import com.schedule.common.TransactionResponse;
import com.schedule.entity.Schedule;
import com.schedule.service.ScheduleService;
import com.schedule.service.ScheduleServiceImpl;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {
	
	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private ScheduleServiceImpl scheduleServiceimpl;

	public ScheduleController(ScheduleService scheduleService) {
		super();
		this.scheduleService = scheduleService;
	}

	public ScheduleController() {
		super();
	}

	 


		@PostMapping("/saveschedule")
		public TransactionResponse saverestschedule(@RequestBody TransactionRequest request){
			return scheduleServiceimpl.saverestschedule(request);
		}
	 
	 
	 
	@PostMapping()
	public ResponseEntity<Schedule> saveAirport(@RequestBody Schedule schedule){
		return new ResponseEntity<Schedule>(scheduleService.saveSchedule(schedule), HttpStatus.CREATED);
	}

	@GetMapping()
	public List<Schedule> getAllSchedule(){
		return scheduleService.getAllSchedule();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Schedule> getById(@PathVariable ("id")int scheduleid){
	return new ResponseEntity<Schedule>(scheduleService.getById(scheduleid),
			HttpStatus.OK);//status -- 200
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<Schedule> updateSchedule(@PathVariable ("id")int sid,
			@RequestBody Schedule schedule){
	return new ResponseEntity<Schedule>(scheduleService.updateSchedule(schedule,sid),
			HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteSchedule(@PathVariable ("id") int sid){
		//delete employee db
		scheduleService.deleteSchedule(sid);
		return new ResponseEntity<String>("Employee record deleted successfully!",HttpStatus.OK);
	}
	
	
	
	
//    @GetMapping("/static/{id}")
//    public Schedule getfake(@PathVariable("id") int id) {
//
//    	Schedule schedule =(Schedule) this.scheduleService.getfakeStaticValue(7);
//        //
//        //http://contact-service/contact/user/
//        Airport contacts = (Airport) this.restTemplate.getForObject("http://localhost:1001/api/airport/", List.class);
//    	
//        schedule.setSourceAirport(contacts);
//       // schedule.setDestination(null);
//        return schedule;
//
//    }
	
}

