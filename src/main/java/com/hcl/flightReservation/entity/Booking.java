package com.hcl.flightReservation.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="booking")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "bookingId")
public class Booking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5116993995766516663L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="booking_id")
	private Long bookingId;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="flight_id")
	private Flight flightId;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User userId;
	
	@Column(name="total_fare")
	private Double totalFare;
	
	@Column(name="booking_date")
	private LocalDate bookingDate;
	
	@OneToMany(mappedBy = "bookingObject", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private Set<Passenger> passangers;
	
	
	public Booking() {
		super();
	}

	public Set<Passenger> getPassangers() {
		return passangers;
	}

//	public void setPassangers(Set<Passenger> passangers) {
//		
//		this.passangers = passangers;
//	}

	public Booking() {
		super();
	}

	public Booking(Flight flightId, User userId, Double totalFare, LocalDate bookingDate) {
		//super();
		
		System.out.println("passangesrs"+this);
		
		this.flightId = flightId;
		this.userId = userId;
		this.totalFare = totalFare;
		this.bookingDate = bookingDate;
		
	 //	this.passangers = Stream.of(passangers).collect(Collectors.toSet());
	//	this.passangers.forEach(x -> x.setBookingObject(this));
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Flight getFlightId() {
		return flightId;
	}

	public void setFlightId(Flight flightId) {
		this.flightId = flightId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
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
		
}

