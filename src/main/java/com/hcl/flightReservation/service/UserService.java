package com.hcl.flightReservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.flightReservation.entity.User;
import com.hcl.flightReservation.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	UserRepository userrepo;
	
	public String  addUser(User user) {
		userrepo.save(user);
		return "sucess";
	}
}


