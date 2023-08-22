package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.model.City;
import com.org.service.CityService;

@RestController
@RequestMapping("/city")
public class CityController {

	@Autowired
	CityService cityService;
	
	@PostMapping("/addCity")
	public String addCity(@RequestBody City city)
	{
		return cityService.addCity(city);
	}
	
	@DeleteMapping("/removeCity/{pincode}")
	public String removeCity(@RequestBody City city)
	{
		return cityService.removeCity(city);
	}
}
