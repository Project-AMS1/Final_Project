package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.model.TicketDetails;
import com.org.service.TicketDetailsService;

@ComponentScan(basePackages = "com")
@RestController
@RequestMapping("/ticketDetails")
public class TicketDetailsController {

	@Autowired
	private TicketDetailsService ticketDetailsService;
	
	@PostMapping("/BookTicket")
	public String bookTicket(@RequestBody TicketDetails ticketDetails)
	{
		return ticketDetailsService.bookTicket(ticketDetails);
	}
	
	@DeleteMapping("/cancelTicket/{id}")
	public String cancelTicket(@RequestBody TicketDetails ticketDetails)
	{
		return ticketDetailsService.cancelTicket(ticketDetails);
	}
}
