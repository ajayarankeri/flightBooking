/**
 * 
 */
package com.hcl.flightReservation.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.stereotype.Controller;

import com.hcl.flightReservation.entity.Booking;
import com.hcl.flightReservation.service.BookingService;

/**
 * @author Administrator
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class BookingControllerTest {
	
	@InjectMocks
	private BookingController bookingController;
	
	@Mock
	private BookingService bookingService;
	
	private	Booking booking;
	@Test
	public void testBookingWithEmpty() {
		
		Booking booking;
		//Mockito.when(bookingService.saveBooking(booking)).thenReturn());
		fail("Not yet implemented");
	}

}
