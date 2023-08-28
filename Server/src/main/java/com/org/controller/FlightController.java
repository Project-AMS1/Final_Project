package com.org.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.dto.AddFlightDto;
import com.org.dto.ShowFlighDto;
import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;
import com.org.model.Flight;
import com.org.service.FlightService;
import com.org.service.FlightServiceImpl;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/flight")
public class FlightController {
	@Autowired
private	FlightService flightService;

	@PostMapping("/addFlight")
//	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<?> addFlight(@RequestBody AddFlightDto flight) {
		return ResponseEntity.status(HttpStatus.CREATED).body(flightService.addFlight(flight));
	}
	@PostMapping("/viewFlight")
	public ResponseEntity<?> showFlight(@RequestBody ShowFlighDto flight){
		return ResponseEntity.status(HttpStatus.OK).body(flightService.showFlight(flight));
	}

	@GetMapping("/allFlight")
	public ResponseEntity<?> viewAllFlight() {
		return  ResponseEntity.status(HttpStatus.OK).body(flightService.viewAllFlight());
	}

	@GetMapping("/viewFlight/{id}")
	public ResponseEntity<?> viewFlight(@PathVariable("id") Long flightNo) {
		return ResponseEntity.status(HttpStatus.OK).body(flightService.viewFlight(flightNo));
	}

	@PutMapping("/updateFlight")
	public ResponseEntity<?> modifyFlight(@RequestBody Flight flight) {
		return ResponseEntity.status(HttpStatus.OK).body(flightService.modifyFlight(flight));
	}

	@DeleteMapping("/deleteFlight/{id}")
	public String removeFlight(@PathVariable("id") Long flightNo) {
		flightService.removeFlight(flightNo);
		return "The flight is Deleted ";
	}
}