package com.airport.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airport.entity.Airport;



//specifies the extension of repository --- JPA
@Repository
public interface AirportRepo extends JpaRepository<Airport,String>{

	Airport findPaymentHistoryByAirportcode(String aircode);

}
