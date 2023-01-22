package com.greatlearning.tickets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.tickets.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	
	public List<Ticket> findByTitleContainsOrDescriptionContainsIgnoreCase(String title,String description);
}
