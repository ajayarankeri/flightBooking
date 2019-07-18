package com.hcl.flightReservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.flightReservation.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public boolean loginUser(String userName, String password) {
		return userRepository.findByUserNameAndPassword(userName,password);
	}

}
