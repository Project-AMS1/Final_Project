package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.exceptions.RecordAlreadyPresentException;
import com.org.model.Aeroplane;
import com.org.model.Users;
import com.org.service.AeroplaneService;


@ComponentScan(basePackages = "com")
@RestController
@RequestMapping("/aeroplane")
public class AeroplaneController {

	@Autowired
	AeroplaneService aeroplaneService;
	
	@PostMapping("/createAeroplane")
	public String addAeroplane(@RequestBody Aeroplane aeroplane) 
	{

		return aeroplaneService.createAeroplane(aeroplane); 
	}
	
	@DeleteMapping("/removeAeroplane/{id}")
	public String removeAeroplane(@RequestBody Aeroplane aeroplane)
	{
		return aeroplaneService.removeAeroplane(aeroplane); 
	}
	
}
