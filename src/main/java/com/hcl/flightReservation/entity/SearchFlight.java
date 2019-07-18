package com.hcl.flightReservation.entity;

import java.time.format.DateTimeFormatter;

public class SearchFlight {
	
	private DateTimeFormatter departure;
	private DateTimeFormatter arrival;
	private String departureSource;
	private String arrivalDestination;
	private String flightCompany;
	private String sort;
	
	public DateTimeFormatter getDeparture() {
		return departure;
	}
	public void setDeparture(DateTimeFormatter departure) {
		this.departure = departure;
	}
	public DateTimeFormatter getArrival() {
		return arrival;
	}
	public void setArrival(DateTimeFormatter arrival) {
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
	
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getFlightCompany() {
		return flightCompany;
	}
	public void setFlightCompany(String flightCompany) {
		this.flightCompany = flightCompany;
	}
	
		

}
