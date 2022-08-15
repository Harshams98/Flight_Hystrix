package com.apigateway;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;


import reactor.core.publisher.Mono;

@EnableEurekaClient
public class FallbackController {
	
	@RequestMapping("/airportFallBack")
	public Mono<String> AirportServiceFallBack(){
		return Mono.just("airport is taking too long to response or its down!"
				+"Try again!");
	}

	@RequestMapping("/flightFallBack")
	public Mono<String> FlightServiceFallBack(){
		return Mono.just("flight is taking too long to response or its down!"
				+"Try again later!");
	}
	
	@RequestMapping("/scheduleFallBack")
	public Mono<String> ScheduleServiceFallBack(){
		return Mono.just("Schedule is taking too long to response or its down!"
				+"Try again later!");
	}
	
	@RequestMapping("/scheduleflightFallBack")
	public Mono<String> ScheduleFlightServiceFallBack(){
		return Mono.just("Scheduleflight is taking too long to response or its down!"
				+"Try again later!");
	}
}
