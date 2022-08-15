package com.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.entity.Flight;



//specifies the extension of repository --- JPA
public interface FlightRepo extends JpaRepository<Flight,Integer>{

}

