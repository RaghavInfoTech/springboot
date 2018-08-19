package com.info.springboot.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.info.springboot.crud.entity.Ticket;
import com.info.springboot.crud.service.TicketService;

/**
 * TicketController class - All Sample REST APIs are defined here and this class
 * is refereed as starting point or landing point of APIs
 *
 * @author Raghava
 */
@RestController
@RequestMapping(value = "/ticket")
public class TicketController {

	@Autowired
	private TicketService service;

	@RequestMapping(value = "/ticket", method = RequestMethod.POST)
	public Ticket bookTicket(@RequestBody Ticket ticket) {
		return service.bookTicket(ticket);
	}

	@GetMapping(value = "/ticket/{ticketId}")
	public Ticket getTicket(@PathVariable("ticketId") Integer ticketId) {

		return service.getTicket(ticketId);
	}

	@GetMapping(value = "/ticket/")
	public List<Ticket> getAllTicket() {

		return service.getAllTickets();
	}

	@RequestMapping(value = "/ticket", method = RequestMethod.PUT)
	public Ticket updateTicket(@RequestBody Ticket ticket) {
		return service.bookTicket(ticket);
	}

	@DeleteMapping(value = "/ticket/{ticketId}")
	public void deleteTicket(@PathVariable("ticketId") Integer ticketId) {
		service.deleteTicket(ticketId);
	}
}
