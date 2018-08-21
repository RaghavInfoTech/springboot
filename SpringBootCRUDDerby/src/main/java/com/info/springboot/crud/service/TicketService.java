package com.info.springboot.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.springboot.crud.dao.TicketDao;
import com.info.springboot.crud.entity.Ticket;

/**
 * Service class , provides service to all REST APIs and calls DAO layer
 *
 * @author Raghava
 */
@Service
public class TicketService {

	@Autowired
	private TicketDao ticketRepo;

	public Ticket bookTicket(Ticket ticket) {
		return ticketRepo.save(ticket);
	}

	public Ticket getTicket(Integer id) {
		 Ticket ticket = ticketRepo.getOne(id);
		 System.out.println(ticket);
		 return  ticket;
	}

	public List<Ticket> getAllTickets() {
		return ticketRepo.findAll();
	}

	public void deleteTicket(Integer ticketId) {
		ticketRepo.deleteById(ticketId);
		
	}

}
