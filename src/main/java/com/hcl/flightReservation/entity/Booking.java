package com.hcl.flightReservation.entity;

import java.time.LocalDate;
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

@Entity
@Table(name="booking")
public class Booking {

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
	
	@OneToMany(mappedBy = "bookingObject", cascade = CascadeType.ALL)
    private Set<Passenger> passangers;
	
	
	public Booking() {
		super();
	}

	public Booking(Flight flightId, User userId, Double totalFare, LocalDate bookingDate,
			Passenger...passangers) {
		super();
		
		this.flightId = flightId;
		this.userId = userId;
		this.totalFare = totalFare;
		this.bookingDate = bookingDate;
		this.passangers = Stream.of(passangers).collect(Collectors.toSet());
		this.passangers.forEach(x -> x.setBookingObject(this));
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

