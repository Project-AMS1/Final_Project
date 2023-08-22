package com.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.dao.TicketDetailsDao;
import com.org.model.TicketDetails;

@Transactional
@Service
public class TicketDetailsServiceImpl implements TicketDetailsService{

	@Autowired
	TicketDetailsDao ticketDetailsDao;
	
	@Override
	public String bookTicket(TicketDetails ticketDetails) {
		ticketDetailsDao.save(ticketDetails);
		return "ticket has been booked";
	}

	@Override
	public String cancelTicket(TicketDetails ticketDetails) {
		ticketDetailsDao.delete(ticketDetails);
		return "deleted";
	}

	
}
