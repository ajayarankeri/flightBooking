package com.hcl.flightReservation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.flightReservation.exception.InvalidUserDataException;

/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
/**
 * @param username
 * @param password
 * @throws InvalidUserDataException
 */
@RestController
@RequestMapping("/user")
public class LoginController {

	private static final String MANDETORY_ERR_MSG= "Mandetory element missing : "; 

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
	try {
			validateMandatoryElements(username,password);
			System.out.println("User logged In sucessfully");

		} catch (InvalidUserDataException invalid) {
			return new ResponseEntity<>(invalid.getMessage(), HttpStatus.BAD_REQUEST);
		} catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// This function will check mandatory elements for login
	private void validateMandatoryElements(String username, String password) throws InvalidUserDataException {

		if(ObjectUtils.isEmpty(username)) {
			throw new InvalidUserDataException(MANDETORY_ERR_MSG+" userName");
		}

		if(ObjectUtils.isEmpty(password)) {
			throw new InvalidUserDataException(MANDETORY_ERR_MSG+" password");
		}

	}
}
