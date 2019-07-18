package com.hcl.flightReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.flightReservation.entity.Booking;

public interface BookingRepo extends JpaRepository <Booking, Long> {

}
