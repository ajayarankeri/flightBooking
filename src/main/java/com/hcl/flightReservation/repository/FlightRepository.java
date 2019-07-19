package com.hcl.flightReservation.repository;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hcl.flightReservation.entity.Flight;


@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>,PagingAndSortingRepository<Flight, Long>{

	@Query(value="select * from flight where departure= (:departure) and arrival= (:arrival) and departure_source= (:departureSource)"
			+ "and arrival_destination=(:arrivalDestination)", nativeQuery=true)
	List<Flight> searchFlight( DateTimeFormatter departure,DateTimeFormatter arrival,String arrivalDestination ,String departureSource);
	
	@Query(value="select * from flight where departure= (:departure) and arrival= (:arrival) and departure_source= (:departureSource)"
			+ "and arrival_destination= (:arrivalDestination) and flight_company= (:flightCompany)" , nativeQuery=true)
	List<Flight> serachFlightByFlightName(DateTimeFormatter departure,DateTimeFormatter arrival,String departureSource,String arrivalDestination,String flightCompany);

	@Query(value="select * from flight where departure= (:departure) and arrival= (:arrival) and departure_source= (:departureSource)"
			+ "and arrival_destination=(:arrivalDestination)", nativeQuery=true)
	List<Flight> searchFlightByFare(DateTimeFormatter departure, DateTimeFormatter arrival, String arrivalDestination,
			String departureSource, Pageable pageable);
	
	@Query(value="select * from flight where departure= (:departure) and arrival= (:arrival) and departure_source= (:departureSource)"
			+ "and arrival_destination=(:arrivalDestination) and flight_company=(:flightCompany)" , nativeQuery=true)
	List<Flight> searchFlightByFareCompany(DateTimeFormatter departure, DateTimeFormatter arrival,
			String arrivalDestination, String departureSource, String flightCompany, Pageable pageable);
		
	
	Flight findByFlightId(int flightId);
}
