package com.greatlearning.tickets.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.tickets.entity.Ticket;
import com.greatlearning.tickets.repository.TicketRepository;
import com.greatlearning.tickets.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService{

	private TicketRepository ticketRepository;
	
	public TicketServiceImpl(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}
	
	@Override
	public List<Ticket> listTickets() {	
		return ticketRepository.findAll();
	}

	@Override
	public Ticket saveTicket(Ticket Ticket) {
		return ticketRepository.save(Ticket);
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
			return ticketRepository.save(ticket);
	}

	@Override
	public Ticket getTicketById(int id) {
		return ticketRepository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		ticketRepository.deleteById(id);
		
	}

	
}
