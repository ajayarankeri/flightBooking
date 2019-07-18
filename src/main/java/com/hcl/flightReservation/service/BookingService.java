package com.hcl.flightReservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.flightReservation.entity.Booking;
import com.hcl.flightReservation.repository.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	BookingRepository bookingRepository;
	
	 public void  saveBooking(Booking booking) {
		 bookingRepository.save(booking);
	 }

}
