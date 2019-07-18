package com.hcl.flightReservation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hcl.flightReservation.entity.Flight;
import com.hcl.flightReservation.entity.SearchFlight;
import com.hcl.flightReservation.repository.FlightRepository;

@Service
public class SearchFlightService {
	
	@Autowired
	FlightRepository flightRepository;
	
	public List<Flight> searchFlight(SearchFlight searchFlight){
		
		List<Flight> flightList = new ArrayList<Flight>();
		
		if(searchFlight.getFlightCompany()==null && searchFlight.getSort()==null) {
			
			flightList=flightRepository.searchFlight(searchFlight.getDeparture(), searchFlight.getArrival(), searchFlight.getArrivalDestination(), 
					searchFlight.getDepartureSource());
			
		}
		else if(searchFlight.getSort()==null&&searchFlight.getFlightCompany()!=null){
			flightList=flightRepository.serachFlightByFlightName(searchFlight.getDeparture(), searchFlight.getArrival(), searchFlight.getArrivalDestination(), 
					searchFlight.getDepartureSource(),searchFlight.getFlightCompany());
		}
		
		else if(searchFlight.getFlightCompany()==null && searchFlight.getSort().equalsIgnoreCase("fair"))
		{
			Pageable pageable = PageRequest.of(0, 10, Sort.by("fare").ascending());
			flightList=flightRepository.searchFlightByFare(searchFlight.getDeparture(), searchFlight.getArrival(), searchFlight.getArrivalDestination(), 
					searchFlight.getDepartureSource(),pageable);
		}
		else {
			Pageable pageable = PageRequest.of(0, 10, Sort.by("fare").ascending());
			flightList=flightRepository.searchFlightByFareCompany(searchFlight.getDeparture(), searchFlight.getArrival(), searchFlight.getArrivalDestination(), 
					searchFlight.getDepartureSource(),searchFlight.getFlightCompany(),pageable);
			
		}
		return flightList;
		
	}

}
