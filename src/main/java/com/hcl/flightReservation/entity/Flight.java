package com.hcl.flightReservation.entity;



import java.time.LocalDateTime;

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
	
	@Column(name="flight_status")
    private int flight_status;
    
	@Column(name="departure_time")
    private LocalDateTime departure;
	
    @Column(name="arrival_time")
	private LocalDateTime arrival;
	
	@Column(name="source")
	private String source;
	
	@Column(name="destination")
	private String destination;
	
	@Column(name="fare")
	private Double fare;
	
	@Column(name="flight_status")
	private int flightStats;

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

	
	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public int getFlight_status() {
		return flight_status;
	}

	public void setFlight_status(int flight_status) {
		this.flight_status = flight_status;
	}
	
	
}

