package com.hcl.flightReservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.flightReservation.entity.Flight;
import com.hcl.flightReservation.entity.SearchFlight;
import com.hcl.flightReservation.service.FlightService;

@RestController
public class SearchFlightController {
	
	@Autowired
	FlightService searchFlightService;
	
	@PostMapping("/search")
     public ResponseEntity<List<Flight>> searchFlight(@RequestBody SearchFlight searchFlight) throws Exception{
		
		if(searchFlight.getArrival()==null&&searchFlight.getDestination().isEmpty()&&searchFlight.getSource().isEmpty()&&
				searchFlight.getDeparture()==null)
			throw new Exception("Please fill all mandatory details");
		
		
		return new ResponseEntity<List<Flight>>(searchFlightService.searchFlight(searchFlight),HttpStatus.OK);
    	 
    	 
     }
}
