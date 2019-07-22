/**
 * 
 */
package com.hcl.flightReservation.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.flightReservation.exception.InvalidUserDataException;
import com.hcl.flightReservation.exception.NoTicketException;
import com.hcl.flightReservation.exception.ResourceNotFoundException;
import com.hcl.flightReservation.pojo.BookingDTO;
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
	
	@Test
	public void testBookingWithEmpty() throws InvalidUserDataException, ResourceNotFoundException, NoTicketException{
		BookingDTO bookingDTO = new BookingDTO();
		
		Assert.assertNotNull(bookingController.saveBooking(bookingDTO));
	}

}
