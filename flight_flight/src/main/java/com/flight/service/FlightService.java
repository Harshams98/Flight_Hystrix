package com.flight.service;

import java.util.List;

import com.flight.entity.Flight;


public interface FlightService {

	
	Flight saveFlight (Flight flight);
	
	List<Flight> getAllFlights();
	
	Flight getById (int flightnum);
	
	Flight updateFlight(Flight flight,int flightnum);
	
	void deleteFlight(int flightnum);
	
}
