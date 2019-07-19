package com.hcl.flightReservation.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.flightReservation.entity.Flight;
import com.hcl.flightReservation.entity.User;
import com.hcl.flightReservation.exception.InvalidUserDataException;
import com.hcl.flightReservation.service.FlightService;
import com.hcl.flightReservation.service.UserService;

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
@RequestMapping("/")
public class LoginController {

	private static final String MANDETORY_ERR_MSG= "Mandetory element missing : "; 
	
	@Autowired
	UserService userService;
	
	@Autowired
	FlightService flightService;
	
	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password) {
		try {
			
			validateMandatoryElements(userName,password);
			if(userName.equals("admin") && password.equals("admin")) {
				List<Flight> pendingList= flightService.fetchPendingApproval();
				return new ResponseEntity<>(pendingList,HttpStatus.OK);
				
			}else {
				User userStatus= userService.loginUser(userName,password);
				if(ObjectUtils.isEmpty(userStatus)) {
					return new ResponseEntity<> ("Please check your credintials",HttpStatus.OK);
				}else {
					return new ResponseEntity<> ("You are logged in successfully",HttpStatus.OK);
				}
			}
			
				
		} catch (InvalidUserDataException invalid) {
			return new ResponseEntity<>(invalid.getMessage(), HttpStatus.BAD_REQUEST);
		} catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@PostMapping("/addFlight")
	public ResponseEntity<?> addFlight(@RequestBody Flight flight,@RequestHeader("role_id") int roleId,@RequestHeader("user_name") String userName,@RequestHeader("password") String password) {
		try {
			if(roleId==2 && userName.equals("flightAdmin") && password.equals("flightAdmin")) {
				checkMandatoryFlightElements(flight);
				flight.setFlightStatus(0); // default 0 will set as pending
				flightService.addNewFlight(flight);
				return new ResponseEntity<> ("record saved sucessfully",HttpStatus.OK);
			
			}else {				
				return new ResponseEntity<> ("Please check your credintials or role",HttpStatus.OK);
			}			
			
		}catch(InvalidUserDataException invalid) {
			return new ResponseEntity<>(invalid.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	@PostMapping("request/{requestType}")
	public ResponseEntity<Object> flightStatus(@PathVariable("requestType") String requestType ,@RequestBody Map<String,String> requestBody){
		System.out.println("Inside request");
		if((requestBody.get("username").equals("admin"))&&(requestBody.get("password").equals("admin"))) {
			if(requestType.equals("approve"))
			{
				return new ResponseEntity<>(flightService.flightDetails(Long.parseLong(requestBody.get("flightId")),1),HttpStatus.OK);	
			}
			else if(requestType.equals("reject"))
			{
				return new ResponseEntity<>(flightService.flightDetails(Long.parseLong(requestBody.get("flightId")),2),HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>("Not coreect request",HttpStatus.BAD_REQUEST);
			}
			
		}else
		{
			return new ResponseEntity<>("Please provide Correct Username and Password",HttpStatus.BAD_REQUEST);
		}
	}

	private void checkMandatoryFlightElements(Flight flight) throws InvalidUserDataException {
		// TODO Auto-generated method stub
		
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
