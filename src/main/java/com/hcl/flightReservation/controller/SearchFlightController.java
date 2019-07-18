package com.hcl.flightReservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hcl.flightReservation.entity.Flight;
import com.hcl.flightReservation.entity.SearchFlight;
import com.hcl.flightReservation.service.SearchFlightService;

@Controller
public class SearchFlightController {
	
	@Autowired
	SearchFlightService searchFlightService;
	
	@PostMapping("/search")
     public ResponseEntity<List<Flight>> searchFlight(@RequestBody SearchFlight searchFlight) throws Exception{
		
		if(searchFlight.getArrival()==null&&searchFlight.getArrivalDestination()==null&&searchFlight.getDepartureSource()==null&&
				searchFlight.getDeparture()==null)
			throw new Exception("Please fill all mandatory details");
		
		
		return new ResponseEntity<List<Flight>>(searchFlightService.searchFlight(searchFlight),HttpStatus.OK);
    	 
    	 
     }
}
