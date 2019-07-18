package com.hcl.flightReservation.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.flightReservation.entity.Booking;
import com.hcl.flightReservation.entity.User;
import com.hcl.flightReservation.pojo.BookingHistoryDTO;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
   
	//@Query(" select new com.hcl.flightReservation.pojo.BookingHistoryDTO(b.bookingDate,b.totalFare,b.passangers, b.flightId.arrival,b.flightId.flightCompany) from Booking b,Passenger p where b.bookingId=p.bookingObject.bookingId and b.userId.userId=:user ")
	public List<Booking> findByUserId(User user);
	//public List<BookingHistoryDTO> findBookingHistory(@Param("user")long user);
}
