package com.hcl.flightReservation.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hcl.flightReservation.entity.Flight;


@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer>,PagingAndSortingRepository<Flight, Integer>{

	@Query(value="select * from flights where departure_time= (:departure) and arrival_time= (:arrival) and source= (:source)"
			+ "and destination=(:destination)", nativeQuery=true)
	List<Flight> searchFlight( LocalDateTime departure,LocalDateTime arrival,String source ,String destination);
	
	@Query(value="select * from flights where departure_time= (:departure) and arrival_time= (:arrival) and source= (:source)"
			+ "and destination= (:destination) and flight_company= (:flightCompany)" , nativeQuery=true)
	List<Flight> serachFlightByFlightName(LocalDateTime departure,LocalDateTime arrival,String source ,String destination,String flightCompany);

	@Query(value="select * from flights where departure_time= (:departure) and arrival_time= (:arrival) and source= (:source)"
			+ "and destination=(:destination)", nativeQuery=true)
	List<Flight> searchFlightByFare(LocalDateTime departure, LocalDateTime arrival, String source ,String destination, Pageable pageable);
	
	@Query(value="select * from flights where departure_time= (:departure) and arrival_time= (:arrival) and source= (:source)"
			+ "and destination=(:destination) and flight_company=(:flightCompany)" , nativeQuery=true)
	List<Flight> searchFlightByFareCompany(LocalDateTime departure, LocalDateTime arrival,
			String source ,String destination, String flightCompany, Pageable pageable);

	
	
		
	
	
}
