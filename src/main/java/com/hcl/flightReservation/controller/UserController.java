package com.hcl.flightReservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.flightReservation.entity.User;
import com.hcl.flightReservation.service.UserService;

@RestController
	@RequestMapping("/")
	public class UserController {
		
		@Autowired
		UserService userservice;

		@PostMapping("/register")
		public ResponseEntity<Object> search(@RequestBody User user) {
			 userservice.addUser(user);
			return new ResponseEntity<> ("record saved sucessfully",HttpStatus.OK);
			
		}
	}


