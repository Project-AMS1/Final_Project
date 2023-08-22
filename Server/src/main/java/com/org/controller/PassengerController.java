package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.model.Passenger;
import com.org.service.PassengerServiceimpl;


@ComponentScan(basePackages = "com")
@RestController
@RequestMapping("/passenger")
public class PassengerController {

	@Autowired
	private PassengerServiceimpl passengerService;
	
	@PostMapping("/addPassenger")
	public String addPassenger(@RequestBody Passenger passenger)
	{
		return passengerService.addPassenger(passenger);
	}
	
	@DeleteMapping("/removePassenger/{aadhar}")
	public String deletePassenger(@RequestBody Passenger passenger)
	{
		return passengerService.removePassenger(passenger);
	}
}
