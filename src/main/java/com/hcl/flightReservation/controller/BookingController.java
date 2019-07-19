package com.hcl.flightReservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.flightReservation.entity.Booking;
import com.hcl.flightReservation.exception.NoTicketException;
import com.hcl.flightReservation.exception.ResourceNotFoundException;
import com.hcl.flightReservation.pojo.BookingDTO;
import com.hcl.flightReservation.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	BookingService bookingService;

	@PostMapping("")
	public ResponseEntity<Object> saveBooking(@RequestBody BookingDTO booking) throws ResourceNotFoundException, NoTicketException{
		
	
		bookingService.saveBooking(booking);
		
		return new ResponseEntity<> ("record saved sucessfully",HttpStatus.OK);
		
	}
	
	
	@GetMapping("/history/{id}")
	public ResponseEntity<Object> saveBooking(@PathVariable("id")long id){
		
		
	 return new ResponseEntity<> (bookingService.getBookingHistory(bookingService.getUserById(id)),HttpStatus.OK);
		//return new ResponseEntity<> (bookingService.getBookingHistory(id),HttpStatus.OK);
	}
}
