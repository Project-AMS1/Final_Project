package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.model.Feedback;
import com.org.service.FeedbackService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@ComponentScan(basePackages = "com")
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping("/addFeedback")
	public String giveFeedback(@RequestBody Feedback feedback)
	{
		return feedbackService.giveFeedback(feedback);
	}
	
	@PutMapping("/updateFeedback")
	public String editFeedback(@RequestBody Feedback feedback)
	{
		return feedbackService.editFeedback(feedback);
	}
	
	@DeleteMapping("/deleteFlight/{id}")
	public String deleteFeedback(@RequestBody Feedback feedback)
	{
		return feedbackService.deleteFeedback(feedback);
	}
	
}
