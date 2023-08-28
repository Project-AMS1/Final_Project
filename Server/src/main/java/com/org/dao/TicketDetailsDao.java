package com.org.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.model.TicketDetails;

public interface TicketDetailsDao extends JpaRepository<TicketDetails, Long> {
	

}
