package com.hcl.flightReservation.service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.flightReservation.entity.Booking;
import com.hcl.flightReservation.entity.Flight;
import com.hcl.flightReservation.entity.Passenger;
import com.hcl.flightReservation.entity.User;
import com.hcl.flightReservation.exception.NoTicketException;
import com.hcl.flightReservation.exception.ResourceNotFoundException;
import com.hcl.flightReservation.pojo.BookingDTO;
import com.hcl.flightReservation.repository.BookingRepository;
import com.hcl.flightReservation.repository.FlightRepository;
import com.hcl.flightReservation.repository.PassengerRepository;
import com.hcl.flightReservation.repository.UserRepository;

@Service
public class BookingService {
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	 public void  saveBooking(BookingDTO booking) throws ResourceNotFoundException, NoTicketException {
		 
		 User user=userRepository.findById(booking.getUserId()).orElseThrow(()->   new ResourceNotFoundException("User not exist"));
		 Flight flight=flightRepository.findByFlightId(booking.getFlightId());
		 if(null==flight) {
			 throw  new ResourceNotFoundException("Flight not exist");
		 }
		 if(flight.getFlightCapacity()==0) {
			  throw new NoTicketException("No seat avalible");
			}
		 
		 Booking bookingObject=new Booking(flight, user, booking.getTotalFare(), booking.getBookingDate());
		  bookingRepository.save(bookingObject);
		Iterator itr=  booking.getPassangers().stream().collect(Collectors.toSet()).iterator();
		
		while(itr.hasNext()) {
			Passenger pass=(Passenger)itr.next();
			pass.setBookingObject(bookingObject);
		    passengerRepository.save(pass);
		}
		
		
		flight.setFlightCapacity(flight.getFlightCapacity()-booking.getPassangers().size());
		flightRepository.save(flight);
	 }
	 
	 public User getUserById(long id) {
		 return userRepository.findById(id).get();
	 }
	 
	 
	 public List<Booking> getBookingHistory(User userid){
 return bookingRepository.findByUserId(userid);
	 }

}
