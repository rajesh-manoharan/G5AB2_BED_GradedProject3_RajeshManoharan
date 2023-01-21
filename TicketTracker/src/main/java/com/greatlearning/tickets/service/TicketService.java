package com.greatlearning.tickets.service;

import java.util.List;

import com.greatlearning.tickets.entity.Ticket;

public interface TicketService {

	List<Ticket> listTickets();

	List<Ticket> searchTicket(String keyword);

	Ticket saveTicket(Ticket ticket);

	// Update - Start
	Ticket getTicketById(int id);

	Ticket updateTicket(Ticket Ticket);
	// Update - End

	void deleteById(int id);
}
