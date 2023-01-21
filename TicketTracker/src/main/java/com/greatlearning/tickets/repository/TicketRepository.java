package com.greatlearning.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.tickets.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
