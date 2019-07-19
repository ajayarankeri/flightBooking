package com.hcl.flightReservation.pojo;

import java.time.LocalDate;
import java.util.Set;

import com.hcl.flightReservation.entity.Passenger;


public class BookingDTO {
	
private int flightId;

	private long userId;

	
	private Double totalFare;
	
	private LocalDate bookingDate;
	
    private Set<Passenger> passangers;
    
	
   

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(Double totalFare) {
		this.totalFare = totalFare;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Set<Passenger> getPassangers() {
		return passangers;
	}

	public void setPassangers(Set<Passenger> passangers) {
		this.passangers = passangers;
	}

}
