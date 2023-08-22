package com.org.service;

import com.org.model.TicketDetails;

public interface TicketDetailsService {

	public String bookTicket(TicketDetails ticketDetails);
	public String cancelTicket(TicketDetails ticketDetails);
}
