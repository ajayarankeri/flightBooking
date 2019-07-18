package com.hcl.flightReservation.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flights")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="flight_id")
	private Long flightId;
	
	@Column(name="flight_company")
	private String flightCompany;
	
	@Column(name="flight_capacity")
	private int flightCapacity;
	
	@Column(name="departure")
	private LocalDate departure;
	
	@Column(name="arrival")
	private LocalDate arrival;
	
	@Column(name="departure_source")
	private String departureSource;
	
	@Column(name="arrival_destination")
	private String arrivalDestination;
	
	@Column(name="fare")
	private Double fare;

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public String getFlightCompany() {
		return flightCompany;
	}

	public void setFlightCompany(String flightCompany) {
		this.flightCompany = flightCompany;
	}

	public int getFlightCapacity() {
		return flightCapacity;
	}

	public void setFlightCapacity(int flightCapacity) {
		this.flightCapacity = flightCapacity;
	}

	public LocalDate getDeparture() {
		return departure;
	}

	public void setDeparture(LocalDate departure) {
		this.departure = departure;
	}

	public LocalDate getArrival() {
		return arrival;
	}

	public void setArrival(LocalDate arrival) {
		this.arrival = arrival;
	}

	public String getDepartureSource() {
		return departureSource;
	}

	public void setDepartureSource(String departureSource) {
		this.departureSource = departureSource;
	}

	public String getArrivalDestination() {
		return arrivalDestination;
	}

	public void setArrivalDestination(String arrivalDestination) {
		this.arrivalDestination = arrivalDestination;
	}

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}
	
	
	
}

