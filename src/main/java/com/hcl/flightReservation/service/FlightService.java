package com.hcl.flightReservation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hcl.flightReservation.entity.Flight;
import com.hcl.flightReservation.entity.SearchFlight;
import com.hcl.flightReservation.repository.FlightRepository;

@Service
public class FlightService {
	
	@Autowired
	FlightRepository flightRepository;
	
	public List<Flight> searchFlight(SearchFlight searchFlight){
		
		List<Flight> flightList = new ArrayList<Flight>();
		
		
		if(searchFlight.getFlightCompany().isEmpty()&&searchFlight.getSort().isEmpty()) {
			
			flightList=flightRepository.searchFlight(searchFlight.getDeparture(), searchFlight.getArrival(), searchFlight.getSource(), 
					searchFlight.getDestination());
			
		}
		else if(searchFlight.getSort().isEmpty()&&(!searchFlight.getFlightCompany().isEmpty())){
			flightList=flightRepository.serachFlightByFlightName(searchFlight.getDeparture(), searchFlight.getArrival(), searchFlight.getSource(), 
					searchFlight.getDestination(),searchFlight.getFlightCompany());
		}
		
		else if(searchFlight.getFlightCompany().isEmpty()&&searchFlight.getSort().equalsIgnoreCase("fare"))
		{
			Pageable pageable = PageRequest.of(0, 10, Sort.by("fare").ascending());
			flightList=flightRepository.searchFlightByFare(searchFlight.getDeparture(), searchFlight.getArrival(), searchFlight.getSource(), 
					searchFlight.getDestination(),pageable);
		}
		else {
			Pageable pageable = PageRequest.of(0, 10, Sort.by("fare").ascending());
			flightList=flightRepository.searchFlightByFareCompany(searchFlight.getDeparture(), searchFlight.getArrival(), searchFlight.getSource(), 
					searchFlight.getDestination(),searchFlight.getFlightCompany(),pageable);
			
		}
		return flightList;
		
	}

	public void addNewFlight(Flight flight) {
		flightRepository.save(flight);
		
	}

	public Optional<Flight> flightDetails(long flightId,int Status) {
		Optional<Flight> flightList=flightRepository.findById(flightId);
		 if(flightList.isPresent()) {
		 Flight flightObject=flightList.get();
		 flightObject.setFlightStatus(Status);
		flightRepository.save(flightObject);
		}		
		return flightList;
	}

	public List<Flight> fetchPendingApproval() {		
		List<Flight> pendingList= flightRepository.findByFlightStatus(0);
		return pendingList;
	}

}
