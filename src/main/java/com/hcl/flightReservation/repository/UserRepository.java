package com.hcl.flightReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.flightReservation.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	boolean findByUserNameAndPassword(String userName, String password);

}
