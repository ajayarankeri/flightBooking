package com.hcl.flightReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.flightReservation.entity.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long>{

}
