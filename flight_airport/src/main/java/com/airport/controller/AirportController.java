package com.airport.controller;

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

import com.airport.entity.Airport;
import com.airport.service.AirportService;
import com.airport.service.AirportServiceImpl;



@RestController
@RequestMapping("/api/airport")
public class AirportController {

	//DI
	@Autowired
	private AirportService airportService;
	
	@Autowired
	private AirportServiceImpl airportServiceImpl;

	// constructor
	public AirportController(AirportService airportService) {
		super();
		this.airportService = airportService;
	}
	
	//default constructor
	public AirportController() {
		super();
	}

	@PostMapping("/doAirportSource")
	public ResponseEntity<Airport> saveSource(@RequestBody Airport airport){
		return new ResponseEntity<Airport>(airportServiceImpl.doAirportSource(airport), HttpStatus.CREATED);
	}
	
	@PostMapping("/doAirportDestination")
	public ResponseEntity<Airport> saveDestination(@RequestBody Airport airport){
		return new ResponseEntity<Airport>(airportServiceImpl.doAirportDestination(airport), HttpStatus.CREATED);
	}

	
	
	//Http message converter
	@PostMapping()
	public ResponseEntity<Airport> saveAirport(@RequestBody Airport airport){
		return new ResponseEntity<Airport>(airportService.saveAirport(airport), HttpStatus.CREATED);
	}
	
    ///Http message converter	-- display all	
	@GetMapping()
	public List<Airport> getAllEmployees(){
		return airportService.getAllAirport();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Airport> getEmployeeById(@PathVariable ("id")String airportcode){
	return new ResponseEntity<Airport>(airportService.getById(airportcode),
			HttpStatus.OK);//status -- 200
	}
	
//	@GetMapping("{id}")
//	public Airport findPaymentHistoryByAirportCode(@PathVariable ("id") String airportcode) {
//		return airportService.findPaymentHistoryByAirportCode(airportcode);
//	}
	
	
	
	
	@PutMapping("{id}")
	public ResponseEntity<Airport> updateEmployee(@PathVariable ("id")String aircode,
			@RequestBody Airport airport){
	return new ResponseEntity<Airport>(airportService.updateAirport(airport,aircode),
			HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable ("id") String aircode){
		//delete employee DB
		airportService.deleteEmployee(aircode);
		return new ResponseEntity<String>("Employee record deleted successfully!",HttpStatus.OK);
	}
	
}
