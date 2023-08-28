package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.dto.AddPassengerDto;
import com.org.dto.RemovePassengerDto;
import com.org.model.Passenger;
import com.org.service.PassengerServiceimpl;


@ComponentScan(basePackages = "com")
@RestController
@RequestMapping("/passenger")
public class PassengerController {

	@Autowired
	private PassengerServiceimpl passengerService;
	
	@PostMapping("/addPassenger")
	public ResponseEntity<?> addPassenger(@RequestBody AddPassengerDto passenger)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(passengerService.addPassenger(passenger));
	}
	
	@DeleteMapping("/removePassenger")
	public String deletePassenger(@RequestBody RemovePassengerDto passenger)
	{
		return passengerService.removePassenger(passenger);
	}
}
