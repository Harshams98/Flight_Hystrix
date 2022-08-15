package com.airport.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.airport.entity.Airport;
import com.airport.repository.AirportRepo;

@Service
public class AirportServiceImpl implements AirportService {

	@Autowired
	AirportRepo airportRepo;

	// constructor
	public AirportServiceImpl(AirportRepo airportRepo) {
		super();
		this.airportRepo = airportRepo;
	}

	// default constructor
	public AirportServiceImpl() {
		super();
	}

	//MappingJackson -- http message
	// insert
	@Override
	public Airport saveAirport(Airport airport) {
	
		return airportRepo.save(airport);
	}

	// Get all
	@Override
	public List<Airport> getAllAirport() {
		// TODO Auto-generated method stub
		return airportRepo.findAll();
	}

	// get specific data
	@Override
	public Airport getById(String airportcode) {
		Optional<Airport> aircode = airportRepo.findById(airportcode);

		return airportRepo.findById(airportcode).orElseThrow(() -> // USING LAMBDA
		new com.airport.exception.ResourceNotFoundException("Airport", "airportcode", aircode));
	}

	// update
	@Override
	public Airport updateAirport(Airport airport, String airportcode) {

		// we need to check weather

		Airport aircode = airportRepo.findById(airportcode).orElseThrow(() ->

		new com.airport.exception.ResourceNotFoundException("Airport", "code", airportcode));
		aircode.setAirportname(airport.getAirportname());
		aircode.setAirportLocation(airport.getAirportLocation());

		// saving existing employee in db
		airportRepo.save(aircode);

		return aircode;

	}

	// delete
	@Override
	public void deleteEmployee(String airportcode) {
		airportRepo.findById(airportcode)
				.orElseThrow(() -> new com.airport.exception.ResourceNotFoundException("Airport", "code", airportcode));
		airportRepo.deleteById(airportcode);

	}
	
	
	//making the source
	public Airport doAirportSource(Airport airport) {

		airport.setAirportcode(UUID.randomUUID().toString());
		airport.setAirportname("Goa_International");
		//calling server via method weather the payment is successful or not
		airport.setAirportLocation("Goa India");
		
		return airportRepo.save(airport);
	}
	
	public Airport doAirportDestination(Airport airport) {

		airport.setAirportcode(UUID.randomUUID().toString());
		airport.setAirportname("BangloreInternational");
		//calling server via method weather the payment is successful or not
		airport.setAirportLocation("Banglore India");
		
		return airportRepo.save(airport);
	}
	
public Airport findPaymentHistoryByAirportCode(String aircode) {
		
		return airportRepo.findPaymentHistoryByAirportcode(aircode);
	}
}
