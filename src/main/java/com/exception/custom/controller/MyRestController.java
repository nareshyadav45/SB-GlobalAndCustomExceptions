package com.exception.custom.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.exception.custom.creation.AgeNotPermittedException;

import jakarta.websocket.server.PathParam;

@RestController
public class MyRestController {

	@GetMapping("/ageGlobally/{age}")
	public ResponseEntity<String> ageNotPermittedGlobally(@PathVariable("age") int userAge) throws AgeNotPermittedException {
	    if(userAge < 18) {
	        throw new AgeNotPermittedException(" Globally You are not allowed to cast your vote because your age does not meet the eligibility criteria.");
	    }
	    
	    return ResponseEntity.status(HttpStatus.ACCEPTED)
	                         .body("You are allowed to cast your vote.");
	}
	
	@GetMapping("/ageLocally/{age}")
	public ResponseEntity<String> ageNotPermitted(@PathVariable("age") int userAge) {
		try {
	    if(userAge < 18) {
	        throw new AgeNotPermittedException(" Locally You are not allowed to cast your vote because your age does not meet the eligibility criteria. ");
	    }
	    
	    return ResponseEntity.status(HttpStatus.ACCEPTED)
	                         .body("You are allowed to cast your vote.");
		}catch (AgeNotPermittedException ex) {
			return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_GATEWAY);
			
		}
		
	}

	
	
	
}
