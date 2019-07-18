package com.hcl.flightReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.flightReservation.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
