package com.org.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.model.TicketDetails;

public interface TicketDetailsDao extends JpaRepository<TicketDetails, Long> {

}
