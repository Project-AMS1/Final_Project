package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.model.Meal;
import com.org.service.MealService;

@ComponentScan(basePackages = "com")
@RestController
@RequestMapping("/meal")
public class MealController {

	@Autowired
	private MealService mealService;
	
	@PostMapping("/addMeal")
	public String addMeal(@RequestBody Meal meal)
	{
		return mealService.addMeal(meal);
	}
	
	@DeleteMapping("/deleteMeal/{id}")
	public String removeMeal(@RequestBody Meal meal)
	{
		return mealService.removeMeal(meal);
	}
	
	@PutMapping("/editMeal")
	public String editMeal(@RequestBody Meal meal)
	{
		return mealService.editMeal(meal);
	}
}
