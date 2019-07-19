package com.hcl.flightReservation.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hcl.flightReservation.entity.Booking;
import com.hcl.flightReservation.entity.User;


@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	public List<Booking> findByUserId(User user);
}
