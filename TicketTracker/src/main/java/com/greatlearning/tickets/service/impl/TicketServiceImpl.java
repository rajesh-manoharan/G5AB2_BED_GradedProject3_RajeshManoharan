package com.greatlearning.tickets.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.greatlearning.tickets.entity.Ticket;
import com.greatlearning.tickets.repository.TicketRepository;
import com.greatlearning.tickets.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	public TicketServiceImpl(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	@Override
	public List<Ticket> listTickets() {
		return ticketRepository.findAll();
	}

	@Override
	public Ticket saveTicket(Ticket ticket) {
		ticket.setCreatedate(LocalDate.now().toString());
		return ticketRepository.save(ticket);
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		ticket.setCreatedate(LocalDate.now().toString());
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

	@Override
	public List<Ticket> searchTicket(String keyword) {
		List<Ticket> searchResult = ticketRepository.findByTitleContainsOrDescriptionContainsIgnoreCase(keyword, keyword);
		return searchResult;
	}

}
