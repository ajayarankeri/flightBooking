package com.hcl.flightReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.flightReservation.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>{

}
