package com.scheduleflight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scheduleflight.entity.ScheduledFlight;


//specifies the extension of repository --- JPA
public interface ScheduledFlightRepo extends JpaRepository<ScheduledFlight,Integer>{

}
