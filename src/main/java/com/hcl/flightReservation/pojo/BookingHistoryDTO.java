package com.hcl.flightReservation.pojo;

import java.time.LocalDate;
import java.util.Set;

import com.hcl.flightReservation.entity.Passenger;

public class BookingHistoryDTO {
	
	private LocalDate ticketDate;
	private double amount;
	private Set<Passenger> passengerList;
	private  LocalDate arrivalDate;
	private String fliteName;
	
	
	
	
	public BookingHistoryDTO(LocalDate ticketDate, double amount, Set<Passenger> passengerList, LocalDate arrivalDate,
			String fliteName) {
		super();
		this.ticketDate = ticketDate;
		this.amount = amount;
		this.passengerList = passengerList;
		this.arrivalDate = arrivalDate;
		this.fliteName = fliteName;
	}
	public LocalDate getTicketDate() {
		return ticketDate;
	}
	public void setTicketDate(LocalDate ticketDate) {
		this.ticketDate = ticketDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Set<Passenger> getPassengerList() {
		return passengerList;
	}
	public void setPassengerList(Set<Passenger> passengerList) {
		this.passengerList = passengerList;
	}
	public LocalDate getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getFliteName() {
		return fliteName;
	}
	public void setFliteName(String fliteName) {
		this.fliteName = fliteName;
	}

}
