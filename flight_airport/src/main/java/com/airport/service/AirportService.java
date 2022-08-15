package com.airport.service;

import java.util.List;

import com.airport.entity.Airport;

public interface AirportService {
	
	//insert
	Airport saveAirport (Airport airport);
	
	//display all by list
	List<Airport> getAllAirport();
	
	///display specific data
	Airport getById (String airportcode);
	
	//update 
	Airport updateAirport(Airport airport,String airportcode);
	
	//delete
	void deleteEmployee(String airportcode);
	
	public Airport findPaymentHistoryByAirportCode(String aircode);

}
