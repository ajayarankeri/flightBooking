package com.hcl.flightReservation.pojo;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.hcl.flightReservation.entity.Flight;
import com.hcl.flightReservation.entity.Passenger;
import com.hcl.flightReservation.entity.User;

public class BookingDTO {
//	
private long flightId;
	
	private long userId;

	
	private Double totalFare;
	
	private LocalDate bookingDate;
	
    private Set<Passenger> passangers;
    
	
   

	public long getFlightId() {
		return flightId;
	}

	public void setFlightId(long flightId) {
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
