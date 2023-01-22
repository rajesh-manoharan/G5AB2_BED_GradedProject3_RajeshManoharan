package com.greatlearning.tickets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.tickets.entity.Ticket;
import com.greatlearning.tickets.service.TicketService;

@Controller
public class TicketController {

	@Autowired
	private TicketService ticketService;

	public TicketController(TicketService ticketService) {

		this.ticketService = ticketService;
	}

	@GetMapping("/tickets")
	public String listTickets(Model model) {

		List<Ticket> tickets = ticketService.listTickets();

		model.addAttribute("tickets", tickets);

		return "Tickets";
	}

	@GetMapping("/tickets/search/{searchString}")
	public String searchTickets(@PathVariable String searchString, Model model) {
		List<Ticket> tickets = ticketService.searchTicket(searchString);
		model.addAttribute("tickets", tickets);
		model.addAttribute("searchString", searchString);
		return "Tickets";
	}

	@GetMapping("/tickets/search/")
	public String searchdefTickets() {
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/newTicket")
	public String addTicketButtonClick(Model model) {
		Ticket tickets = new Ticket();
		model.addAttribute("ticket", tickets);
		return "create-ticket";
	}

	@PostMapping("/tickets")
	public String submitButtonClickforAdd(@ModelAttribute("ticket") Ticket ticket) {
		ticketService.saveTicket(ticket);
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/{id}/edit")
	public String updateTicketButtonClicked(@PathVariable int id, Model model) {

		Ticket selectedTicket = ticketService.getTicketById(id);

		model.addAttribute("ticket", selectedTicket);

		return "edit-ticket";
	}

	@PostMapping("/tickets/{id}/edit")
	public String submitButtonClickedForUpdateTicket(@PathVariable int id, @ModelAttribute("ticket") Ticket ticket) {

		// Update the ticket object
		Ticket existingTicketObj = ticketService.getTicketById(id);

		existingTicketObj.setTitle(ticket.getTitle());
		existingTicketObj.setDescription(ticket.getDescription());
		existingTicketObj.setContent(ticket.getContent());

		ticketService.updateTicket(ticket);

		return "redirect:/tickets";
	}

	// Update Ticket - End

	@GetMapping("/tickets/{id}/view")
	public String viewTicketButtonClicked(@PathVariable int id, Model model) {

		Ticket selectedTicket = ticketService.getTicketById(id);

		model.addAttribute("ticket", selectedTicket);

		return "view-ticket";
	}

	@GetMapping("/tickets/{id}/delete")
	public String deleteTicket(@PathVariable int id) {

		ticketService.deleteById(id);
		return "redirect:/tickets";
	}
}
